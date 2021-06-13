package com.yallage.oceanik.util;

import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.util.Random;

/**
 * Base utilities.
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

}
