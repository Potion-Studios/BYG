package potionstudios.byg.mixin.access.client;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ClientLevel.class)
public interface ClientLevelAccess {


    @Invoker("addEntity")
    void byg_invokeAddEntity(int i, Entity entity);
}
