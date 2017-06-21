package com.github.cekmorse.persist.config;

import com.github.cekmorse.persist.domain.Domain;
import com.github.cekmorse.persist.repository.Repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by keith on 6/20/17.
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = {Domain.class, Repository.class})
public class RepositoryConfigs {
}
