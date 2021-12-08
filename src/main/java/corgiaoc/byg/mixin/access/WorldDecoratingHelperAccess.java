package corgiaoc.byg.mixin.access;

import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(WorldDecoratingHelper.class)
public interface WorldDecoratingHelperAccess {

    @Accessor
    ISeedReader getLevel();

    @Accessor
    ChunkGenerator getGenerator();
}
