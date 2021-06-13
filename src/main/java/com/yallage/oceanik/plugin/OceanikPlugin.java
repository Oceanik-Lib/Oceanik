package com.yallage.oceanik.plugin;

import lombok.Getter;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginBase;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

/**
 * Represents a plugin dependent on Oceanik.
 *
 * @author Milkory
 */
public abstract class OceanikPlugin extends PluginBase {

    @Getter private Plugin parent;

    void setParent(Plugin parent) {
        this.parent = parent;
    }

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

    // region # Delegated methods

    @NotNull @Override public File getDataFolder() {
        return parent.getDataFolder();
    }

    @NotNull @Override public PluginDescriptionFile getDescription() {
        return parent.getDescription();
    }

    @NotNull @Override public FileConfiguration getConfig() {
        return parent.getConfig();
    }

    @Nullable @Override public InputStream getResource(@NotNull String filename) {
        return parent.getResource(filename);
    }

    @Override public void saveConfig() {
        parent.saveConfig();
    }

    @Override public void saveDefaultConfig() {
        parent.saveDefaultConfig();
    }

    @Override public void saveResource(@NotNull String resourcePath, boolean replace) {
        parent.saveResource(resourcePath, replace);
    }

    @Override public void reloadConfig() {
        parent.reloadConfig();
    }

    @NotNull @Override public PluginLoader getPluginLoader() {
        return parent.getPluginLoader();
    }

    @NotNull @Override public Server getServer() {
        return parent.getServer();
    }

    @Override public boolean isEnabled() {
        return parent.isEnabled();
    }

    @Override public boolean isNaggable() {
        return parent.isNaggable();
    }

    @Override public void setNaggable(boolean canNag) {
        parent.setNaggable(canNag);
    }

    @Nullable @Override public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
        return parent.getDefaultWorldGenerator(worldName, id);
    }

    @NotNull @Override public Logger getLogger() {
        return parent.getLogger();
    }

    // endregion

}