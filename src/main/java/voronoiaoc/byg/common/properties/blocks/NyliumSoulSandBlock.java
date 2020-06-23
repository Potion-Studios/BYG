package voronoiaoc.byg.common.properties.blocks;//package voronoiaoc.byg.common.properties.blocks;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.entity.EntityType;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//
//public class NyliumSoulSandBlock extends Block {
//    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);
//
//    public NyliumSoulSandBlock(AbstractBlock.Settings p_i48326_1_) {
//        super(p_i48326_1_);
//    }
//
//    public VoxelShape getCollisionShape(BlockState p_220071_1_, BlockView p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
//        return SHAPE;
//    }
//
//    public void neighborChanged(BlockState p_220069_1_, World p_220069_2_, BlockPos p_220069_3_, Block p_220069_4_, BlockPos p_220069_5_, boolean p_220069_6_) {
//        p_220069_2_.getPendingBlockTicks().scheduleTick(p_220069_3_, this, this.tickRate(p_220069_2_));
//    }
//
//    public boolean isNormalCube(BlockState p_220081_1_, BlockView p_220081_2_, BlockPos p_220081_3_) {
//        return true;
//    }
//
//    public void onBlockAdded(BlockState p_220082_1_, World p_220082_2_, BlockPos p_220082_3_, BlockState p_220082_4_, boolean p_220082_5_) {
//        p_220082_2_.getPendingBlockTicks().scheduleTick(p_220082_3_, this, this.tickRate(p_220082_2_));
//    }
//
//    public boolean allowsMovement(BlockState p_196266_1_, BlockView p_196266_2_, BlockPos p_196266_3_, PathType p_196266_4_) {
//        return false;
//    }
//
//    public boolean canEntitySpawn(BlockState p_220067_1_, BlockView p_220067_2_, BlockPos p_220067_3_, EntityType<?> p_220067_4_) {
//        return true;
//    }
//
////    public boolean isViewBlocking(BlockState p_229870_1_, BlockView p_229870_2_, BlockPos p_229870_3_) {
//        return true;
//    }
//}
