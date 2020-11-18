package corgiaoc.byg.client.textures;

import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class BYGMaterials {
    public static final Material GLOWCELIUM;
    public static final Material RED_GLOWCANE;
    public static final Material BLUE_GLOWCANE;
    public static final Material PURPLE_GLOWCANE;
    public static final Material PINK_GLOWCANE;

    static {
        GLOWCELIUM = (new Material.Builder(MapColor.GRASS)).build();
        RED_GLOWCANE = (new Material.Builder(MapColor.RED)).build();
        BLUE_GLOWCANE = (new Material.Builder(MapColor.BLUE)).build();
        PURPLE_GLOWCANE = (new Material.Builder(MapColor.PURPLE)).build();
        PINK_GLOWCANE = (new Material.Builder(MapColor.PINK)).build();
    }

}
