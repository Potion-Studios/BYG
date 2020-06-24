package voronoiaoc.byg.common.world.worldtype.layers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum BYGRiverLayer implements ICastleTransformer {
    INSTANCE;

    public static final int RIVER = Registry.BIOME.getId(Biomes.RIVER);

    public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
        int i = riverFilter(center);
        return i == riverFilter(east) && i == riverFilter(north) && i == riverFilter(west) && i == riverFilter(south) ? RIVER : RIVER;
    }

    private static int riverFilter(int biomeID) {
        return biomeID >= 2 ? 2 + (biomeID & 1) : biomeID;
    }
}