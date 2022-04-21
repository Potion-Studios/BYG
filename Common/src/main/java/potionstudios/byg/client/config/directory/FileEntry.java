package potionstudios.byg.client.config.directory;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import potionstudios.byg.client.config.screen.ConfigEditScreen;
import potionstudios.byg.client.config.serializers.ConfigEntriesSerializer;
import potionstudios.byg.mixin.access.client.ScreenAccess;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileEntry<T> extends KeyCommentToolTipEntry<T> {

    private final Button openFileButton;
    private final Button editButton;

    public FileEntry(Screen parent, String key) {
        this(parent, key, "");
    }

    public FileEntry(Screen parent, String key, String comment) {
        this(parent, key, new TextComponent(comment));
    }

    public FileEntry(Screen parent, String key, Component comment) {
        super(parent, key, comment);
        this.openFileButton = new Button(0, 0, 75, 20, new TranslatableComponent("Open"), (button) -> {
            ((ScreenAccess) parent).byg_invokeOpenLink(Path.of(comment.getString()).toUri());
        }) {
            protected MutableComponent createNarrationMessage() {
                return new TranslatableComponent("narrator.controls.reset", key);
            }
        };

        ConfigEntriesSerializer<?> serializer = ConfigEntriesSerializer.fromFile(Paths.get(comment.getString()));

        this.editButton = new Button(0, 0, 75, 20, new TranslatableComponent("Edit"), (button) -> {
            if (serializer != null) {
                Minecraft.getInstance().setScreen(new ConfigEditScreen(this.parent, serializer, comment.getString()));
            }
        }) {
            protected MutableComponent createNarrationMessage() {
                return new TranslatableComponent("narrator.controls.reset", key);
            }
        };
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

        this.renderToolTip = pIsMouseOver;
    }

    @Override
    public List<? extends NarratableEntry> narratables() {
        return ImmutableList.of(this.openFileButton, this.editButton);
    }

    @Override
    public List<? extends GuiEventListener> children() {
        return ImmutableList.of(this.openFileButton, this.editButton);
    }

    @Override
    public int getRowLength() {
        return super.getRowLength() + 20 + this.openFileButton.getWidth() + this.openFileButton.getWidth() + 10;
    }

    @Override
    public boolean mouseClicked(double $$0, double $$1, int $$2) {
        return super.mouseClicked($$0, $$1, $$2);
    }
}
