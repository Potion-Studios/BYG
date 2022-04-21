package potionstudios.byg.client.config;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class ConfigEditEntry<T> extends ContainerObjectSelectionList.Entry<ConfigEditEntry<T>> {

    protected final Screen parent;
    protected final String key;
    protected final T defaultVal;
    protected final int maxKeyWidth;
    protected final int maxCommentWidth;
    private final Component comment;
    protected final ScreenPosition keyScreenPosition = new ScreenPosition();
    protected final List<Component> toolTip = new ArrayList<>();
    private int cachedWidth = 0;
    protected boolean renderToolTip;

    public ConfigEditEntry(Screen parent, String key, T defaultVal) {
        this(parent, key, defaultVal, new TextComponent("A list of weighted regions containing a unique biome layout. Regions may be inlined or may call a file from \"this_file_parent_directory/regions\""));
    }

    public ConfigEditEntry(Screen parent, String key, T defaultVal, Component comment) {
        this.parent = parent;
        this.key = key;
        this.defaultVal = defaultVal;
        this.maxKeyWidth = Minecraft.getInstance().font.width(key);
        this.maxCommentWidth = Minecraft.getInstance().font.width(comment);
        this.comment = comment;
    }

    public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
        float x = (float) ((pLeft) - (this.maxKeyWidth)) - 10;
        float y = (float) (pTop + pHeight / 2 - 9 / 2);

        this.keyScreenPosition.x = x;
        this.keyScreenPosition.y = y;
        makeAndCacheConfigCommentToolTip(pWidth);

        Minecraft.getInstance().font.draw(pPoseStack, this.key, this.keyScreenPosition.x, this.keyScreenPosition.y, 16777215);
    }

    private void makeAndCacheConfigCommentToolTip(int pWidth) {
        if (cachedWidth != pWidth) {
            toolTip.clear();
            StringBuilder comment = new StringBuilder();
            for (String words : this.comment.getString().split("\s")) {
                if (Minecraft.getInstance().font.width(comment.toString()) < pWidth) {
                    comment.append(words).append(" ");
                } else {
                    toolTip.add(new TextComponent(comment.toString()));
                    comment = new StringBuilder(words).append(" ");
                }
            }
            if (!comment.isEmpty()) {
                toolTip.add(new TextComponent(comment.toString()));
            }
            cachedWidth = pWidth;
        }
    }

    @Nullable
    public T getValue() throws Exception {
        return null;
    }

    public void tick() {
    }


}