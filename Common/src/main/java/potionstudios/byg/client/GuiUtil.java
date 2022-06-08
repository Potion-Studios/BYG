package potionstudios.byg.client;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.apache.commons.lang3.mutable.MutableInt;

import java.util.List;

public class GuiUtil {

    public static void makeAndCacheConfigCommentWrappedToolTip(int pWidth, String commentString, MutableInt cachedWidth, List<Component> toolTip) {
        if (commentString.isEmpty()) {
            return;
        }
        if (cachedWidth.intValue() != pWidth) {
            toolTip.clear();
            for (String lines : commentString.split("\n")) {
                StringBuilder comment = new StringBuilder();
                for (String word : lines.split("\s")) {
                    if (word.isBlank() && !lines.isBlank()) {
                        continue;
                    }
                    word = word.trim();
                    if (Minecraft.getInstance().font.width(word) > pWidth) {
                        char[] chars = word.toCharArray();
                        for (char aChar : chars) {
                            String character = Character.toString(aChar);
                            if (Minecraft.getInstance().font.width(comment.toString() + character) < pWidth) {
                                comment.append(character);
                            } else {
                                toolTip.add(Component.literal(comment.toString()));
                                comment = new StringBuilder(character);
                            }
                        }
                        comment.append(" ");
                    } else {
                        if (Minecraft.getInstance().font.width(comment.toString() + word) < pWidth) {
                            comment.append(word).append(" ");
                        } else {
                            toolTip.add(Component.literal(comment.toString()));
                            comment = new StringBuilder();
                            if (Minecraft.getInstance().font.width(word) > pWidth) {
                                char[] chars = word.toCharArray();
                                for (char aChar : chars) {
                                    String character = Character.toString(aChar);
                                    if (Minecraft.getInstance().font.width(comment.toString() + character) < pWidth) {
                                        comment.append(character);
                                    } else {
                                        toolTip.add(Component.literal(comment.toString()));
                                        comment = new StringBuilder(character);
                                    }
                                }
                                comment.append(" ");
                            } else {
                                comment.append(word).append(" ");
                            }
                        }
                    }
                }
                if (!comment.isEmpty()) {
                    toolTip.add(Component.literal(comment.toString()));
                }
            }
            cachedWidth.setValue(pWidth);
        }
    }

}
