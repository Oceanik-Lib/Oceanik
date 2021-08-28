package com.milkory.oceanik.plugin;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents an {@code oceanik.json} file of an {@link OceanikPlugin}.
 *
 * @author Milkory
 */
@Getter
@ToString
@EqualsAndHashCode
public class OPluginDescription {
    private String name;
    private String version;
    private String description;
    private String main;
    private String author;
    private String license;
}
