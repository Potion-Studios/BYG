package potionstudios.byg.config;

import java.nio.file.Path;

import static potionstudios.byg.BYG.CONFIG_PATH;

public class WorldConfig {

    public static WorldConfig INSTANCE = null;
    private final CommentedConfigBuilder configHelper;

    public WorldConfig(Path path) {
        this.configHelper = new CommentedConfigBuilder(path);
        this.configHelper.build();
    }

    public static WorldConfig worldConfig(boolean refreshConfig) {
        if (INSTANCE == null || refreshConfig) {
            INSTANCE = new WorldConfig(CONFIG_PATH.resolve("world.toml"));
        }
        return INSTANCE;
    }

    public static WorldConfig worldConfig() {
        return worldConfig(false);
    }
}