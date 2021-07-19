package corgiaoc.byg.common.properties.blocks.nether;

import corgiaoc.byg.common.entity.tileentities.HypogealImperiumTE;
import corgiaoc.byg.core.BYGTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class HypogealImperiumBlock extends Block {
    public HypogealImperiumBlock(Properties properties) {
        super(properties);
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
           return BYGTileEntities.HYPOGEAL.get().create();
        }


    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result) {
        if (!worldIn.isClientSide) {
            TileEntity tile = worldIn.getBlockEntity(pos);
            if (tile instanceof HypogealImperiumTE) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (HypogealImperiumTE) tile, pos);
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;
    }



    @Override
    public void onRemove(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity te = worldIn.getBlockEntity(pos);
            if (te instanceof HypogealImperiumTE) {
                InventoryHelper.dropContents(worldIn, pos, ((HypogealImperiumTE) te).getItems());
            }
            super.onRemove(state, worldIn, pos, newState, isMoving);
        }
    }
    }

