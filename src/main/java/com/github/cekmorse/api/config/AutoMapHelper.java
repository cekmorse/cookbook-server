package com.github.cekmorse.api.config;

import com.github.cekmorse.api.dto.AutoMapDto;

import org.reflections.Reflections;

import java.util.Set;

import javax.annotation.Nonnull;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFactory;

import static com.github.cekmorse.api.dto.AutoMapDto.*;

/**
 * Created by keith on 6/22/17.
 */
@Slf4j
public class AutoMapHelper
{
    protected void simpleMapClasses(MapperFactory aMapperFactory, Class a, Class b) {
        aMapperFactory.classMap(a, b).byDefault().register();
    }

    public void autoRegister(@Nonnull MapperFactory aMapperFactory, @Nonnull String aMapperPackages)
    {
        //auto-register classes in each package (comma-delimited)
        String[] packages = aMapperPackages.split(",");
        for (String packageName : packages)
        {
            if (packageName != null && !packageName.isEmpty())
            {
                log.info("Auto registering source objects in package: " + packageName);
                try
                {
                    autoRegisterClasses(aMapperFactory, packageName);
                }
                catch (Exception aE)
                {
                    log.error("An error occurred registering a mapper package: " + packageName, aE);
                }
            }
        }
    }

    protected void autoRegisterClasses(MapperFactory aMapperFactory, String aMapperPackage)
    {
        //find all classes to automap
        Reflections reflections = new Reflections(aMapperPackage);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(AutoMapDto.class);

        //get list of mapped dtos
        for (Class<?> nonDtoClass : annotated)
        {
            AutoMapDto autoMap = nonDtoClass.getAnnotation(AutoMapDto.class);
            if (autoMap.domain() != null && !UseAnnotated.class.equals(autoMap.domain()))
            {
                nonDtoClass = autoMap.domain();
            }

            //register each object to dto mapping
            for (Class dtoClass : autoMap.value())
            {
                simpleMapClasses(aMapperFactory, nonDtoClass, dtoClass);
            }
        }
    }}
