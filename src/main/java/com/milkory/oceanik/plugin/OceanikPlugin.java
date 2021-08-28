package com.milkory.oceanik.plugin;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginBase;
import org.bukkit.plugin.PluginLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import static lombok.AccessLevel.*;

/**
 * Represents a plugin dependent on Oceanik.
 *
 * @author Milkory
 */
public abstract class OceanikPlugin extends PluginBase {

    @Getter @Setter(PACKAGE) private Plugin parent;
    @Getter @Setter(PACKAGE) private OPluginDescription description;

    @Override public void onDisable() {
    }

    @Override public void onLoad() {
    }

    @Override public void onEnable() {
    }

    @Override public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return true;
    }

    @Nullable @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }

    // region # Delegating methods

    @NotNull @Override public final File getDataFolder() {
        return parent.getDataFolder();
    }

    @Nullable @Override public final InputStream getResource(@NotNull String filename) {
        return parent.getResource(filename);
    }

    @Override public final void saveResource(@NotNull String resourcePath, boolean replace) {
        parent.saveResource(resourcePath, replace);
    }

    @NotNull @Override public final PluginLoader getPluginLoader() {
        return parent.getPluginLoader();
    }

    @NotNull @Override public final Server getServer() {
        return parent.getServer();
    }

    @Override public final boolean isEnabled() {
        return parent.isEnabled();
    }

    @Nullable @Override public final ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
        return parent.getDefaultWorldGenerator(worldName, id);
    }

    @NotNull @Override public final Logger getLogger() {
        return parent.getLogger();
    }

    // endregion

}
