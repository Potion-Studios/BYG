package potionstudios.byg.common.world.biome.end;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
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

import javax.annotation.Nullable;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;

public record EndBiomesConfig(boolean useBYGEndBiomeSourceInNewWorlds, boolean warnBYGEndBiomeSourceNotUsedInNewWorlds,
                              boolean useUpdatingConfig, LayersBiomeData islandLayers,
                              LayersBiomeData voidLayers, LayersBiomeData skyLayers,
                              int skyLayerStartY, boolean addAllEndBiomeCategoryEntries) {
    public static final Supplier<Path> CONFIG_PATH = () -> BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-end-biomes.json");

    public static final Codec<EndBiomesConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            Codec.BOOL.fieldOf("useBYGNetherBiomeSourceInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.useBYGEndBiomeSourceInNewWorlds),
            Codec.BOOL.optionalFieldOf("useConfigDataInExistingWorlds", true).forGetter(overworldBiomeConfig -> overworldBiomeConfig.useUpdatingConfig),
            Codec.BOOL.fieldOf("warnBYGNetherBiomeSourceNotUsedInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.warnBYGEndBiomeSourceNotUsedInNewWorlds),
            LayersBiomeData.CODEC.fieldOf("islandLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.islandLayers),
            LayersBiomeData.CODEC.fieldOf("voidLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.voidLayers),
            LayersBiomeData.CODEC.fieldOf("skyLayerData").forGetter(overworldBiomeConfig -> overworldBiomeConfig.skyLayers),
            Codec.INT.fieldOf("skyLayerStartY").forGetter(overworldBiomeConfig -> overworldBiomeConfig.skyLayerStartY),
            Codec.BOOL.fieldOf("addAllEndBiomeCategoryEntries").forGetter(overworldBiomeConfig -> overworldBiomeConfig.addAllEndBiomeCategoryEntries)

        ).apply(builder, EndBiomesConfig::new);
    });
    public static EndBiomesConfig INSTANCE = null;

    public static final EndBiomesConfig DEFAULT = new EndBiomesConfig(true, true, true, LayersBiomeData.DEFAULT_END_ISLANDS, LayersBiomeData.DEFAULT_END_VOID, LayersBiomeData.DEFAULT_SKY, 180, true);


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
            EndBiomesConfig registryUpdatedConfig = new EndBiomesConfig(INSTANCE.useBYGEndBiomeSourceInNewWorlds(),
                INSTANCE.warnBYGEndBiomeSourceNotUsedInNewWorlds(), INSTANCE.useUpdatingConfig(),
                new LayersBiomeData(BYGUtil.combineWeightedRandomListsWithoutDuplicatesFilter(INSTANCE.islandLayers().biomeWeights(), registryDefaults), INSTANCE.islandLayers().biomeSize()),
                new LayersBiomeData(INSTANCE.voidLayers().biomeWeights(), INSTANCE.voidLayers().biomeSize()),
                new LayersBiomeData(INSTANCE.skyLayers().biomeWeights(), INSTANCE.skyLayers().biomeSize()), INSTANCE.skyLayerStartY(), INSTANCE.addAllEndBiomeCategoryEntries());

            createConfig(CONFIG_PATH.get(), registryUpdatedConfig);
            INSTANCE = registryUpdatedConfig;
        }

        return INSTANCE;
    }

    private static EndBiomesConfig readConfig() {
        final Path path = CONFIG_PATH.get();

        if (!path.toFile().exists()) {
            createConfig(path, DEFAULT);
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(path.toFile()))).result().orElseThrow(() -> BYGUtil.configFileFailureException(path)).getFirst();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void createConfig(Path path, EndBiomesConfig configToSerialize) {
        JsonElement jsonElement = CODEC.encodeStart(JsonOps.INSTANCE, configToSerialize).result().get();

        try {
            Files.createDirectories(path.getParent());
            Files.write(path, new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(jsonElement).getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(e.toString());
        }
    }
}