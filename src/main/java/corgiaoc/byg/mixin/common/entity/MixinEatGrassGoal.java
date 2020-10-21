//package corgiaoc.byg.mixin.common.entity;
//
//import com.mojang.datafixers.util.Pair;
//import corgiaoc.byg.BYG;
//import corgiaoc.byg.core.BYGBlocks;
//import net.minecraft.block.Block;
//import net.minecraft.entity.MobEntity;
//import net.minecraft.entity.ai.goal.EatGrassGoal;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Mixin(EatGrassGoal.class)
//public abstract class MixinEatGrassGoal {
//
//
//    @Shadow
//    private int eatingGrassTimer;
//
//    @Shadow
//    @Final
//    private MobEntity grassEaterEntity;
//
//    @Shadow
//    @Final
//    private World entityWorld;
//
//    private static final List<Block> grassBlocks = new ArrayList<>();
//
//    private static final List<Pair<Block, Block>> blockPairs = new ArrayList<>();
//
//
//    @Inject(at = @At("HEAD"), method = "tick()V", cancellable = true)
//    private void addModdedGrassForTick(CallbackInfo ci) {
//        this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
//        if (this.eatingGrassTimer == 4) {
//            BlockPos blockpos = this.grassEaterEntity.getPosition();
//            if (grassBlocks.contains(this.entityWorld.getBlockState(blockpos).getBlock())) {
//                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.grassEaterEntity)) {
//                    this.entityWorld.destroyBlock(blockpos, false);
//                }
//                this.grassEaterEntity.eatGrassBonus();
//                ci.cancel();
//            } else {
//                BlockPos blockpos1 = blockpos.down();
//
//                for (Pair<Block, Block> blockPair : blockPairs) {
//                    if (blockPair.getFirst().equals(this.entityWorld.getBlockState(blockpos1).getBlock())) {
//                        if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.grassEaterEntity)) {
//                            this.entityWorld.playEvent(2001, blockpos1, Block.getStateId(blockPair.getFirst().getDefaultState()));
//                            BYG.LOGGER.info("Boogaloo");
//                            this.entityWorld.setBlockState(blockpos1, blockPair.getSecond().getDefaultState(), 2);
//                        }
//
//                        this.grassEaterEntity.eatGrassBonus();
//                    }
//                }
//            }
//        }
//    }
//
//
//    @Inject(at = @At("HEAD"), method = "shouldExecute", cancellable = true)
//    private void addModdedGrassForExecution(CallbackInfoReturnable<Boolean> cir) {
//        if (this.grassEaterEntity.getRNG().nextInt(this.grassEaterEntity.isChild() ? 50 : 1000) != 0) {
//            cir.setReturnValue(false);
//        } else {
//            BlockPos blockpos = this.grassEaterEntity.getPosition();
//            if (grassBlocks.contains(this.entityWorld.getBlockState(blockpos).getBlock())) {
//                cir.setReturnValue(true);
//            } else {
//                for (Pair<Block, Block> blockPair : blockPairs) {
//                    cir.setReturnValue(blockPair.getFirst().equals(this.entityWorld.getBlockState(blockpos.down()).getBlock()));
//                }
//            }
//        }
//    }
//
//
//    static {
//        blockPairs.add(new Pair<>(BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.MEADOW_DIRT));
//        grassBlocks.add(BYGBlocks.SHORT_BEACH_GRASS);
//        grassBlocks.add(BYGBlocks.SHORT_GRASS);
//    }
//}
//
