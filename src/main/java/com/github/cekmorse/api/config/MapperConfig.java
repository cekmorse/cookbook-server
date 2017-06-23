package com.github.cekmorse.api.config;

import com.github.cekmorse.api.converter.ClassStringBidirectionalConverter;
import com.github.cekmorse.api.converter.DateDateTimeBidirectionalConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.PassThroughConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by keith on 6/22/17.
 */
@Slf4j
@Configuration
public class MapperConfig {
    private MapperFactory mapperFactory;

    @Value("${mapper.package}")
    private String mapperPackage;

    @Bean
    public MapperFactory mapperFactory()
    {
        if (null == mapperFactory)
        {
            mapperFactory = new DefaultMapperFactory.Builder().build();
            autoRegisterClasses(mapperFactory);
            registerConverters(mapperFactory);
            registerClasses(mapperFactory);
        }
        return mapperFactory;
    }

    @Bean
    public MapperFacade mapperFacade()
    {
        return mapperFactory().getMapperFacade();
    }

    protected void simpleMapClasses(MapperFactory aMapperFactory, Class a, Class b) {
        aMapperFactory.classMap(a, b).byDefault().register();
    }

    protected void registerConverters(MapperFactory aMapperFactory) {
        ConverterFactory converterFactory = aMapperFactory.getConverterFactory();
        converterFactory.registerConverter(new ClassStringBidirectionalConverter());
        converterFactory.registerConverter(new DateDateTimeBidirectionalConverter());
        converterFactory.registerConverter(new PassThroughConverter(org.joda.time.DateTime.class));
    }

    protected void registerClasses(MapperFactory aMapperFactory) {
    }

    protected void autoRegisterClasses(MapperFactory aMapperFactory)
    {
        if (mapperPackage != null)
        {
            new AutoMapHelper().autoRegister(aMapperFactory, mapperPackage);
        }
    }
}
