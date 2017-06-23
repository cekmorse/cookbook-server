package com.github.cekmorse.cookbook.api.config.unit;

import com.github.cekmorse.api.config.MapperConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;

/**
 * Created by keith on 6/22/17.
 */
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class, ProxyTransactionManagementConfiguration.class})
@ComponentScan(basePackageClasses = TestApiConfigs.class)
@Import( {TestApiConfig.class, MapperConfig.class} )
public class TestApiConfigs {
}
