package corgiaoc.byg.common.world.biome;

import net.minecraft.util.math.MathHelper;

public class BiomeUtil {
    public static int calcSkyColor(float f) {
        float g = f / 3.0F;
        g = MathHelper.clamp(g, -1.0F, 1.0F);
        return MathHelper.hsvToRGB(0.62222224F - g * 0.05F, 0.5F + g * 0.1F, 1.0F);
    }
}