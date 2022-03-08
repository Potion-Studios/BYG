package potionstudios.byg.mixin.access;

import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Boat.class)
public interface BoatEntityAccess {

    @Accessor("lastYd")
    void byg_setLastYd(double lastYd);

    @Accessor("status")
    Boat.Status byg_getStatusField();
}
