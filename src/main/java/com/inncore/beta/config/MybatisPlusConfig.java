package com.inncore.beta.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class MybatisPlusConfig {
    private static Logger log = LoggerFactory.getLogger(MybatisPlusConfig.class);

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();

        List<ISqlParser> sqlParserList = new ArrayList<>();

        // 创建租户SQL解析器
        TenantSqlParser tenantSqlParser = new TenantSqlParser();

        // 设置租户处理器
        tenantSqlParser.setTenantHandler(new TenantHandler() {
            @Override
            public Expression getTenantId(boolean s) {
                // 设置当前租户ID，实际情况你可以从cookie、或者缓存中拿都行
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = requestAttributes.getRequest();
                String tenantId = request.getHeader("tenantId");
                log.debug("tenantId={}", tenantId);
                return new StringValue(tenantId);
            }

            @Override
            public String getTenantIdColumn() {
                // 对应数据库租户ID的列名
                return "tenant_id";
            }

            @Override
            public boolean doTableFilter(String tableName) {
                // 是否需要需要过滤某一张表
              /*  List<String> tableNameList = Arrays.asList("sys_user");
                if (tableNameList.contains(tableName)){
                    return true;
                }*/
                List<String> tables = Arrays.asList("sys_user_role", "sys_role_dept", "sys_role_permission", "sys_role_menu");
                if (tableName.startsWith("sys_") && !tables.contains(tableName)){
                    return false;
                }
                return true;
            }
        });

        sqlParserList.add(tenantSqlParser);
        page.setSqlParserList(sqlParserList);

        return page;
    }
}
