package potionstudios.byg.mixin.access;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Set;
import java.util.function.Supplier;

@Mixin(BiomeSource.class)
public interface BiomeSourceAccess {

    @Invoker("codec")
    Codec<? extends BiomeSource> byg_invokeCodec();


    @Accessor("possibleBiomes")
    void byg_setPossibleBiomes(Supplier<Set<Holder<Biome>>> possibleBiomes);
}