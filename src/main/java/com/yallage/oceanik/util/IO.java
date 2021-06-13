package com.yallage.oceanik.util;

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

    /** Initialize a file, including creating the parent folders and itself. */
    public static File initFile(File file) throws IOException {
        if (!file.exists()) {
            var parent = file.getParentFile();
            if (!(((parent.exists() && !parent.isFile()) || parent.mkdirs()) && file.createNewFile())) {
                throw new IOException("Failed to create file - " + file.getPath());
            }
        }
        return file;
    }

}
