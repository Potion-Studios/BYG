package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SurfaceRules.StateRule.class)
public interface SurfaceRulesStateRuleAccess {


    @Invoker("<init>")
    static SurfaceRules.StateRule byg_create(BlockState state) {
        throw new Error("Mixin did not apply!");
    }
}