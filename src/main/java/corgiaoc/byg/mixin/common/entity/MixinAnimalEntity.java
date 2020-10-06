package corgiaoc.byg.mixin.common.entity;

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
import corgiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

@Mixin(AnimalEntity.class)
public class MixinAnimalEntity {

    @Inject(at = @At("HEAD"), method = "canAnimalSpawn(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/IWorld;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)Z", cancellable = true)
    private static void addModdedGrass(EntityType<? extends AnimalEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        BlockState state = worldIn.getBlockState(pos.down());
        if (state.getBlock() == BYGBlockList.OVERGROWN_STONE || state.getBlock() == BYGBlockList.OVERGROWN_DACITE || state.getBlock() == BYGBlockList.MEADOW_GRASSBLOCK) {
            cir.setReturnValue(worldIn.getLightSubtracted(pos, 0) > 8);
        }
    }
}
