package potionstudios.byg.datagen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;

import java.util.Arrays;
import java.util.function.Supplier;

public class BYGItemTagsProvider extends ItemTagsProvider {
    public BYGItemTagsProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126530_, p_126531_, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            tag(type.logTag(), type.log(), type.strippedLog());
        }
    }

    @SafeVarargs
    @SuppressWarnings("ALL")
    private void tag(TagKey<Item> tag, Supplier<? extends ItemLike>... items) {
        this.tag(tag).add(Arrays.stream(items).map(Supplier::get).map(ItemLike::asItem).toArray(Item[]::new));
    }
}
