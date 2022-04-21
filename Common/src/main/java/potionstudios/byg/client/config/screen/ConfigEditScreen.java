package potionstudios.byg.client.config.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.TextComponent;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.client.config.ConfigEditEntry;
import potionstudios.byg.client.config.directory.FileBrowserScreen;
import potionstudios.byg.client.config.serializers.ConfigEntriesSerializer;

import java.nio.file.Path;
import java.util.Optional;

public class ConfigEditScreen extends Screen {

    private final Screen parent;
    private final ConfigEntriesSerializer<?> file;
    private final String filePath;
    private ConfigMap<?> configFiles;

    public ConfigEditScreen(Screen parent, ConfigEntriesSerializer<?> element, String filePath) {
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
        this.configFiles = new ConfigMap<>(this, width, height, 40, this.height - 37, 25);
        for (ConfigEditEntry<?> entry : this.file.createEntries(this)) {
            this.configFiles.addEntry(entry);
        }

        this.addRenderableWidget(new Button(this.width - (this.width / 2) - 20, this.height - 30, 150, 20, CommonComponents.GUI_DONE, (p_95761_) -> {
            save();
        }));

        this.addWidget(this.configFiles);
        super.init();
    }

    @NotNull
    private void save() {
        StringBuilder errors = new StringBuilder(this.file.save(this.configFiles.children()));
        if (errors.isEmpty()) {
            if (this.parent instanceof FileBrowserScreen) {
                Path resolve = BYG.CONFIG_PATH.getParent().resolve(this.filePath);
                try {
                    this.file.saveFile(resolve);
                    this.minecraft.getToasts().addToast(SystemToast.multiline(Minecraft.getInstance(), SystemToast.SystemToastIds.PACK_LOAD_FAILURE, new TextComponent("Saved Config File:"), new TextComponent(resolve.toString())));
                } catch (Exception e) {
                    errors.append(e.getMessage());
                }
            }
        }

        if (!errors.isEmpty()) {
            this.minecraft.getToasts().addToast(SystemToast.multiline(Minecraft.getInstance(), SystemToast.SystemToastIds.PACK_LOAD_FAILURE, new TextComponent("Could not save File."), new TextComponent(errors.toString())));
        } else {
            this.minecraft.setScreen(this.parent);
        }
    }


    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderDirtBackground(0);
        this.configFiles.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        // Translation component
        drawCenteredString(pPoseStack, this.font, new TextComponent(String.format("Editing config file: \"%s\"", this.title.getString())), this.width / 2, 15, 16777215);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        for (ConfigEditEntry<?> child : this.configFiles.children()) {
            if (child.renderToolTip) {
                this.renderTooltip(pPoseStack, child.toolTip, Optional.empty(), pMouseX, pMouseY);
            }
        }
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
