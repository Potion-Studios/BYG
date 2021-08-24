package corgiaoc.byg.common.properties.blocks.end.nightshade;

import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.util.MLBlockTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class NightshadeBerryBushBlock extends SweetBerryBushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    public NightshadeBerryBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(BYGItems.NIGHTSHADE_BERRIES);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        int i = state.getValue(AGE);
        if (i < 3 && worldIn.getRawBrightness(pos.above(), 0) <= 10 && random.nextInt(5) == 0) {
            worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(i + 1)), 2);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(handIn).getItem() == Items.BONE_MEAL) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + worldIn.random.nextInt(2);
            popResource(worldIn, pos, new ItemStack(BYGItems.NIGHTSHADE_BERRIES, j + (flag ? 1 : 0)));
            worldIn.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
            worldIn.setBlock(pos, state.setValue(AGE, Integer.valueOf(1)), 2);
            return InteractionResult.SUCCESS;
        } else {
            return super.use(state, worldIn, pos, player, handIn, hit);
        }
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(BlockTags.NYLIUM) || state.is(MLBlockTags.END_STONES) || super.mayPlaceOn(state, worldIn, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    @Override
    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.PHANTOM && entityIn.getType() != EntityType.ENDERMAN) {
            entityIn.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
            if (!worldIn.isClientSide && state.getValue(AGE) > 0 && (entityIn.xOld != entityIn.getX() || entityIn.zOld != entityIn.getZ())) {
                double d0 = Math.abs(entityIn.getX() - entityIn.xOld);
                double d1 = Math.abs(entityIn.getZ() - entityIn.zOld);
                if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
                    entityIn.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0F);
                }
            }

        }
    }

    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        VoxelShape lvt_5_1_ = this.getShape(stateIn, worldIn, pos, CollisionContext.empty());
        Vec3 lvt_6_1_ = lvt_5_1_.bounds().getCenter();
        double lvt_7_1_ = (double) pos.getX() + lvt_6_1_.x;
        double lvt_9_1_ = (double) pos.getZ() + lvt_6_1_.z;

        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (rand.nextBoolean()) {
                worldIn.addParticle(ParticleTypes.WARPED_SPORE, lvt_7_1_ + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) rand.nextFloat()), lvt_9_1_ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
            }
        }

    }
}