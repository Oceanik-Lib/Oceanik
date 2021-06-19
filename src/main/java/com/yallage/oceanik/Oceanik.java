package com.yallage.oceanik;

import lombok.Getter;

import java.util.logging.Logger;

/**
 * The main class of Oceanik.
 *
 * @author Milkory
 */
public class Oceanik {

    @Getter private static final Oceanik instance = new Oceanik();

    private final Logger logger = Logger.getLogger("Oceanik");

    private Oceanik() {
        logger.info("Oceanik loaded successfully!");
    }

}
