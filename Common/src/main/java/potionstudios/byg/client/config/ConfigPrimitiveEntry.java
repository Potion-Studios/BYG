package potionstudios.byg.client.config;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.List;

public class ConfigPrimitiveEntry extends ConfigEditEntry {

    private final EditBox editBox;
    private final Button resetButton;

    public ConfigPrimitiveEntry(String key, Object defaultVal) {
        super(key, defaultVal);
        this.editBox = new EditBox(Minecraft.getInstance().font, 0, 0, 200, 20, new TextComponent(key));
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
        this.resetButton.x = this.editBox.getWidth() + pLeft + 150;
        this.resetButton.y = pTop;
        this.resetButton.active = !this.editBox.getValue().equals(this.defaultVal.toString());
        this.resetButton.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.editBox.x = pLeft + 105;
        this.editBox.y = pTop;
        this.editBox.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        super.render(pPoseStack, pIndex, pTop, pLeft, pWidth, pHeight, pMouseX, pMouseY, pIsMouseOver, pPartialTick);
    }

    public List<? extends GuiEventListener> children() {
        return ImmutableList.of(this.resetButton, this.editBox);
    }

    public List<? extends NarratableEntry> narratables() {
        return ImmutableList.of(this.resetButton, this.editBox);
    }

    @Override
    public void tick() {
        this.editBox.tick();
    }
}
