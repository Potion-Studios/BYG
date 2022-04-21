package potionstudios.byg.client.config;

import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.TextComponent;
import potionstudios.byg.BYG;
import potionstudios.byg.util.jankson.JanksonUtil;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class ConfigEditScreen extends Screen {

    private static final Set<Class<?>> PRIMITIVE_TYPES = Util.make(new HashSet<>(), set -> {
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

    private final Screen parent;
    private final JsonElement file;
    private final String filePath;
    private ConfigMap<?> configFiles;

    protected ConfigEditScreen(Screen parent, JsonElement element, String filePath) {
        super(new TextComponent(filePath));
        this.parent = parent;
        this.file = element;
        this.filePath = filePath;
    }

    @Override
    public void tick() {
        this.configFiles.children().forEach(ConfigEditEntry::tick);
    }

    @Override
    protected void init() {
        this.configFiles = new ConfigMap<>(this, width, height, 40, this.height - 37, 100);
        if (file instanceof JsonObject jsonObject) {
            jsonObject.forEach((key, element) -> {
                if (element instanceof JsonPrimitive primitive) {
                    Object value = primitive.getValue();
                    ConfigPrimitiveEntry<?> configPrimitiveEntry = makePrimitiveEntry(key, value);
                    if (configPrimitiveEntry != null) {
                        configFiles.addEntry(configPrimitiveEntry);
                    }
                } else if (element instanceof JsonArray jsonArray) {
                    configFiles.addEntry(new ConfigCollectionEntry(this, key, jsonArray, filePath));
                } else if (element instanceof JsonObject jsonObject1) {
                    configFiles.addEntry(new ConfigCollectionEntry(this, key, jsonObject1, filePath));
                }
            });
        } else if (file instanceof JsonArray array) {
            for (int i = 0; i < array.size(); i++) {
                JsonElement element = array.get(i);
                if (element instanceof JsonPrimitive primitive) {
                    ConfigPrimitiveEntry<?> configPrimitiveEntry = makePrimitiveEntry(Integer.toString(i + 1), primitive.getValue());
                    if (configPrimitiveEntry != null) {
                        configFiles.addEntry(configPrimitiveEntry);
                    }
                } else if (element instanceof JsonObject jsonObject) {
                    configFiles.addEntry(new ConfigCollectionEntry(this, Integer.toString(i + 1), jsonObject, filePath));
                } else if (element instanceof JsonArray jsonArray) {
                    configFiles.addEntry(new ConfigCollectionEntry(this, Integer.toString(i + 1), jsonArray, filePath));
                }
            }
        }
        this.addRenderableWidget(new Button(this.width - (this.width / 2) - 20, this.height - 30, 150, 20, CommonComponents.GUI_DONE, (p_95761_) -> {
            String save = save();
            if (save.isEmpty()) {
                this.minecraft.setScreen(this.parent);
            } else {
                this.minecraft.getToasts().addToast(SystemToast.multiline(Minecraft.getInstance(), SystemToast.SystemToastIds.PACK_LOAD_FAILURE, new TextComponent("Could not save."), new TextComponent(save)));
            }
        }));

        this.addWidget(this.configFiles);
        super.init();
    }

    private String save() {
        StringBuilder errors = new StringBuilder();
        if (this.file instanceof JsonObject asJsonObject) {
            for (ConfigEditEntry<?> child : this.configFiles.children()) {
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
        } else if (this.file instanceof JsonArray asJsonArray) {
            for (ConfigEditEntry<?> child : this.configFiles.children()) {
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

        if (errors.isEmpty()) {
            if (this.parent instanceof ConfigurationFilesScreen) {
                try {
                    Files.write(BYG.CONFIG_PATH.getParent().resolve(this.filePath), this.file.toJson(JanksonUtil.JSON_GRAMMAR).getBytes());
                } catch (IOException e) {
                    errors.append(e.getMessage());
                }
            }
        }
        String errorsAsString = errors.toString();
        if (!errorsAsString.isEmpty()) {
            errorsAsString = "Errors were found:\n" + errorsAsString;
        }

        return errorsAsString;
    }

    @Nullable
    private static ConfigPrimitiveEntry<?> makePrimitiveEntry(String key, Object value) {
        if (value instanceof Integer asInt) {
            return new ConfigPrimitiveEntry<>(key, asInt, Integer::parseInt);
        } else if (value instanceof Long asLong) {
            return new ConfigPrimitiveEntry<>(key, asLong, Long::parseLong);
        } else if (value instanceof String asString) {
            return new ConfigPrimitiveEntry<>(key, asString, Function.identity());
        } else if (value instanceof Double asDouble) {
            return new ConfigPrimitiveEntry<>(key, asDouble, Double::parseDouble);
        } else if (value instanceof Boolean asBoolean) {
            return new ConfigPrimitiveEntry<>(key, asBoolean, Boolean::parseBoolean);
        }
        BYG.LOGGER.error(String.format("Could not make entry to edit for key: \"%s\"", key));

        return null;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderDirtBackground(0);
        this.configFiles.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        // Translation component
        drawCenteredString(pPoseStack, this.font, new TextComponent(String.format("Editing config file: \"%s\"", this.title.getString())), this.width / 2, 15, 16777215);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    public static class ConfigMap<T> extends ContainerObjectSelectionList<ConfigEditEntry<T>> {
        private final Screen screen;

        public ConfigMap(Screen screen, int width, int height, int y0, int y1, int itemHeight) {
            super(Minecraft.getInstance(), width, height, y0, y1, itemHeight);
            this.screen = screen;
        }

        @Override
        protected boolean isFocused() {
            return this.screen.getFocused() == this;
        }

        @Override
        public int addEntry(ConfigEditEntry $$0) {
            return super.addEntry($$0);
        }

        @Override
        protected int getScrollbarPosition() {
            return this.width - 10;
        }
    }
}
