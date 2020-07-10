package voronoiaoc.byg.common.world.worldtype116;

import com.mojang.serialization.Lifecycle;
import net.minecraft.client.gui.screen.BiomeGeneratorTypeScreens;
import net.minecraft.server.IDynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import voronoiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import voronoiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;

public class WorldType116 extends BiomeGeneratorTypeScreens {
    public WorldType116() {
        super("byg");
    }


    public static void addGenerator() {
        BiomeGeneratorTypeScreens.field_239068_c_.add(new WorldType116());
    }


    @Override
    protected ChunkGenerator func_230484_a_(long seed) {
        return new NoiseChunkGenerator(new BYGBiomeProvider116(seed), seed, DimensionSettings.Preset.field_236122_b_.func_236137_b_());
    }

    public static ChunkGenerator bygNetherGenerator(long seed) {
        return new NoiseChunkGenerator(new BYGNetherBiomeProvider(seed), seed, DimensionSettings.Preset.field_236124_d_.func_236137_b_());
    }

    public static ChunkGenerator bygEndGenerator(long seed) {
        return new NoiseChunkGenerator(new BYGEndBiomeProvider(seed), seed, DimensionSettings.Preset.field_236125_e_.func_236137_b_());
    }

    @Override
    public DimensionGeneratorSettings func_241220_a_(IDynamicRegistries.Impl impl, long seed, boolean features, boolean bonusChest) {
        return new DimensionGeneratorSettings(seed, features, bonusChest, DimensionGeneratorSettings.func_236216_a_(pickBYGDimension(seed), this.func_230484_a_(seed)));
    }

    public static SimpleRegistry<Dimension> pickBYGDimension(long seed) {
        SimpleRegistry<Dimension> simpleregistry = new SimpleRegistry<>(Registry.DIMENSION_KEY, Lifecycle.experimental());
        simpleregistry.register(Dimension.field_236054_c_, new Dimension(() -> DimensionType.field_236005_i_, bygNetherGenerator(seed)));
        simpleregistry.register(Dimension.field_236055_d_, new Dimension(() -> DimensionType.field_236006_j_, bygEndGenerator(seed)));
        simpleregistry.func_239662_d_(Dimension.field_236054_c_);
        simpleregistry.func_239662_d_(Dimension.field_236055_d_);
        return simpleregistry;
    }
}
