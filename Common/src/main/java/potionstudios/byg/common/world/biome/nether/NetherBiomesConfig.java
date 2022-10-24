package potionstudios.byg.common.world.biome.nether;

import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgitaco.corgilib.serialization.jankson.JanksonJsonOps;
import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import corgitaco.corgilib.shadow.blue.endless.jankson.api.SyntaxError;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.LayersBiomeData;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.ModPlatform;

import javax.annotation.Nullable;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

public record NetherBiomesConfig(boolean forceBYGNetherBiomeSource, boolean addAllNetherBiomeTagEntries,
                                 int layerSize, LayersBiomeData upperLayer,
                                 LayersBiomeData middleLayer, LayersBiomeData bottomLayer) {
    public static final Supplier<Path> LEGACY_CONFIG_PATH = () -> ModPlatform.INSTANCE.configPath().resolve(BYG.MOD_ID + "-nether-biomes.json");
    public static final Supplier<Path> CONFIG_PATH = () -> ModPlatform.INSTANCE.configPath().resolve("nether-biomes.json5");

    public static final Codec<NetherBiomesConfig> LEGACY_CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            Codec.BOOL.fieldOf("useBYGNetherBiomeSourceInNewWorlds").forGetter(netherBiomesConfig -> netherBiomesConfig.forceBYGNetherBiomeSource),
            Codec.BOOL.fieldOf("addAllEndBiomeCategoryEntries").forGetter(netherBiomesConfig -> netherBiomesConfig.addAllNetherBiomeTagEntries),
            Codec.INT.fieldOf("layerSizeInBlocks").forGetter(netherBiomesConfig -> netherBiomesConfig.layerSize),
            LayersBiomeData.CODEC.fieldOf("upperLayer").forGetter(netherBiomesConfig -> netherBiomesConfig.upperLayer),
            LayersBiomeData.CODEC.fieldOf("middleLayer").forGetter(netherBiomesConfig -> netherBiomesConfig.middleLayer),
            LayersBiomeData.CODEC.fieldOf("bottomLayer").forGetter(netherBiomesConfig -> netherBiomesConfig.bottomLayer)
        ).apply(builder, NetherBiomesConfig::new);
    });

    public static final Codec<NetherBiomesConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            Codec.BOOL.fieldOf("forceBYGNetherBiomeSource").forGetter(netherBiomesConfig -> netherBiomesConfig.forceBYGNetherBiomeSource),
            Codec.BOOL.fieldOf("addAllNetherBiomeTagEntries").forGetter(netherBiomesConfig -> netherBiomesConfig.addAllNetherBiomeTagEntries),
            Codec.INT.fieldOf("layerSizeInBlocks").forGetter(netherBiomesConfig -> netherBiomesConfig.layerSize),
            LayersBiomeData.CODEC.fieldOf("upperLayer").forGetter(netherBiomesConfig -> netherBiomesConfig.upperLayer),
            LayersBiomeData.CODEC.fieldOf("middleLayer").forGetter(netherBiomesConfig -> netherBiomesConfig.middleLayer),
            LayersBiomeData.CODEC.fieldOf("bottomLayer").forGetter(netherBiomesConfig -> netherBiomesConfig.bottomLayer)
        ).apply(builder, NetherBiomesConfig::new);
    });
    public static NetherBiomesConfig INSTANCE = null;

    public static final NetherBiomesConfig DEFAULT = new NetherBiomesConfig(true, true, 40, LayersBiomeData.DEFAULT_NETHER_UPPER, LayersBiomeData.DEFAULT_NETHER_MIDDLE, LayersBiomeData.DEFAULT_NETHER_LOWER);

    public static NetherBiomesConfig getConfig() {
        return getConfig(false, false, null);
    }

    public static NetherBiomesConfig getConfig(boolean serialize) {
        return getConfig(serialize, false, null);
    }

    public static NetherBiomesConfig getConfig(boolean serialize, boolean recreate, @Nullable Registry<Biome> additional) {
        if (INSTANCE == null || serialize || recreate) {
            INSTANCE = readConfig(recreate);
        }

        if (additional != null && INSTANCE.addAllNetherBiomeTagEntries()) {
            SimpleWeightedRandomList<ResourceKey<Biome>> registryDefaults = Util.make((SimpleWeightedRandomList.<ResourceKey<Biome>>builder()), builder -> {
                additional.stream().map(additional::getResourceKey).map(Optional::get).map(additional::getHolderOrThrow).filter(biomeHolder -> biomeHolder.is(BiomeTags.IS_NETHER)).map(biomeHolder -> biomeHolder.unwrapKey().orElseThrow()).forEach(biomeResourceKey -> builder.add(biomeResourceKey, 2));
            }).build();

            BiPredicate<Collection<ResourceKey<Biome>>, ResourceKey<Biome>> filter = (existing, added) -> !existing.contains(added);

            // Upgrade the config with registry values.
            NetherBiomesConfig registryUpdatedConfig = new NetherBiomesConfig(INSTANCE.forceBYGNetherBiomeSource(),
                INSTANCE.addAllNetherBiomeTagEntries(), INSTANCE.layerSize(),
                new LayersBiomeData(INSTANCE.bottomLayer().biomeWeights(), INSTANCE.bottomLayer().biomeSize()),
                new LayersBiomeData(BYGUtil.combineWeightedRandomLists(filter, INSTANCE.middleLayer().biomeWeights(), registryDefaults), INSTANCE.middleLayer().biomeSize()),
                new LayersBiomeData(BYGUtil.combineWeightedRandomLists(filter, INSTANCE.upperLayer().biomeWeights(), registryDefaults), INSTANCE.upperLayer().biomeSize()));

            createConfig(CONFIG_PATH.get(), registryUpdatedConfig);
            INSTANCE = registryUpdatedConfig;
        }

        return INSTANCE;
    }

    private static NetherBiomesConfig readConfig(boolean recreate) {
        final Path legacyPath = LEGACY_CONFIG_PATH.get();
        final Path path = CONFIG_PATH.get();

        NetherBiomesConfig config = DEFAULT;
        if (legacyPath.toFile().exists()) {
            try {
                FileReader reader = new FileReader(legacyPath.toFile());
                config = LEGACY_CODEC.decode(JsonOps.INSTANCE, JsonParser.parseReader(reader)).result().orElseThrow(() -> BYGUtil.configFileFailureException(legacyPath)).getFirst();
                reader.close();
                Files.delete(legacyPath);
            } catch (IOException e) {
                BYG.LOGGER.error("Could not create new config file for: " + legacyPath.toString());
                e.printStackTrace();
                return config;
            }
        }

        if (!path.toFile().exists() || recreate) {
            createConfig(path, config);
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return JanksonUtil.readConfig(path, CODEC, JanksonJsonOps.INSTANCE);
        } catch (IOException | SyntaxError e) {
            throw new IllegalStateException(e);
        }
    }

    private static void createConfig(Path path, NetherBiomesConfig configToSerialize) {
        Map<String, String> comments = Util.make(new HashMap<>(), map -> {
            map.put("forceBYGNetherBiomeSource", "Is BYG's Nether Biome Source used?\nBYG's nether biome source will automatically add all known nether biomes that specify their biomes in the \"minecraft:is_nether\" tag, see \"addAllNetherBiomeTagEntries\" comment.");
            map.put("addAllNetherBiomeTagEntries", "Does this config automatically fill with all values specified in the \"minecraft:is_nether\" biome tag?");
            map.put("bottomLayer", "Biomes that appear at the bottom of the nether dimension.\nThis layer appears in the y range of: \"dimension min Y to layer size\".");
            map.put("middleLayer", "Biomes that appear at the middle of the nether dimension above the bottom layer.\nThis layer appears in the y range of: \"layer size to (layer size + layer size)\".\nie. y40 to y80 if layer size is 40 or y60 to y120 if layer size is 60.");
            map.put("topLayer", "Biomes that appear at the top of the nether dimension above the middle layer.\nThis layer appears in the y range of: \"layer size + layer size to dimension max Y\".\nie. y80 to dimension max Y if layer size is 40 or y120 to dimension max Y if layer size is 60.");

            String biomeWeights = """
                Higher weight, means the biome in question is bound to spawn more frequently against all other biomes listed here.
                Weight of 0 means the biome is disabled.
                                
                "data" should be a valid biome ID from vanilla, mods, or datapacks.
                If the biome in question is not in the biome registry, the biome is ignored & logged in the "latest.log".
                """;
            map.put("bottomLayer.biomeWeights", biomeWeights);
            map.put("middleLayer.biomeWeights", biomeWeights);
            map.put("topLayer.biomeWeights", biomeWeights);
        });

        String netherConfigHeader = "If your settings in this file seem to have to no effect on the generation of the nether, it is more than likely that another mod(s) related to the nether has taken control instead, and you should user their config.";

        JanksonUtil.createConfig(path, CODEC, JanksonUtil.HEADER_OPEN + "\n\n" + netherConfigHeader + "\n*/", comments, JanksonJsonOps.INSTANCE, configToSerialize);
    }
}
