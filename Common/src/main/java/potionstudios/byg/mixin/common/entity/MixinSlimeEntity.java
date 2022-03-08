package potionstudios.byg.mixin.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Slime.class)
public class MixinSlimeEntity {

    @Inject(at = @At("HEAD"), method = "checkSlimeSpawnRules", cancellable = true)
    private static void injectSwampCategory(EntityType<Slime> entity, LevelAccessor world, MobSpawnType reason, BlockPos withSpawnerPos, Random randomIn, CallbackInfoReturnable<Boolean> cir) {
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            if (Biome.getBiomeCategory(world.getBiome(withSpawnerPos)) == Biome.BiomeCategory.SWAMP && withSpawnerPos.getY() > 50 && withSpawnerPos.getY() < 70 && randomIn.nextFloat() < 0.5F && randomIn.nextFloat() < world.getMoonBrightness() && world.getMaxLocalRawBrightness(withSpawnerPos) <= randomIn.nextInt(8)) {
                cir.setReturnValue(Mob.checkMobSpawnRules(entity, world, reason, withSpawnerPos, randomIn));
            }
        }
    }
}
