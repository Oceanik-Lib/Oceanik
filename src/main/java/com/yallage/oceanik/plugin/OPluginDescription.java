package com.yallage.oceanik.plugin;

import lombok.Getter;
import lombok.ToString;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.InvalidDescriptionException;

/**
 * The oceanik.yml file of a {@link OceanikPlugin}.
 *
 * @author Milkory
 */
@Getter
@ToString
public class OPluginDescription {

    final String main;

    public OPluginDescription(String main) {
        this.main = main;
    }

    public static OPluginDescription fromYaml(YamlConfiguration yaml) throws InvalidDescriptionException {
        if (!yaml.isString("main")) {
            throw new InvalidDescriptionException("Does not contain a main class.");
        }
        return new OPluginDescription(yaml.getString("main"));
    }

}
