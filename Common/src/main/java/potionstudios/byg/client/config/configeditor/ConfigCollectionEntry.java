package potionstudios.byg.client.config.configeditor;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Component;

import potionstudios.byg.client.config.serializers.ConfigEntriesSerializer;

import java.util.List;

public class ConfigCollectionEntry extends ConfigEditEntry<ConfigEntriesSerializer<?>> {

    private final Button editButton;

    public ConfigCollectionEntry(Screen parent, String key, ConfigEntriesSerializer<?> val) {
        this(parent, key, val, Component.literal(""));
    }

    public ConfigCollectionEntry(Screen parent, String key, ConfigEntriesSerializer<?> val, Component comment) {
        super(parent, key, comment);
        this.editButton = new Button(0, 0, 200, 20, Component.translatable("Edit"), (button) -> {
            Minecraft.getInstance().setScreen(new ConfigEditScreen(parent, val, val.path() + "." + key));
        }) {
            protected MutableComponent createNarrationMessage() {
                return Component.translatable("narrator.controls.reset", key);
            }
        };
    }

    @Override
    public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
        super.render(pPoseStack, pIndex, pTop, pLeft, pWidth, pHeight, pMouseX, pMouseY, pIsMouseOver, pPartialTick);
        this.editButton.x = (int) (this.keyScreenPosition.x + this.maxKeyWidth + 10);
        this.editButton.y = (pTop + pHeight / 2 - 9);
        this.editButton.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderToolTip = this.editButton.isMouseOver(pMouseX, pMouseY);
    }

    public List<? extends GuiEventListener> children() {
        return ImmutableList.of(this.editButton);
    }

    public List<? extends NarratableEntry> narratables() {
        return ImmutableList.of(this.editButton);
    }

    @Override
    public int getRowWidth() {
        return super.getRowWidth() + 10 + this.editButton.getWidth() + 60;
    }
}
