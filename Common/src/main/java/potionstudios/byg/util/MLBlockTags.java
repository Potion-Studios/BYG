package potionstudios.byg.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;

public class MLBlockTags {

    public static final TagKey<Block> NETHERRACK = createTag("netherrack");
    public static final TagKey<Block> END_STONES = createTag("end_stones");
    public static final TagKey<Block> ORES = createTag("ores");
    public static final TagKey<Block> BOOKSHELVES = createTag("bookshelves");
    public static final TagKey<Block> SANDSTONE = createTag("sandstone");

    public static TagKey<Block> createTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BYG.MOD_LOADER_TAG_TARGET, path));
    }

    public static void bootStrap() {

    }
}
