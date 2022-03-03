package potionstudios.byg.common.world.feature.stateproviders;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import potionstudios.byg.mixin.access.BlockStateProviderAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGStateProviders {

    public static final List<RegistryObject<BlockStateProviderType<?>>> STATE_PROVIDERS = new ArrayList<>();


    public static final BlockStateProviderType<BetweenNoiseThresholdProvider> BETWEEN_NOISE_THRESHOLD_PROVIDER = register("between_noise_threshold_provider", BetweenNoiseThresholdProvider.CODEC);


    private static <P extends BlockStateProvider> BlockStateProviderType<P> register(String id, Codec<P> codec) {
        BlockStateProviderType<P> type = BlockStateProviderAccess.byg_create(codec);
        STATE_PROVIDERS.add(new RegistryObject<>(type, id));
        return type;
    }

    public static Collection<RegistryObject<BlockStateProviderType<?>>> bootStrap() {
        return STATE_PROVIDERS;
    }
}
