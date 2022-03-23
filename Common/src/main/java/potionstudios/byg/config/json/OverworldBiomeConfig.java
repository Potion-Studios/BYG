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
import potionstudios.byg.common.world.biome.overworld.Region;
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
                                   List<Wrapped<Region>> values) {
    public static final OverworldBiomeConfig DEFAULT = new OverworldBiomeConfig(true, Region.OVERWORLD_DEFAULTS);

    public static OverworldBiomeConfig INSTANCE = null;

    public static final String HEADER_CLOSED = """
        /*
        This file uses the ".json5" file extension which allows for comments like this in a json file!
        Your text editor may show this file with invalid/no syntax, if so, we recommend you download:
                
        VSCode: https://code.visualstudio.com/
        JSON5 plugin(for VSCode): https://marketplace.visualstudio.com/items?itemName=mrmlnc.vscode-json5
                    
        to make editing this file much easier.
        */""";

    public static final String HEADER_OPEN = """
        /*
        This file uses the ".json5" file extension which allows for comments like this in a json file!
        Your text editor may show this file with invalid/no syntax, if so, we recommend you download:
                
        VSCode: https://code.visualstudio.com/
        JSON5 plugin(for VSCode): https://marketplace.visualstudio.com/items?itemName=mrmlnc.vscode-json5
                    
        to make editing this file much easier.""";

    public static final Map<String, String> COMMENTS = Util.make(new HashMap<>(), map -> {
        map.put("overworld_enabled", "Global toggle to enable or disable BYG's overworld biomes.");
        map.put("regions", "A list of weighted regions containing a unique biome layout.\nRegions may be inlined or may call a file from \"this_file_parent_directory/regions\"");
    });

    public static final Codec<OverworldBiomeConfig> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            Codec.BOOL.fieldOf("overworld_enabled").forGetter(overworldBiomeConfig -> overworldBiomeConfig.generateOverworld),
            Region.BIOME_PROVIDER_DATA_FROM_FILE_CODEC.listOf().fieldOf("regions").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values)
        ).apply(builder, OverworldBiomeConfig::new)
    );

    public static final Codec<List<Wrapped<Region>>> FROM_OLD_CODEC_LIST = Region.OLD_CODEC.listOf().comapFlatMap(biomeProviderDataList -> {
        List<Wrapped<Region>> wrapped = new ArrayList<>();
        for (int i = 0; i < biomeProviderDataList.size(); i++) {
            Region region = biomeProviderDataList.get(i);
            String id = "region_" + (i + 1);
            Wrapped<Region> dataWrapped = new Wrapped<>(Optional.of(id), region);
            Region.BIOME_REGIONS.put(id, Pair.of(Region.COMMENTS, dataWrapped));
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


    public static OverworldBiomeConfig getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        return INSTANCE;
    }

    public static void setConfigInstance(OverworldBiomeConfig config) {
        INSTANCE = config;
    }

    private static OverworldBiomeConfig readConfig() {
        final Path path = BYG.CONFIG_PATH.resolve("overworld").resolve("byg-overworld-biomes.json5");
        OverworldBiomeConfig getOldOrDefault = readAndDeleteOldOverworldConfig(BYG.CONFIG_PATH.resolve("overworld-biomes.json"), OLD_CODEC, JanksonJsonOps.INSTANCE, DEFAULT);
        if (getOldOrDefault != DEFAULT) {
            BYG.LOGGER.warn("Old overworld config detected, lets try and repair it...");
        }

        FromFileOps.Access registry = new FromFileOps.Access();
        FromFileOps<JsonElement> fromFileOps = new FromFileOps<>(JanksonJsonOps.INSTANCE, registry);
        Path regions = path.getParent().resolve("regions");
        Path biomePickers = path.getParent().resolve("biome_selectors");

        try {
            createDefaultsAndRegister(BYGOverworldBiomeSelectors.BIOME_LAYOUTS, registry.get("biome_layout"), BYGOverworldBiomeSelectors.BIOME_LAYOUT_CODEC, fromFileOps, biomePickers);
            createDefaultsAndRegister(Region.BIOME_REGIONS, registry.get("regions"), Region.BIOME_PROVIDER_DATA_FROM_FILE_CODEC, fromFileOps, regions);
            if (!path.toFile().exists()) {
                createConfig(path, CODEC, HEADER_CLOSED, COMMENTS, fromFileOps, getOldOrDefault);
            }
            OverworldBiomeConfig overworldBiomeConfig = JanksonUtil.readConfig(path, CODEC, fromFileOps);
            BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));
            return overworldBiomeConfig;
        } catch (IOException | SyntaxError e) {
            throw new IllegalStateException(e);
        }
    }

    private static <T> void createDefaultsAndRegister(Map<String, Pair<Map<String, String>, T>> defaults, Map<String, T> registry, Codec<T> codec, FromFileOps<JsonElement> fromFileOps, Path providers) throws IOException {
        defaults.forEach((s, listWrapped) -> {
            Path registryPath = providers.resolve(s + ".json5");
            if (!registryPath.toFile().exists()) {
                createConfig(registryPath, codec, listWrapped.getFirst().getOrDefault("", HEADER_CLOSED), listWrapped.getFirst(), fromFileOps, listWrapped.getSecond());
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
