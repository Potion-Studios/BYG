package corgiaoc.byg.common.properties.blocks;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BookshelfBlock extends Block {

    public static Tag<Block> BOOKSHELF_TAG = TagRegistry.block(new Identifier("c", "bookshelves"));

    public BookshelfBlock(Settings builder) {
        super(builder);

    }
}
