package voronoiaoc.byg.common.properties.items.itemtiers;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class BYGTools {

    public static class AxeItemBYG extends AxeItem {
        public AxeItemBYG(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class PickaxeItemBYG extends PickaxeItem {
        public PickaxeItemBYG(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class HoeItemBYG extends HoeItem {
        public HoeItemBYG(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }
}
