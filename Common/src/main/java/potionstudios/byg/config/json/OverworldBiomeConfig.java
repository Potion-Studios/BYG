package potionstudios.byg.config.json;

import blue.endless.jankson.JsonElement;
import blue.endless.jankson.api.SyntaxError;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.overworld.BYGOverworldBiomeBuilders;
import potionstudios.byg.util.codec.FromFileOps;
import potionstudios.byg.util.codec.Wrapped;
import potionstudios.byg.util.jankson.JanksonJsonOps;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static potionstudios.byg.util.jankson.JanksonUtil.createConfig;

public record OverworldBiomeConfig(boolean generateOverworld,
                                   List<Wrapped<BYGOverworldBiomeBuilders.BiomeProviderData>> values) {
    public static final OverworldBiomeConfig DEFAULT = new OverworldBiomeConfig(true, BYGOverworldBiomeBuilders.OVERWORLD_DEFAULTS);

    public static OverworldBiomeConfig INSTANCE = null;

    public static final String HEADER = """
        /*
        This config is responsible for all overworld related settings for BYG.
        This file uses the ".json5" file extension which allows for comments like this in a json file!
        Your text editor may show this file with invalid/no syntax, if so, we recommend you download:
        
        VSCode: https://code.visualstudio.com/
        JSON5 plugin(for VSCode): https://marketplace.visualstudio.com/items?itemName=mrmlnc.vscode-json5
                    
        to make editing this file much easier.
        */
        """;

    public static final Map<String, String> COMMENTS = Util.make(new HashMap<>(), map -> {
        map.put("overworld_enabled", "Global toggle to enable or disable BYG's overworld biomes.");


        String biomeLayout = """
            [
            ARID-ICY,
            DRY-ICY,
            NEUTRAL-ICY,
            WET-ICY,
            HUMID-ICY
            ],
            [
            ARID-COLD,
            DRY-COLD,
            NEUTRAL-COLD,
            WET-COLD,
            HUMID-COLD
            ],
            [
            ARID-NEUTRAL,
            DRY-NEUTRAL,
            NEUTRAL-NEUTRAL,
            WET-NEUTRAL,
            HUMID-NEUTRAL
            ],
            [
            ARID-WARM,
            DRY-WARM,
            NEUTRAL-WARM,
            WET-WARM,
            HUMID-WARM
            ],
            [
            ARID-HOT,
            DRY-HOT,
            NEUTRAL-HOT,
            WET-HOT,
            HUMID-HOT
            ]
            """;

        String oceanLayout =
            """
                [
                SHALLOW-ICY,
                SHALLOW-COLD,
                SHALLOW-NEUTRAL,
                SHALLOW-WARM,
                SHALLOW-HOT
                ],
                [
                DEEP-ICY,
                DEEP-COLD,
                DEEP-NEUTRAL,
                DEEP-WARM,
                DEEP-HOT
                ]
                """;

        String requiresValidKeys =
            """
                All keys passed in must be valid in the biome registry!
                "minecraft:the_void" is invalid as it represents a value of "NULL(nothing)" internally.
                """;

        map.put("providers", "A list of weighted providers/regions that contain a unique biome layout.");

        map.put("providers.peak_biomes", "Appearing on mountainous terrain & BELOW weirdness 0, here is the \"peak_biomes\" layout:\n" + biomeLayout + requiresValidKeys);
        map.put("providers.peak_biomes_variant", "Appearing on mountainous terrain & ABOVE weirdness 0, here is the \"peak_biome_variants\" layout:\n" + biomeLayout + requiresValidKeys);
        map.put("providers.oceans", "Appearing on terrain below sea level, here is the \"ocean_biomes\" layout:\n" + oceanLayout + requiresValidKeys);

        map.put("providers.plateau_biomes", "Appearing on elevated flat terrain BELOW weirdness 0 or in unfilled(\"NULL(nothing)\") spots in \"plateau_biome_variants\", here is the \"plateau_biomes\" layout:\n" + biomeLayout + requiresValidKeys);
        map.put("providers.plateau_biomes_variant", "Appearing on elevated flat terrain ABOVE weirdness 0, here is the \"plateau_biomes\" layout:\n" + biomeLayout + """
            All keys passed in must be valid in the biome registry!
            "minecraft:the_void" is valid and represents NULL as it represents a value of "NULL(nothing)".
            In slots containing "minecraft:the_void", biomes at the equivalent temperature/humidity index in "plateau_biomes" will be used instead.
            """);
        map.put("providers.middle_biomes", "Appearing on terrain BELOW weirdness 0 or in unfilled(\"NULL(nothing)\") spots in \"middle_biomes_variants\", here is the \"middle_biomes\" layout:\n" + biomeLayout + requiresValidKeys);
        map.put("providers.middle_biomes_variant", "Appearing on terrain ABOVE weirdness 0, here is the \"middle_biomes_variant\" layout:\n" + biomeLayout +
            """
                All keys passed in must be valid in the biome registry!
                "minecraft:the_void" is valid and represents NULL as it represents a value of "NULL(nothing)".
                In slots containing "minecraft:the_void", biomes at the equivalent temperature/humidity index in "middle_biomes" will be used instead.
                """);

        map.put("providers.shattered_biomes", "Appearing on shattered terrain here is the \"shattered_biomes\" layout:\n" + biomeLayout +
            """
                All keys passed in must be valid in the biome registry!
                "minecraft:the_void" is valid and represents NULL as it represents a value of "NULL(nothing)".
                In slots containing "minecraft:the_void", biomes at the equivalent temperature/humidity index in "middle_biomes" will be used instead.
                """);

        map.put("providers.beach_biomes", "Appearing on terrain bordering oceans, here is the \"beach_biomes\" layout:\n" + biomeLayout + requiresValidKeys);
        map.put("providers.swapper",
            """
                Used to swap biomes not found in the temperature/humidity layouts.
                Biomes found within the biome selectors, may not be used as the swapped "value" and biomes only from Minecraft may be used as the "key".
                            
                "key" = "minecraft:biome_registry_path"
                "value" = "modid:new_biome_registry_path"
                "key":"value"
                """);
        map.put("providers.weight",
            """
                The weight of this provider/region against all other providers.
                Higher numbers do NOT increase the provider's size.
                Weight "0" disables this provider and all its entries.
                """
        );
    });

    public static final Codec<OverworldBiomeConfig> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            Codec.BOOL.fieldOf("overworld_enabled").forGetter(overworldBiomeConfig -> overworldBiomeConfig.generateOverworld),
            BYGOverworldBiomeBuilders.BIOME_PROVIDER_DATA_FROM_FILE_CODEC.listOf().fieldOf("providers").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values)
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
        OverworldBiomeConfig from = readAndDeleteOldOverworldConfig(BYG.CONFIG_PATH.resolve("byg-overworld-biomes.json"), CODEC, JanksonJsonOps.INSTANCE, DEFAULT);


        FromFileOps.Access registry = new FromFileOps.Access();
        FromFileOps<JsonElement> fromFileOps = new FromFileOps<>(JanksonJsonOps.INSTANCE, registry);
        Path regions = path.getParent().resolve("regions");
        Path biomePickers = path.getParent().resolve("biome_picker");

        try {
            createDefaultsAndRegister(BYGOverworldBiomeBuilders.BIOME_LAYOUTS, registry.get("biome_layout"), BYGOverworldBiomeBuilders.BIOME_LAYOUT, fromFileOps, biomePickers);
            createDefaultsAndRegister(BYGOverworldBiomeBuilders.BIOME_REGIONS, registry.get("regions"), BYGOverworldBiomeBuilders.BIOME_PROVIDER_DATA_FROM_FILE_CODEC, fromFileOps, regions);
            if (!path.toFile().exists()) {
                createConfig(path, CODEC, HEADER, COMMENTS, fromFileOps, from);
            }
            OverworldBiomeConfig overworldBiomeConfig = JanksonUtil. readConfig(path, CODEC, fromFileOps);
            BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));
            return overworldBiomeConfig;
        } catch (IOException | SyntaxError e) {
            throw new IllegalStateException(e);
        }
    }

    private static <T> void createDefaultsAndRegister(Map<String, T> defaults, Map<String, T> registry, Codec<T> codec, FromFileOps<JsonElement> fromFileOps, Path providers) throws IOException {
        defaults.forEach((s, listWrapped) -> {
            Path registryPath = providers.resolve(s + ".json5");
            if (!registryPath.toFile().exists()) {
                createConfig(registryPath, codec, HEADER, new HashMap<>(), fromFileOps, listWrapped);
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
