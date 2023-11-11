package potionstudios.byg.common.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HorseArmorItem;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;

public class BYGHorseArmor extends HorseArmorItem {
    public BYGHorseArmor(int bonus, String armorMaterial, Properties properties) {
        super(bonus, armorMaterial, properties);
    }
    
    public @NotNull ResourceLocation getTexture() {
        return BYG.createLocation(super.getTexture().getPath());
    }
}