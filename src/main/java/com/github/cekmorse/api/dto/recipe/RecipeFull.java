package com.github.cekmorse.api.dto.recipe;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by keith on 6/21/17.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class RecipeFull {
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private String author;
    private String sourceDoc;
}
