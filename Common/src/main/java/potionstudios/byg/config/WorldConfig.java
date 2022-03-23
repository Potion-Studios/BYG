package potionstudios.byg.config;

import java.nio.file.Path;

import static potionstudios.byg.BYG.CONFIG_PATH;

public class WorldConfig {

    public static WorldConfig INSTANCE = null;
    public final boolean appendBiomePlacedFeatures;

    public WorldConfig(Path path) {
        CommentedConfigBuilder builder = new CommentedConfigBuilder(path);
        this.appendBiomePlacedFeatures = builder.add(
            """
                Append BYG's placed features to all biomes? By disabling this, you remove BYG placed features not designated to specific biomes.
                To configure the features that spawn using this, use the "/worldgenexport" command and edit the files found at:
                "byg/worldgen/placed_feature/global/<decoration_stage>"
                "byg/worldgen/placed_feature/global/placed_feature/<feature>"
                "byg/worldgen/configured_feature/global/<decoration_stage>"
                in the output folder.""",
            "append_biome_placed_features", true);
        builder.build();
    }

    public static WorldConfig worldConfig(boolean refreshConfig) {
        if (INSTANCE == null || refreshConfig) {
            INSTANCE = new WorldConfig(CONFIG_PATH.resolve("byg-world.toml"));
        }
        return INSTANCE;
    }

    public static WorldConfig worldConfig() {
        return worldConfig(false);
    }
}