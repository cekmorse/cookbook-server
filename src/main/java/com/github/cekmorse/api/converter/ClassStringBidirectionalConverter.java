package com.github.cekmorse.api.converter;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

/**
 * Created by keith on 6/22/17.
 */
public class ClassStringBidirectionalConverter extends BidirectionalConverter<String, Class> {
    @Override
    public Class convertTo(String s, Type<Class> aType) {
        try
        {
            return Class.forName(s);
        }
        catch (ClassNotFoundException e)
        {
            return null;
        }
    }

    @Override
    public String convertFrom(Class aClass, Type<String> aType) {
        if (aClass == null)
        {
            return null;
        }
        return aClass.getCanonicalName();
    }
}

