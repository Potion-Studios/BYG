package potionstudios.byg.common.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;
import potionstudios.byg.BYG;

public class BYGHorseArmor extends HorseArmorItem {
    public BYGHorseArmor(int bonus, String armorMaterial, Properties properties) {
        super(bonus, armorMaterial, properties);
    }
    
    public ResourceLocation getTexture() {
        return new ResourceLocation(BYG.MOD_ID, super.getTexture().getPath());
    }
}