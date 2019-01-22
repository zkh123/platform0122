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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by huanglijun on 2019/1/22
 */
@Configuration
@MapperScan(basePackages = "com.example.platform0122.dao.local",sqlSessionFactoryRef = "localSqlSessionFactory")
public class LocalConfig {
    @Primary
    @Bean(name = "localDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "localTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("localDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "localSqlSessionFactory")
    public SqlSessionFactory basicSqlSessionFactory(@Qualifier("localDataSource") DataSource basicDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(basicDataSource);
        factoryBean.setTypeAliasesPackage("com.example.platform0122.entity");
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/local/*.xml"));
        return factoryBean.getObject();
    }

    @Primary
    @Bean(name = "localSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("localSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
