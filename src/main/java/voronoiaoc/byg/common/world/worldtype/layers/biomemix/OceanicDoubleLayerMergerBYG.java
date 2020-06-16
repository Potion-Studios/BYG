package voronoiaoc.byg.common.world.worldtype.layers.biomemix;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;
import voronoiaoc.byg.common.world.worldtype.layers.traits.mergelayerswmanager.InitMerge2;
import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;

@SuppressWarnings("deprecation")
public class OceanicDoubleLayerMergerBYG extends InitMerge2 implements IDimOffset1Transformer {
    public OceanicDoubleLayerMergerBYG(BiomeGroupManager manager) {
        super(manager);
    }

    @Override
    public int apply(IExtendedNoiseRandom<?> rand, IArea OceanicInitLayer, IArea oceanMix, int x, int z) {
        int oceanCheck = OceanicInitLayer.getValue(x, z);
        int oceanMixValue = oceanMix.getValue(x, z);

        return (oceanCheck) == 0 ? oceanMixValue : oceanCheck;
    }
}