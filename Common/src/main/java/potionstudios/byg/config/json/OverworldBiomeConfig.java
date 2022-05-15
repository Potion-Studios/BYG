package potionstudios.byg.config.json;

import blue.endless.jankson.JsonElement;
import blue.endless.jankson.api.SyntaxError;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.overworld.BYGOverworldBiomeSelectors;
import potionstudios.byg.common.world.biome.overworld.OverworldRegion;
import potionstudios.byg.util.ModPlatform;
import potionstudios.byg.util.codec.FromFileOps;
import potionstudios.byg.util.codec.Wrapped;
import potionstudios.byg.util.jankson.JanksonJsonOps;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static potionstudios.byg.util.jankson.JanksonUtil.createConfig;

public record OverworldBiomeConfig(boolean generateOverworld,
                                   List<Wrapped<OverworldRegion>> values) {
    public static final OverworldBiomeConfig DEFAULT = new OverworldBiomeConfig(true, OverworldRegion.OVERWORLD_DEFAULTS);

    public static OverworldBiomeConfig INSTANCE = null;

    public static final Map<String, String> COMMENTS = Util.make(new HashMap<>(), map -> {
        map.put("overworld_enabled", "Global toggle to enable or disable BYG's overworld biomes.");
        map.put("regions", "A list of weighted regions containing a unique biome layout.\nRegions may be inlined or may call a file from \"this_file_parent_directory/regions\"");
    });

    public static final Codec<OverworldBiomeConfig> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.BOOL.fieldOf("overworld_enabled").forGetter(overworldBiomeConfig -> overworldBiomeConfig.generateOverworld),
                    OverworldRegion.BIOME_PROVIDER_DATA_FROM_FILE_CODEC.listOf().fieldOf("regions").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values)
            ).apply(builder, OverworldBiomeConfig::new)
    );

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
                    FROM_OLD_CODEC_LIST.fieldOf("providers").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values)
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
            BYG.LOGGER.warn("Old overworld config detected, lets try and repair it...");
        }

        FromFileOps.Access registry = new FromFileOps.Access();
        FromFileOps<JsonElement> fromFileOps = new FromFileOps<>(JanksonJsonOps.INSTANCE, registry);
        Path regions = path.getParent().resolve("regions");
        Path biomePickers = path.getParent().resolve("biome_selectors");

        try {
            createDefaultsAndRegister(recreate, BYGOverworldBiomeSelectors.BIOME_LAYOUTS, registry.get("biome_layout"), BYGOverworldBiomeSelectors.BIOME_LAYOUT_CODEC, fromFileOps, biomePickers);
            createDefaultsAndRegister(recreate, OverworldRegion.BIOME_REGIONS, registry.get("regions"), OverworldRegion.BIOME_PROVIDER_DATA_FROM_FILE_CODEC, fromFileOps, regions);
            if (!path.toFile().exists() || recreate) {
                createConfig(path, CODEC, JanksonUtil.HEADER_CLOSED, COMMENTS, fromFileOps, getOldOrDefault);
            }
            OverworldBiomeConfig overworldBiomeConfig = JanksonUtil.readConfig(path, CODEC, fromFileOps);
            BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));
            return overworldBiomeConfig;
        } catch (IOException | SyntaxError e) {
            throw new IllegalStateException(e);
        }
    }

    private static <T> void createDefaultsAndRegister(boolean recreate, Map<String, Pair<Map<String, String>, T>> defaults, Map<String, T> registry, Codec<T> codec, FromFileOps<JsonElement> fromFileOps, Path providers) throws IOException {
        defaults.forEach((s, listWrapped) -> {
            Path registryPath = providers.resolve(s + ".json5");
            if (!registryPath.toFile().exists() || recreate) {
                createConfig(registryPath, codec, listWrapped.getFirst().getOrDefault("", JanksonUtil.HEADER_CLOSED), listWrapped.getFirst(), fromFileOps, listWrapped.getSecond());
            }
        });


        Files.walk(providers).forEach(path1 -> {
            String fileName = path1.getFileName().toString();
            if (fileName.endsWith(".json5") || fileName.endsWith(".json")) {
                String relativizedPath = providers.relativize(path1).toString();
                String id = relativizedPath.replace(".json5", "").replace(".json", "").replace("\\", "/");
                try {
                    registry.put(id, JanksonUtil.readConfig(path1, codec, fromFileOps));
                } catch (IOException | SyntaxError e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static <T> T readAndDeleteOldOverworldConfig(Path oldPath, Codec<T> codec, DynamicOps<JsonElement> ops, T from) {
        if (oldPath.toFile().exists()) {
            try {
                from = JanksonUtil.readConfig(oldPath, codec, ops);
                Files.delete(oldPath);
            } catch (IOException | SyntaxError e) {
                e.printStackTrace();
            }
        }
        return from;
    }
}
