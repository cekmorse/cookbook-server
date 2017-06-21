package com.github.cekmorse.api.dto;

import com.github.cekmorse.persist.domain.HasUuid;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by keith on 6/21/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = false)
@EqualsAndHashCode(of = {"uuid"})
public class HasUuidImplBase implements HasUuid, Serializable{
    private String uuid;
}
