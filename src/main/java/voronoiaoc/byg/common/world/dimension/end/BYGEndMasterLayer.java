package voronoiaoc.byg.common.world.dimension.end;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.newbiome.context.Context;
import net.minecraft.world.level.newbiome.layer.traits.AreaTransformer0;
import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;

public enum BYGEndMasterLayer implements AreaTransformer0 {
    INSTANCE;

    @Override
    public int applyPixel(Context context, int x, int y) {
        return pickRandomBiomeID(context);
    }

    public int pickRandomBiomeID(Context randomnessSource) {
        if (BYGNetherBiomeProvider.biomeIdList.isEmpty()) {
            return BuiltinRegistries.BIOME.getId(BuiltinRegistries.BIOME.get(Biomes.END_HIGHLANDS));
        }
        return BuiltinRegistries.BIOME.getId(BYGEndBiomeProvider.bygEndBiomeList.get(randomnessSource.nextRandom(BYGEndBiomeProvider.bygEndBiomeList.size())));
    }
}
