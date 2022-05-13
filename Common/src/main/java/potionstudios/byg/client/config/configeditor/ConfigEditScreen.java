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
import java.util.*;
import java.util.function.BiFunction;

public class ConfigEditScreen extends Screen {


    private final Screen parent;
    private final ConfigEntriesSerializer<?> file;
    private final String shownPath;
    @Nullable
    private final Path absolutePath;
    private final boolean reloadsOnSave;
    private ConfigMap<?> configEntries;
    private String searchCache = "";
    private EditBox searchBox;
    private final Set<ConfigEditEntry<?>> hidden = new ObjectOpenHashSet<>();

    public ConfigEditScreen(Screen parent, ConfigEntriesSerializer<?> element, String relativizedPath) {
        this(parent, element, relativizedPath, null, false);
    }

    public ConfigEditScreen(Screen parent, ConfigEntriesSerializer<?> element, String relativizedPath, @Nullable Path filePath, boolean reloadsOnSave) {
        super(new TextComponent(String.format("Editing config file: \"%s\"", relativizedPath.toString())));
        this.parent = parent;
        this.file = element;
        this.shownPath = relativizedPath;
        this.absolutePath = filePath;
        this.reloadsOnSave = reloadsOnSave;
    }

    @Override
    public void tick() {
        this.configEntries.children().forEach(ConfigEditEntry::tick);
        this.searchBox.tick();
    }

    @Override
    protected void init() {
        this.configEntries = new ConfigMap<>(this, width, height, 40, this.height - 37, 25);
        int maxCommentWidth = this.configEntries.getRowWidth();
        for (ConfigEditEntry<?> entry : this.file.createEntries(this, this.shownPath)) {
            this.configEntries.addEntry(entry);
            maxCommentWidth = Math.max(maxCommentWidth, entry.getRowWidth());
        }
        addConfigEntryButton();

        this.configEntries.rowWidth = maxCommentWidth;
        int searchWidth = 250;

        this.searchBox = new EditBox(Minecraft.getInstance().font, this.width / 2 - (searchWidth / 2), 18, searchWidth, 20, new TextComponent(""));
        this.searchBox.setResponder(this::searchResponder);

        int buttonWidth = 150;
        this.addRenderableWidget(new Button(this.width - (this.width / 2) - (buttonWidth / 2), this.height - 30, buttonWidth, 20, CommonComponents.GUI_DONE, (p_95761_) -> {
            save();
        }));
        this.addRenderableWidget(this.searchBox);

        this.addWidget(this.configEntries);
        super.init();
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        this.configEntries.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredString(pPoseStack, this.font, this.title, this.width / 2, 5, 16777215);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        for (ConfigEditEntry<?> child : this.configEntries.children()) {
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
            String shownPath = this.file.path() + "." + key;
            if (value.equalsIgnoreCase("list")) {
                return new ConfigCollectionEntry(this, key, this.file.makeList(shownPath), new TextComponent(""));
            } else if (value.equalsIgnoreCase("map")) {
                return new ConfigCollectionEntry(this, key, this.file.makeMap(shownPath), new TextComponent(""));
            }
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
        AddConfigEditEntryEntry addConfigEditEntryEntry = new AddConfigEditEntryEntry(this, this.configEntries, makeEntry, "");
        this.configEntries.addEntry(addConfigEditEntryEntry);
    }

    private void searchResponder(String s) {
        if (!this.searchCache.equals(s)) {
            List children = this.configEntries.children();
            ArrayList<? extends ConfigEditEntry<?>> keyCommentToolTipEntries = new ArrayList<>(children);
            for (ConfigEditEntry<?> child : keyCommentToolTipEntries) {
                if (!child.key.toLowerCase(Locale.ROOT).contains(s.toLowerCase(Locale.ROOT))) {
                    children.remove(child);
                    child.renderToolTip = false;
                    hidden.add(child);
                }
            }
            for (ConfigEditEntry<?> entry : new ObjectOpenHashSet<>(this.hidden)) {
                if (entry.key.toLowerCase(Locale.ROOT).contains(s.toLowerCase(Locale.ROOT))) {
                    children.add(entry);
                    this.hidden.remove(entry);
                }
            }
            this.searchCache = s;
            this.configEntries.setScrollAmount(0);
        }
    }

    private void save() {
        StringBuilder errors = new StringBuilder(this.file.save(this.configEntries.children()));
        if (errors.isEmpty()) {
            if (this.parent instanceof FileBrowserScreen && this.absolutePath != null) {
                try {
                    this.file.saveFile(this.absolutePath);
                    if (this.reloadsOnSave) {
                        FileBrowserScreen.ON_RELOAD.accept(this.absolutePath);
                    }
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
