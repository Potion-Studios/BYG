package potionstudios.byg.datagen.providers.tag;

import static net.minecraft.tags.ItemTags.create;
import static potionstudios.byg.BYG.createLocation;
import static potionstudios.byg.common.block.BYGBlocks.*;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.datagen.util.DatagenUtils;
import potionstudios.byg.datagen.util.PredicatedTagProvider;
import potionstudios.byg.mixin.access.TagBuilderAccess;
import potionstudios.byg.mixin.dev.BlockBehaviorAccess;
import potionstudios.byg.reg.RegistryObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BYGItemTagsProvider extends ItemTagsProvider {
    private final TagAppender<Item> logsThatBurn = tag(ItemTags.LOGS_THAT_BURN);
    private final TagAppender<Item> logs = tag(ItemTags.LOGS);

    public BYGItemTagsProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126530_, p_126531_, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        final var planksTag = tag(ItemTags.PLANKS);
        final var bookshelvesTag = tag(create(createLocation("bookshelves")));
        final var trapdoorsTag = tag(ItemTags.TRAPDOORS);
        final var woodenButtonsTag = tag(ItemTags.WOODEN_BUTTONS);
        final var woodenDoorsTag = tag(ItemTags.WOODEN_DOORS);
        final var woodenFencesTag = tag(ItemTags.WOODEN_FENCES);
        final var woodenPressurePlatesTag = tag(ItemTags.WOODEN_PRESSURE_PLATES);
        final var woodenSlabsTag = tag(ItemTags.WOODEN_SLABS);
        final var woodenStairsTag = tag(ItemTags.WOODEN_STAIRS);
        final var woodenTrapdoorsTag = tag(ItemTags.WOODEN_TRAPDOORS);
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            tag(type.logTag().item(), type.log(), type.strippedLog(), type.wood(), type.strippedWood());
            logs.addTag(type.logTag().item());
            logsThatBurn.addTag(type.logTag().item());
            bookshelvesTag.add(type.bookshelf().get().asItem());

            planksTag.add(type.planks().get().asItem());
            trapdoorsTag.add(type.trapdoor().get().asItem());
            woodenButtonsTag.add(type.button().get().asItem());
            woodenDoorsTag.add(type.door().get().asItem());
            woodenFencesTag.add(type.fence().get().asItem());
            woodenPressurePlatesTag.add(type.pressurePlate().get().asItem());
            woodenSlabsTag.add(type.slab().get().asItem());
            woodenStairsTag.add(type.stairs().get().asItem());
            woodenTrapdoorsTag.add(type.trapdoor().get().asItem());
        }

        new PredicatedTagProvider<>(BYGItems.PROVIDER)
            .add(checkBlockItem(StairBlock.class), ItemTags.STAIRS)
            .add(checkBlockItem(SlabBlock.class), ItemTags.SLABS)
            .add(checkBlockItem(ButtonBlock.class), ItemTags.BUTTONS)
            .add(isMaterial(Material.LEAVES), ItemTags.LEAVES)
            .add(isMaterial(Material.SAND), ItemTags.SAND)
            .run(super::tag);

        final var saplingsTag = tag(ItemTags.SAPLINGS);
        BYGItems.SAPLINGS.stream().map(RegistryObject::get).forEach(saplingsTag::add);

        wood("withering_oak_logs", WITHERING_OAK_LOG, WITHERING_OAK_WOOD);
        wood("palo_verde_logs", PALO_VERDE_LOG, PALO_VERDE_WOOD, STRIPPED_PALO_VERDE_LOG, STRIPPED_PALO_VERDE_WOOD);

        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }

    @SafeVarargs
    private void wood(String name, Supplier<? extends ItemLike>... items) {
        final var tag = create(createLocation("wood/" + name));
        tag(tag, items);
        logsThatBurn.addTag(tag);
        logs.addTag(tag);
    }

    private static Predicate<Item> isMaterial(Material... materials) {
        final var materialsList = List.of(materials);
        return it -> it instanceof BlockItem bi && materialsList.contains(((BlockBehaviorAccess) bi.getBlock()).getMaterial());
    }

    private static Predicate<Item> checkBlockItem(Class<?> blockClazz) {
        return item -> item instanceof BlockItem bi && blockClazz.isInstance(bi.getBlock());
    }

    @SafeVarargs
    @SuppressWarnings("ALL")
    private void tag(TagKey<Item> tag, Supplier<? extends ItemLike>... items) {
        this.tag(tag).add(Arrays.stream(items).filter(Objects::nonNull).map(Supplier::get).map(ItemLike::asItem).toArray(Item[]::new));
    }

}
