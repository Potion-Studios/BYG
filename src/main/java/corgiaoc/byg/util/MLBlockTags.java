package corgiaoc.byg.util;

import corgiaoc.byg.mixin.access.BlockTagsAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public class MLBlockTags {

    public static final String MOD_LOADER_TAG_TARGET = "c";

    public static final Tag.Named<Block> NETHERRACK = createTag("netherrack");
    public static final Tag.Named<Block> DIRT = createTag("dirt");
    public static final Tag.Named<Block> END_STONES = createTag("end_stones");
    public static final Tag.Named<Block> ORES = createTag("ores");
    public static final Tag.Named<Block> BOOKSHELVES = createTag("bookshelves");

    public static Tag.Named<Block> createTag(String path) {
        return BlockTagsAccess.invokeBind(new ResourceLocation(MOD_LOADER_TAG_TARGET, path).toString());
    }
}
