package potionstudios.byg.common.world.biome.end;

import blue.endless.jankson.api.SyntaxError;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.jankson.JanksonJsonOps;
import potionstudios.byg.util.jankson.JanksonUtil;

import javax.annotation.Nullable;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public record EndBiomesConfig(boolean forceBYGEndBiomeSource, boolean addAllEndBiomeCategoryEntries, int skyLayerStartY,
                              LayersBiomeData islandLayers, LayersBiomeData voidLayers, LayersBiomeData skyLayers) {
    public static final Supplier<Path> LEGACY_CONFIG_PATH = () -> BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-end-biomes.json");
    public static final Supplier<Path> CONFIG_PATH = () -> BYG.CONFIG_PATH.resolve("end-biomes.json5");

    public static final Codec<EndBiomesConfig> LEGACY_CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            Codec.BOOL.fieldOf("useBYGNetherBiomeSourceInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.forceBYGEndBiomeSource),
            Codec.BOOL.fieldOf("addAllEndBiomeCategoryEntries").forGetter(overworldBiomeConfig -> overworldBiomeConfig.addAllEndBiomeCategoryEntries),
            Codec.INT.fieldOf("skyLayerStartY").forGetter(overworldBiomeConfig -> overworldBiomeConfig.skyLayerStartY),
            LayersBiomeData.CODEC.fieldOf("islandLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.islandLayers),
            LayersBiomeData.CODEC.fieldOf("voidLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.voidLayers),
            LayersBiomeData.CODEC.fieldOf("skyLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.skyLayers)
        ).apply(builder, EndBiomesConfig::new);
    });

    public static final Codec<EndBiomesConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            Codec.BOOL.fieldOf("forceBYGEndBiomeSource").forGetter(overworldBiomeConfig -> overworldBiomeConfig.forceBYGEndBiomeSource),
            Codec.BOOL.fieldOf("addAllEndBiomeCategoryEntries").forGetter(overworldBiomeConfig -> overworldBiomeConfig.addAllEndBiomeCategoryEntries),
            Codec.INT.fieldOf("skyLayerStartY").forGetter(overworldBiomeConfig -> overworldBiomeConfig.skyLayerStartY),
            LayersBiomeData.CODEC.fieldOf("islandLayer").forGetter(overworldBiomeConfig -> overworldBiomeConfig.islandLayers),
            LayersBiomeData.CODEC.fieldOf("voidLayer").forGetter(overworldBiomeConfig -> overworldBiomeConfig.voidLayers),
            LayersBiomeData.CODEC.fieldOf("skyLayer").forGetter(overworldBiomeConfig -> overworldBiomeConfig.skyLayers)
        ).apply(builder, EndBiomesConfig::new);
    });

    public static EndBiomesConfig INSTANCE = null;

    public static final EndBiomesConfig DEFAULT = new EndBiomesConfig(true, true, 180, LayersBiomeData.DEFAULT_END_ISLANDS, LayersBiomeData.DEFAULT_END_VOID, LayersBiomeData.DEFAULT_SKY);


    public static EndBiomesConfig getConfig() {
        return getConfig(false, null);
    }

    public static EndBiomesConfig getConfig(boolean serialize) {
        return getConfig(serialize, null);
    }

    public static EndBiomesConfig getConfig(boolean serialize, @Nullable Registry<Biome> additional) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        if (additional != null && INSTANCE.addAllEndBiomeCategoryEntries()) {
            SimpleWeightedRandomList<ResourceKey<Biome>> registryDefaults = Util.make((SimpleWeightedRandomList.<ResourceKey<Biome>>builder()), builder -> {
                for (Biome biome : additional) {
                    //TODO: Tags
                    if (Biome.getBiomeCategory(additional.getHolderOrThrow(additional.getResourceKey(biome).get())) == Biome.BiomeCategory.THEEND) {
                        builder.add(additional.getResourceKey(biome).get(), 2);
                    }
                }
            }).build();
            // Upgrade the config with registry values.
            EndBiomesConfig registryUpdatedConfig = new EndBiomesConfig(INSTANCE.forceBYGEndBiomeSource(), INSTANCE.addAllEndBiomeCategoryEntries(), INSTANCE.skyLayerStartY(),
                new LayersBiomeData(BYGUtil.combineWeightedRandomListsWithoutDuplicatesFilter(INSTANCE.islandLayers().biomeWeights(), registryDefaults), INSTANCE.islandLayers().biomeSize()),
                new LayersBiomeData(INSTANCE.voidLayers().biomeWeights(), INSTANCE.voidLayers().biomeSize()),
                new LayersBiomeData(INSTANCE.skyLayers().biomeWeights(), INSTANCE.skyLayers().biomeSize()));

            createConfig(CONFIG_PATH.get(), registryUpdatedConfig);
            INSTANCE = registryUpdatedConfig;
        }

        return INSTANCE;
    }

    private static EndBiomesConfig readConfig() {
        final Path legacyPath = LEGACY_CONFIG_PATH.get();
        final Path path = CONFIG_PATH.get();

        EndBiomesConfig config = DEFAULT;
        if (legacyPath.toFile().exists()) {
            try {
                config = LEGACY_CODEC.decode(JsonOps.INSTANCE, JsonParser.parseReader(new FileReader(path.toFile()))).result().orElseThrow(() -> BYGUtil.configFileFailureException(path)).getFirst();
                Files.delete(legacyPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!path.toFile().exists()) {
            createConfig(path, config);
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return JanksonUtil.readConfig(path, CODEC, JanksonJsonOps.INSTANCE);
        } catch (IOException | SyntaxError e) {
            throw new IllegalStateException(e);
        }
    }

    private static void createConfig(Path path, EndBiomesConfig configToSerialize) {
        Map<String, String> comments = Util.make(new HashMap<>(), map -> {
            map.put("forceBYGNetherBiomeSource", "Is BYG's Nether Biome Source used?\nBYG's nether biome source will automatically add all known end biomes that specify their biome category as \"the_end\", see \"addAllEndBiomeCategoryEntries\" comment.");
            map.put("addAllEndBiomeCategoryEntries", "Does this config automatically fill with all biomes using the \"the_end\" biome category? Note: Vanilla at the time of writing does not have an end biomes tag.");
            map.put("skyLayer", "Biomes that spawn in the Y range of \"skyLayerStartY to Dimension Max Y.");
            map.put("islandLayer", "Biomes that spawn where the large end islands/surface generate.");
            map.put("voidLayer", "Biomes that spawn where there is no ground aka void.");

            String biomeWeights = """
                Higher weight, means the biome in question is bound to spawn more frequently against all other biomes listed here.
                Weight of 0 means the biome is disabled.
                                
                "data" should be a valid biome ID from vanilla, mods, or datapacks.
                If the biome in question is not in the biome registry, the game will crash.
                """;
            map.put("skyLayer.biomeWeights", biomeWeights);
            map.put("islandLayer.biomeWeights", biomeWeights);
            map.put("voidLayer.biomeWeights", biomeWeights);
        });

        String endConfigHeader = "If your settings in this file seem to have to no effect on the generation of the end, it is more than likely that another mod(s) related to the end has taken control instead, and you should user their config.";

        JanksonUtil.createConfig(path, CODEC, JanksonUtil.HEADER_OPEN + "\n\n" + endConfigHeader + "\n*/", comments, JanksonJsonOps.INSTANCE, configToSerialize);
    }
}