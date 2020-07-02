package voronoiaoc.byg.common.properties.blocks.plants;

import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import voronoiaoc.byg.client.gui.BYGCraftingTableScreen;

public class BYGCraftingTableBlock extends CraftingTableBlock {
    private static final Text TITLE = new TranslatableText("container.crafting");

    public BYGCraftingTableBlock(Settings properties) {
        super(properties);
    }

    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> new BYGCraftingTableScreen(i, playerInventory, ScreenHandlerContext.create(world, pos), this), TITLE);
    }
}

