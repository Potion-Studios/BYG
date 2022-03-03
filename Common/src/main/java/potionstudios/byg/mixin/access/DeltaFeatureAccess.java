package potionstudios.byg.mixin.access;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.DeltaFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DeltaFeature.class)
public interface DeltaFeatureAccess {


    @Accessor("CANNOT_REPLACE")
    static ImmutableList<Block> byg_getCANNOT_REPLACE() {
        throw new Error("Mixin did not apply!");
    }

    @Accessor("CANNOT_REPLACE") @Mutable
    static void byg_setCANNOT_REPLACE(ImmutableList<Block> blocks) {
        throw new Error("Mixin did not apply!");
    }
}
