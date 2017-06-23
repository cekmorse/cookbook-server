package com.github.cekmorse.api.spring;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by keith on 6/22/17.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface HeaderVariable
{
    String value();
}
