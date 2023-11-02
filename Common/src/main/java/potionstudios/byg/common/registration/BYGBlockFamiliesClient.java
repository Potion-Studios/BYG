package potionstudios.byg.common.registration;

import net.minecraft.client.renderer.RenderType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BYGBlockFamiliesClient {

    // For ASPEN SKYRIS and MAPLE add translucent

    public static Map<BYGBlockFamily, RenderType> renderTypes = new ConcurrentHashMap<>();

    static {
        register(BYGBlockFamilies.ASPEN, RenderType.translucent());
        register(BYGBlockFamilies.SKYRIS, RenderType.translucent());
    }

    private static void register(BYGBlockFamily bygBlockFamily, RenderType renderType) {
        renderTypes.put(bygBlockFamily, renderType);
    }
}