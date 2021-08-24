package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.client.gui.BYGWorkbenchContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BYGCraftingTableBlock extends CraftingTableBlock {
    private static final Component GUI_TITLE = new TranslatableComponent("container.crafting");

    public BYGCraftingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        return new SimpleMenuProvider((id, inventory, entity) -> new BYGWorkbenchContainer(id, inventory, ContainerLevelAccess.create(worldIn, pos), this), GUI_TITLE);
    }
}

