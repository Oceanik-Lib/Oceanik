package com.milkory.oceanik;

import lombok.Getter;

import java.io.File;
import java.util.logging.Logger;

/**
 * The main class of Oceanik.
 *
 * @author Milkory
 */
public class Oceanik {

    @Getter private static final Oceanik instance = new Oceanik();

    private final Logger logger = Logger.getLogger("Oceanik");
    private final File rootPath = new File(System.getProperty("user.dir"), "libs/Oceanik/");

    private Oceanik() {
        System.out.println(rootPath.getPath());
        logger.info("Oceanik loaded successfully!");
    }

}
