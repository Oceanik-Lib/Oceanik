package com.milkory.oceanik.util;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.util.Objects;

/**
 * IO utilities.
 *
 * @author Milkory
 */
public class IO {

    /** Let an {@link OutputStream} read all bytes from an {@link InputStream}, then close and return it. */
    public static <T extends OutputStream> T readFully(InputStream in, T out) throws IOException {
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1) {
            out.write(buf, 0, len);
        }
        out.close();
        return out;
    }

    /** Get an {@link InputStreamReader} of a specified file from a {@link Plugin}. */
    public static InputStreamReader getResourceReader(Plugin plugin, String file) {
        return new InputStreamReader(Objects.requireNonNull(plugin.getResource(file)));
    }

    public static YamlConfiguration loadYamlResource(Plugin plugin, String file) {
        return YamlConfiguration.loadConfiguration(getResourceReader(plugin, file));
    }

    /** Initialize a file, including creating the parent folders and itself. */
    public static File initFile(File file) throws IOException {
        if (!file.exists()) {
            initFolder(file.getParentFile());
            if (!file.createNewFile()) {
                throw new IOException("Failed to create file - " + file.getPath());
            }
        }
        return file;
    }

    /** Initialize a folder, which means to create it. */
    public static File initFolder(File file) throws IOException {
        if (!file.exists()) {
            if (file.isFile() || !file.mkdirs()) {
                throw new IOException("Failed to create folder - " + file.getPath());
            }
        }
        return file;
    }

}
