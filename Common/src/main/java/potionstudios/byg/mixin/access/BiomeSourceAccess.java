package potionstudios.byg.mixin.access;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.biome.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BiomeSource.class)
public interface BiomeSourceAccess {

    @Invoker("codec")
    Codec<? extends BiomeSource> byg_invokeCodec();
}