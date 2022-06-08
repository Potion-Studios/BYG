package potionstudios.byg.client.config.filebrowser;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.FastColor;
import potionstudios.byg.client.config.configeditor.ConfigEditScreen;
import potionstudios.byg.client.config.serializers.ConfigEntriesSerializer;
import potionstudios.byg.mixin.access.client.ScreenAccess;
import potionstudios.byg.util.BYGUtil;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;

public class FileEntry<T> extends KeyCommentToolTipEntry<T> {
    private static final MutableComponent RELOADS_ON_SAVE = Component.literal("Reloads on save");
    private static final MutableComponent DOES_NOT_RELOAD_ON_SAVE = Component.literal("Does not Reload on save");
    private static final MutableComponent RELOAD = Component.literal("Reload");

    private final Button openFileButton;
    private final Button editButton;
    private final Button reloadButton;
    private final boolean isReloadable;
    private boolean overrideDefaultToolTip;
    private int lastReload = -1;

    public FileEntry(boolean isReloadable, Screen parent, String relativizedPath, Path absolutePath, Consumer<Path> onReload) {
        super(parent, relativizedPath, relativizedPath);
        this.isReloadable = isReloadable;
        this.openFileButton = new Button(0, 0, 50, 20, Component.translatable("Open"), (button) -> {
            ((ScreenAccess) parent).byg_invokeOpenLink(absolutePath.toUri());
        }) {
            protected MutableComponent createNarrationMessage() {
                return Component.translatable("narrator.controls.reset", relativizedPath);
            }
        };

        ConfigEntriesSerializer<?> serializer = ConfigEntriesSerializer.fromFile(absolutePath);

        this.editButton = new Button(0, 0, 50, 20, Component.translatable("Edit"), (button) -> {
            if (serializer != null) {
                Minecraft.getInstance().setScreen(new ConfigEditScreen(this.parent, serializer, relativizedPath, absolutePath, isReloadable));
            }
        }) {
            protected MutableComponent createNarrationMessage() {
                return Component.translatable("narrator.controls.reset", relativizedPath);
            }
        };
        MutableComponent reload = Component.translatable("Reload");
        this.reloadButton = new Button(0, 0, 50, 20, reload, (button) -> {
            if (isReloadable) {
                onReload.accept(absolutePath);
            }
            this.lastReload = 60;
            button.active = false;
        }) {
            protected MutableComponent createNarrationMessage() {
                return Component.translatable("narrator.controls.reset", relativizedPath);
            }
        };

        this.reloadButton.active = isReloadable;


        if (serializer == null) {
            this.editButton.active = false;
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
        super.render(pPoseStack, pIndex, pTop, pLeft, pWidth, pHeight, pMouseX, pMouseY, pIsMouseOver, pPartialTick);
        this.editButton.x = (int) (this.keyScreenPosition.x + maxKeyWidth + 20);
        this.editButton.y = (pTop + pHeight / 2 - 9);
        this.editButton.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.openFileButton.x = this.editButton.x + this.editButton.getWidth() + 10;
        this.openFileButton.y = this.editButton.y;
        this.openFileButton.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.reloadButton.x = this.openFileButton.x + this.openFileButton.getWidth() + 10;
        this.reloadButton.y = this.openFileButton.y;
        this.reloadButton.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        int minX = pLeft - 15;
        int maxX = pLeft - 5;
        int minY = pTop;
        int maxY = pTop + pHeight;
        this.overrideDefaultToolTip = BYGUtil.isInside(minX, minY, maxX, maxY, pMouseX, pMouseY);
        if (this.overrideDefaultToolTip) {
            if (this.toolTip.get(0) != RELOADS_ON_SAVE) {
                this.toolTip.clear();
                this.toolTip.add(this.isReloadable ? RELOADS_ON_SAVE : DOES_NOT_RELOAD_ON_SAVE);
            }
            this.renderToolTip = true;
        } else {
            this.renderToolTip = pIsMouseOver;
        }
        GuiComponent.fill(pPoseStack, minX, minY, maxX, maxY, this.isReloadable ? FastColor.ARGB32.color(255, 0, 255, 0) : FastColor.ARGB32.color(255, 255, 0, 0));
    }

    @Override
    public boolean toolTipCacheReload(int pWidth, boolean pIsMouseOver) {
        if (this.overrideDefaultToolTip) {
            return false;
        } else {
            return super.toolTipCacheReload(pWidth, pIsMouseOver);
        }
    }

    @Override
    public List<? extends NarratableEntry> narratables() {
        return ImmutableList.of(this.openFileButton, this.editButton, this.reloadButton);
    }

    @Override
    public List<? extends GuiEventListener> children() {
        return ImmutableList.of(this.openFileButton, this.editButton, this.reloadButton);
    }

    @Override
    public int getRowLength() {
        return super.getRowLength() + 20 + this.openFileButton.getWidth() + 10 + this.openFileButton.getWidth() + 10 + this.reloadButton.getWidth();
    }

    @Override
    public boolean mouseClicked(double $$0, double $$1, int $$2) {
        return super.mouseClicked($$0, $$1, $$2);
    }

    @Override
    public void tick() {
        super.tick();
        if (lastReload > 0) {
            this.lastReload--;
            this.reloadButton.setMessage(Component.literal(Integer.toString((lastReload / 20) + 1)));
        } else if (lastReload == 0) {
            this.reloadButton.setMessage(RELOAD);
            this.reloadButton.active = true;
        }
    }
}
