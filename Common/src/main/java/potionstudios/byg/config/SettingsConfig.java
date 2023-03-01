package potionstudios.byg.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgitaco.corgilib.serialization.codec.CollectionCodec;
import corgitaco.corgilib.serialization.codec.CommentedCodec;
import corgitaco.corgilib.serialization.jankson.JanksonJsonOps;
import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import corgitaco.corgilib.shadow.blue.endless.jankson.api.SyntaxError;
import potionstudios.byg.util.ModPlatform;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public record SettingsConfig(boolean appendBiomePlacedFeatures, boolean appendLootTables, boolean customVillagers,
                             boolean customStructures, boolean useBYGWorldGen, LoggerSettings loggerSettings) {

    public static final Supplier<Path> CONFIG_PATH = () -> ModPlatform.INSTANCE.configPath().resolve("settings.json5");

    private static SettingsConfig INSTANCE = null;

    private static final SettingsConfig DEFAULT = new SettingsConfig(true, true, true, true, true, new LoggerSettings(false, true, false, Set.of()));

    public static final Codec<SettingsConfig> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    CommentedCodec.of(Codec.BOOL, "add_global_biome_placed_features", """
                                            
                            Add global BYG features to non BYG biomes?
                                                                
                            By disabling this, you remove BYG placed features not designated to specific BYG biomes.
                                            
                            Such features include but are not limited to:
                            -Ores
                            -Stones
                            -Palm Trees
                                            
                            To configure the features that spawn using this, use the "/corgilib worldRegistryExport" command and edit the files found at:
                                            
                            "byg/worldgen/placed_feature/global/<decoration_stage>"
                            "byg/worldgen/placed_feature/global/placed_feature/<feature>"
                            "byg/worldgen/configured_feature/global/<decoration_stage>"
                                            
                            in the output folder.
                            """).orElse(true).forGetter(config -> config.appendBiomePlacedFeatures),
                    CommentedCodec.of(Codec.BOOL, "add_loot_tables", """
                                                        
                            Add BYG items automatically to applicable loot tables?
                                            
                            For example BYG may add:
                            -Piglin trades to the piglin trade loot table.
                            -Loot to vanilla structures such as Abandoned Mineshafts or Jungle temples.
                                           
                            To configure these loot tables or add your own, create a datapack with loot tables matching the following path:
                            "data/modid/append_loot_tables/file_path_to_loot_table_you_want_to_append"
                                            
                            Examples:
                            BYG's added Piglin trades: "data/byg/append_loot_tables/minecraft/gameplay/piglin_bartering.json",
                            BYG's added loot to abandoned mineshafts: "data/byg/append_loot_tables/minecraft/chests/abandoned_mineshaft.json"
                            BYG's added loot to Repurposed Structure's Jungle Village Jungle House: "data/byg/append_loot_tables/repurposed_structures/chests/villages/jungle_house.json"
                                              
                            """).orElse(true).forGetter(config -> config.appendLootTables),
                    CommentedCodec.of(Codec.BOOL, "add_custom_villagers", "Add custom BYG Villagers & Structures to villages?").orElse(true).forGetter(config -> config.customVillagers),
                    CommentedCodec.of(Codec.BOOL, "add_custom_structures", "Add custom BYG Structures?").orElse(true).forGetter(config -> config.customStructures),
                    CommentedCodec.of(Codec.BOOL, "world_generation", "Use BYG world generation?").orElse(true).forGetter(config -> config.useBYGWorldGen),
                    CommentedCodec.of(LoggerSettings.CODEC, "logger_settings", "Logger settings.").orElse(new LoggerSettings(false, false, false, Set.of())).forGetter(config -> config.loggerSettings)
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

        try {
            return JanksonUtil.readConfig(path, CODEC, JanksonJsonOps.INSTANCE);
        } catch (IOException | SyntaxError e) {
            throw new RuntimeException(e);
        }
    }

    private static void createConfig(Path path) {
        JanksonUtil.createConfig(path, CODEC, JanksonUtil.HEADER_CLOSED, Map.of(), JanksonJsonOps.INSTANCE, DEFAULT);
    }

    public record LoggerSettings(boolean logInfo, boolean logWarnings, boolean logDebug, Set<String> exclude) {
        public static final Codec<Set<String>> HASH_SET_CODEC = new CollectionCodec<>(Codec.STRING, HashSet::new);

        public static final Codec<LoggerSettings> CODEC = RecordCodecBuilder.create(builder ->
                builder.group(
                        Codec.BOOL.fieldOf("log_info").orElse(false).forGetter(config -> config.logInfo),
                        Codec.BOOL.fieldOf("log_warnings").orElse(false).forGetter(config -> config.logWarnings),
                        Codec.BOOL.fieldOf("log_debug").orElse(false).forGetter(config -> config.logDebug),
                        CommentedCodec.of(HASH_SET_CODEC, "exclude", """
                                Exclude BYG loggers that may contain any of the words or phrases in this list.
                                Example:
                                "exclude": [
                                           "event",
                                           "load event",
                                           "loaded"
                                           ]
                                """).orElse(Set.of()).forGetter(config -> config.exclude)
                ).apply(builder, LoggerSettings::new)
        );
    }
}