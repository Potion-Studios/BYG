package voronoiaoc.byg.common.properties.items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import voronoiaoc.byg.common.properties.items.itemtiers.BYGArmorTiers;

public class BYGArmorItem extends ArmorItem {
    private final BYGArmorTiers material;

    public BYGArmorItem(BYGArmorTiers materialIn, EquipmentSlot slot, Item.Settings builder) {
        super(materialIn, slot, builder);
        this.material = materialIn;

    }

    public BYGArmorTiers getBYGArmorMaterial() {
        return this.material;
    }
}
