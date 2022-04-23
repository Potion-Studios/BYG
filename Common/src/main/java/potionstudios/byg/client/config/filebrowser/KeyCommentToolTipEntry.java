
package potionstudios.byg.client.config.filebrowser;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import potionstudios.byg.client.config.ScreenPosition;

import java.util.ArrayList;
import java.util.List;

public abstract class KeyCommentToolTipEntry<T> extends ContainerObjectSelectionList.Entry<KeyCommentToolTipEntry<T>> {

    public final Screen parent;
    public final String key;
    public final int maxKeyWidth;
    public final int maxCommentWidth;
    private final Component comment;
    protected final ScreenPosition keyScreenPosition = new ScreenPosition();
    public final List<Component> toolTip = new ArrayList<>();
    private int cachedWidth = 0;
    public boolean renderToolTip;

    public KeyCommentToolTipEntry(Screen parent, String key) {
        this(parent, key, new TextComponent(""));
    }

    public KeyCommentToolTipEntry(Screen parent, String key, String comment) {
        this(parent, key, new TextComponent(comment));
    }

    public KeyCommentToolTipEntry(Screen parent, String key, Component comment) {
        this.parent = parent;
        this.key = "..." + key.substring(Math.max(key.length() - 35, 0));
        this.maxKeyWidth = Minecraft.getInstance().font.width(this.key);
        this.maxCommentWidth = Minecraft.getInstance().font.width(comment);
        this.comment = comment;
    }

    public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
        float x = (float) ((pLeft) - (this.getRowLength())) + pWidth;
        float y = (float) (pTop + pHeight / 2 - 9 / 2);

        this.keyScreenPosition.x = x;
        this.keyScreenPosition.y = y;
        boolean reloadsCache = toolTipCacheReload(pWidth, pIsMouseOver);
        if (reloadsCache) {
            makeAndCacheConfigCommentToolTip(pWidth);
        }
        Minecraft.getInstance().font.draw(pPoseStack, this.key, this.keyScreenPosition.x, this.keyScreenPosition.y, 16777215);
    }

    public boolean toolTipCacheReload(int pWidth, boolean pIsMouseOver) {
        return pIsMouseOver || this.comment.getString().isBlank() || cachedWidth != pWidth;
    }

    private void makeAndCacheConfigCommentToolTip(int pWidth) {
        toolTip.clear();
        for (String lines : this.comment.getString().split("\n")) {
            StringBuilder comment = new StringBuilder();
            for (String word : lines.split("\s")) {
                if (word.isBlank() && !lines.isBlank()) {
                    continue;
                }
                word = word.trim();
                if (Minecraft.getInstance().font.width(comment.toString()) < pWidth) {
                    comment.append(word).append(" ");
                } else {
                    toolTip.add(new TextComponent(comment.toString()));
                    comment = new StringBuilder(word).append(" ");
                }
            }
            if (!comment.isEmpty()) {
                toolTip.add(new TextComponent(comment.toString()));
            }
        }
        cachedWidth = pWidth;
    }

    public void tick() {
    }

    public int getRowLength() {
        return this.maxKeyWidth;
    }
}