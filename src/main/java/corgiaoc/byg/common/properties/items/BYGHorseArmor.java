package corgiaoc.byg.common.properties.items;

import corgiaoc.byg.BYG;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;

public class BYGHorseArmor extends HorseArmorItem {
    public BYGHorseArmor(int bonus, String armorMaterial, Properties properties) {
        super(bonus, armorMaterial, properties);
    }



    @Environment(EnvType.CLIENT)
    public ResourceLocation getTexture() {
        return new ResourceLocation(BYG.MOD_ID, super.getTexture().getPath());
    }
}