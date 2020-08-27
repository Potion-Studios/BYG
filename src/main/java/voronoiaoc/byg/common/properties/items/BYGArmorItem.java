package voronoiaoc.byg.common.properties.items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import voronoiaoc.byg.common.properties.items.itemtiers.BYGArmorTiers;

public class BYGArmorItem extends ArmorItem {
    private final BYGArmorTiers material;

    public BYGArmorItem(BYGArmorTiers materialIn, EquipmentSlot slot, Item.Properties builder) {
        super(materialIn, slot, builder);
        this.material = materialIn;

    }

    public BYGArmorTiers getBYGArmorMaterial() {
        return this.material;
    }
}
