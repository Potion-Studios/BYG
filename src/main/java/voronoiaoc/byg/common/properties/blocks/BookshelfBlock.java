package voronoiaoc.byg.common.properties.blocks;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public class BookshelfBlock extends Block {
    public static Tag<Block> BOOKSHELF_TAG = TagRegistry.block(new ResourceLocation("c", "bookshelves"));

    protected BookshelfBlock(Properties builder) {
        super(builder);
    }
}
