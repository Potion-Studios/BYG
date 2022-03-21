package potionstudios.byg.config.json;

import blue.endless.jankson.*;
import blue.endless.jankson.api.SyntaxError;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.overworld.BYGOverworldBiomeBuilders;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.JanksonJsonOps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public record OverworldBiomeConfig(boolean generateOverworld,
                                   List<BYGOverworldBiomeBuilders.BiomeProviderData> values) {
    public static final OverworldBiomeConfig DEFAULT = new OverworldBiomeConfig(true, BYGOverworldBiomeBuilders.OVERWORLD_DEFAULTS);
    private static final Jankson JANKSON = Jankson.builder().build();

    public static OverworldBiomeConfig INSTANCE = null;

    public static final Map<String, String> COMMENTS = Util.make(new HashMap<>(), map -> {
        map.put("overworld_enabled", "Global toggle to enable or disable BYG biomes.");


        String biomeLayout = """
            [ARID-ICY, DRY-ICY, NEUTRAL-ICY, WET-ICY, HUMID-ICY]
            [ARID-COLD, DRY-COLD, NEUTRAL-COLD, WET-COLD, HUMID-COLD]
            [ARID-NEUTRAL, DRY-NEUTRAL, NEUTRAL-NEUTRAL, WET-NEUTRAL, HUMID-NEUTRAL]
            [ARID-WARM, DRY-WARM, NEUTRAL-WARM, WET-WARM, HUMID-WARM]
            [ARID-HOT, DRY-HOT, NEUTRAL-HOT, WET-HOT, HUMID-HOT]
            """;

        String oceanLayout = """
            [SHALLOW-ICY, SHALLOW-COLD, SHALLOW-NEUTRAL, SHALLOW-WARM, SHALLOW-HOT]
            [DEEP-ICY, DEEP-COLD, DEEP-NEUTRAL, DEEP-WARM, DEEP-HOT]
            """;

        String requiresValidKeys = """
            All keys passed in must be valid in the biome registry!
            "minecraft:the_void" is invalid as it represents a value of "NULL(nothing)" internally.""";

        map.put("providers.peak_biomes", "Appearing in mountainous terrain & BELOW weirdness 0, here is the \"peak_biomes\" layout:\n" + biomeLayout + requiresValidKeys);
        map.put("providers.peak_biome_variants", "Appearing in mountainous terrain & ABOVE weirdness 0, here is the \"peak_biome_variants\" layout:\n" + biomeLayout + requiresValidKeys);
        map.put("providers.ocean_biomes", "Appearing in terrain below sea level, here is the \"ocean_biomes\" layout:\n" + oceanLayout + requiresValidKeys);
        map.put("providers.beach_biomes", "Appearing in terrain bordering oceans, here is the \"beach_biomes\" layout:\n" + biomeLayout + requiresValidKeys);
        map.put("providers.weight", """
            The weight of this provider/region against all other providers.
            Higher numbers do NOT increase the provider's size.
            Weight "0" disables this provider and all it's entries."""
        );
    });

    public static final Codec<OverworldBiomeConfig> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
            Codec.BOOL.fieldOf("overworld_enabled").forGetter(overworldBiomeConfig -> overworldBiomeConfig.generateOverworld),
            BYGOverworldBiomeBuilders.BiomeProviderData.CODEC.listOf().fieldOf("providers").forGetter(overworldBiomeConfig -> overworldBiomeConfig.values)
        ).apply(builder, OverworldBiomeConfig::new);
    });


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
            OverworldBiomeConfig overworldBiomeConfig = readOverworldBiomeConfig(path, JANKSON);
            BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));
            return overworldBiomeConfig;
        } catch (IOException | SyntaxError e) {
            throw new IllegalStateException(e);
        }
    }

    private static OverworldBiomeConfig readAndDeleteOldOverworldConfig(Path oldPath, OverworldBiomeConfig from) {
        if (oldPath.toFile().exists()) {
            try {
                from = readOverworldBiomeConfig(oldPath, JANKSON);
                Files.delete(oldPath);
            } catch (IOException | SyntaxError e) {
                e.printStackTrace();
            }
        }
        return from;
    }

    private static OverworldBiomeConfig readOverworldBiomeConfig(Path path, Jankson jankson) throws IOException, SyntaxError {
        return CODEC.decode(JanksonJsonOps.INSTANCE, jankson.load(path.toFile())).resultOrPartial(BYG.LOGGER::error)
            .orElseThrow(() -> BYGUtil.configFileFailureException(path)).getFirst();
    }

    private static void createConfig(Path path, OverworldBiomeConfig config) {
        JsonElement jsonElement = CODEC.encodeStart(JanksonJsonOps.INSTANCE, config).result().orElseThrow();

        if (jsonElement instanceof JsonObject jsonObject) {
            jsonElement = addCommentsAndAlphabeticallySortRecursively(COMMENTS, jsonObject, "", true);
        }
        try {
            Files.createDirectories(path.getParent());
            String str = jsonElement.toJson(new JsonGrammar.Builder().withComments(true).bareSpecialNumerics(true).printCommas(true).build());
            Files.write(path, str.getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(e.toString());
        }
    }

    private static JsonObject addCommentsAndAlphabeticallySortRecursively(Map<String, String> comments, JsonObject object, String parentKey, boolean alphabeticallySorted) {
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            String objectKey = entry.getKey();
            String commentsKey = parentKey + objectKey;

            String comment = null;
            if (comments.containsKey(commentsKey)) {
                String commentToAdd = comments.get(commentsKey);
                object.setComment(objectKey, commentToAdd);
                comment = commentToAdd;
            }

            JsonElement value = entry.getValue();
            if (value instanceof JsonArray array) {
                JsonArray sortedJsonElements = new JsonArray();
                for (JsonElement element : array) {
                    if (element instanceof JsonObject nestedObject) {
                        sortedJsonElements.add(addCommentsAndAlphabeticallySortRecursively(comments, nestedObject, entry.getKey() + ".", alphabeticallySorted));
                    }
                }
                if (!sortedJsonElements.isEmpty()) {
                    object.put(objectKey, sortedJsonElements, comment);
                }
            }

            if (value instanceof JsonObject nestedObject) {
                object.put(objectKey, addCommentsAndAlphabeticallySortRecursively(comments, nestedObject, entry.getKey() + ".", alphabeticallySorted), comment);
            }
        }

        if (alphabeticallySorted) {
            JsonObject alphabeticallySortedJsonObject = new JsonObject();
            TreeMap<String, JsonElement> map = new TreeMap<>(String::compareTo);
            map.putAll(object);
            alphabeticallySortedJsonObject.putAll(map);
            alphabeticallySortedJsonObject.forEach((key, entry) -> {
                alphabeticallySortedJsonObject.setComment(key, object.getComment(key));
            });

            return alphabeticallySortedJsonObject;
        }
        return object;
    }
}
