package com.github.cekmorse.persist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by keith on 6/20/17.
 */
@Configuration
@Import({DatabaseConfig.class, RepositoryConfigs.class})
public class PersistConfigs {
}
