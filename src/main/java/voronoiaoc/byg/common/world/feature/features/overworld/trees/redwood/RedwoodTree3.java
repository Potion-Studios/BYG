//package voronoiaoc.byg.common.world.feature.features.overworld.trees.redwood;
//
//import com.mojang.datafixers.Dynamic;
//import net.minecraft.block.Blocks;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.BlockBox;
//import net.minecraft.world.gen.ModifiableTestableWorld;
////import net.minecraft.world.gen.feature.DefaultFeatureConfig;
//import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
//import voronoiaoc.byg.core.byglists.BYGBlockList;
//
//import java.util.Random;
//import java.util.Set;
//import java.util.function.Function;
//
//public class RedwoodTree3 extends BYGAbstractTreeFeature<DefaultFeatureConfig> {
//
//    public RedwoodTree3(Codec<DefaultFeatureConfig> configIn) {
//        super(configIn);
//    }
//
//    protected boolean place(Set<BlockPos> changedBlocks, ServerWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn) {
//        int randTreeHeight = 23 + rand.nextInt(5);
//        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);
//
//        if (pos.getY() + randTreeHeight + 1 < worldIn.getDimensionHeight()) {
//            BlockPos blockpos = pos.down();
//            if (!isDesiredGround(worldIn, blockpos, Blocks.GRASS_BLOCK)) {
//                return false;
//            } else if (!this.doesTreeFit(worldIn, pos, randTreeHeight)) {
//                return false;
//            } else {
//
//            }
//        }
//        return true;
//    }
//
//    //Log Placement
//    private void treeLog(Set<BlockPos> setlogblock, ServerWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
//        if (canTreePlaceHere(reader, pos)) {
//            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.REDWOOD_LOG.getDefaultState(), boundingBox);
//        }
//    }
//
//    //Log Placement
//    private void treeBranch(Set<BlockPos> setlogblock, ServerWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
//        if (canTreePlaceHere(reader, pos)) {
//            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.REDWOOD_LOG.getDefaultState(), boundingBox);
//        }
//    }
//
//    //Leaves Placement
//    private void leafs(Set<BlockPos> blockPos, ServerWorldAccess reader, BlockPos pos, BlockBox boundingBox) {
//        BlockPos.Mutable blockpos = new BlockPos.Mutable().set(pos);
//        if (isAir(reader, blockpos)) {
//            this.setFinalBlockState(blockPos, reader, blockpos,  BYGBlockList.REDWOOD_LEAVES.getDefaultState(), boundingBox);
//        }
//    }
//
//
//
//    private boolean doesTreeFit(ModifiableTestableWorld reader, BlockPos blockPos, int height) {
//        int x = blockPos.getX();
//        int y = blockPos.getY();
//        int z = blockPos.getZ();
//        BlockPos.Mutable pos = new BlockPos.Mutable();
//
//        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
//            //Distance/Density of trees. Positive Values ONLY
//            int distance = 2;
//
//            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
//                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
//                    if (!canTreePlaceHere(reader, pos.set(x + xOffset, y + yOffset, z + zOffset))) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//}