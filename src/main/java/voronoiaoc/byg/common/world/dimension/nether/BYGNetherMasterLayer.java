package voronoiaoc.byg.common.world.dimension.nether;

import net.minecraft.data.BuiltinRegistries;
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
        if (BYGNetherBiomeProvider.biomeList.isEmpty()) {
            return BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.get(Biomes.NETHER_WASTES));
        }
        return BuiltinRegistries.BIOME.getId(BYGNetherBiomeProvider.biomeList.get(randomnessSource.nextRandom(BYGNetherBiomeProvider.biomeList.size())));
    }
}