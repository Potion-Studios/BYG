package potionstudios.byg.common.world.biome;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.BiomeSource;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.function.Supplier;

public class BYGBiomeSources {
    public static final RegistrationProvider<Codec<? extends BiomeSource>> PROVIDER = RegistrationProvider.get(Registries.BIOME_SOURCE, BYG.MOD_ID);

    public static final RegistryObject<Codec<BYGEndBiomeSource>> END_BIOME_SOURCE_CODEC = register("end", () -> BYGEndBiomeSource.CODEC);
    public static final RegistryObject<Codec<BYGNetherBiomeSource>> NETHER_BIOME_SOURCE_CODEC = register("nether", () -> BYGNetherBiomeSource.CODEC);
    public static final RegistryObject<Codec<BYGDebugBiomeSource>> DEBUG_BIOMES = register("debug_biomes", () -> BYGDebugBiomeSource.CODEC);


    public static <T extends BiomeSource> RegistryObject<Codec<T>> register(String id, Supplier<Codec<T>> codecSupplier) {
        return PROVIDER.register(id, codecSupplier);
    }

    public static void loadClass() {}
}
