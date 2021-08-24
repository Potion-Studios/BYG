package corgiaoc.byg.common.properties.items;

import corgiaoc.byg.common.properties.items.itemtiers.BYGArmorTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class BYGArmorItem extends ArmorItem {
    public BYGArmorItem(BYGArmorTiers materialIn, EquipmentSlot slot, Properties builder) {
        super(materialIn, slot, builder);
    }
}
