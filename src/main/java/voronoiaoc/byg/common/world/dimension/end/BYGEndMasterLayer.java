package voronoiaoc.byg.common.world.dimension.end;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.BuiltInBiomes;
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
            return BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.get(BuiltInBiomes.END_HIGHLANDS));
        }
        return BuiltinRegistries.BIOME.getRawId(BYGEndBiomeProvider.bygEndBiomeList.get(randomnessSource.nextInt(BYGEndBiomeProvider.bygEndBiomeList.size())));
    }
}
