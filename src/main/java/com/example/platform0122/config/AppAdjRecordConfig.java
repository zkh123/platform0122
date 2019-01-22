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
@MapperScan(basePackages = "com.example.platform0122.dao.news",sqlSessionFactoryRef = "newsSqlSessionFactory")
public class AppAdjRecordConfig {

    @Bean(name = "newsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.news")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "newsTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("newsDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "newsSqlSessionFactory")
    public SqlSessionFactory basicSqlSessionFactory(@Qualifier("newsDataSource") DataSource basicDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(basicDataSource);
        factoryBean.setTypeAliasesPackage("com.example.platform0122.entity");
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/news/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "newsSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("newsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
