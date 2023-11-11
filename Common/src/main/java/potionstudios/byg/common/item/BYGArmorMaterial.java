package potionstudios.byg.common.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BYGArmorMaterial implements ArmorMaterial {
    public static final BYGArmorMaterial AMETRINE = new BYGArmorMaterial("ametrine", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, () -> Ingredient.of(BYGItems.AMETRINE_GEMS.get()));
    public static final BYGArmorMaterial PENDORITE = new BYGArmorMaterial("pendorite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, () -> Ingredient.of(BYGItems.PENDORITE_SCRAPS.get()));

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    public BYGArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float toughnessIn, Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterialSupplier);
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.ordinal()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type slotIn) {
        return this.damageReductionAmountArray[slotIn.ordinal()];
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public @NotNull SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    public @NotNull String getName() {
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