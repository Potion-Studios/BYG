package corgiaoc.byg.common.properties.items.itemtiers;

import corgiaoc.byg.core.BYGItems;
import java.util.function.Supplier;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum BYGItemTiers implements ToolMaterial {
    AMETRINE(4, 64, 16.0F, 0.8F, 25, () -> {
        return Ingredient.ofItems(BYGItems.AMETRINE_GEMS);
    }),
    PENDORITE(5, 2500, 9.5F, 4.0F, 15, () -> {
        return Ingredient.ofItems(BYGItems.PENDORITE_SCRAPS);
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairMaterial;

    BYGItemTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new Lazy<>(repairMaterialIn);
    }

    public int getDurability() {
        return this.maxUses;
    }

    public float getMiningSpeedMultiplier() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}