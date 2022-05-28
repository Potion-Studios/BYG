package potionstudios.byg.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGScaffoldingBlock;

import javax.annotation.Nullable;

public class SythianScaffoldingBlockItem extends BlockItem {

    public SythianScaffoldingBlockItem(Block p_43060_, Item.Properties p_43061_) {
        super(p_43060_, p_43061_);
    }

    @Nullable
    public BlockPlaceContext updatePlacementContext(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        BlockState blockstate = level.getBlockState(blockpos);
        Block block = this.getBlock();
        if (!blockstate.is(block)) {
            return BYGScaffoldingBlock.getBlockDistance(level, blockpos) == 7 ? null : pContext;
        } else {
            Direction direction;
            if (pContext.isSecondaryUseActive()) {
                direction = pContext.isInside() ? pContext.getClickedFace().getOpposite() : pContext.getClickedFace();
            } else {
                direction = pContext.getClickedFace() == Direction.UP ? pContext.getHorizontalDirection() : Direction.UP;
            }

            int i = 0;
            BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable().move(direction);

            while(i < 7) {
                if (!level.isClientSide && !level.isInWorldBounds(blockpos$mutableblockpos)) {
                    Player player = pContext.getPlayer();
                    int j = level.getMaxBuildHeight();
                    if (player instanceof ServerPlayer && blockpos$mutableblockpos.getY() >= j) {
                        ((ServerPlayer)player).sendMessage((new TranslatableComponent("build.tooHigh", j - 1)).withStyle(ChatFormatting.RED), ChatType.GAME_INFO, Util.NIL_UUID);
                    }
                    break;
                }

                blockstate = level.getBlockState(blockpos$mutableblockpos);
                if (!blockstate.is(this.getBlock())) {
                    if (blockstate.canBeReplaced(pContext)) {
                        return BlockPlaceContext.at(pContext, blockpos$mutableblockpos, direction);
                    }
                    break;
                }

                blockpos$mutableblockpos.move(direction);
                if (direction.getAxis().isHorizontal()) {
                    ++i;
                }
            }

            return null;
        }
    }

    protected boolean mustSurvive() {
        return false;
    }
}