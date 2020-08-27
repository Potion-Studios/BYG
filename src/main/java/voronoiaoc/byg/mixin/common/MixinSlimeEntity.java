package voronoiaoc.byg.mixin.common;

import net.minecraft.core.BlockPos;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(Slime.class)
public class MixinSlimeEntity {

    @Inject(at = @At("HEAD"), method = "checkSlimeSpawnRules(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/core/BlockPos;Ljava/util/Random;)Z", cancellable = true, require = 0)
    private static void injectSwampCategory(EntityType<Slime> type, LevelAccessor world, MobSpawnType spawnReason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> cir) {
        if (world.getDifficulty() != Difficulty.PEACEFUL) {
            Biome biome = world.getBiome(pos);
            if (biome.getBiomeCategory() == Biome.BiomeCategory.SWAMP && biome != BuiltinRegistries.BIOME.get(Biomes.SWAMP) && pos.getY() > 50 && pos.getY() < 70 && random.nextFloat() < 0.5F && random.nextFloat() < world.getMoonBrightness() && world.getMaxLocalRawBrightness(pos) <= random.nextInt(8)) {
                cir.setReturnValue(Slime.checkSlimeSpawnRules(type, world, spawnReason, pos, random));
            }
        }
    }
}
