package corgiaoc.byg.mixin.common.entity;

import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Animal.class)
public class MixinAnimalEntity {

    @Inject(at = @At("HEAD"), method = "checkAnimalSpawnRules", cancellable = true)
    private static void addModdedGrass(EntityType<? extends Animal> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        BlockState state = worldIn.getBlockState(pos.below());
        if (state.getBlock() == BYGBlocks.OVERGROWN_STONE || state.getBlock() == BYGBlocks.OVERGROWN_DACITE || state.getBlock() == BYGBlocks.MEADOW_GRASSBLOCK) {
            cir.setReturnValue(worldIn.getRawBrightness(pos, 0) > 8);
        }
    }
}
