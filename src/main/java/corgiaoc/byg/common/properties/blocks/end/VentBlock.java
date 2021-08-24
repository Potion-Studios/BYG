package corgiaoc.byg.common.properties.blocks.end;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class VentBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D);

    public VentBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any());
    }

    public void stepOn(Level worldIn, BlockPos pos, Entity entityIn) {
        if (!entityIn.fireImmune() && entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn)) {
            entityIn.hurt(DamageSource.HOT_FLOOR, 1.0F);
        }

        super.stepOn(worldIn, pos, entityIn);
    }

    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        }
    }

    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        Random random = worldIn.getRandom();
        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (rand.nextBoolean()) {
                worldIn.addParticle(ParticleTypes.SMOKE, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
            }
        }
        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (rand.nextBoolean()) {
                worldIn.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
            }
        }
    }


    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
