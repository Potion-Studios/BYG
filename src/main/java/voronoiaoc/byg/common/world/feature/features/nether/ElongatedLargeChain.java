//package voronoiaoc.byg.common.world.feature.features.nether;
//
//import com.mojang.serialization.Codec;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.material.Material;
//import net.minecraft.util.Direction;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.ISeedReader;
//import net.minecraft.world.IWorld;
//import net.minecraft.world.gen.ChunkGenerator;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.NoFeatureConfig;
//import net.minecraftforge.common.Tags;
//import voronoiaoc.byg.core.byglists.BYGBlockList;
//
//import java.util.Random;
//import java.util.function.Function;
//
//public class ElongatedLargeChain extends Feature<NoFeatureConfig> {
//    public ElongatedLargeChain(Codec<NoFeatureConfig> config) {
//        super(config);
//    }
//
//    //TODO: Make this actually Elongated.
//    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
//        int randChainLength = 2 + rand.nextInt(5);
//
//        BlockPos.Mutable mainMutable1 = new BlockPos.Mutable(pos);
//        BlockPos.Mutable mainMutable2 = new BlockPos.Mutable(pos);
//        mainMutable1.move(Direction.UP, 2);
//        mainMutable2.move(Direction.UP, 2);
//
//        if (!worldIn.isAirBlock(pos)) {
//            return false;
//        } else if (!worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.NETHERRACK)) {
//            return false;
//        }
//        else {
//            for (int moveDown = 0; moveDown <= randChainLength;) {
//                for (int move = -1; move <= 1; move++) {
//                    BlockPos.Mutable mutable1 = new BlockPos.Mutable(mainMutable1.getX() + move, mainMutable1.getY(), mainMutable1.getZ());
//                    BlockPos.Mutable mutable2 = new BlockPos.Mutable(mutable1.add(0, -4, 0));
//                    BlockPos.Mutable mutable3 = new BlockPos.Mutable(mainMutable2.getX(), mainMutable2.getY() - 3, mainMutable2.getZ() + move);
//                    BlockPos.Mutable mutable4 = new BlockPos.Mutable(mutable3.add(0, -4, 0));
//
//                    if (canReplaceBlock(worldIn, mutable1))
//                        worldIn.setBlockState(mutable1, BYGBlockList.SOAPSTONE.getDefaultState(), 2);
//                    if (canReplaceBlock(worldIn, mutable2))
//                        worldIn.setBlockState(mutable2, BYGBlockList.SOAPSTONE.getDefaultState(), 2);
//
//                    if (canReplaceBlock(worldIn, mutable3))
//                        worldIn.setBlockState(mutable3, BYGBlockList.SOAPSTONE.getDefaultState(), 2);
//                    if (canReplaceBlock(worldIn, mutable4))
//                        worldIn.setBlockState(mutable4, BYGBlockList.SOAPSTONE.getDefaultState(), 2);
//
//
//
//                    BlockPos.Mutable mutable5 = new BlockPos.Mutable(mainMutable1.getX() + 2, (mainMutable1.getY() - 2) + move, mainMutable1.getZ());
//                    BlockPos.Mutable mutable6 = new BlockPos.Mutable(mainMutable2.getX(), (mainMutable2.getY() - 5) + move, mainMutable2.getZ() + 2);
//                    if (canReplaceBlock(worldIn, mutable5))
//                        worldIn.setBlockState(mutable5, BYGBlockList.SOAPSTONE.getDefaultState(), 2);
//                    if (worldIn.getBlockState(mutable5.west(4)).isAir())
//                        worldIn.setBlockState(mutable5.west(4), BYGBlockList.SOAPSTONE.getDefaultState(), 2);
//
//                    if (canReplaceBlock(worldIn, mutable6))
//                        worldIn.setBlockState(mutable6, BYGBlockList.SOAPSTONE.getDefaultState(), 2);
//                    if (worldIn.getBlockState(mutable6.north(4)).isAir())
//                        worldIn.setBlockState(mutable6.north(4), BYGBlockList.SOAPSTONE.getDefaultState(), 2);
//
//                }
//                moveDown++;
//                mainMutable1.move(Direction.DOWN, 8);
//                mainMutable2.move(Direction.DOWN, 8);
//            }
//            return true;
//        }
//    }
//
//    public boolean canReplaceBlock(IWorld world, BlockPos pos) {
//       return world.getBlockState(pos).isIn(Tags.Blocks.NETHERRACK) || world.getBlockState(pos).isAir() || world.getBlockState(pos).getMaterial() == Material.PLANTS || world.getBlockState(pos).getMaterial() == Material.OCEAN_PLANT || world.getBlockState(pos).getMaterial() == Material.TALL_PLANTS || world.getBlockState(pos).getBlock() == Blocks.LAVA;
//    }
//}