package voronoiaoc.byg.mixin.common.world.feature;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.BasaltColumnFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BasaltColumnFeature.class)
public class MixinBasaltFeatures {

    @Inject(at = @At("RETURN"), method = "func_236247_a_(Lnet/minecraft/world/IWorld;ILnet/minecraft/util/math/BlockPos;)Z", cancellable = true)
    private static void allowWater(IWorld world, int maxY, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        String dimensionKey = ((WorldGenRegion) world).getWorld().getDimensionKey().func_240901_a_().toString();

        if (!cir.getReturnValue() && dimensionKey.equals("minecraft:overworld"))
            cir.setReturnValue(world.getBlockState(pos).getMaterial() == Material.WATER);
    }
}
