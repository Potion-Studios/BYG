package potionstudios.byg.mixin.access;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MinecraftServer.class)
public interface MinecraftServerAccess {

    @Accessor("storageSource")
    LevelStorageSource.LevelStorageAccess byg_getStorageSource();
}
