package corgiaoc.byg.common.properties.blocks.end.bulbisgardens;

import net.minecraft.block.BlockState;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EnderLilyBlock extends LilyPadBlock {

    protected EnderLilyBlock(Settings properties) {
        super(properties);
    }

    @Override
    protected boolean canPlantOnTop(BlockState state, BlockView reader, BlockPos p_200014_3_) {
        FluidState fluidState = reader.getFluidState(p_200014_3_);
        return fluidState.getFluid() == Fluids.WATER;
    }
}
