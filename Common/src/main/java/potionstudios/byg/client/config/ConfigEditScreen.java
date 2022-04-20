package potionstudios.byg.client.config;

import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.JsonPrimitive;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.TextComponent;

public class ConfigEditScreen extends Screen {

    private final Screen parent;
    private final JsonElement file;
    private final String filePath;
    private ConfigMap configFiles;

    protected ConfigEditScreen(Screen parent, JsonElement file, String filePath) {
        super(new TextComponent(filePath));
        this.parent = parent;
        this.file = file;
        this.filePath = filePath;
    }

    @Override
    public void tick() {
        this.configFiles.children().forEach(ConfigEditEntry::tick);
    }

    @Override
    protected void init() {
        this.configFiles = new ConfigMap(this, width, height, 40, this.height - 37, 25);
        if (file instanceof JsonObject jsonObject) {
            jsonObject.forEach((key, element) -> {
                if (element instanceof JsonPrimitive primitive) {
                    configFiles.addEntry(new ConfigPrimitiveEntry(key, primitive.getValue()));
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
                    configFiles.addEntry(new ConfigPrimitiveEntry(Integer.toString(i), primitive.getValue()));
                } else if (element instanceof JsonObject jsonObject) {
                    configFiles.addEntry(new ConfigCollectionEntry(this, Integer.toString(i), jsonObject, filePath));
                } else if (element instanceof JsonArray jsonArray) {
                    configFiles.addEntry(new ConfigCollectionEntry(this, Integer.toString(i), jsonArray, filePath));
                }
            }
        }
        this.addRenderableWidget(new Button(this.width - (this.width / 2) - 20, this.height - 30, 150, 20, CommonComponents.GUI_DONE, (p_95761_) -> {
            this.minecraft.setScreen(this.parent);
        }));

        this.addWidget(this.configFiles);
        super.init();
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderDirtBackground(0);
        this.configFiles.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        // Translation component
        drawCenteredString(pPoseStack, this.font, new TextComponent(String.format("Editing config file: \"%s\"", this.title.getString())), this.width / 2, 15, 16777215);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    public static class ConfigMap extends ContainerObjectSelectionList<ConfigEditEntry> {
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
    }
}
