package potionstudios.byg.common.block.nether;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import potionstudios.byg.common.blockentity.BYGBlockEntities;
import potionstudios.byg.common.blockentity.HypogealImperiumBlockEntity;

import javax.annotation.Nullable;
import java.util.Random;

public class HypogealImperiumBlock extends BaseEntityBlock {
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public HypogealImperiumBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, Boolean.FALSE));
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult result) {
        if (!worldIn.isClientSide) {
            BlockEntity tile = worldIn.getBlockEntity(pos);
            if (tile instanceof HypogealImperiumBlockEntity) {
                player.openMenu((HypogealImperiumBlockEntity) tile);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }



    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof HypogealImperiumBlockEntity) {
                Containers.dropContents(worldIn, pos, ((HypogealImperiumBlockEntity) te).getItems());
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(LIT);
    }

    
    public void animateTick(BlockState state, Level world, BlockPos pos, Random rand) {
        if (state.getValue(LIT)) {
            for(int i = -2; i <= 2; ++i) {
                for(int j = -2; j <= 2; ++j) {
                    if (i > -2 && i < 2 && j == -1) {
                        j = 2;
                    }
                    if (rand.nextInt(16) == 0) {
                        for(int k = 0; k <= 1; ++k) {
                            world.addParticle(ParticleTypes.END_ROD, (double)pos.getX() + 0.5D, (double)pos.getY() + 2.0D, (double)pos.getZ() + 0.5D, (double)((float)i + rand.nextFloat()) - 0.5D, (float)k - rand.nextFloat() - 1.0F, (double)((float)j + rand.nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return BYGBlockEntities.HYPOGEAL.get().create(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, BYGBlockEntities.HYPOGEAL.get(), HypogealImperiumBlockEntity::tick);
    }
}

