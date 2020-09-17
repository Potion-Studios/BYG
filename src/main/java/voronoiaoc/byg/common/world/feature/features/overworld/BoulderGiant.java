//package voronoiaoc.byg.common.world.feature.features.overworld;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.material.Material;
//import net.minecraft.util.Direction;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.gen.ChunkGenerator;
//
//import java.util.Random;
//
//public class BoulderGiant extends Feature<DefaultFeatureConfig> {
//
//    protected long seed;
//    protected static OpenSimplex2F noiseGen;
//
//    public void setSeed(long seed) {
//        if (this.seed != seed || noiseGen == null) {
//            noiseGen = new OpenSimplex2F(seed);
//            this.seed = seed;
//        }
//    }
//
//
//    public BoulderGiant() {
//        super(DefaultFeatureConfig.CODEC);
//    }
//
//    @Override
//    public boolean generate(StructureWorldAccess world, ChunkGenerator chunkGenerator, Random random, BlockPos position, DefaultFeatureConfig config) {
//
//        setSeed(world.getSeed());
//
//        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable().set(position.down(6));
//        BlockPos.Mutable blockpos$Mutable2 = new BlockPos.Mutable().set(blockpos);
//        int stackHeight = random.nextInt(5) + 2;
//        int radius = random.nextInt(5) + 3 + stackHeight;
//
//        for(int rockNum = 0; rockNum < stackHeight; rockNum++){
//            blockpos$Mutable.move(
//                    random.nextInt(3) - 1,
//                    (int)(random.nextInt(radius) * 0.2f + radius * 0.8f) - 1,
//                    random.nextInt(3) - 1);
//
//            for(int x = -radius; x <= radius; x++){
//                for(int y = -radius; y <= radius; y++){
//                    for(int z = -radius; z <= radius; z++){
//
//                        int squaredDistance = x*x + y*y + z*z;
//                        if (squaredDistance <= radius * radius) {
//
//                            blockpos$Mutable2.set(blockpos$Mutable).move(x,y,z);
//
//                            // Rough the surface of the boulders a bit
//                            double noiseValue = noiseGen.noise3_Classic(blockpos$Mutable2.getX() * 0.04D, blockpos$Mutable2.getY() * 0.01D, blockpos$Mutable2.getZ() * 0.04D);
//                            if (squaredDistance > radius * radius * 0.8f &&
//                                    noiseValue > -0.3D && noiseValue < 0.3D) {
//                                continue;
//                            }
//
//                            BlockState blockState = world.getBlockState(blockpos$Mutable2);
//                            if(blockState.isAir() || blockState.getMaterial() == Material.SOIL || blockState.getMaterial() == Material.PLANT ||
//                                    blockState.getMaterial() == Material.REPLACEABLE_PLANT || blockState.getMaterial() == Material.LEAVES ||
//                                    blockState.getMaterial() == Material.AGGREGATE || blockState.getMaterial() == Material.BAMBOO || blockState.getMaterial() == Material.CACTUS
//                                    || blockState.getMaterial() == Material.WATER || blockState.getMaterial() == Material.LAVA)
//                            {
//                                world.setBlockState(blockpos$Mutable2, Blocks.SANDSTONE.getDefaultState(), 3);
//                            }
//                        }
//                    }
//                }
//            }
//
//            while(blockpos$Mutable.getY() < 255 && !world.getBlockState(blockpos$Mutable).isAir()){
//                blockpos$Mutable.move(Direction.UP);
//            }
//
//            radius = (int) (radius * (0.5f + ((1 - stackHeight/6f) * 0.5f)) + 1);
//        }
//
//        return true;
//    }
//}