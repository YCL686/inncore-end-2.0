package com.inncore.beta.config;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.inncore.beta.entity.GeneratorConfig;
import com.inncore.beta.generator.CustomConfigBuilder;
import com.inncore.beta.generator.ForeignKey;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class AutoGeneratorConfig {
    @Value("${generator.filepath}")
    private String GENERATOR_FILEPATH;
    private AutoGenerator mpg;
    private GlobalConfig gc;
    private DataSourceConfig dsc;
    private PackageConfig pc;
    private StrategyConfig strategy;
    private InjectionConfig ic;
    private TemplateConfig templateConfig;

    private GeneratorConfig config;
    private String tableNames;
    private String types;
    private String projectPath;
    private String vuePath;

    public AutoGeneratorConfig() {
        this.mpg = new AutoGenerator();
        this.gc = new GlobalConfig();
        this.dsc = new DataSourceConfig();
        this.pc = new PackageConfig();
        this.strategy = new StrategyConfig();
        this.ic = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        this.templateConfig = new TemplateConfig();
        this.config = new GeneratorConfig();
        this.tableNames = "";
        this.types = "";
        this.projectPath = "";
        this.vuePath = "";
    }

    public List<String> getTables(GeneratorConfig config) {
        List<String> result = new ArrayList<>();
        dsc = new DataSourceConfig();
        dsc.setUrl(config.getUrl());
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(config.getUsername());
        dsc.setPassword(config.getPassword());
        ConfigBuilder configBuilder = new ConfigBuilder(null, dsc, null, null, null);
        List<TableInfo> tableInfos = configBuilder.getTableInfoList();
        tableInfos.stream().forEach(tableInfo -> result.add(tableInfo.getName()));
        return result;
    }

    public String generate(GeneratorConfig config, String tableNames, String fileTypes) {
        config(config, tableNames, fileTypes);
        mpg.execute();
        String zipFilepath = GENERATOR_FILEPATH + "/" + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)
                + "/" + FileUtil.getName(projectPath) + ".zip";
        ZipFile zipFile = new ZipFile(zipFilepath);
        try {
            zipFile.addFolder(new File(projectPath));
        } catch (ZipException e) {
            e.printStackTrace();
            return null;
        }
        FileUtil.del(projectPath);
        return zipFilepath;
    }

    public void config(GeneratorConfig config, String tableNames, String types) {
        this.config = config;
        this.tableNames = tableNames;
        this.types = types;
        // ???????????????
        mpg = new AutoGenerator();

        // ????????????
        gc = new GlobalConfig();
        //String projectPath = System.getProperty("user.dir");
        projectPath = GENERATOR_FILEPATH + File.separator + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)
                + File.separator + StrUtil.uuid();
        vuePath = projectPath;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(config.getAuthor());
        gc.setOpen(false);
        gc.setSwagger2(true);
        gc.setActiveRecord(true);
        gc.setBaseResultMap(true);
        gc.setFileOverride(true);
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // ???????????????
        dsc = new DataSourceConfig();
        //dsc.setUrl("jdbc:mysql://localhost:3306/ant?useUnicode=true&useSSL=false&characterEncoding=utf8");
        //dsc.setUrl("jdbc:mysql://134.175.47.234:3306/rbac-security?characterEncoding=UTF-8&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setUrl(config.getUrl());
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(config.getUsername());
        dsc.setPassword(config.getPassword());
        //dsc.setTypeConvert();
        dsc.setTypeConvert((GlobalConfig globalConfig, String fieldType) -> {
            String t = fieldType.toLowerCase();
            if (t.contains("tinyint")) {
                return DbColumnType.INTEGER;
            }
            if (t.contains("time")) {
                return DbColumnType.DATE;
            }
            return new MySqlTypeConvert().processTypeConvert(globalConfig, fieldType);
        });
        mpg.setDataSource(dsc);

        // ?????????
        pc = new PackageConfig();
        pc.setModuleName(config.getModuleName());
        pc.setParent(config.getPackageName());
        pc.setEntity("entity");
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setServiceImpl("service.impl");
        //pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        // ????????????
        strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("????????????????????????,?????????????????????!");
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        // ????????????
        strategy.setSuperControllerClass("com.baomidou.mybatisplus.extension.api.ApiController");
        // ??????????????????????????????
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(tableNames.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setLogicDeleteFieldName("deleted");

        mpg.setStrategy(strategy);


        CustomConfigBuilder customConfigBuilder = new CustomConfigBuilder();
        customConfigBuilder.setConfigBuilder(mpg.getConfig());
        customConfigBuilder.setDataSourceConfig(mpg.getDataSource());
        List<ForeignKey> foreignKeys = customConfigBuilder.getForeignKeys();
        System.out.println(foreignKeys);
        // ???????????????
        ic = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
                ConfigBuilder builder = new ConfigBuilder(null, dsc, null, null, null);
                Map<String, Object> map = new HashMap<>();
                map.put("tables", builder.getTableInfoList());
                List<ForeignKey> results = new ArrayList<>();
                for(ForeignKey key : foreignKeys) {
                    for(TableInfo tableInfo : builder.getTableInfoList()) {
                        if(key.getForeignTableName().equals(tableInfo.getName())) {
                            key.setForeignTableInfo(tableInfo);
                            String className = tableInfo.getEntityName();
                            key.setForeignClassName(className.substring(0,1).toLowerCase() + className.substring(1));
                            results.add(key);
                        }
                    }

                }
                map.put("foreignKeys", results);

                setMap(map);
            }
            @Override
            public Map<String, Object> prepareObjectMap(Map<String, Object> objectMap) {
                List<ForeignKey> allKeys = (List<ForeignKey>) getMap().get("foreignKeys");
                TableInfo table = (TableInfo) objectMap.get("table");
                List<ForeignKey> results = new ArrayList<>();
                for (ForeignKey key : allKeys) {
                    if (key.getTableName().equals(table.getName())) {
                        results.add(key);
                    }
                }
                objectMap.put("foreignKeys", results);
                System.out.println("keys=" + results);
                return objectMap;
            }
        };

        // ????????????????????? freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // ????????????????????? velocity
        String templatePath = "/templates/mapper.xml.vm";
        String indexVuePath = "/templates/index.vue.vm";
        String addEditVuePath = "/templates/addEdit.vue.vm";
        String apiJsPath = "/templates/api.js.vm";
        String[] fileTypes = types.split(",");
        List<String> files = new ArrayList<String>(Arrays.asList(fileTypes));
        // ?????????????????????
        List<FileOutConfig> focList = new ArrayList<>();
        // ?????????????????????????????????
        if (files.contains("xml")) {
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // ???????????????????????? ??? ????????? Entity ????????????????????????????????? xml ????????????????????????????????????
                    return projectPath + "/src/main/resources/mapper/"
                            + (StrUtil.isNotEmpty(pc.getModuleName()) ? pc.getModuleName() + "/" : "")
                            + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
        }

        focList.add(new FileOutConfig(indexVuePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // ???????????????????????? ??? ????????? Entity ????????????????????????????????? xml ????????????????????????????????????
                return vuePath + "/src/views/generator/" + tableInfo.getEntityName() +"/"
                        + "index.vue";
            }
        });
        focList.add(new FileOutConfig(addEditVuePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // ???????????????????????? ??? ????????? Entity ????????????????????????????????? xml ????????????????????????????????????
                return vuePath + "/src/views/generator/" + tableInfo.getEntityName() +"/"
                        + "addEdit.vue";
            }
        });
        focList.add(new FileOutConfig(apiJsPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // ???????????????????????? ??? ????????? Entity ????????????????????????????????? xml ????????????????????????????????????
                return vuePath + "/src/api/" + tableInfo.getEntityPath()
                        + ".js";
            }
        });

        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // ??????????????????????????????????????????
                checkDir("??????????????????????????????????????????????????????");
                if (fileType == FileType.MAPPER) {
                    // ???????????? mapper ????????????????????????????????????????????? false
                    return !new File(filePath).exists();
                }
                // ????????????????????????
                return true;
            }
        });
        */
        if (focList.size() > 0) {
            ic.setFileOutConfigList(focList);
        }
        mpg.setCfg(ic);

        // ????????????
        templateConfig = new TemplateConfig();

        // ???????????????????????????
        //????????????????????????????????????????????????.ftl/.vm, ??????????????????????????????????????????
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();

        if (files.contains("controller")) {
            templateConfig.setController("templates/controller.java");
        } else {
            templateConfig.setController(null);
        }
        if (files.contains("entity")) {
            templateConfig.setEntity("templates/entity.java");
        } else {
            templateConfig.setEntity(null);
        }
        if (files.contains("mapper")) {
            templateConfig.setMapper("templates/mapper.java");
        } else {
            templateConfig.setMapper(null);
        }
        if (files.contains("service")) {
            templateConfig.setService("templates/service.java");
            templateConfig.setServiceImpl("templates/service.impl.java");
        } else {
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
        }

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);


    }

}
