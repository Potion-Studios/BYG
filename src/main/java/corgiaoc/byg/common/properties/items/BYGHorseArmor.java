package corgiaoc.byg.common.properties.items;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class BYGHorseArmor extends HorseArmorItem {
    private final int bonus;
    private final Identifier texture;

    public BYGHorseArmor(int bonus, String armorMaterial, Item.Settings properties) {
        this(bonus, new Identifier("byg:textures/entity/horse/armor/horse_armor_" + armorMaterial + ".png"), properties);
    }

    public BYGHorseArmor(int bonus, Identifier texture, Settings properties) {
        super(bonus, null, properties);
        this.bonus = bonus;
        this.texture = texture;
    }


    @Environment(EnvType.CLIENT)
    public Identifier getTexture() {
        return texture;
    }
}