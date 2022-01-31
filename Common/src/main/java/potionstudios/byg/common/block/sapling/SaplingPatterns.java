package potionstudios.byg.common.block.sapling;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import potionstudios.byg.BYG;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record SaplingPatterns(Map<ResourceLocation, List<Entry>> saplingPatterns) {
    public static final SaplingPatterns DEFAULT = new SaplingPatterns(Util.make(new Object2ObjectOpenHashMap<>(), map -> {
        map.put(new ResourceLocation(BYG.MOD_ID, "baobab_sapling"), Util.make(new ArrayList<>(), list -> {
            list.add(new Entry(List.of(
                    "xxx",
                    "xxx",
                    "xxx"), SimpleWeightedRandomList.single(new ResourceLocation(BYG.MOD_ID, "baobab_tree1"))));
        }));
    }));

    public static SaplingPatterns INSTANCE = null;

    public static final Codec<SaplingPatterns> CODEC = RecordCodecBuilder.create(builder -> {
        return builder.group(
                Codec.unboundedMap(ResourceLocation.CODEC, Entry.CODEC.listOf()).fieldOf("sapling_patterns").forGetter(saplingPatterns -> saplingPatterns.saplingPatterns)
        ).apply(builder, SaplingPatterns::new);
    });


    public static SaplingPatterns getConfig() {
        return getConfig(false);
    }

    public static SaplingPatterns getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        return INSTANCE;
    }

    private static SaplingPatterns readConfig() {
        final Path path = BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-sapling-patterns.json");

        if (!path.toFile().exists()) {
            JsonElement jsonElement = CODEC.encodeStart(JsonOps.INSTANCE, DEFAULT).result().get();

            try {
                Files.createDirectories(path.getParent());
                Files.write(path, new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(jsonElement).getBytes());
            } catch (IOException e) {
                BYG.LOGGER.error(e.toString());
            }
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return CODEC.decode(JsonOps.INSTANCE, new JsonParser().parse(new FileReader(path.toFile()))).result().orElseThrow(RuntimeException::new).getFirst();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return DEFAULT;
    }

    public record Entry(List<String> pattern, SimpleWeightedRandomList<ResourceLocation> spawners) {
        public static final Codec<Entry> CODEC = RecordCodecBuilder.create(builder -> {
            return builder.group(
                    Codec.STRING.listOf().fieldOf("pattern").forGetter(entry -> entry.pattern),
                    SimpleWeightedRandomList.wrappedCodec(ResourceLocation.CODEC).fieldOf("spawners").forGetter(overworldBiomeConfig -> overworldBiomeConfig.spawners)
            ).apply(builder, Entry::new);
        });
    }
}
