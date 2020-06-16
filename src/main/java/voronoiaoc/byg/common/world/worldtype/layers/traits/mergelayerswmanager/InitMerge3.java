package voronoiaoc.byg.common.world.worldtype.layers.traits.mergelayerswmanager;

import voronoiaoc.byg.common.world.worldtype.layers.traits.Merge3Layers;
import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;

public abstract class InitMerge3 implements Merge3Layers {
    public BiomeGroupManager manager;

    public InitMerge3(BiomeGroupManager manager) {
        this.manager = manager;
    }
}
