package voronoiaoc.byg.common.world.dimension.nether.chunk;

import net.minecraft.world.gen.GenerationSettings;

public class BYGNetherGenSettings extends GenerationSettings {
    public int getBedrockFloorHeight() {
        return 0;
    }

    public int getBedrockRoofHeight() {
        return BYGNetherChunkGenerator.netherHeight();
    }
}

