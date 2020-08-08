package voronoiaoc.byg.common.properties.items.itemtiers;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import voronoiaoc.byg.core.byglists.BYGItemList;

import java.util.function.Supplier;

public enum BYGItemTiers implements ToolMaterial {
    AMETRINE(4, 64, 16.0F, 0.8F, 25, () -> {
        return Ingredient.ofItems(BYGItemList.AMETRINE_GEMS);
    }),
    PENDORITE(5, 2551, 6.0F, 5.0F, 14, () -> {
        return Ingredient.ofItems(BYGItemList.PENDORITE_SCRAPS);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    BYGItemTiers(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
