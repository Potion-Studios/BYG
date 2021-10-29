package corgiaoc.byg.client.textures;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class BYGMaterials {
    public static final Material AMETRINE;
    public static final Material SUBZERO_CRYSTAL;

    static {
        AMETRINE = (new Material.Builder(MaterialColor.COLOR_PINK)).nonSolid().build();
        SUBZERO_CRYSTAL = (new Material.Builder(MaterialColor.COLOR_LIGHT_BLUE)).nonSolid().build();

    }

}
