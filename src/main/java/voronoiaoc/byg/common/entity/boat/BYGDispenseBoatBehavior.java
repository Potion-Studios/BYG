package voronoiaoc.byg.common.entity.boat;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BYGDispenseBoatBehavior extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior dispenseItemBehaviour = new DefaultDispenseItemBehavior();

    private final BYGBoatEntity.BYGType type;

    public BYGDispenseBoatBehavior(BYGBoatEntity.BYGType type) {
        this.type = type;
    }

    @Override
    protected ItemStack dispenseStack(IBlockSource source, ItemStack stack) {
        Direction direction = source.getBlockState().get(DispenserBlock.FACING);
        World world = source.getWorld();
        double d0 = source.getX() + (double) ((float) direction.getXOffset() * 1.125F);
        double d1 = source.getY() + (double) ((float) direction.getYOffset() * 1.125F);
        double d2 = source.getZ() + (double) ((float) direction.getZOffset() * 1.125F);
        BlockPos blockpos = source.getBlockPos().offset(direction);
        double d3;
        if (world.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
            d3 = 1.0D;
        } else {
            if (!world.getBlockState(blockpos).isAir() || !world.getFluidState(blockpos.down()).isTagged(FluidTags.WATER)) {
                return this.dispenseItemBehaviour.dispense(source, stack);
            }

            d3 = 0.0D;
        }

        BYGBoatEntity boatentity = new BYGBoatEntity(world, d0, d1 + d3, d2);
        boatentity.setBYGBoatType(this.type);
        boatentity.rotationYaw = direction.getHorizontalAngle();
        world.addEntity(boatentity);
        stack.shrink(1);
        return stack;
    }
}
