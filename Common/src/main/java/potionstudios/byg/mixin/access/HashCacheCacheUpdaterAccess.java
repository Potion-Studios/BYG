package potionstudios.byg.mixin.access;

import net.minecraft.data.HashCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(HashCache.CacheUpdater.class)
public interface HashCacheCacheUpdaterAccess {

    @Invoker("<init>")
    static HashCache.CacheUpdater byg_create(String $$0, HashCache.ProviderCache $$1){
        throw new Error("Mixin did not apply!");
    }
}
