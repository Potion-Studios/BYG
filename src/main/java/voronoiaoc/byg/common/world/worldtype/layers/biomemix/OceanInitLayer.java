package voronoiaoc.byg.common.world.worldtype.layers.biomemix;

import net.minecraft.world.gen.INoiseRandom;
import voronoiaoc.byg.common.world.worldtype.layers.InitLayer;
import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;

@SuppressWarnings("deprecation")
public class OceanInitLayer extends InitLayer {
    public OceanInitLayer(BiomeGroupManager manager) {
        super(manager);
    }

    @Override
    public int apply(INoiseRandom rand, int genX, int genZ) {
        return 0;
    }
}
