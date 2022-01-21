package potionstudios.byg.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.BlockTagsAccess;

public class MLBlockTags {

    public static final Tag.Named<Block> NETHERRACK = createTag("netherrack");
    public static final Tag.Named<Block> END_STONES = createTag("end_stones");
    public static final Tag.Named<Block> ORES = createTag("ores");
    public static final Tag.Named<Block> BOOKSHELVES = createTag("bookshelves");

    public static Tag.Named<Block> createTag(String path) {
        return BlockTagsAccess.invokeBind(new ResourceLocation(BYG.MOD_LOADER_TAG_TARGET, path).toString());
    }

    public static void bootStrap() {

    }
}
