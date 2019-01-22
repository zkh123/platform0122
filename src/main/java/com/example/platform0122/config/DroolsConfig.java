package com.example.platform0122.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by huanglijun on 2019/1/22
 */
@Configuration
@MapperScan(basePackages = "com.example.platform0122.dao.drools",sqlSessionFactoryRef = "droolsSqlSessionFactory")
public class DroolsConfig {
    @Bean(name = "droolsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.drools")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "droolsTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("droolsDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "droolsSqlSessionFactory")
    public SqlSessionFactory basicSqlSessionFactory(@Qualifier("droolsDataSource") DataSource basicDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(basicDataSource);
        factoryBean.setTypeAliasesPackage("com.example.platform0122.entity");
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/drools/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "droolsSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("droolsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
