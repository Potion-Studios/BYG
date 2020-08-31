package voronoiaoc.byg.common;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BYGMaterials {
    public static final Material GLOWCELIUM;
    public static final Material RED_GLOWCANE;
    public static final Material BLUE_GLOWCANE;
    public static final Material PURPLE_GLOWCANE;
    public static final Material PINK_GLOWCANE;

    static {
        GLOWCELIUM = (new Material.Builder(MaterialColor.GRASS)).build();
        RED_GLOWCANE = (new Material.Builder(MaterialColor.COLOR_RED)).build();
        BLUE_GLOWCANE = (new Material.Builder(MaterialColor.COLOR_BLUE)).build();
        PURPLE_GLOWCANE = (new Material.Builder(MaterialColor.COLOR_PURPLE)).build();
        PINK_GLOWCANE = (new Material.Builder(MaterialColor.COLOR_PINK)).build();
    }

}
