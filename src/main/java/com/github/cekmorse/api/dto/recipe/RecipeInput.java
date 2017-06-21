package com.github.cekmorse.api.dto.recipe;

import com.github.cekmorse.api.dto.HasUuidImplBase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by keith on 6/21/17.
 */
@Getter
@Setter
@ToString(callSuper = true )
@NoArgsConstructor
public class RecipeInput extends HasUuidImplBase {
    private String name;
}
