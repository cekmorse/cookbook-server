package com.github.cekmorse.persist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import javax.sql.DataSource;

/**
 * Created by keith on 6/20/17.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    //JPA properties
    protected static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    protected static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    protected static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    protected static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    @Value("${db.driver}")
    protected String dbDriver;

    @Value("${db.password}")
    protected String dbPassword;

    @Value("${db.url}")
    protected String dbUrl;

    @Value("${db.username}")
    protected String dbUsername;

    @Value("${hibernate.dialect}")
    protected String hibernateDialect;

    @Value("${hibernate.format_sql}")
    protected String hibernateFormatSql;

    @Value("${hibernate.hbm2ddl.auto}")
    protected String hibernateAutoGenSchema;

    @Value("${hibernate.show_sql}")
    protected String hibernateShowSql;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);

        Properties dbProps = new Properties();
        dbProps.setProperty("transformedBitIsBoolean", "true");
        dataSource.setConnectionProperties(dbProps);

        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPersistenceUnitName("domain");

        entityManagerFactoryBean.setJpaProperties(buildJpaProperties());

        return entityManagerFactoryBean;
    }

    protected Properties buildJpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, hibernateFormatSql);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, hibernateAutoGenSchema);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);
        return jpaProperties;
    }
}
