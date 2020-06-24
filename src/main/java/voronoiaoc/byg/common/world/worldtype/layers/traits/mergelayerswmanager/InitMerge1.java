package voronoiaoc.byg.common.world.worldtype.layers.traits.mergelayerswmanager;

import voronoiaoc.byg.common.world.worldtype.layers.traits.Merge1Layer;
import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;

public abstract class InitMerge1 implements Merge1Layer {
    public static BiomeGroupManager manager;

    public InitMerge1(BiomeGroupManager manager) {
        InitMerge1.manager = manager;
    }
}
