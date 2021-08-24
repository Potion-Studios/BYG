package corgiaoc.byg.common.properties.items.itemtiers;

import corgiaoc.byg.core.BYGItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum BYGArmorTiers implements ArmorMaterial {
    AMETRINE("ametrine", 39, new int[]{4, 7, 9, 4}, 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 3.2F, () -> {
        return Ingredient.of(BYGItems.AMETRINE_GEMS);
    }),
    PENDORITE("pendorite", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, () -> {
        return Ingredient.of(BYGItems.PENDORITE_SCRAPS);
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    BYGArmorTiers(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughnessIn, Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterialSupplier);
    }

    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}