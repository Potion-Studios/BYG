package potionstudios.byg.client.config.configeditor;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.TextComponent;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.client.config.filebrowser.FileBrowserScreen;
import potionstudios.byg.client.config.serializers.ConfigEntriesSerializer;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;

public class ConfigEditScreen extends Screen {

    private final Screen parent;
    private final ConfigEntriesSerializer<?> file;
    private final String shownPath;
    @Nullable
    private final Path absolutePath;
    private ConfigMap<?> configFiles;
    private String searchCache = "";
    private EditBox searchBox;
    private final Set<ConfigEditEntry<?>> hidden = new ObjectOpenHashSet<>();

    public ConfigEditScreen(Screen parent, ConfigEntriesSerializer<?> element, String relativizedPath) {
        this(parent, element, relativizedPath, null);
    }

    public ConfigEditScreen(Screen parent, ConfigEntriesSerializer<?> element, String relativizedPath, @Nullable Path filePath) {
        super(new TextComponent(String.format("Editing config file: \"%s\"", relativizedPath.toString())));
        this.parent = parent;
        this.file = element;
        this.shownPath = relativizedPath;
        this.absolutePath = filePath;
    }

    @Override
    public void tick() {
        this.configFiles.children().forEach(ConfigEditEntry::tick);
        this.searchBox.tick();
    }

    @Override
    protected void init() {
        this.configFiles = new ConfigMap<>(this, width, height, 40, this.height - 37, 25);
        int maxCommentWidth = this.configFiles.getRowWidth();
        for (ConfigEditEntry<?> entry : this.file.createEntries(this, this.shownPath)) {
            this.configFiles.addEntry(entry);
            maxCommentWidth = Math.max(maxCommentWidth, entry.getRowLength());
        }
//        addConfigEntryButton();

        this.configFiles.rowWidth = maxCommentWidth;
        int searchWidth = 250;

        this.searchBox = new EditBox(Minecraft.getInstance().font, this.width / 2 - (searchWidth / 2), 18, searchWidth, 20, new TextComponent(""));
        this.searchBox.setResponder(this::searchResponder);

        int buttonWidth = 150;
        this.addRenderableWidget(new Button(this.width - (this.width / 2) - (buttonWidth / 2), this.height - 30, buttonWidth, 20, CommonComponents.GUI_DONE, (p_95761_) -> {
            save();
        }));
        this.addRenderableWidget(this.searchBox);

        this.addWidget(this.configFiles);
        super.init();
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        this.configFiles.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredString(pPoseStack, this.font, this.title, this.width / 2, 5, 16777215);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        for (ConfigEditEntry<?> child : this.configFiles.children()) {
            if (child.renderToolTip) {
                this.renderTooltip(pPoseStack, child.toolTip, Optional.empty(), pMouseX, pMouseY);
            }
        }
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }

    private void addConfigEntryButton() {
        BiFunction<String, String, ConfigEditEntry<?>> makeEntry = (key, value) -> {
            Object value1;
            try {
                if (value.contains(".")) {
                    value1 = Double.parseDouble(value);
                } else {
                    long parseLong = Long.parseLong(value);
                    if (parseLong <= Integer.MAX_VALUE) {
                        value1 = (int) parseLong;
                    } else {
                        value1 = parseLong;
                    }
                }
            } catch (Exception e) {
                value1 = value;
            }
            return ConfigEntriesSerializer.makePrimitiveEntry(key, value1, this);
        };
        AddConfigEditEntryEntry addConfigEditEntryEntry = new AddConfigEditEntryEntry(this, this.configFiles, this.configFiles.children().size(), makeEntry, "");
        this.configFiles.addEntry(addConfigEditEntryEntry);
    }

    private void searchResponder(String s) {
        if (!this.searchCache.equals(s)) {
            List children = this.configFiles.children();
            ArrayList<? extends ConfigEditEntry<?>> keyCommentToolTipEntries = new ArrayList<>(children);
            for (ConfigEditEntry<?> child : keyCommentToolTipEntries) {
                if (!child.key.toLowerCase().contains(s.toLowerCase())) {
                    children.remove(child);
                    hidden.add(child);
                }
            }
            for (ConfigEditEntry<?> entry : new ObjectOpenHashSet<>(this.hidden)) {
                if (entry.key.toLowerCase().contains(s.toLowerCase())) {
                    children.add(entry);
                    this.hidden.remove(entry);
                }
            }
            this.searchCache = s;
        }
    }

    private void save() {
        StringBuilder errors = new StringBuilder(this.file.save(this.configFiles.children()));
        if (errors.isEmpty()) {
            if (this.parent instanceof FileBrowserScreen && this.absolutePath != null) {
                try {
                    this.file.saveFile(this.absolutePath);
                    this.minecraft.getToasts().addToast(SystemToast.multiline(Minecraft.getInstance(), SystemToast.SystemToastIds.PACK_LOAD_FAILURE, new TextComponent("Saved Config File:"), new TextComponent(this.shownPath)));
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

    public static class ConfigMap<T> extends ContainerObjectSelectionList<ConfigEditEntry<T>> {
        private final Screen screen;
        private int rowWidth = super.getRowWidth();

        public ConfigMap(Screen screen, int width, int height, int y0, int y1, int itemHeight) {
            super(Minecraft.getInstance(), width, height, y0, y1, itemHeight);
            this.screen = screen;
            this.setRenderBackground(false);
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

        @Override
        public int getRowWidth() {
            return this.rowWidth;
        }
    }
}
