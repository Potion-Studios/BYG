package corgiaoc.byg.common.world.feature.nether.trees.withering;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import java.util.Random;
import java.util.Set;

public class WitheringOakTree2 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public WitheringOakTree2(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwNetherTags(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 2, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 3, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 4, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 0), boundsIn);
                placeNetherTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 9, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 9, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 10, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 10, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 11, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 11, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 11, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 11, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 12, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 12, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 12, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 12, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 12, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 13, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 13, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 13, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 13, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 13, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 14, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 14, -2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 14, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 14, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 14, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 14, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 15, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 15, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 15, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 15, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 15, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 15, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 16, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 16, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 16, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 16, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 16, -3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 16, -4), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 16, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 16, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 17, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 17, -1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 17, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 17, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 17, -4), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 17, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 18, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 18, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 18, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 18, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 18, -4), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 18, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 18, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 19, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 19, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 19, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 19, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 19, 2), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 20, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 20, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 20, 0), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 21, 1), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 21, 3), boundsIn);
                placeNetherBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 22, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 12, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 13, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 14, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 14, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, 15, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 15, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 15, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 15, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 15, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 15, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, 16, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 16, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 16, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 16, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 16, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 16, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, 17, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 17, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 17, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 17, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 17, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 17, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 17, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 17, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-4, 18, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 18, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 18, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 18, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 18, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 18, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 18, -4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 18, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 18, -5), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 19, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 19, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 19, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 19, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 19, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 19, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 19, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 20, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 20, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 20, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 20, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 20, 4), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(5, 20, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 21, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 21, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 21, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 21, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 21, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(4, 21, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 22, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 22, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 22, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 22, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 22, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 23, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 23, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 23, 1), boundsIn);
            }
        }
        return true;
    }
}