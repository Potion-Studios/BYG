package potionstudios.byg.client.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import potionstudios.byg.mixin.access.client.KeyMappingAccess;

public class BYGClientUtil {

    public static boolean isKeyOrMouseButtonDown(Minecraft minecraft, KeyMapping keyMapping) {
        InputConstants.Key key = ((KeyMappingAccess) keyMapping).byg_getKey();
        long window = minecraft.getWindow().getWindow();
        int keyValue = key.getValue();
        if (key.getType() == InputConstants.Type.MOUSE) {
            return GLFW.glfwGetMouseButton(window, keyValue) == 1;
        } else {
            return InputConstants.isKeyDown(window, keyValue);
        }
    }
}
