package potionstudios.byg.mixin.access;

import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ChunkGenerator.class)
public interface ChunkGeneratorAccess {

    @Accessor("biomeSource")
    @Mutable
    void byg_setBiomeSource(BiomeSource biomeSource);
}
