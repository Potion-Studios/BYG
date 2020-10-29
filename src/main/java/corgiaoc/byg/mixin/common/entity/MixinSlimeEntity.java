package corgiaoc.byg.mixin.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.Difficulty;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(SlimeEntity.class)
public class MixinSlimeEntity {
    @Inject(at = @At("HEAD"), method = "canSpawn(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/WorldAccess;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)Z", cancellable = true)
    private static void injectSwampCategory(EntityType<SlimeEntity> entity, WorldAccess world, SpawnReason reason, BlockPos withSpawnerPos, Random randomIn, CallbackInfoReturnable<Boolean> cir) {
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            Biome biome = world.getBiome(withSpawnerPos);
            if (biome.getCategory() == Biome.Category.SWAMP && biome != BuiltinRegistries.BIOME.getOrThrow(BiomeKeys.SWAMP) && withSpawnerPos.getY() > 50 && withSpawnerPos.getY() < 70 && randomIn.nextFloat() < 0.5F && randomIn.nextFloat() < world.getMoonSize() && world.getLightLevel(withSpawnerPos) <= randomIn.nextInt(8)) {
                cir.setReturnValue(MobEntity.canMobSpawn(entity, world, reason, withSpawnerPos, randomIn));
            }
        }
    }
}
