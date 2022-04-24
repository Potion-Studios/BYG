package potionstudios.byg.client.config.serializers;

import net.minecraft.client.gui.screens.Screen;
import potionstudios.byg.client.config.configeditor.ConfigEditEntry;
import potionstudios.byg.client.config.configeditor.ConfigPrimitiveEntry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

public class XMLPropertiesConfigEntriesSerializer implements ConfigEntriesSerializer<Properties> {

    private final Properties properties;
    private final String path;

    public XMLPropertiesConfigEntriesSerializer(Properties properties, String path) {
        this.properties = properties;
        this.path = path;
    }

    @Override
    public List<ConfigEditEntry<?>> createEntries(Screen screen, String shownPath) {
        ArrayList<ConfigEditEntry<?>> entries = new ArrayList<>();
        this.properties.forEach((key, value) -> {
            entries.add(new ConfigPrimitiveEntry<>(screen, key.toString(), value.toString(), Function.identity()));
        });
        return entries;
    }

    @Override
    public void saveFile(Path configFilePath) throws IOException {
        try {
            if (configFilePath.endsWith(".xml")) {
                this.properties.storeToXML(new FileOutputStream(configFilePath.toFile()), "");
            } else {
                this.properties.store(new FileWriter(configFilePath.toFile()), "");
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public String path() {
        return this.path;
    }

    @Override
    public ConfigEntriesSerializer<Properties> makeMap(String shownPath) {
        return null;
    }

    @Override
    public ConfigEntriesSerializer<Properties> makeList(String shownPath) {
        return null;
    }

    @Override
    public String save(List<? extends ConfigEditEntry<?>> entries) {
        StringBuilder errors = new StringBuilder();
        for (ConfigEditEntry<?> entry : entries) {
            try {
                Object value = entry.getValue();
                this.properties.put(entry.key, value);
            } catch (Exception e) {
                errors.append(entry.key).append(": ").append(e.getMessage()).append("\n");
                e.printStackTrace();
            }
        }
        return errors.toString();
    }

    public static XMLPropertiesConfigEntriesSerializer fromPath(Path path) throws IOException {
        Properties properties = new Properties();
        String fileName = path.toFile().getName();
        if (fileName.endsWith(".xml")) {
            properties.loadFromXML(new FileInputStream(path.toFile()));
        } else if (fileName.endsWith(".properties")) {
            properties.load(new FileInputStream(path.toFile()));
        } else {
            throw new IOException(String.format("\"%s\" does not end with \".xml\" or \".properties\" file extension.", path.toString()));
        }

        return new XMLPropertiesConfigEntriesSerializer(properties, path.toString());
    }
}
