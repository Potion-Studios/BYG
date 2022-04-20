package potionstudios.byg.client.config;

import blue.endless.jankson.JsonObject;
import blue.endless.jankson.api.SyntaxError;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import potionstudios.byg.BYG;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConfigurationFilesScreen extends Screen {

    public static final Supplier<List<Path>> CONFIG_FILES = () -> {
        try {
            Path configDir = BYG.CONFIG_PATH.getParent();
            return Files.walk(configDir).filter(path -> !path.toFile().isDirectory()).sorted(Comparator.comparing(Path::toString)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    };

    private ConfigList configFiles;

    public ConfigurationFilesScreen() {
        super(new TextComponent(""));
    }

    @Override
    protected void init() {
        this.configFiles = new ConfigList(width, height, 40, this.height - 37, 25);
        for (Path path : CONFIG_FILES.get()) {
            configFiles.addEntry(new Entry(this, this.font, BYG.CONFIG_PATH.getParent().relativize(path).toString()));
        }
        this.addWidget(this.configFiles);
        super.init();
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderDirtBackground(0);
        this.configFiles.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    public static class ConfigList extends ObjectSelectionList<Entry> {

        public ConfigList(int width, int height, int y0, int y1, int itemHeight) {
            super(Minecraft.getInstance(), width, height, y0, y1, itemHeight);
        }

        @Override
        public int addEntry(ConfigurationFilesScreen.Entry $$0) {
            return super.addEntry($$0);
        }
    }

    public static class Entry extends ObjectSelectionList.Entry<Entry> {

        private final Screen parent;
        private final Font font;
        private final String path;

        public Entry(Screen parent, Font font, String path) {
            this.parent = parent;
            this.font = font;
            this.path = path;
        }

        @Override
        public Component getNarration() {
            return new TextComponent("");
        }

        @Override
        public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
            GuiComponent.drawString(pPoseStack, font, this.path, pLeft + 5, pTop + 2, 16777215);
        }

        @Override
        public boolean mouseClicked(double mouseX, double mouseY, int button) {
            if (button == 0) {
                try {
                    JsonObject load = JanksonUtil.JANKSON.load(BYG.CONFIG_PATH.getParent().resolve(Path.of(this.path)).toFile());
                    Minecraft.getInstance().setScreen(new ConfigEditScreen(this.parent, load, this.path));
                } catch (IOException | SyntaxError e) {
                    e.printStackTrace();
                }
            }
            return super.mouseClicked(mouseX, mouseY, button);
        }
    }
}
