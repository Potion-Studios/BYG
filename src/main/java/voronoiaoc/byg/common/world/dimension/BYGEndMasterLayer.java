package voronoiaoc.byg.common.world.dimension;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;

public enum BYGEndMasterLayer implements IAreaTransformer0 {
    INSTANCE;

    public static List<Biome> biomeList = new ArrayList<>();

    @Override
    public int apply(INoiseRandom context, int x, int y) {
        return pickRandomBiomeID(context);
    }

    public int pickRandomBiomeID(INoiseRandom randomnessSource) {
        return Registry.BIOME.getId(biomeList.get(randomnessSource.random(biomeList.size())));
    }

    static {
        biomeList.add(BYGBiomeList.WARPEDDESERT);
        biomeList.add(BYGBiomeList.SYTHIANTORRIDS);
        biomeList.add(BYGBiomeList.GLOWSTONEGARDENS);
    }
}
