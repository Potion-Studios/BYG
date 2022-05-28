package potionstudios.byg.datagen.providers.tag;

import static net.minecraft.tags.ItemTags.create;
import static potionstudios.byg.BYG.createLocation;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.datagen.util.DatagenUtils;
import potionstudios.byg.reg.RegistryObject;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;

public class BYGItemTagsProvider extends ItemTagsProvider {
    public BYGItemTagsProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126530_, p_126531_, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            tag(type.logTag().item(), type.log(), type.strippedLog(), type.wood(), type.strippedWood());
        }

        final var saplingsTag = tag(ItemTags.SAPLINGS);
        BYGItems.SAPLINGS.stream().map(RegistryObject::get).forEach(saplingsTag::add);

        copy(BlockTags.LOGS, ItemTags.LOGS);
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.create(createLocation("bookshelves")), create(createLocation("bookshelves")));
        copy(BlockTags.TRAPDOORS, ItemTags.TRAPDOORS);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);

        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.BUTTONS, ItemTags.BUTTONS);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.SAND, ItemTags.SAND);

        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }

    @SafeVarargs
    @SuppressWarnings("ALL")
    private void tag(TagKey<Item> tag, Supplier<? extends ItemLike>... items) {
        this.tag(tag).add(Arrays.stream(items).filter(Objects::nonNull).map(Supplier::get).map(ItemLike::asItem).toArray(Item[]::new));
    }

}
