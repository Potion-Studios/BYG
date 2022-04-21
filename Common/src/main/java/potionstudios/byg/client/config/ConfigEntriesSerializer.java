package potionstudios.byg.client.config;

import blue.endless.jankson.api.SyntaxError;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    List<ConfigEditEntry<?>> createEntries(Screen screen);

    void saveFile(Path configFilePath) throws IOException;

    String save(List<? extends ConfigEditEntry<?>> entries);

    String path();

    static ConfigEntriesSerializer<?> fromFile(Path path) {
        String fileName = path.toFile().getName();
        try {
            if (fileName.endsWith(".json") || fileName.endsWith(".json5")) {
                return JanksonConfigEntriesSerializer.fromPath(path);
            }
        } catch (IOException | SyntaxError e) {
            e.printStackTrace();
        }
        return null;
    }
}
