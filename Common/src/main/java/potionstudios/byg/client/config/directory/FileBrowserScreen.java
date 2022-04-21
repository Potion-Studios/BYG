package potionstudios.byg.client.config.directory;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.TextComponent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileBrowserScreen extends Screen {

    public static final Function<Path, List<Path>> CONFIG_FILES = (configDir) -> {
        try {
            return Files.walk(configDir).filter(path -> !path.toFile().isDirectory()).sorted(Comparator.comparing(Path::toString)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    };

    private final Screen parent;
    private final Path configDir;
    private ConfigMap<?> configFiles;

    public FileBrowserScreen(Screen parent, Path configDir) {
        super(new TextComponent(""));
        this.parent = parent;
        this.configDir = configDir;
    }

    @Override
    public void tick() {
    }

    @Override
    protected void init() {
        this.configFiles = new ConfigMap<>(this, width, height, 40, this.height - 37, 25);
        int maxCommentWidth = this.configFiles.getRowWidth();
        for (Path path : CONFIG_FILES.apply(this.configDir)) {
            String relativizedPath = this.configDir.getParent().relativize(path).toString();
            FileEntry<?> fileEntry = new FileEntry<>(this, relativizedPath, path);
            maxCommentWidth = Math.max(maxCommentWidth, fileEntry.getRowLength());
            this.configFiles.addEntry(fileEntry);
        }
        this.configFiles.rowWidth = maxCommentWidth;

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
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        for (KeyCommentToolTipEntry<?> child : this.configFiles.children()) {
            if (child.renderToolTip) {
                this.renderTooltip(pPoseStack, child.toolTip, Optional.empty(), pMouseX, pMouseY);
            }
        }
    }

    public static class ConfigMap<T> extends ContainerObjectSelectionList<KeyCommentToolTipEntry<T>> {
        private final Screen screen;
        private int rowWidth;

        public ConfigMap(Screen screen, int width, int height, int y0, int y1, int itemHeight) {
            super(Minecraft.getInstance(), width, height, y0, y1, itemHeight);
            this.screen = screen;
            rowWidth = super.getRowWidth();
        }

        @Override
        protected boolean isFocused() {
            return this.screen.getFocused() == this;
        }

        @Override
        public int addEntry(KeyCommentToolTipEntry $$0) {
            return super.addEntry($$0);
        }


        @Override
        public int getRowWidth() {
            return this.rowWidth;
        }

        @Override
        protected int getScrollbarPosition() {
            return this.width - 10;
        }
    }
}
