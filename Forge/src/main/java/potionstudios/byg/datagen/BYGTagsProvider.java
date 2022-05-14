package potionstudios.byg.datagen;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.registration.RegistryObject;

import java.util.Arrays;
import java.util.function.Supplier;

import static potionstudios.byg.common.block.BYGBlocks.*;

class BYGTagsProvider {

    @MethodsReturnNonnullByDefault
    static final class Blocks extends TagsProvider<Block> {

        Blocks(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
            super(pGenerator, Registry.BLOCK, BYG.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags() {
            tag(
                BYGBlockTags.LUSH,
                LUSH_GRASS_PATH, LUSH_GRASS_BLOCK, LUSH_FARMLAND
            );

            final var slabsTag = super.tag(BYGBlockTags.SLABS);
            PROVIDER.getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(SlabBlock.class::isInstance)
                .forEach(slabsTag::add);
        }

        @SafeVarargs
        @SuppressWarnings("ALL")
        private void tag(TagKey<Block> tag, Supplier<? extends Block>... blocks) {
            this.tag(tag).add(Arrays.stream(blocks).map(Supplier::get).toArray(Block[]::new));
        }

        @Override
        public String getName() {
            return "bygblocks";
        }
    }

}
