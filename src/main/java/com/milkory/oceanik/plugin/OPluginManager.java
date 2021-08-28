package com.milkory.oceanik.plugin;

import com.milkory.oceanik.util.Base;
import com.milkory.oceanik.util.IO;
import lombok.Getter;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milkory
 */
public class OPluginManager {

    @Getter private static final OPluginManager instance = new OPluginManager();

    @Getter private final List<OceanikPlugin> plugins = new ArrayList<>();

    /**
     * Load an {@link OceanikPlugin} from a specified {@link JavaPlugin}.
     *
     * @param plugin JavaPlugin to be loaded.
     * @return OceanikPlugin of the JavaPlugin if succeed.
     * @throws InvalidPluginException Thrown when the specified file is an invalid plugin.
     */
    @NotNull public OceanikPlugin loadPlugin(@NotNull JavaPlugin plugin) throws InvalidPluginException {
        OPluginDescription desc;
        Class<? extends OceanikPlugin> main;
        OceanikPlugin inst;
        try {
            desc = Base.GSON.fromJson(IO.getResourceReader(plugin, "oceanik.json"), OPluginDescription.class);
            main = plugin.getClass().getClassLoader().loadClass(desc.getMain()).asSubclass(OceanikPlugin.class);
            inst = main.getConstructor().newInstance();
            inst.setParent(plugin);
            inst.setDescription(desc);
        } catch (Exception e) {
            throw new InvalidPluginException(e);
        }
        plugins.add(inst);
        return inst;
    }

    public void enablePlugin(@NotNull OceanikPlugin plugin) {
        Base.TODO();
    }

    public void disablePlugin(@NotNull OceanikPlugin plugin) {
        Base.TODO();
    }

}
