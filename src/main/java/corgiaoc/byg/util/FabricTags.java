package corgiaoc.byg.util;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class FabricTags {

    public static final Tag<Block> NETHERRACK = blockTagRegister("netherrack");
    public static final Tag<Block> END_STONES = blockTagRegister("end_stones");
    public static final Tag<Block> SAND = blockTagRegister("sand");
    public static final Tag<Block> DIRT = blockTagRegister("dirt");
    public static Tag<Block> BOOKSHELF = TagRegistry.block(new Identifier("c", "bookshelves"));

    public static Tag<Block> blockTagRegister(String id) {
        return TagRegistry.block(new Identifier("c", id));
    }
}
