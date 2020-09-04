package voronoiaoc.byg.common.world.dimension.nether;

import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer0;

public enum BYGNetherMasterLayer implements AreaTransformer0 {
    INSTANCE;

    @Override
    public int applyPixel(Context context, int x, int y) {
        return pickRandomBiomeID(context);
    }

    public int pickRandomBiomeID(Context randomnessSource) {
        if (BYGNetherBiomeProvider.biomeIdList.isEmpty()) {
            return BYGNetherBiomeProvider.biomeRegistry.getId(BYGNetherBiomeProvider.biomeRegistry.get(Biomes.NETHER_WASTES));
        }
        return BYGNetherBiomeProvider.biomeRegistry.getId(BYGNetherBiomeProvider.biomeRegistry.get(BYGNetherBiomeProvider.biomeIdList.get(randomnessSource.nextRandom(BYGNetherBiomeProvider.biomeIdList.size()))));
    }
}