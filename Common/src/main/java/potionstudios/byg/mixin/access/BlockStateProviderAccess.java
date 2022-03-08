package potionstudios.byg.mixin.access;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockStateProviderType.class)
public interface BlockStateProviderAccess {

    @Invoker("<init>")
    static <P extends BlockStateProvider> BlockStateProviderType<P> byg_create(Codec<P> codec) {
        throw new Error("Mixin did not apply!");
    }
}
