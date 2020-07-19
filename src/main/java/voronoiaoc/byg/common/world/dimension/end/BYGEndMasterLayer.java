package voronoiaoc.byg.common.world.dimension.end;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;

public enum BYGEndMasterLayer implements InitLayer {
    INSTANCE;
    @Override
    public int sample(LayerRandomnessSource context, int x, int y) {
        return pickRandomBiomeID(context);
    }

    public int pickRandomBiomeID(LayerRandomnessSource randomnessSource) {
        if (BYGNetherBiomeProvider.biomeList.isEmpty()) {
            return Registry.BIOME.getRawId(Biomes.END_HIGHLANDS);
        }
        return Registry.BIOME.getRawId(BYGEndBiomeProvider.vanillaEnd.get(randomnessSource.nextInt(BYGNetherBiomeProvider.biomeList.size())));
    }
}
