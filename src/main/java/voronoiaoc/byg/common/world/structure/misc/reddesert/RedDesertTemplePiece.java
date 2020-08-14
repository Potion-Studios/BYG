//package voronoiaoc.byg.common.world.structure.misc.reddesert;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.StairsBlock;
//import net.minecraft.nbt.CompoundNBT;
//import net.minecraft.util.Direction;
//import net.minecraft.util.math.ChunkPos;
//import net.minecraft.util.math.MutableBoundingBox;
//import net.minecraft.world.IWorld;
//import net.minecraft.world.gen.ChunkGenerator;
//import net.minecraft.world.gen.feature.structure.IStructurePieceType;
//import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
//import net.minecraft.world.gen.feature.template.TemplateManager;
//import net.minecraft.world.storage.loot.LootTables;
//import voronoiaoc.byg.core.byglists.BYGStructureList;
//
//import java.util.Random;
//
//public class RedDesertTemplePiece extends ScatteredStructurePiece {
//    private final boolean[] hasPlacedChest = new boolean[4];
//
//    public RedDesertTemplePiece(Random random, int x, int z) {
//        super(BYGStructureList.REDDESERTTEMPLE_PIECE, random, x, 66, z, 21, 15, 21);
//    }
//
//
//    public RedDesertTemplePiece(TemplateManager p_i51351_1_, CompoundNBT p_i51351_2_) {
//        super(IStructurePieceType.TEDP, p_i51351_2_);
//        this.hasPlacedChest[0] = p_i51351_2_.getBoolean("hasPlacedChest0");
//        this.hasPlacedChest[1] = p_i51351_2_.getBoolean("hasPlacedChest1");
//        this.hasPlacedChest[2] = p_i51351_2_.getBoolean("hasPlacedChest2");
//        this.hasPlacedChest[3] = p_i51351_2_.getBoolean("hasPlacedChest3");
//    }
//
//    /**
//     * (abstract) Helper method to read subclass data from NBT
//     */
//    protected void readAdditional(CompoundNBT tagCompound) {
//        super.readAdditional(tagCompound);
//        tagCompound.putBoolean("hasPlacedChest0", this.hasPlacedChest[0]);
//        tagCompound.putBoolean("hasPlacedChest1", this.hasPlacedChest[1]);
//        tagCompound.putBoolean("hasPlacedChest2", this.hasPlacedChest[2]);
//        tagCompound.putBoolean("hasPlacedChest3", this.hasPlacedChest[3]);
//    }
//
//    public boolean create(IWorld world, ChunkGenerator chunkGenerator, Random rand, MutableBoundingBox boundingBox, ChunkPos chunkPos) {
//        this.fillWithBlocks(world, boundingBox, 0, -4, 0, this.width - 1, 0, this.depth - 1, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//
//        for (int i = 1; i <= 9; ++i) {
//            this.fillWithBlocks(world, boundingBox, i, i, i, this.width - 1 - i, i, this.depth - 1 - i, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//            this.fillWithBlocks(world, boundingBox, i + 1, i, i + 1, this.width - 2 - i, i, this.depth - 2 - i, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        }
//
//        for (int k1 = 0; k1 < this.width; ++k1) {
//            for (int j = 0; j < this.depth; ++j) {
//                int k = -5;
//                this.replaceAirAndLiquidDownwards(world, Blocks.RED_SANDSTONE.getDefaultState(), k1, -5, j, boundingBox);
//            }
//        }
//
//        BlockState blockstate1 = Blocks.RED_SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.NORTH);
//        BlockState blockstate2 = Blocks.RED_SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH);
//        BlockState blockstate3 = Blocks.RED_SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.EAST);
//        BlockState blockstate = Blocks.RED_SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.WEST);
//        this.fillWithBlocks(world, boundingBox, 0, 0, 0, 4, 9, 4, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 1, 10, 1, 3, 10, 3, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.setBlockState(world, blockstate1, 2, 10, 0, boundingBox);
//        this.setBlockState(world, blockstate2, 2, 10, 4, boundingBox);
//        this.setBlockState(world, blockstate3, 0, 10, 2, boundingBox);
//        this.setBlockState(world, blockstate, 4, 10, 2, boundingBox);
//        this.fillWithBlocks(world, boundingBox, this.width - 5, 0, 0, this.width - 1, 9, 4, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, this.width - 4, 10, 1, this.width - 2, 10, 3, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.setBlockState(world, blockstate1, this.width - 3, 10, 0, boundingBox);
//        this.setBlockState(world, blockstate2, this.width - 3, 10, 4, boundingBox);
//        this.setBlockState(world, blockstate3, this.width - 5, 10, 2, boundingBox);
//        this.setBlockState(world, blockstate, this.width - 1, 10, 2, boundingBox);
//        this.fillWithBlocks(world, boundingBox, 8, 0, 0, 12, 4, 4, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 9, 1, 0, 11, 3, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 9, 1, 1, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 9, 2, 1, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 9, 3, 1, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 10, 3, 1, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 11, 3, 1, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 11, 2, 1, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 11, 1, 1, boundingBox);
//        this.fillWithBlocks(world, boundingBox, 4, 1, 1, 8, 3, 3, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 4, 1, 2, 8, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 12, 1, 1, 16, 3, 3, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 12, 1, 2, 16, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 5, 4, 5, this.width - 6, 4, this.depth - 6, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 9, 4, 9, 11, 4, 11, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 8, 1, 8, 8, 3, 8, Blocks.CUT_RED_SANDSTONE.getDefaultState(), Blocks.CUT_RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 12, 1, 8, 12, 3, 8, Blocks.CUT_RED_SANDSTONE.getDefaultState(), Blocks.CUT_RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 8, 1, 12, 8, 3, 12, Blocks.CUT_RED_SANDSTONE.getDefaultState(), Blocks.CUT_RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 12, 1, 12, 12, 3, 12, Blocks.CUT_RED_SANDSTONE.getDefaultState(), Blocks.CUT_RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 1, 1, 5, 4, 4, 11, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, this.width - 5, 1, 5, this.width - 2, 4, 11, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 6, 7, 9, 6, 7, 11, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, this.width - 7, 7, 9, this.width - 7, 7, 11, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 5, 5, 9, 5, 7, 11, Blocks.CUT_RED_SANDSTONE.getDefaultState(), Blocks.CUT_RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, this.width - 6, 5, 9, this.width - 6, 7, 11, Blocks.CUT_RED_SANDSTONE.getDefaultState(), Blocks.CUT_RED_SANDSTONE.getDefaultState(), false);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 5, 5, 10, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 5, 6, 10, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 6, 6, 10, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), this.width - 6, 5, 10, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), this.width - 6, 6, 10, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), this.width - 7, 6, 10, boundingBox);
//        this.fillWithBlocks(world, boundingBox, 2, 4, 4, 2, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, this.width - 3, 4, 4, this.width - 3, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.setBlockState(world, blockstate1, 2, 4, 5, boundingBox);
//        this.setBlockState(world, blockstate1, 2, 3, 4, boundingBox);
//        this.setBlockState(world, blockstate1, this.width - 3, 4, 5, boundingBox);
//        this.setBlockState(world, blockstate1, this.width - 3, 3, 4, boundingBox);
//        this.fillWithBlocks(world, boundingBox, 1, 1, 3, 2, 2, 3, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, this.width - 3, 1, 3, this.width - 2, 2, 3, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.setBlockState(world, Blocks.RED_SANDSTONE.getDefaultState(), 1, 1, 2, boundingBox);
//        this.setBlockState(world, Blocks.RED_SANDSTONE.getDefaultState(), this.width - 2, 1, 2, boundingBox);
//        this.setBlockState(world, Blocks.RED_SANDSTONE_SLAB.getDefaultState(), 1, 2, 2, boundingBox);
//        this.setBlockState(world, Blocks.RED_SANDSTONE_SLAB.getDefaultState(), this.width - 2, 2, 2, boundingBox);
//        this.setBlockState(world, blockstate, 2, 1, 2, boundingBox);
//        this.setBlockState(world, blockstate3, this.width - 3, 1, 2, boundingBox);
//        this.fillWithBlocks(world, boundingBox, 4, 3, 5, 4, 3, 17, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, this.width - 5, 3, 5, this.width - 5, 3, 17, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 3, 1, 5, 4, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, this.width - 6, 1, 5, this.width - 5, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//
//        for (int l = 5; l <= 17; l += 2) {
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 4, 1, l, boundingBox);
//            this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), 4, 2, l, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), this.width - 5, 1, l, boundingBox);
//            this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), this.width - 5, 2, l, boundingBox);
//        }
//
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 10, 0, 7, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 10, 0, 8, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 9, 0, 9, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 11, 0, 9, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 8, 0, 10, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 12, 0, 10, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 7, 0, 10, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 13, 0, 10, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 9, 0, 11, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 11, 0, 11, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 10, 0, 12, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 10, 0, 13, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 10, 0, 10, boundingBox);
//
//        for (int l1 = 0; l1 <= this.width - 1; l1 += this.width - 1) {
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), l1, 2, 1, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 2, 2, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), l1, 2, 3, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), l1, 3, 1, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 3, 2, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), l1, 3, 3, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 4, 1, boundingBox);
//            this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), l1, 4, 2, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 4, 3, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), l1, 5, 1, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 5, 2, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), l1, 5, 3, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 6, 1, boundingBox);
//            this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), l1, 6, 2, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 6, 3, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 7, 1, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 7, 2, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), l1, 7, 3, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), l1, 8, 1, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), l1, 8, 2, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), l1, 8, 3, boundingBox);
//        }
//
//        for (int i2 = 2; i2 <= this.width - 3; i2 += this.width - 3 - 2) {
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), i2 - 1, 2, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2, 2, 0, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), i2 + 1, 2, 0, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), i2 - 1, 3, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2, 3, 0, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), i2 + 1, 3, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2 - 1, 4, 0, boundingBox);
//            this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), i2, 4, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2 + 1, 4, 0, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), i2 - 1, 5, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2, 5, 0, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), i2 + 1, 5, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2 - 1, 6, 0, boundingBox);
//            this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), i2, 6, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2 + 1, 6, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2 - 1, 7, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2, 7, 0, boundingBox);
//            this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), i2 + 1, 7, 0, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), i2 - 1, 8, 0, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), i2, 8, 0, boundingBox);
//            this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), i2 + 1, 8, 0, boundingBox);
//        }
//
//        this.fillWithBlocks(world, boundingBox, 8, 4, 0, 12, 6, 0, Blocks.CUT_RED_SANDSTONE.getDefaultState(), Blocks.CUT_RED_SANDSTONE.getDefaultState(), false);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 8, 6, 0, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 12, 6, 0, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 9, 5, 0, boundingBox);
//        this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), 10, 5, 0, boundingBox);
//        this.setBlockState(world, Blocks.BLUE_TERRACOTTA.getDefaultState(), 11, 5, 0, boundingBox);
//        this.fillWithBlocks(world, boundingBox, 8, -14, 8, 12, -11, 12, Blocks.CUT_RED_SANDSTONE.getDefaultState(), Blocks.CUT_RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 8, -10, 8, 12, -10, 12, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 8, -9, 8, 12, -9, 12, Blocks.CUT_RED_SANDSTONE.getDefaultState(), Blocks.CUT_RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 8, -8, 8, 12, -1, 12, Blocks.RED_SANDSTONE.getDefaultState(), Blocks.RED_SANDSTONE.getDefaultState(), false);
//        this.fillWithBlocks(world, boundingBox, 9, -11, 9, 11, -1, 11, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.setBlockState(world, Blocks.STONE_PRESSURE_PLATE.getDefaultState(), 10, -11, 10, boundingBox);
//        this.fillWithBlocks(world, boundingBox, 9, -13, 9, 11, -13, 11, Blocks.TNT.getDefaultState(), Blocks.AIR.getDefaultState(), false);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 8, -11, 10, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 8, -10, 10, boundingBox);
//        this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), 7, -10, 10, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 7, -11, 10, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 12, -11, 10, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 12, -10, 10, boundingBox);
//        this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), 13, -10, 10, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 13, -11, 10, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 10, -11, 8, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 10, -10, 8, boundingBox);
//        this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), 10, -10, 7, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 10, -11, 7, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 10, -11, 12, boundingBox);
//        this.setBlockState(world, Blocks.AIR.getDefaultState(), 10, -10, 12, boundingBox);
//        this.setBlockState(world, Blocks.CHISELED_RED_SANDSTONE.getDefaultState(), 10, -10, 13, boundingBox);
//        this.setBlockState(world, Blocks.CUT_RED_SANDSTONE.getDefaultState(), 10, -11, 13, boundingBox);
//
//        for (Direction direction : Direction.Plane.HORIZONTAL) {
//            if (!this.hasPlacedChest[direction.getHorizontalIndex()]) {
//                int i1 = direction.getXOffsetPos() * 2;
//                int j1 = direction.getZOffsetPos() * 2;
//                this.hasPlacedChest[direction.getHorizontalIndex()] = this.generateChest(world, boundingBox, rand, 10 + i1, -11, 10 + j1, LootTables.CHESTS_DESERT_PYRAMID);
//            }
//        }
//
//        return true;
//    }
//}