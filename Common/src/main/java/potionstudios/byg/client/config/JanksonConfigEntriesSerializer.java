package potionstudios.byg.client.config;

import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;
import blue.endless.jankson.api.SyntaxError;
import net.minecraft.client.gui.screens.Screen;
import potionstudios.byg.BYG;
import potionstudios.byg.util.jankson.JanksonUtil;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class JanksonConfigEntriesSerializer implements ConfigEntriesSerializer<JsonElement> {

    private final JsonElement jsonElement;
    private final String path;

    private JanksonConfigEntriesSerializer(JsonElement jsonElement, String path) {
        this.jsonElement = jsonElement;
        this.path = path;
    }

    @Override
    public List<ConfigEditEntry<?>> createEntries(Screen screen) {
        List<ConfigEditEntry<?>> fileEditEntries = new ArrayList<>();
        if (jsonElement instanceof JsonObject jsonObject) {
            jsonObject.forEach((key, element) -> {
                if (element instanceof JsonPrimitive primitive) {
                    Object value = primitive.getValue();
                    ConfigPrimitiveEntry<?> configPrimitiveEntry = makePrimitiveEntry(key, value, screen);
                    if (configPrimitiveEntry != null) {
                        fileEditEntries.add(configPrimitiveEntry);
                    }
                } else if (element instanceof JsonArray jsonArray) {
                    fileEditEntries.add(new ConfigCollectionEntry(screen, key, new JanksonConfigEntriesSerializer(jsonArray, path)));
                } else if (element instanceof JsonObject jsonObject1) {
                    fileEditEntries.add(new ConfigCollectionEntry(screen, key, new JanksonConfigEntriesSerializer(jsonObject1, path)));
                }
            });
        } else if (jsonElement instanceof JsonArray array) {
            for (int i = 0; i < array.size(); i++) {
                JsonElement element = array.get(i);
                if (element instanceof JsonPrimitive primitive) {
                    ConfigPrimitiveEntry<?> configPrimitiveEntry = makePrimitiveEntry(Integer.toString(i + 1), primitive.getValue(), screen);
                    if (configPrimitiveEntry != null) {
                        fileEditEntries.add(configPrimitiveEntry);
                    }
                } else if (element instanceof JsonObject jsonObject) {
                    fileEditEntries.add(new ConfigCollectionEntry(screen, Integer.toString(i + 1), new JanksonConfigEntriesSerializer(jsonObject, path)));
                } else if (element instanceof JsonArray jsonArray) {
                    fileEditEntries.add(new ConfigCollectionEntry(screen, Integer.toString(i + 1), new JanksonConfigEntriesSerializer(jsonArray, path)));
                }
            }
        }
        return fileEditEntries;
    }

    @Nullable
    private static ConfigPrimitiveEntry<?> makePrimitiveEntry(String key, Object value, Screen parent) {
        if (value instanceof Integer asInt) {
            return new ConfigPrimitiveEntry<>(parent, key, asInt, Integer::parseInt);
        } else if (value instanceof Long asLong) {
            return new ConfigPrimitiveEntry<>(parent, key, asLong, Long::parseLong);
        } else if (value instanceof String asString) {
            return new ConfigPrimitiveEntry<>(parent, key, asString, Function.identity());
        } else if (value instanceof Double asDouble) {
            return new ConfigPrimitiveEntry<>(parent, key, asDouble, Double::parseDouble);
        } else if (value instanceof Boolean asBoolean) {
            return new ConfigPrimitiveEntry<>(parent, key, asBoolean, Boolean::parseBoolean);
        }
        BYG.LOGGER.error(String.format("Could not make entry to edit for key: \"%s\"", key));

        return null;
    }

    @Override
    public void saveFile(Path configFile) throws IOException {
        try {
            Files.write(configFile, this.jsonElement.toJson(JanksonUtil.JSON_GRAMMAR).getBytes());
        } catch (IOException e) {
           throw e;
        }
    }

    @Override
    public String save(List<? extends ConfigEditEntry<?>> configFiles) {
        StringBuilder errors = new StringBuilder();
        if (this.jsonElement instanceof JsonObject asJsonObject) {
            for (ConfigEditEntry<?> child : configFiles) {
                try {
                    Object value = child.getValue();
                    if (value == null) {
                        continue;
                    }
                    if (PRIMITIVE_TYPES.contains(value.getClass())) {
                        asJsonObject.put(child.key, new JsonPrimitive(value));
                    }
                } catch (Exception e) {
                    errors.append(child.key).append(": ").append(e.getMessage()).append("\n");
                }
            }
        } else if (this.jsonElement instanceof JsonArray asJsonArray) {
            for (ConfigEditEntry<?> child : configFiles) {
                try {
                    Object value = child.getValue();
                    if (value == null) {
                        continue;
                    }
                    if (PRIMITIVE_TYPES.contains(value.getClass())) {
                        int index = Integer.parseInt(child.key) - 1;
                        asJsonArray.remove(index);
                        asJsonArray.add(index, new JsonPrimitive(value));
                    }
                } catch (Exception e) {
                    errors.append(child.key).append(": ").append(e.getMessage()).append("\n");
                }
            }
        }
        String errorsAsString = errors.toString();
        if (!errorsAsString.isEmpty()) {
            errorsAsString = "Errors were found:\n" + errorsAsString;
        }

        return errorsAsString;

    }

    public static JanksonConfigEntriesSerializer fromPath(Path path) throws IOException, SyntaxError {
        JsonElement jsonElement1;
        String fileName = path.toFile().getName();
        if (fileName.endsWith(".json") || fileName.endsWith(".json5")) {
            try {
                jsonElement1 = JanksonUtil.JANKSON.load(path.toFile());
            } catch (IOException | SyntaxError e) {
                throw e;
            }
        } else {
            throw new FileSystemException(String.format("\"%s\" does not end with \".json\" or \".json5\" file extension.", path.toString()));
        }

        return new JanksonConfigEntriesSerializer(jsonElement1, path.toString());
    }

    @Override
    public String path() {
        return this.path;
    }
}
