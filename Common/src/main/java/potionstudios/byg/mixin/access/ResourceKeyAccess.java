package potionstudios.byg.mixin.access;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ResourceKey.class)
public interface ResourceKeyAccess {

    @Invoker("create")
    static <T> ResourceKey<T> create(ResourceLocation registryName, ResourceLocation location) {
        throw new Error("Mixin not applied!");
    }

}
