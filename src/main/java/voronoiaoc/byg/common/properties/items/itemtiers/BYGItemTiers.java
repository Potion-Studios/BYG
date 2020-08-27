package voronoiaoc.byg.common.properties.items.itemtiers;

import voronoiaoc.byg.core.byglists.BYGItemList;

import java.util.function.Supplier;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum BYGItemTiers implements Tier {
    AMETRINE(4, 64, 16.0F, 0.8F, 25, () -> {
        return Ingredient.of(BYGItemList.AMETRINE_GEMS);
    }),
   PENDORITE(5, 2500, 9.5F, 4.0F, 15, () -> {
      return Ingredient.of(BYGItemList.PENDORITE_SCRAPS);
   });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    BYGItemTiers(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new LazyLoadedValue(repairIngredient);
    }

    public int getUses() {
        return this.itemDurability;
    }

    public float getSpeed() {
        return this.miningSpeed;
    }

    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    public int getLevel() {
        return this.miningLevel;
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
