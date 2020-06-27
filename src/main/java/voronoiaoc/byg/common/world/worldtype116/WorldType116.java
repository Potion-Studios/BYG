package voronoiaoc.byg.common.world.worldtype116;

import net.minecraft.client.gui.screen.BiomeGeneratorTypeScreens;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;

public class WorldType116 {

    private static final BiomeGeneratorTypeScreens BYG = new BiomeGeneratorTypeScreens("byg") {
        protected ChunkGenerator func_230484_a_(long seed) {
            return new NoiseChunkGenerator(new BYGBiomeProvider116(seed), seed, DimensionSettings.Preset.field_236122_b_.func_236137_b_());
        }
    };

    public static void addGenerator() {
        BiomeGeneratorTypeScreens.field_239068_c_.add(BYG);
    }
}
