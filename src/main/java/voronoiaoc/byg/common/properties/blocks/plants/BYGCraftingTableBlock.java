package voronoiaoc.byg.common.properties.blocks.plants;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import voronoiaoc.byg.client.gui.BYGCraftingTableScreen;

public class BYGCraftingTableBlock extends CraftingTableBlock {
    private static final Component TITLE = new TranslatableComponent("container.crafting");

    public BYGCraftingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos) {
        return new SimpleMenuProvider((i, playerInventory, playerEntity) -> new BYGCraftingTableScreen(i, playerInventory, ContainerLevelAccess.create(world, pos), this), TITLE);
    }
}

