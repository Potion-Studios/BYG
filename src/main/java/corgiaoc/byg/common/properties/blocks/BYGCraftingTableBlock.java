package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.client.gui.BYGWorkbenchContainer;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BYGCraftingTableBlock extends CraftingTableBlock {
    private static final Text GUI_TITLE = new TranslatableText("container.crafting");

    public BYGCraftingTableBlock(Settings properties) {
        super(properties);
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((id, inventory, entity) -> new BYGWorkbenchContainer(id, inventory, ScreenHandlerContext.create(worldIn, pos), this), GUI_TITLE);
    }
}

