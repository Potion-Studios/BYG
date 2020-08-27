package voronoiaoc.byg.common.properties.blocks;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BYGPollenBlock extends Block {

    protected BYGPollenBlock(Properties builder) {
        super(builder);

    }

    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity && entityIn.getType() != EntityType.BEE && entityIn.getType() != EntityType.BAT) {
            entityIn.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
            double d0 = Math.abs(entityIn.getX() - entityIn.xOld);
            double d1 = Math.abs(entityIn.getZ() - entityIn.zOld);
        }
    }

    public void animateTick(BlockState state, Level world, BlockPos pos, Random p_180655_4_) {
        VoxelShape shape = this.getShape(state, world, pos, CollisionContext.empty());
        Vec3 vec3D = shape.bounds().getCenter();
        double lvt_7_1_ = (double) pos.getX() + vec3D.x;
        double lvt_9_1_ = (double) pos.getZ() + vec3D.z;

        for (int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (p_180655_4_.nextBoolean()) {
                world.addParticle(ParticleTypes.FALLING_NECTAR, lvt_7_1_ + (double) (p_180655_4_.nextFloat() / 5.0F), (double) pos.getY() + (0.5D - (double) p_180655_4_.nextFloat()), lvt_9_1_ + (double) (p_180655_4_.nextFloat() / 5.0F), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    @Override
    public boolean isPossibleToRespawnInThis() {
        return false;
    }
}
