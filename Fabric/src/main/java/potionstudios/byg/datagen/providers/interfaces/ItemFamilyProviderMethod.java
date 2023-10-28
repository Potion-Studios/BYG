package potionstudios.byg.datagen.providers.interfaces;

import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.item.Item;

public interface ItemFamilyProviderMethod {
    Item getItem();
    ItemModelGenerators getGenerator();
}