package potionstudios.byg.client.config.serializers;

import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;
import blue.endless.jankson.api.SyntaxError;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import potionstudios.byg.client.config.configeditor.ConfigCollectionEntry;
import potionstudios.byg.client.config.configeditor.ConfigEditEntry;
import potionstudios.byg.client.config.configeditor.ConfigPrimitiveEntry;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JanksonConfigEntriesSerializer implements ConfigEntriesSerializer<JsonElement> {

    private final JsonElement jsonElement;
    private final String path;

    private JanksonConfigEntriesSerializer(JsonElement jsonElement, String path) {
        this.jsonElement = jsonElement;
        this.path = path;
    }

    @Override
    public List<ConfigEditEntry<?>> createEntries(Screen screen, String shownPath) {
        List<ConfigEditEntry<?>> fileEditEntries = new ArrayList<>();
        if (jsonElement instanceof JsonObject jsonObject) {
            jsonObject.forEach((key, element) -> {
                String comment = jsonObject.getComment(key) == null ? "" : jsonObject.getComment(key);
                if (element instanceof JsonPrimitive primitive) {
                    Object value = primitive.getValue();
                    ConfigPrimitiveEntry<?> configPrimitiveEntry = ConfigEntriesSerializer.makePrimitiveEntry(key, value, screen, comment);
                    if (configPrimitiveEntry != null) {
                        fileEditEntries.add(configPrimitiveEntry);
                    }
                } else if (element instanceof JsonArray jsonArray) {
                    fileEditEntries.add(new ConfigCollectionEntry(screen, key, new JanksonConfigEntriesSerializer(jsonArray, shownPath), new TextComponent(comment)));
                } else if (element instanceof JsonObject jsonObject1) {
                    fileEditEntries.add(new ConfigCollectionEntry(screen, key, new JanksonConfigEntriesSerializer(jsonObject1, shownPath), new TextComponent(comment)));
                }
            });
        } else if (jsonElement instanceof JsonArray array) {
            for (int i = 0; i < array.size(); i++) {
                JsonElement element = array.get(i);
                if (element instanceof JsonPrimitive primitive) {
                    ConfigPrimitiveEntry<?> configPrimitiveEntry = ConfigEntriesSerializer.makePrimitiveEntry(Integer.toString(i + 1), primitive.getValue(), screen);
                    if (configPrimitiveEntry != null) {
                        fileEditEntries.add(configPrimitiveEntry);
                    }
                } else if (element instanceof JsonObject jsonObject) {
                    fileEditEntries.add(new ConfigCollectionEntry(screen, Integer.toString(i + 1), new JanksonConfigEntriesSerializer(jsonObject, shownPath)));
                } else if (element instanceof JsonArray jsonArray) {
                    fileEditEntries.add(new ConfigCollectionEntry(screen, Integer.toString(i + 1), new JanksonConfigEntriesSerializer(jsonArray, shownPath)));
                }
            }
        }
        return fileEditEntries;
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
    public String save(List<? extends ConfigEditEntry<?>> fileEditEntries) {
        StringBuilder errors = new StringBuilder();
        if (this.jsonElement instanceof JsonObject asJsonObject) {
            for (ConfigEditEntry<?> child : fileEditEntries) {
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
            for (ConfigEditEntry<?> child : fileEditEntries) {
                try {
                    Object value = child.getValue();
                    if (value == null) {
                        continue;
                    }
                    if (PRIMITIVE_TYPES.contains(value.getClass())) {
                        int index = Integer.parseInt(child.key) - 1;
                        if (index < asJsonArray.size()) {
                            asJsonArray.remove(index);
                        }
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
            throw new IOException(String.format("\"%s\" does not end with \".json\" or \".json5\" file extension.", path.toString()));
        }

        return new JanksonConfigEntriesSerializer(jsonElement1, path.toString());
    }

    @Override
    public String path() {
        return this.path;
    }

    @Override
    public ConfigEntriesSerializer<JsonElement> makeMap(String shownPath) {
        return new JanksonConfigEntriesSerializer(new JsonObject(), shownPath);
    }

    @Override
    public ConfigEntriesSerializer<JsonElement> makeList(String shownPath) {
        return new JanksonConfigEntriesSerializer(new JsonArray(), shownPath);
    }
}
