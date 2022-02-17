package potionstudios.byg.util;

import potionstudios.byg.BYG;

import java.nio.file.Path;

public interface ModLoaderContext {

    Path configPath();

    static ModLoaderContext getInstance() {
        ModLoaderContext data = BYG.MODLOADER_DATA;

        if (data == null) {
            throw new RuntimeException("Accessed ModLoaderContext too early!");
        }

        return data;
    }
}
