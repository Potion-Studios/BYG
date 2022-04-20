package potionstudios.byg.client.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;

public abstract class ConfigEditEntry extends ContainerObjectSelectionList.Entry<ConfigEditEntry> {

    /**
     * The localized key description for this ConfigEditEntry
     */
    protected final String key;
    protected final Object defaultVal;
    protected final int maxWidth;

    public ConfigEditEntry(String key, Object defaultVal) {
        this.key = key;
        this.defaultVal = defaultVal;
        this.maxWidth = Minecraft.getInstance().font.width(key);
    }

    public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
        float f = (float) (pLeft + 90 - this.maxWidth);
        Minecraft.getInstance().font.draw(pPoseStack, this.key, f, (float) (pTop + pHeight / 2 - 9 / 2), 16777215);
    }

    public void tick(){
    }
}