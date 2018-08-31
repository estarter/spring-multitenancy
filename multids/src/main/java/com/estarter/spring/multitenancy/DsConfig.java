package com.estarter.spring.multitenancy;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DsConfig {
    @Value("${myds1.url}")
    private String url1;
    @Value("${myds1.username}")
    private String username1;
    @Value("${myds1.password}")
    private String password1;
    @Value("${myds2.url}")
    private String url2;
    @Value("${myds2.username}")
    private String username2;
    @Value("${myds2.password}")
    private String password2;

    @Bean
    public DataSource dataSource() {

        DataSourceProperties properties1 = new DataSourceProperties();
        properties1.setUrl(url1);
        properties1.setUsername(username1);
        properties1.setPassword(password1);
        DataSource ds1 = properties1.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        DataSourceProperties properties2 = new DataSourceProperties();
        properties2.setUrl(url2);
        properties2.setUsername(username2);
        properties2.setPassword(password2);
        DataSource ds2 = properties2.initializeDataSourceBuilder().type(HikariDataSource.class).build();

        AbstractRoutingDataSource ards = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return TenantStorage.getTenantName();
            }
        };
        Map<Object,Object> dataSources = new HashMap<>();
        dataSources.put("db1", ds1);
        dataSources.put("db2", ds2);
        dataSources.put(null, ds1);
        ards.setTargetDataSources(dataSources);
        ards.afterPropertiesSet();
        return ards;
    }

}
