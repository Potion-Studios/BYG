package potionstudios.byg.mixin.common;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapLike;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.resources.RegistryReadOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.RegistryReadOpsAccess;

import java.util.Optional;
import java.util.Random;

@Mixin(RegistryLookupCodec.class)
public class MixinRegistryLookupCodec<E> {

    @Shadow @Final private ResourceKey<? extends Registry<E>> registryKey;

    @Inject(method = "decode", at = @At("RETURN"))
    private void setStatic(DynamicOps<E> $$0, MapLike<E> $$1, CallbackInfoReturnable<DataResult<Registry<E>>> cir) {
        if ($$0 instanceof RegistryReadOps ) {
            DataResult<Registry<E>> registry = (((RegistryReadOpsAccess) $$0)).invokeRegistry(this.registryKey);
            final Optional<Registry<E>> left = registry.get().left();
            if (left.get().getRandom(new Random(1)) instanceof Biome) {
                BYG.biomeRegistryAccess = (Registry<Biome>) left.get();
            }
        }
    }
}
