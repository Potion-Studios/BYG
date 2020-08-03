package voronoiaoc.byg.mixin.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(SlimeEntity.class)
public class MixinSlimeEntity {
    @Inject(at = @At("HEAD"), method = "func_223366_c(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/IWorld;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)Z", cancellable = true)
    private static void injectSwampCategory(EntityType<SlimeEntity> entity, IWorld world, SpawnReason reason, BlockPos spawnPos, Random randomIn, CallbackInfoReturnable<Boolean> cir) {
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            Biome biome = world.getBiome(spawnPos);
            if (biome.getCategory() == Biome.Category.SWAMP && biome != Biomes.SWAMP && spawnPos.getY() > 50 && spawnPos.getY() < 70 && randomIn.nextFloat() < 0.5F && randomIn.nextFloat() < world.getCurrentMoonPhaseFactor() && world.getLight(spawnPos) <= randomIn.nextInt(8)) {
               cir.setReturnValue(MobEntity.canSpawnOn(entity, world, reason, spawnPos, randomIn));
            }
        }
    }
}
