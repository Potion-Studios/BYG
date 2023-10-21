package potionstudios.byg.datagen.providers.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.BYGTags;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.datagen.util.DatagenUtils;
import potionstudios.byg.datagen.util.PredicatedTagProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static net.minecraft.tags.ItemTags.create;
import static potionstudios.byg.BYG.createLocation;
import static potionstudios.byg.common.BYGTags.*;

public class BYGItemTagsProvider extends ItemTagsProvider {
    public BYGItemTagsProvider(DataGenerator p_126530_, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> future, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126530_.getPackOutput(), pLookupProvider, future, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            tag(type.logTag().item(), type.log(), type.strippedLog(), type.wood(), type.strippedWood());
        }

        final var saplingsTag = tag(SAPLINGS.byg(RegistryType.ITEMS));
        BYGItems.SAPLINGS.stream().map(RegistryObject::get).forEach(saplingsTag::add);

        BYGBlockTagsProvider.EXTRA_WOOD_TYPES.forEach(type -> copy(BlockTags.create(type), create(type)));

        copy(BYGTags.LOGS);
        copy(BYGTags.LOGS_THAT_BURN);
        copy(BOOKSHELVES);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.TRAPDOORS, ItemTags.TRAPDOORS);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BYGBlockTags.WOODEN_FENCE_GATES, create(BYGBlockTags.WOODEN_FENCE_GATES.location()));

        copy(STAIRS);
        copy(SLABS);
        copy(BUTTONS);
        copy(SAND);
        copy(SCAFFOLDING);
        copy(CAMPFIRES);
        copy(ICE);
        copy(ORES);

        copy(BYGBlockTags.MUSHROOMS, bygTag("mushrooms"));

        new PredicatedTagProvider<>(BYGItems.PROVIDER)
                .checkRegistryName(name -> name.endsWith("_leaves"), bygTag(LEAVES))
              .run(this::tag);

        tag(STICKS.byg(RegistryType.ITEMS)).add(Items.STICK);
        tag(SHEARS.byg(RegistryType.ITEMS)).add(Items.SHEARS);

        for (BYGTags tag : BYGTags.values()) {
            DatagenUtils.addBYGTag(this::tag, tag, Registries.ITEM);
        }

        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }

    private void copy(BYGTags tag) {
        copy(tag.byg(BYGTags.RegistryType.BLOCKS), tag.byg(BYGTags.RegistryType.ITEMS));
    }

    private static TagKey<Item> bygTag(String path) {
        return create(createLocation(path));
    }

    private static TagKey<Item> bygTag(BYGTags tags) {
        return tags.byg(RegistryType.ITEMS);
    }

    @SafeVarargs
    @SuppressWarnings("ALL")
    private void tag(TagKey<Item> tag, Supplier<? extends ItemLike>... items) {
        this.tag(tag).add(Arrays.stream(items).filter(Objects::nonNull).map(Supplier::get).map(ItemLike::asItem).toArray(Item[]::new));
    }
}
