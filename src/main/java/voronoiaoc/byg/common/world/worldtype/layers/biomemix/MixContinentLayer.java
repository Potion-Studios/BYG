package voronoiaoc.byg.common.world.worldtype.layers.biomemix;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.INoiseRandom;
import voronoiaoc.byg.common.world.worldtype.layers.InitLayer;
import voronoiaoc.byg.common.world.worldtype.math.BiomeGroupManager;

@SuppressWarnings("deprecation")
public class MixContinentLayer extends InitLayer {
    public MixContinentLayer(BiomeGroupManager manager) {
        super(manager);
    }

    @Override
    public int apply(INoiseRandom rand, int genX, int genZ) {
        return Registry.BIOME.getId(this.manager.getBiomeGroup(genX, genZ).pickBiome(rand));
    }
}
