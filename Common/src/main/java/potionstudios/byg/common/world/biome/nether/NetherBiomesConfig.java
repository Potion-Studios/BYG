package potionstudios.byg.common.world.biome.nether;

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

public record NetherBiomesConfig(boolean useBYGNetherBiomeSourceInNewWorlds,
                                 boolean warnBYGNetherBiomeSourceNotUsedInNewWorlds,
                                 boolean useUpdatingConfig, LayersBiomeData upperLayer,
                                 LayersBiomeData middleLayer, LayersBiomeData bottomLayer, int layerSize,
                                 boolean addAllNetherBiomeCategoryEntries) {
    public static final Supplier<Path> CONFIG_PATH = () -> BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-nether-biomes.json");

    public static final Codec<NetherBiomesConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            Codec.BOOL.fieldOf("useBYGNetherBiomeSourceInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.useBYGNetherBiomeSourceInNewWorlds),
            Codec.BOOL.fieldOf("warnBYGNetherBiomeSourceNotUsedInNewWorlds").forGetter(overworldBiomeConfig -> overworldBiomeConfig.warnBYGNetherBiomeSourceNotUsedInNewWorlds),
            Codec.BOOL.optionalFieldOf("useConfigDataInExistingWorlds", true).forGetter(overworldBiomeConfig -> overworldBiomeConfig.useUpdatingConfig),
            LayersBiomeData.CODEC.fieldOf("upperLayer").forGetter(overworldBiomeConfig -> overworldBiomeConfig.upperLayer),
            LayersBiomeData.CODEC.fieldOf("middleLayer").forGetter(overworldBiomeConfig -> overworldBiomeConfig.middleLayer),
            LayersBiomeData.CODEC.fieldOf("bottomLayer").forGetter(overworldBiomeConfig -> overworldBiomeConfig.bottomLayer),
            Codec.INT.fieldOf("layerSizeInBlocks").forGetter(overworldBiomeConfig -> overworldBiomeConfig.layerSize),
            Codec.BOOL.fieldOf("addAllEndBiomeCategoryEntries").forGetter(overworldBiomeConfig -> overworldBiomeConfig.addAllNetherBiomeCategoryEntries)
        ).apply(builder, NetherBiomesConfig::new);
    });
    public static NetherBiomesConfig INSTANCE = null;

    public static final NetherBiomesConfig DEFAULT = new NetherBiomesConfig(true, true, true, LayersBiomeData.DEFAULT_NETHER_UPPER, LayersBiomeData.DEFAULT_NETHER_MIDDLE, LayersBiomeData.DEFAULT_NETHER_LOWER, 40, true);


    public static NetherBiomesConfig getConfig() {
        return getConfig(false, null);
    }

    public static NetherBiomesConfig getConfig(boolean serialize) {
        return getConfig(serialize, null);
    }

    public static NetherBiomesConfig getConfig(boolean serialize, @Nullable Registry<Biome> additional) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        if (additional != null && INSTANCE.addAllNetherBiomeCategoryEntries()) {
            SimpleWeightedRandomList<ResourceKey<Biome>> registryDefaults = Util.make((SimpleWeightedRandomList.<ResourceKey<Biome>>builder()), builder -> {

                for (Biome biome : additional) {
                    //TODO: Tags
                    if (Biome.getBiomeCategory(additional.getHolderOrThrow(additional.getResourceKey(biome).get())) == Biome.BiomeCategory.NETHER) {
                        builder.add(additional.getResourceKey(biome).get(), 2);
                    }
                }

            }).build();
            // Upgrade the config with registry values.
            NetherBiomesConfig registryUpdatedConfig = new NetherBiomesConfig(INSTANCE.useBYGNetherBiomeSourceInNewWorlds(),
                INSTANCE.warnBYGNetherBiomeSourceNotUsedInNewWorlds(), INSTANCE.useUpdatingConfig(),
                new LayersBiomeData(INSTANCE.bottomLayer().biomeWeights(), INSTANCE.bottomLayer().biomeSize()),
                new LayersBiomeData(BYGUtil.combineWeightedRandomListsWithoutDuplicatesFilter(INSTANCE.middleLayer().biomeWeights(), registryDefaults), INSTANCE.middleLayer().biomeSize()),
                new LayersBiomeData(BYGUtil.combineWeightedRandomListsWithoutDuplicatesFilter(INSTANCE.upperLayer().biomeWeights(), registryDefaults), INSTANCE.upperLayer().biomeSize()), INSTANCE.layerSize(), INSTANCE.addAllNetherBiomeCategoryEntries());

            createConfig(CONFIG_PATH.get(), registryUpdatedConfig);
            INSTANCE = registryUpdatedConfig;
        }

        return INSTANCE;
    }

    private static NetherBiomesConfig readConfig() {
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

    private static void createConfig(Path path, NetherBiomesConfig configToSerialize) {
        JsonElement jsonElement = CODEC.encodeStart(JsonOps.INSTANCE, configToSerialize).result().get();

        try {
            Files.createDirectories(path.getParent());
            Files.write(path, new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(jsonElement).getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(e.toString());
        }
    }

}
