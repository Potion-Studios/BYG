package potionstudios.byg.common.properties.items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import potionstudios.byg.common.properties.items.itemtiers.BYGArmorTiers;

public class BYGArmorItem extends ArmorItem {
    public BYGArmorItem(BYGArmorTiers materialIn, EquipmentSlot slot, Properties builder) {
        super(materialIn, slot, builder);
    }


}
