package potionstudios.byg.config.json;

import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.api.SyntaxError;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.overworld.BYGOverworldBiomeBuilders;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.jankson.JanksonJsonOps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static potionstudios.byg.util.jankson.JanksonUtil.*;

public record OverworldBiomeConfig(boolean generateOverworld,
                                   List<BYGOverworldBiomeBuilders.BiomeProviderData> values) {
    public static final OverworldBiomeConfig DEFAULT = new OverworldBiomeConfig(true, BYGOverworldBiomeBuilders.OVERWORLD_DEFAULTS);

    public static OverworldBiomeConfig INSTANCE = null;

    public static final Map<String, String> COMMENTS = Util.make(new HashMap<>(), map -> {
        map.put("overworld_enabled", "Global toggle to enable or disable BYG biomes.");


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

        map.put("providers.plateau_biomes", "Appearing on elevated flat terrain BELOW weirdness 0 or in unfilled(\"NULL(nothing)\") spots in \"plateau_biome_variants\", here is the \"plateau_biomes\" layout:\n" + oceanLayout + requiresValidKeys);
        map.put("providers.plateau_biomes_variant", "Appearing on elevated flat terrain ABOVE weirdness 0, here is the \"plateau_biomes\" layout:\n" + oceanLayout + """
            All keys passed in must be valid in the biome registry!
            "minecraft:the_void" is valid and represents NULL as it represents a value of "NULL(nothing)".
            In slots containing "minecraft:the_void", biomes at the equivalent temperature/humidity index in "plateau_biomes" will be used instead.
            """);
        map.put("providers.middle_biomes", "Appearing on terrain BELOW weirdness 0 or in unfilled(\"NULL(nothing)\") spots in \"middle_biomes_variants\", here is the \"middle_biomes\" layout:\n" + oceanLayout + requiresValidKeys);
        map.put("providers.middle_biomes_variant", "Appearing on terrain ABOVE weirdness 0, here is the \"middle_biomes_variant\" layout:\n" + oceanLayout +
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
            BYGOverworldBiomeBuilders.BiomeProviderData.CODEC.listOf().fieldOf("providers").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values)
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

        final Path path = BYG.CONFIG_PATH.resolve("overworld-biomes.json5");
        OverworldBiomeConfig from = readAndDeleteOldOverworldConfig(BYG.CONFIG_PATH.resolve("overworld-biomes.json"), DEFAULT);

        if (!path.toFile().exists()) {
            createConfig(path, from);
        }

        try {
            OverworldBiomeConfig overworldBiomeConfig = readOverworldBiomeConfig(path);
            BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));
            return overworldBiomeConfig;
        } catch (IOException | SyntaxError e) {
            throw new IllegalStateException(e);
        }
    }

    private static OverworldBiomeConfig readAndDeleteOldOverworldConfig(Path oldPath, OverworldBiomeConfig from) {
        if (oldPath.toFile().exists()) {
            try {
                from = readOverworldBiomeConfig(oldPath);
                Files.delete(oldPath);
            } catch (IOException | SyntaxError e) {
                e.printStackTrace();
            }
        }
        return from;
    }

    private static OverworldBiomeConfig readOverworldBiomeConfig(Path path) throws IOException, SyntaxError {
        return CODEC.decode(JanksonJsonOps.INSTANCE, JANKSON.load(path.toFile())).resultOrPartial(BYG.LOGGER::error)
            .orElseThrow(() -> BYGUtil.configFileFailureException(path)).getFirst();
    }

    private static void createConfig(Path path, OverworldBiomeConfig config) {
        JsonElement jsonElement = CODEC.encodeStart(JanksonJsonOps.INSTANCE, config).result().orElseThrow();

        if (jsonElement instanceof JsonObject jsonObject) {
            jsonElement = addCommentsAndAlphabeticallySortRecursively(COMMENTS, jsonObject, "", true);
        }
        try {
            Files.createDirectories(path.getParent());
            String str = jsonElement.toJson(JSON_GRAMMAR);
            Files.write(path, str.getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(e.toString());
        }
    }
}
