package com.github.cekmorse.api.controller;

import com.github.cekmorse.api.dto.recipe.RecipeFull;
import com.github.cekmorse.api.exception.BadRequestException;
import com.github.cekmorse.api.exception.NotModifiedException;
import com.github.cekmorse.api.exception.ResourceNotFoundException;
import com.github.cekmorse.api.spring.AutoPagedResourcesAssembler;
import com.github.cekmorse.api.spring.HeaderVariable;
import com.github.cekmorse.persist.domain.RecipeDomain;
import com.github.cekmorse.service.RecipeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import ma.glasnost.orika.MapperFacade;

import static com.github.cekmorse.api.controller.ControllerDefaults.DEFAULT_PAGE_SIZE;
import static com.github.cekmorse.api.controller.ControllerDefaults.DEFAULT_SORT_FIELD;

/**
 * Created by keith on 6/21/17.
 */
@RestController
@RequestMapping(value = "/recipes")
@Transactional
public class RecipeController {

    @Autowired
    protected RecipeService service;

    @Autowired
    protected MapperFacade mapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<PagedResources<RecipeFull>> getRecipe(
            @HeaderVariable("If-Modified-Since")
            final Date aIfModifiedSince,
            @PageableDefault(
                    size = DEFAULT_PAGE_SIZE,
                    sort = DEFAULT_SORT_FIELD,
                    direction = Sort.Direction.DESC)
                    Pageable aPageable,
            AutoPagedResourcesAssembler<RecipeFull>
                    aPageAssembler
    ) throws ResourceNotFoundException, BadRequestException
    {
        Page<RecipeDomain> domain = service.findAll(aPageable, aIfModifiedSince);
        if (domain == null)
        {
            throw new ResourceNotFoundException("No samples found");
        }

        return ResponseEntity.ok(aPageAssembler.toResource(domain, aPageable, RecipeFull.class));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RecipeFull> getSample(
            @PathVariable("id")
            final String aId,
            @HeaderVariable("If-Modified-Since")
            final Date aIfModifiedSince
    ) throws ResourceNotFoundException, BadRequestException, NotModifiedException
    {
        if (aId == null)
        {
            throw new BadRequestException("Missing id");
        }
        RecipeDomain domain = service.findOne(aId);
        if (domain == null)
        {
            throw new ResourceNotFoundException("identifier=" + aId);
        }
        if (aIfModifiedSince != null && !domain.getUpdatedAt().after(aIfModifiedSince))
        {
            throw new NotModifiedException(domain.getUpdatedAt());
        }
        return ResponseEntity.ok(mapper.map(domain, RecipeFull.class));
    }

    // TODO: 6/22/17 Setup ASYNC for Create Update Delete.
}
