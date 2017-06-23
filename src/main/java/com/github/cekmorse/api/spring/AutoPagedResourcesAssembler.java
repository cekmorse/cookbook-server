package com.github.cekmorse.api.spring;

import com.github.cekmorse.api.spring.ResourceAssemblerHelper.PassThroughResourceAssembler;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.util.UriComponents;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import ma.glasnost.orika.MapperFacade;

/**
 * Created by keith on 6/22/17.
 */
public class AutoPagedResourcesAssembler<T extends ResourceSupport> extends PagedResourcesAssembler<T>
{
    @Getter(AccessLevel.PROTECTED)
    private final MapperFacade mapper;

    protected PassThroughResourceAssembler<T> passThroughResourceAssembler = new PassThroughResourceAssembler<>();

    public AutoPagedResourcesAssembler(HateoasPageableHandlerMethodArgumentResolver resolver, UriComponents baseUri, MapperFacade aMapperFacade)
    {
        super(resolver, baseUri);
        mapper = aMapperFacade;
    }

    public <D> PagedResources<T> toResource(Page<D> source, Pageable aPageInfo, Class<T> destinationClass)
    {
        List<T> converted = getMapper().mapAsList(source.getContent(), destinationClass);
        Page<T> destPage = new PageImpl<T>(converted, aPageInfo, source.getTotalElements());
        return toResource(destPage, passThroughResourceAssembler);
    }
}
