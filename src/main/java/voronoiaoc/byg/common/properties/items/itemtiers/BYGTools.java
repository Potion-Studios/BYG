package voronoiaoc.byg.common.properties.items.itemtiers;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class BYGTools {

    public static class AxeItemBYG extends AxeItem {
        public AxeItemBYG(Tier material, float attackDamage, float attackSpeed, Properties settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class PickaxeItemBYG extends PickaxeItem {
        public PickaxeItemBYG(Tier material, int attackDamage, float attackSpeed, Properties settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class HoeItemBYG extends HoeItem {
        public HoeItemBYG(Tier material, int attackDamage, float attackSpeed, Properties settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }
}
