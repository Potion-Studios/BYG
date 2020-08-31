package voronoiaoc.byg.common.properties.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;

public class BYGHorseArmor extends HorseArmorItem {
    private final int bonus;
    private final ResourceLocation texture;

    public BYGHorseArmor(int bonus, String armorMaterial, Item.Properties properties) {
        this(bonus, new ResourceLocation("byg:textures/entity/horse/armor/horse_armor_" + armorMaterial + ".png"), properties);
    }

    public BYGHorseArmor(int bonus, ResourceLocation texture, Item.Properties properties) {
        super(bonus, null, properties);
        this.bonus = bonus;
        this.texture = texture;
    }


    @Override
    public ResourceLocation getTexture() {
        return texture;
    }
}