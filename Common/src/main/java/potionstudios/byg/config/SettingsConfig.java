package potionstudios.byg.config;

import blue.endless.jankson.api.SyntaxError;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import potionstudios.byg.BYG;
import potionstudios.byg.util.ModPlatform;
import potionstudios.byg.util.jankson.JanksonJsonOps;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.function.Supplier;

public record SettingsConfig(boolean appendBiomePlacedFeatures, boolean appendLootTables, boolean customVillagers,
                             boolean customStructures, boolean useBYGWorldGen) {

    public static final Supplier<Path> CONFIG_PATH = () -> ModPlatform.INSTANCE.configPath().resolve("settings.json5");

    private static SettingsConfig INSTANCE = null;

    private static final SettingsConfig DEFAULT = new SettingsConfig(true, true, true, true, true);

    public static final Codec<SettingsConfig> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            Codec.BOOL.fieldOf("add_biome_placed_features").orElse(true).forGetter(config -> config.appendBiomePlacedFeatures),
            Codec.BOOL.fieldOf("add_loot_tables").orElse(true).forGetter(config -> config.appendLootTables),
            Codec.BOOL.fieldOf("add_custom_villagers").orElse(true).forGetter(config -> config.customVillagers),
            Codec.BOOL.fieldOf("add_custom_structures").orElse(true).forGetter(config -> config.customStructures),
            Codec.BOOL.fieldOf("world_generation").orElse(true).forGetter(config -> config.useBYGWorldGen)
        ).apply(builder, SettingsConfig::new)
    );

    public static SettingsConfig getConfig() {
        return getConfig(false, false);
    }

    public static SettingsConfig getConfig(boolean serialize, boolean recreate) {
        if (INSTANCE == null || serialize || recreate) {
            INSTANCE = readConfig(recreate);
        }

        return INSTANCE;
    }

    public static void setConfigInstance(SettingsConfig config) {
        INSTANCE = config;
    }

    private static SettingsConfig readConfig(boolean recreate) {
        final Path path = CONFIG_PATH.get();

        if (!path.toFile().exists() || recreate) {
            createConfig(path);
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return JanksonUtil.readConfig(path, CODEC, JanksonJsonOps.INSTANCE);
        } catch (IOException | SyntaxError e) {
            throw new RuntimeException(e);
        }
    }

    private static void createConfig(Path path) {
        HashMap<String, String> comments = Util.make(new HashMap<>(), map -> {
            map.put("add_biome_placed_features", """
                Add BYG's placed features to all biomes?
                                
                By disabling this, you remove BYG placed features not designated to specific biomes.
                
                To configure the features that spawn using this, use the "/worldgenexport" command and edit the files found at:
                "byg/worldgen/placed_feature/global/<decoration_stage>"
                "byg/worldgen/placed_feature/global/placed_feature/<feature>"
                "byg/worldgen/configured_feature/global/<decoration_stage>"
                in the output folder.""");
            map.put("add_loot_tables", """
                Add BYG items automatically to applicable loot tables?
                                
                For example BYG may add piglin trades to the piglin trade loot table.
                                
                To configure these loot tables or add your own, create a datapack with loot tables matching the following path:
                "data/modid/append_loot_tables/file_path_to_loot_table_you_want_to_append"
                                
                Examples:
                BYG's added Piglin trades: "data/byg/append_loot_tables/minecraft/gameplay/piglin_bartering.json",
                BYG's added loot to abandoned mineshafts: "data/byg/append_loot_tables/minecraft/chests/abandoned_mineshaft.json"
                BYG's added loot to Repurposed Structure's Jungle Village Jungle House: "data/byg/append_loot_tables/repurposed_structures/chests/villages/jungle_house.json"
                """);
            map.put("add_custom_villagers", "Add custom BYG Villagers/Structures to villages?");
            map.put("add_custom_structures", "Add custom BYG Structures?");
            map.put("world_generation", "Use BYG world generation?");
        });
        JanksonUtil.createConfig(path, CODEC, JanksonUtil.HEADER_CLOSED, comments, JanksonJsonOps.INSTANCE, DEFAULT);
    }
}