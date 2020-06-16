package voronoiaoc.byg.common.world.worldtype.layers.traits.mergelayerswmanager;

import voronoiaoc.byg.common.world.worldtype.layers.traits.Merge2Layers;
import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;

public abstract class InitMerge2 implements Merge2Layers {
    public  BiomeGroupManager manager;

    public InitMerge2(BiomeGroupManager manager) {
        this.manager = manager;
    }
}
