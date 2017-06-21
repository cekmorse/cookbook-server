package com.github.cekmorse.cookbook.persist.config;

import com.github.cekmorse.persist.config.DatabaseConfig;
import com.github.cekmorse.persist.config.RepositoryConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/**
 * Created by keith on 6/20/17.
 */
@Configuration
@EnableAutoConfiguration
@Import(value = {DatabaseConfig.class, RepositoryConfig.class, DbUnitConfig.class})
public class PersistConfigs {
}
