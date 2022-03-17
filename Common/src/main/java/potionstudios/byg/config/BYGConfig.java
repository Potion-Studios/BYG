package potionstudios.byg.config;

import java.nio.file.Path;

import static potionstudios.byg.BYG.CONFIG_PATH;

public class BYGConfig {
    private static BYGConfig INSTANCE = null;

    public final boolean appendLootTables;

    public BYGConfig(Path path) {
        CommentedConfigBuilder commentedConfigBuilder = new CommentedConfigBuilder(path);
        this.appendLootTables = commentedConfigBuilder.add("Append BYG items automatically to applicable loot tables?", "append_loot_tables", true);
        commentedConfigBuilder.build();
    }

    public static BYGConfig getConfig() {
        return getConfig(false);
    }

    public static BYGConfig getConfig(boolean refreshConfig) {
        if (INSTANCE == null || refreshConfig) {
            INSTANCE = new BYGConfig(CONFIG_PATH.resolve("byg-common.toml"));
        }
        return INSTANCE;
    }
}