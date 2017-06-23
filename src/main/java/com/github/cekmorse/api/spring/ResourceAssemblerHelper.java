package com.github.cekmorse.api.spring;

import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;

import lombok.AccessLevel;
import lombok.Getter;
import ma.glasnost.orika.MapperFacade;

/**
 * Created by keith on 6/22/17.
 */
public class ResourceAssemblerHelper
{
    public static class MappingResourceAssembler<S,D extends ResourceSupport> implements ResourceAssembler<S,D>
    {
        @Getter(AccessLevel.PROTECTED)
        private final MapperFacade mapper;
        @Getter(AccessLevel.PROTECTED)
        private final Class<D> destinationClass;

        public MappingResourceAssembler(MapperFacade aMapper, Class<D> aDestinationClass)
        {
            mapper = aMapper;
            destinationClass = aDestinationClass;
        }

        @Override
        public D toResource(S aSource)
        {
            return getMapper().map(aSource, getDestinationClass());
        }
    }

    public static class PassThroughResourceAssembler<D extends ResourceSupport> implements ResourceAssembler<D,D>
    {
        @Override
        public D toResource(D aSource)
        {
            return aSource;
        }
    }
}
