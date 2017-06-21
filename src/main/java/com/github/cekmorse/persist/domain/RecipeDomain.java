package com.github.cekmorse.persist.domain;


import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by keith on 6/16/17.
 */
@Entity
@Table(name = "recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = false)
@EqualsAndHashCode(of = {"uuid"})
public class RecipeDomain implements HasUuid, Cloneable{

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", nullable = false)
    private String uuid;

    @Basic
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Basic
    @Column(name = "createdAt", unique = false, nullable = false)
    private Date createdAt;

    @Basic
    @Column(name = "updatedAt", unique = false, nullable = false)
    private Date updatedAt;

    @Basic
    @Column(name = "author", unique = false, nullable = true)
    private String author;

    @Basic
    @Column(name = "sourceDoc", unique = false, nullable = true)
    private String sourceDoc;

//    private List<IngredientDomain> ingredients;
//    private List<InstructionDomain> instructions;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (RecipeDomain) super.clone();
    }
}
