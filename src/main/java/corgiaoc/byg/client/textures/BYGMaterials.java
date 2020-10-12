package corgiaoc.byg.client.textures;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BYGMaterials {
    public static final Material GLOWCELIUM;
    public static final Material RED_GLOWCANE;
    public static final Material BLUE_GLOWCANE;
    public static final Material PURPLE_GLOWCANE;
    public static final Material PINK_GLOWCANE;

    static {
        GLOWCELIUM = (new Material.Builder(MaterialColor.GRASS)).build();
        RED_GLOWCANE = (new Material.Builder(MaterialColor.RED)).build();
        BLUE_GLOWCANE = (new Material.Builder(MaterialColor.BLUE)).build();
        PURPLE_GLOWCANE = (new Material.Builder(MaterialColor.PURPLE)).build();
        PINK_GLOWCANE = (new Material.Builder(MaterialColor.PINK)).build();
    }

}
