package com.milkory.oceanik.util;

import com.google.common.annotations.Beta;
import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.util.*;

/**
 * Base utilities. (only for Java)
 *
 * @author Milkory
 */
public class Base {

    public static final Gson GSON = new Gson();
    public static final Yaml YAML = new Yaml();
    public static final Random RANDOM = new Random();

    public static void TODO() {
        throw new UnsupportedOperationException("Operation is not implemented");
    }

    public static void TODO(String msg) {
        throw new UnsupportedOperationException("Operation is not implemented: " + msg);
    }

    public static void error() {
        throw new IllegalStateException("Something went wrong");
    }

    public static void error(String msg) {
        throw new IllegalStateException("Something went wrong: " + msg);
    }

    public static void ignoreReturn(Object any) {
    }

    @Beta @SafeVarargs public static <T> List<T> listOf(T... elements) {
        return List.of(elements);
    }

    @Beta @SafeVarargs public static <T> List<T> mutableListOf(T... elements) {
        var list = new ArrayList<T>(elements.length);
        list.addAll(Arrays.asList(elements));
        return list;
    }

}
