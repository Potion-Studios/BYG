package potionstudios.byg.common.world.feature.stateproviders;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.BlockStateProviderAccess;
import potionstudios.byg.registration.RegistrationProvider;
import potionstudios.byg.registration.RegistryObject;

public class BYGStateProviders {
    private static final RegistrationProvider<BlockStateProviderType<?>> PROVIDER = RegistrationProvider.get(Registry.BLOCK_STATE_PROVIDER_TYPE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<BlockStateProviderType<BetweenNoiseThresholdProvider>> BETWEEN_NOISE_THRESHOLD_PROVIDER = register("between_noise_threshold_provider", BetweenNoiseThresholdProvider.CODEC);

    private static <P extends BlockStateProvider> RegistryObject<BlockStateProviderType<P>> register(String id, Codec<P> codec) {
        return PROVIDER.register(id, () -> BlockStateProviderAccess.byg_create(codec));
    }

    public static void loadClass() {}
}
