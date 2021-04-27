package com.ymm.microservices.usercenter.generator;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 配置汇总 传递给文件生成工具
 *
 * @author YangHu, tangguo, hubin
 * @since 2016-08-30
 */
public class CustomConfigBuilder {

    private static Logger log = LoggerFactory.getLogger(CustomConfigBuilder.class);

    private DataSourceConfig dataSourceConfig;

    private ConfigBuilder configBuilder;

    public CustomConfigBuilder() {

    }

    public ConfigBuilder getConfigBuilder() {
        return configBuilder;
    }

    public void setConfigBuilder(ConfigBuilder configBuilder) {
        this.configBuilder = configBuilder;
    }

    public DataSourceConfig getDataSourceConfig() {
        return dataSourceConfig;
    }

    public void setDataSourceConfig(DataSourceConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public List<ForeignKey> getForeignKeys() {
        List<ForeignKey> results = new ArrayList<>();
        try {
            Connection connection = dataSourceConfig.getConn();
            log.info("DataSourceConfig={}", dataSourceConfig);
            String url = dataSourceConfig.getUrl();
            String database = url.substring(url.lastIndexOf("/") + 1, url.indexOf("?"));
            String sql = "select * from information_schema.KEY_COLUMN_USAGE where REFERENCED_TABLE_SCHEMA != '' AND TABLE_SCHEMA = '"
                    + database + "'" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet;


            try {
                resultSet = preparedStatement.executeQuery();

                try{
                    while(resultSet.next()) {
                        ForeignKey foreignKey = new ForeignKey();
                        String tableName = resultSet.getString("TABLE_NAME");
                        String column = resultSet.getString("COLUMN_NAME");
                        String foreignTableName = resultSet.getString("REFERENCED_TABLE_NAME");
                        String foreignColumn = resultSet.getString("REFERENCED_COLUMN_NAME");
                        foreignKey.setTableName(tableName);
                        foreignKey.setColumn(column);
                        foreignKey.setForeignTableName(foreignTableName);
                        foreignKey.setForeignColumn(foreignColumn);
                        results.add(foreignKey);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    resultSet.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                preparedStatement.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return results;
    }
}
