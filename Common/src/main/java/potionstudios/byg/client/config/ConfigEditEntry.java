package potionstudios.byg.client.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

import javax.annotation.Nullable;

public abstract class ConfigEditEntry<T> extends ContainerObjectSelectionList.Entry<ConfigEditEntry<T>> {

    /**
     * The localized key description for this ConfigEditEntry
     */
    protected final String key;
    protected final T defaultVal;
    protected final int maxKeyWidth;
    protected final int maxCommentWidth;
    private final Component comment;
    protected final ScreenPosition keyScreenPosition = new ScreenPosition();

    public ConfigEditEntry(String key, T defaultVal) {
        this(key, defaultVal, new TextComponent("A list of weighted regions containing a unique biome layout. Regions may be inlined or may call a file from \"this_file_parent_directory/regions\""));
    }

    public ConfigEditEntry(String key, T defaultVal, Component comment) {
        this.key = key;
        this.defaultVal = defaultVal;
        this.maxKeyWidth = Minecraft.getInstance().font.width(key);
        this.maxCommentWidth = Minecraft.getInstance().font.width(comment);
        this.comment = comment;
    }

    public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
        float x = (float) ((pLeft) - (this.maxKeyWidth)) - 10;
        float y = (float) (pTop + pHeight / 2);

        this.keyScreenPosition.x = x;
        this.keyScreenPosition.y = y;

        Minecraft.getInstance().font.draw(pPoseStack, this.key, this.keyScreenPosition.x, this.keyScreenPosition.y, 16777215);
        Minecraft.getInstance().font.draw(pPoseStack, this.comment, pLeft - pWidth, pTop, 16777215);
    }

    @Nullable
    public T getValue() throws Exception {
        return null;
    }

    public void tick() {
    }


}