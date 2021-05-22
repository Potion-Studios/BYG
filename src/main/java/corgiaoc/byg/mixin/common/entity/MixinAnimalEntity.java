package corgiaoc.byg.mixin.common.entity;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(AnimalEntity.class)
public class MixinAnimalEntity {

    @Inject(at = @At("HEAD"), method = "checkAnimalSpawnRules", cancellable = true)
    private static void addModdedGrass(EntityType<? extends AnimalEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        BlockState state = worldIn.getBlockState(pos.below());
        if (state.getBlock() == BYGBlocks.OVERGROWN_STONE || state.getBlock() == BYGBlocks.OVERGROWN_DACITE || state.getBlock() == BYGBlocks.MEADOW_GRASSBLOCK) {
            cir.setReturnValue(worldIn.getRawBrightness(pos, 0) > 8);
        }
    }
}
