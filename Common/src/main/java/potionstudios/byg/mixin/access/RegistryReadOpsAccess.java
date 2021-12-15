package potionstudios.byg.mixin.access;

import com.mojang.serialization.DataResult;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryReadOps;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(RegistryReadOps.class)
public interface RegistryReadOpsAccess {

    @Invoker
    <E> DataResult<Registry<E>> invokeRegistry(ResourceKey<? extends Registry<E>> $$0);
}
