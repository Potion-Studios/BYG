package potionstudios.byg.client.config.serializers;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.UnmodifiableConfig;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.electronwill.nightconfig.toml.TomlWriter;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import potionstudios.byg.client.config.configeditor.ConfigCollectionEntry;
import potionstudios.byg.client.config.configeditor.ConfigEditEntry;
import potionstudios.byg.client.config.configeditor.ConfigPrimitiveEntry;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TomlConfigEntriesSerializer implements ConfigEntriesSerializer<CommentedConfig> {

    private final Object configOrList;
    private final String path;

    private TomlConfigEntriesSerializer(Object configOrList, String path) {
        this.configOrList = configOrList;
        this.path = path;
    }

    @Override
    public List<ConfigEditEntry<?>> createEntries(Screen screen, String shownPath) {
        List<ConfigEditEntry<?>> entries = new ArrayList<>();
        if (configOrList instanceof CommentedConfig commentedConfig) {
            commentedConfig.valueMap().forEach((key, object) -> {
                String comment = commentedConfig.getComment(key) == null ? "" : commentedConfig.getComment(key);
                if (object instanceof CommentedConfig asCommentedConfig) {
                    entries.add(new ConfigCollectionEntry(screen, key, new TomlConfigEntriesSerializer(asCommentedConfig, shownPath), new TextComponent(comment)));
                } else if (object instanceof List<?> list) {
                    entries.add(new ConfigCollectionEntry(screen, key, new TomlConfigEntriesSerializer(list, shownPath), new TextComponent(comment)));
                } else {
                    ConfigPrimitiveEntry<?> configPrimitiveEntry = ConfigEntriesSerializer.makePrimitiveEntry(key, object, screen, comment);
                    if (configPrimitiveEntry != null) {
                        entries.add(configPrimitiveEntry);
                    }
                }
            });
        } else if (configOrList instanceof List<?> array) {
            for (int i = 0; i < array.size(); i++) {
                Object element = array.get(i);
                if (element instanceof CommentedConfig commentedConfig) {
                    entries.add(new ConfigCollectionEntry(screen, Integer.toString(i + 1), new TomlConfigEntriesSerializer(commentedConfig, shownPath)));
                } else if (element instanceof List<?> list) {
                    entries.add(new ConfigCollectionEntry(screen, Integer.toString(i + 1), new TomlConfigEntriesSerializer(list, shownPath)));
                } else {
                    ConfigPrimitiveEntry<?> configPrimitiveEntry = ConfigEntriesSerializer.makePrimitiveEntry(Integer.toString(i + 1), element, screen);
                    if (configPrimitiveEntry != null) {
                        entries.add(configPrimitiveEntry);
                    }
                }
            }
        }

        return entries;
    }

    @Override
    public void saveFile(Path configFilePath) {
        TomlWriter writer = new TomlWriter();
        if (this.configOrList instanceof UnmodifiableConfig unmodifiableConfig) {
            try {
                writer.write(unmodifiableConfig, configFilePath, WritingMode.REPLACE);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new IllegalStateException("Trying to save incorrect object type");
        }
    }

    @Override
    public String save(List<? extends ConfigEditEntry<?>> entries) {
        StringBuilder errors = new StringBuilder();
        if (this.configOrList instanceof CommentedConfig asJsonObject) {
            for (ConfigEditEntry<?> child : entries) {
                try {
                    Object value = child.getValue();
                    if (value == null) {
                        continue;
                    }
                    if (PRIMITIVE_TYPES.contains(value.getClass())) {
                        asJsonObject.set(child.key, value);
                    }
                } catch (Exception e) {
                    errors.append(child.key).append(": ").append(e.getMessage()).append("\n");
                }
            }
        } else if (this.configOrList instanceof List asJsonArray) {
            for (ConfigEditEntry<?> child : entries) {
                try {
                    Object value = child.getValue();
                    if (value == null) {
                        continue;
                    }
                    if (PRIMITIVE_TYPES.contains(value.getClass())) {
                        int index = Integer.parseInt(child.key) - 1;
                        asJsonArray.remove(index);
                        asJsonArray.add(index, child.getValue());
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

    public static TomlConfigEntriesSerializer fromPath(Path path) throws IOException {
        String fileName = path.toFile().getName();
        if (fileName.endsWith(".toml")) {
            CommentedFileConfig builtConfig = CommentedFileConfig.of(path);
            builtConfig.load();
            return new TomlConfigEntriesSerializer(builtConfig, path.toString());
        } else {
            throw new IOException(String.format("\"%s\" does not end with the \".toml\" file extension.", path.toString()));
        }
    }

    @Override
    public String path() {
        return this.path;
    }
}
