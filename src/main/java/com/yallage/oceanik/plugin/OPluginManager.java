package com.yallage.oceanik.plugin;

import com.yallage.oceanik.util.IO;
import lombok.Getter;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.yallage.oceanik.util.Base.TODO;
import static com.yallage.oceanik.util.Base.YAML;

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
    @NotNull public OceanikPlugin loadPlugin(@NotNull JavaPlugin plugin) throws InvalidPluginException, InvalidDescriptionException {
        OPluginDescriptionFile desc;
        Class<? extends OceanikPlugin> main;
        OceanikPlugin inst;
        try {
            desc = YAML.loadAs(IO.getResourceReader(plugin, "oceanik.yml"), OPluginDescriptionFile.class);
            main = ClassLoader.getSystemClassLoader().loadClass(desc.getMain()).asSubclass(OceanikPlugin.class);
            inst = main.getConstructor().newInstance();
            inst.setParent(plugin);
        } catch (NullPointerException | ClassNotFoundException | ClassCastException | NoSuchMethodException e) {
            throw new InvalidPluginException(e);
        } catch (Exception e) {
            throw new InvalidDescriptionException(e);
        }
        plugins.add(inst);
        return inst;
    }

    public void enablePlugin(@NotNull OceanikPlugin plugin) {
        TODO();
    }

    public void disablePlugin(@NotNull OceanikPlugin plugin) {
        TODO();
    }

}
