package com.github.cekmorse.cookbook.persist.service.config.unit;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;

/**
 * Created by keith on 6/21/17.
 */
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class, ProxyTransactionManagementConfiguration.class})
@ComponentScan(basePackageClasses = ServiceConfigs.class)
public class ServiceConfigs {
}
