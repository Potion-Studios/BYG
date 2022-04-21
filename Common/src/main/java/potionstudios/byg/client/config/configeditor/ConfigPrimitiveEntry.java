package potionstudios.byg.client.config.configeditor;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.List;
import java.util.function.Function;

public class ConfigPrimitiveEntry<T> extends ConfigEditEntry<T> {

    private final EditBox editBox;
    private final Function<String, T> getValue;
    private final Button resetButton;

    public ConfigPrimitiveEntry(Screen parent, String key, T defaultVal, Function<String, T> getValue) {
        this(parent, key, defaultVal, getValue, new TextComponent(""));
    }

    public ConfigPrimitiveEntry(Screen parent, String key, T defaultVal, Function<String, T> getValue, String comment) {
        this(parent, key, defaultVal, getValue, new TextComponent(comment));
    }

    public ConfigPrimitiveEntry(Screen parent, String key, T defaultVal, Function<String, T> getValue, Component comment) {
        super(parent, key, defaultVal, comment);
        this.editBox = new EditBox(Minecraft.getInstance().font, 0, 0, 200, 20, new TextComponent(key));
        this.editBox.setMaxLength(1000);
        this.getValue = getValue;
        this.editBox.setValue(defaultVal.toString());
        this.resetButton = new Button(0, 0, 50, 20, new TranslatableComponent("controls.reset"), (button) -> {
            this.editBox.setValue(defaultVal.toString());
            button.active = false;
        }) {
            protected MutableComponent createNarrationMessage() {
                return new TranslatableComponent("narrator.controls.reset", key);
            }
        };
    }

    @Override
    public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
        super.render(pPoseStack, pIndex, pTop, pLeft, pWidth, pHeight, pMouseX, pMouseY, pIsMouseOver, pPartialTick);
        this.editBox.x = (int) (this.keyScreenPosition.x + this.maxKeyWidth + 10);
        this.editBox.y = (pTop + pHeight / 2 - 9);
        this.editBox.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.resetButton.x = this.editBox.x + this.editBox.getWidth() + 20;
        this.resetButton.y = this.editBox.y;
        this.resetButton.active = !this.editBox.getValue().equals(this.defaultVal.toString());
        this.resetButton.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderToolTip = this.editBox.isMouseOver(pMouseX, pMouseY);
    }

    public List<? extends GuiEventListener> children() {
        return ImmutableList.of(this.resetButton, this.editBox);
    }

    public List<? extends NarratableEntry> narratables() {
        return ImmutableList.of(this.resetButton, this.editBox);
    }

    @Override
    public T getValue() {
        return this.getValue.apply(this.editBox.getValue());
    }

    @Override
    public void tick() {
        this.editBox.tick();
    }

    @Override
    public int getRowLength() {
        return super.getRowLength() + 10 + this.editBox.getWidth() + 20 + this.resetButton.getWidth();
    }
}
