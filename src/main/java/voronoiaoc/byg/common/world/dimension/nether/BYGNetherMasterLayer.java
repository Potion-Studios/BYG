package voronoiaoc.byg.common.world.dimension.nether;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public enum BYGNetherMasterLayer implements InitLayer {
    INSTANCE;
    @Override
    public int sample(LayerRandomnessSource context, int x, int y) {
        return pickRandomBiomeID(context);
    }

    public int pickRandomBiomeID(LayerRandomnessSource randomnessSource) {
        if (BYGNetherBiomeProvider.biomeList.isEmpty()) {
            return Registry.BIOME.getRawId(Biomes.NETHER_WASTES);
        }
        return Registry.BIOME.getRawId(BYGNetherBiomeProvider.biomeList.get(randomnessSource.nextInt(BYGNetherBiomeProvider.biomeList.size())));
    }
}
