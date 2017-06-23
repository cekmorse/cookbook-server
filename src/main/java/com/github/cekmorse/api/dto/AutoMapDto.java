package com.github.cekmorse.api.dto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by keith on 6/22/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AutoMapDto
{
    Class<?>[] value();
    Class<?> domain() default UseAnnotated.class;

    final class UseAnnotated {}
}
