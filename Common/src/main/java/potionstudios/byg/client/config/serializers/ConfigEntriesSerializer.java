package potionstudios.byg.client.config.serializers;

import blue.endless.jankson.api.SyntaxError;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import potionstudios.byg.BYG;
import potionstudios.byg.client.config.configeditor.ConfigEditEntry;
import potionstudios.byg.client.config.configeditor.ConfigPrimitiveEntry;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public interface ConfigEntriesSerializer<T> {

    Set<Class<?>> PRIMITIVE_TYPES = Util.make(new HashSet<>(), set -> {
        set.add(int.class);
        set.add(double.class);
        set.add(long.class);
        set.add(boolean.class);
        set.add(Integer.class);
        set.add(Double.class);
        set.add(Long.class);
        set.add(Boolean.class);
        set.add(String.class);
    });

    List<ConfigEditEntry<?>> createEntries(Screen screen, String shownPath);

    void saveFile(Path configFilePath) throws Exception;

    String save(List<? extends ConfigEditEntry<?>> entries);

    String path();

    @Nullable
    static ConfigEntriesSerializer<?> fromFile(Path path) {
        String fileName = path.toFile().getName();
        try {
            if (fileName.endsWith(".json") || fileName.endsWith(".json5")) {
                return JanksonConfigEntriesSerializer.fromPath(path);
            } else if (fileName.endsWith(".xml") || fileName.endsWith(".properties")) {
                return XMLPropertiesConfigEntriesSerializer.fromPath(path);
            } else if (fileName.endsWith(".toml")) {
                return TomlConfigEntriesSerializer.fromPath(path);
            }
        } catch (IOException | SyntaxError e) {
            e.printStackTrace();
        }
        return null;
    }

    ConfigEntriesSerializer<T> makeMap(String shownPath);

    ConfigEntriesSerializer<T> makeList(String shownPath);


    @Nullable
    static ConfigPrimitiveEntry<?> makePrimitiveEntry(String key, Object value, Screen parent) {
        return makePrimitiveEntry(key, value, parent, "");
    }

    @Nullable
    static ConfigPrimitiveEntry<?> makePrimitiveEntry(String key, Object value, Screen parent, String comment) {
        if (value instanceof Integer asInt) {
            return new ConfigPrimitiveEntry<>(parent, key, asInt, Integer::parseInt, comment);
        } else if (value instanceof Long asLong) {
            return new ConfigPrimitiveEntry<>(parent, key, asLong, Long::parseLong, comment);
        } else if (value instanceof String asString) {
            return new ConfigPrimitiveEntry<>(parent, key, asString, Function.identity(), comment);
        } else if (value instanceof Double asDouble) {
            return new ConfigPrimitiveEntry<>(parent, key, asDouble, Double::parseDouble, comment);
        } else if (value instanceof Boolean asBoolean) {
            return new ConfigPrimitiveEntry<>(parent, key, asBoolean, Boolean::parseBoolean, comment);
        }
        BYG.LOGGER.error(String.format("Could not make entry to edit for key: \"%s\"", key));

        return null;
    }
}
