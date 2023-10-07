package potionstudios.byg.config.json;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgitaco.corgilib.serialization.codec.CommentedCodec;
import corgitaco.corgilib.serialization.codec.FromFileOps;
import corgitaco.corgilib.serialization.codec.Wrapped;
import corgitaco.corgilib.serialization.jankson.JanksonJsonOps;
import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import corgitaco.corgilib.shadow.blue.endless.jankson.JsonElement;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.overworld.BYGOverworldBiomeSelectors;
import potionstudios.byg.common.world.biome.overworld.OverworldRegion;
import potionstudios.byg.config.BYGConfigHandler;
import potionstudios.byg.util.ModPlatform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static corgitaco.corgilib.serialization.jankson.JanksonUtil.createConfig;


public record OverworldBiomeConfig(boolean generateOverworld,
                                   List<Wrapped<OverworldRegion>> values, Map<ResourceKey<Biome>, ResourceKey<Biome>> globalSwapper) {

    public static final Codec<Map<ResourceKey<Biome>, ResourceKey<Biome>>> BIOME_SWAPPER = Codec.unboundedMap(ResourceKey.codec(Registries.BIOME), ResourceKey.codec(Registries.BIOME));


    public static final Codec<OverworldBiomeConfig> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    CommentedCodec.of(Codec.BOOL, "overworld_enabled", "Global toggle to enable or disable BYG's overworld biomes.").forGetter(overworldBiomeConfig -> overworldBiomeConfig.generateOverworld),
                    CommentedCodec.of(OverworldRegion.BIOME_PROVIDER_DATA_FROM_FILE_CODEC.listOf(), "regions", "A list of weighted regions containing a unique biome layout.\nRegions may be inlined or may call a file from \"this_file_parent_directory/regions\"").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values),
                    CommentedCodec.of(BIOME_SWAPPER, "global_biome_swapper", """
                            Global biome swapper that swaps any biome of your choice with another in all BYG Overworld regions.
                            
                            You must use biome ids.
                            
                            Example:
                            =====================
                            
                            "global_biome_swapper": {
                                "byg:atacama_desert": "minecraft:desert",
                                "byg:bayou": "minecraft:swamp",
                                "minecraft:sunflower_plains": "byg:black_forest"
                            }
                            
                            =====================
                            
                            """).forGetter(overworldBiomeConfig -> overworldBiomeConfig.globalSwapper)
            ).apply(builder, OverworldBiomeConfig::new)
    );

    public static final OverworldBiomeConfig DEFAULT = new OverworldBiomeConfig(true, OverworldRegion.OVERWORLD_DEFAULTS, Map.of());

    public static OverworldBiomeConfig INSTANCE = null;

    public static final Codec<List<Wrapped<OverworldRegion>>> FROM_OLD_CODEC_LIST = OverworldRegion.OLD_CODEC.listOf().comapFlatMap(biomeProviderDataList -> {
        List<Wrapped<OverworldRegion>> wrapped = new ArrayList<>();
        for (int i = 0; i < biomeProviderDataList.size(); i++) {
            OverworldRegion overworldRegion = biomeProviderDataList.get(i);
            String id = "region_" + (i + 1);
            Wrapped<OverworldRegion> dataWrapped = new Wrapped<>(Optional.of(id), overworldRegion);
            OverworldRegion.BIOME_REGIONS.put(id, Pair.of(OverworldRegion.COMMENTS, dataWrapped));
            wrapped.add(dataWrapped);
        }
        return DataResult.success(wrapped);
    }, wrapped -> wrapped.stream().map(Wrapped::value).collect(Collectors.toList()));


    public static final Codec<OverworldBiomeConfig> OLD_CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.BOOL.fieldOf("overworld_enabled").forGetter(overworldBiomeConfig -> overworldBiomeConfig.generateOverworld),
                    FROM_OLD_CODEC_LIST.fieldOf("providers").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values),
                    BIOME_SWAPPER.fieldOf("global_biome_swapper").forGetter(overworldBiomeConfig -> overworldBiomeConfig.globalSwapper)
            ).apply(builder, OverworldBiomeConfig::new)
    );


    public static OverworldBiomeConfig getConfig() {
        return getConfig(false, false);
    }

    public static OverworldBiomeConfig getConfig(boolean serialize, boolean recreate) {
        if (INSTANCE == null || serialize || recreate) {
            INSTANCE = readConfig(recreate);
        }

        return INSTANCE;
    }

    public static void setConfigInstance(OverworldBiomeConfig config) {
        INSTANCE = config;
    }

    private static OverworldBiomeConfig readConfig(boolean recreate) {
        final Path path = ModPlatform.INSTANCE.configPath().resolve("overworld").resolve("byg-overworld-biomes.json5");
        OverworldBiomeConfig getOldOrDefault = readAndDeleteOldOverworldConfig(ModPlatform.INSTANCE.configPath().resolve("overworld-biomes.json"), OLD_CODEC, JanksonJsonOps.INSTANCE, DEFAULT);
        if (getOldOrDefault != DEFAULT) {
            BYG.logWarning("Old overworld config detected, lets try and repair it...");
        }

        FromFileOps.Access registry = new FromFileOps.Access();
        FromFileOps<JsonElement> fromFileOps = new FromFileOps<>(JanksonJsonOps.INSTANCE, registry);
        Path regions = path.getParent().resolve("regions");
        Path biomePickers = path.getParent().resolve("biome_selectors");

        try {
            createDefaultsAndRegister(recreate, BYGOverworldBiomeSelectors.BIOME_LAYOUTS, registry.get("biome_layout"), BYGOverworldBiomeSelectors.BIOME_LAYOUT_CODEC, fromFileOps, biomePickers);
            createDefaultsAndRegister(recreate, OverworldRegion.BIOME_REGIONS, registry.get("regions"), OverworldRegion.BIOME_PROVIDER_DATA_FROM_FILE_CODEC, fromFileOps, regions);
            if (!path.toFile().exists() || recreate) {
                createConfig(path, CODEC, JanksonUtil.HEADER_CLOSED, Map.of(), fromFileOps, getOldOrDefault);
            }
            OverworldBiomeConfig overworldBiomeConfig = JanksonUtil.readConfig(path, CODEC, fromFileOps);
            BYG.logInfo(String.format("\"%s\" was read.", path));
            return overworldBiomeConfig;
        } catch (Exception e) {
            e.printStackTrace();
            BYGConfigHandler.CONFIG_EXCEPTIONS.add(e);
            return DEFAULT;
        }
    }

    private static <T> void createDefaultsAndRegister(boolean recreate, Map<String, Pair<Map<String, String>, T>> defaults, Map<String, T> registry, Codec<T> codec, FromFileOps<JsonElement> fromFileOps, Path providers) throws IOException {
        defaults.forEach((s, listWrapped) -> {
            Path registryPath = providers.resolve(s + ".json5");

            if (!registryPath.toFile().exists() || recreate) {
                createConfig(registryPath, codec, listWrapped.getFirst().getOrDefault("", JanksonUtil.HEADER_CLOSED), listWrapped.getFirst(), fromFileOps, listWrapped.getSecond());
            }
            registry.putIfAbsent(s, listWrapped.getSecond());
        });


        Files.walk(providers).forEach(path1 -> {
            String fileName = path1.getFileName().toString();
            if (fileName.endsWith(".json5") || fileName.endsWith(".json")) {
                String relativizedPath = providers.relativize(path1).toString();
                String id = relativizedPath.replace(".json5", "").replace(".json", "").replace("\\", "/");
                try {
                    registry.put(id, JanksonUtil.readConfig(path1, codec, fromFileOps));
                } catch (Exception e) {
                    e.printStackTrace();
                    BYGConfigHandler.CONFIG_EXCEPTIONS.add(e);
                }
            }
        });
    }

    private static <T> T readAndDeleteOldOverworldConfig(Path oldPath, Codec<T> codec, DynamicOps<JsonElement> ops, T from) {
        if (oldPath.toFile().exists()) {
            try {
                from = JanksonUtil.readConfig(oldPath, codec, ops);
                Files.delete(oldPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return from;
    }
}
