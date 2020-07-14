package voronoiaoc.byg.common.world.dimension.nether;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;

public enum BYGNetherMasterLayer implements InitLayer {
    INSTANCE;
    @Override
    public int sample(LayerRandomnessSource context, int x, int y) {
        return pickRandomBiomeID(context);
    }

    public int pickRandomBiomeID(LayerRandomnessSource randomnessSource) {
        List<Biome> biomeList = new ArrayList<>();
        biomeList.add(BYGBiomeList.SYTHIANTORRIDS);
        return BuiltinRegistries.BIOME.getRawId(biomeList.get(randomnessSource.nextInt(biomeList.size())));
    }
}
