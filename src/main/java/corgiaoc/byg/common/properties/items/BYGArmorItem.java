package corgiaoc.byg.common.properties.items;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.properties.items.itemtiers.BYGArmorTiers;
import edu.umd.cs.findbugs.annotations.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class BYGArmorItem extends ArmorItem {
    private final BYGArmorTiers material;

    public BYGArmorItem(BYGArmorTiers materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
        this.material = materialIn;

    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return BYG.MOD_ID + ":textures/models/armor/" + getBYGArmorMaterial().getName() + "_layer_" + (slot == EquipmentSlotType.LEGS ? 2 : 1) + ".png";
    }

    public BYGArmorTiers getBYGArmorMaterial() {
        return this.material;
    }
}
