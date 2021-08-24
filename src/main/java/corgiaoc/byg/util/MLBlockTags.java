package corgiaoc.byg.util;

import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class MLBlockTags {

    public static final String MOD_LOADER_TAG_TARGET = "forge";

    public static final ITag.INamedTag<Block> NETHERRACK = createTag("netherrack");
    public static final ITag.INamedTag<Block> DIRT = createTag("dirt");
    public static final ITag.INamedTag<Block> END_STONES = createTag("end_stones");
    public static final ITag.INamedTag<Block> ORES = createTag("ores");


    public static ITag.INamedTag<Block> createTag(String path) {
        return BlockTags.bind(new ResourceLocation(MOD_LOADER_TAG_TARGET, path).toString());
    }
}
