package com.github.cekmorse.cookbook.persist.config;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Created by keith on 6/20/17.
 */
public class DbUnitConfig {
    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(DataSource dataSource) {
        DatabaseDataSourceConnectionFactoryBean dbConnectionFactory = new DatabaseDataSourceConnectionFactoryBean(dataSource);
        dbConnectionFactory.setDatabaseConfig(dbUnitDatabaseConfig());
        return dbConnectionFactory;
    }

    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {
        DatabaseConfigBean config = new DatabaseConfigBean();
        config.setDatatypeFactory(dbUnitDataTypeFactory());
        return config;
    }

    @Bean
    public MySqlDataTypeFactory dbUnitDataTypeFactory() {
        return new MySqlDataTypeFactory();
    }
}
