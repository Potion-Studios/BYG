package potionstudios.byg.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.locale.Language;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.text.WordUtils;
import potionstudios.byg.BYG;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LangFileGenerator {

    public static final Map<Class<?>, String> TYPE_ID = Util.make(new HashMap<>(), map -> {
        map.put(EntityType.class, "entity");
        map.put(Biome.class, "biome");
        map.put(Block.class, "block");
        map.put(Item.class, "item");
        map.put(MobEffect.class, "effect");
    });

    public static final Map<String, String> MISC_LANG_ENTRIES = Util.make(new TreeMap<>(), map -> {
        InputStream resourceAsStream = Language.class.getResourceAsStream("/assets/byg/lang/en_us_misc.json");
        map.putAll(new Gson().fromJson(new InputStreamReader(resourceAsStream), TreeMap.class));
    });

    public static void createLangFile(Path path) {
        Map<String, String> lang = new TreeMap<>(MISC_LANG_ENTRIES);
        for (Registry<?> registry : Registry.REGISTRY) {
            yes(registry, lang);
        }
        for (Registry<?> registry : BuiltinRegistries.REGISTRY) {
            yes(registry, lang);
        }

        try {
            Files.createDirectories(path.getParent());
            Files.write(path, new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(lang).getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(e.toString());
        }
    }

    private static <T> void yes(Registry<T> registry, Map<String, String> map) {
        for (T value : registry) {
            ResourceLocation key = registry.getKey(value);
            if (key.getNamespace().equals(BYG.MOD_ID)) {
                TYPE_ID.forEach((aClass, s) -> {
                    if (aClass.isAssignableFrom(value.getClass())) {
                        String id = Util.makeDescriptionId(s, key);
                        map.put(id, WordUtils.capitalize(key.getPath().replace("_", " ")));
                    }
                });
            }
        }
    }
}
