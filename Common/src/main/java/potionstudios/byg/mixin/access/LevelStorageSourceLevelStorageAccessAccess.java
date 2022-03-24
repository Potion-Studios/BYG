package potionstudios.byg.mixin.access;

import net.minecraft.world.level.storage.LevelStorageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.nio.file.Path;

@Mixin(LevelStorageSource.LevelStorageAccess.class)
public interface LevelStorageSourceLevelStorageAccessAccess {

    @Accessor("levelPath")
    Path byg_getLevelPath();
}