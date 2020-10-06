package corgiaoc.byg.common.properties.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import corgiaoc.byg.client.gui.BYGWorkbenchContainer;

public class BYGCraftingTableBlock extends CraftingTableBlock {
    private static final ITextComponent GUI_TITLE = new TranslationTextComponent("container.crafting");

    public BYGCraftingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((id, inventory, entity) -> new BYGWorkbenchContainer(id, inventory, IWorldPosCallable.of(worldIn, pos), this), GUI_TITLE);
    }
}

