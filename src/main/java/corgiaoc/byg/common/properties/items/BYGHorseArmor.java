package corgiaoc.byg.common.properties.items;

import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BYGHorseArmor extends HorseArmorItem {
    private final int bonus;
    private final ResourceLocation texture;

    public BYGHorseArmor(int bonus, String armorMaterial, Item.Properties properties) {
        this(bonus, new ResourceLocation("byg:textures/entity/horse/armor/horse_armor_" + armorMaterial + ".png"), properties);
    }

    public BYGHorseArmor(int bonus, ResourceLocation texture, Properties properties) {
        super(bonus, texture, properties);
        this.bonus = bonus;
        this.texture = texture;
    }


    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getTexture() {
        return texture;
    }

    public int getProtection() {
        return this.bonus;
    }
}