package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.PositionalRandomFactory;
import net.minecraft.world.level.levelgen.RandomSource;
import net.minecraft.world.level.levelgen.SurfaceSystem;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SurfaceSystem.class)
public interface SurfaceSystemAccess {

    @Accessor("clayBandsOffsetNoise")
    NormalNoise byg_getClayBandsOffsetNoise();

    @Accessor("randomFactory")
    PositionalRandomFactory byg_getRandomFactory();

    @Invoker("makeBands")
    static void byg_invokeMakeBands(RandomSource randomSource, BlockState[] states, int offset, BlockState state) {
        throw new Error("Mixin did not apply!");
    }
}
