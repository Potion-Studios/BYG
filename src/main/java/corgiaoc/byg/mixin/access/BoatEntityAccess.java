package corgiaoc.byg.mixin.access;

import net.minecraft.entity.item.BoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BoatEntity.class)
public interface BoatEntityAccess {

    @Accessor
    double getLastYd();

    @Accessor
    void setLastYd(double lastYd);

    @Accessor("status")
    BoatEntity.Status getStatusField();
}
