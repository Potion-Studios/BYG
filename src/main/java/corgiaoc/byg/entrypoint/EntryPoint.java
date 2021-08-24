package corgiaoc.byg.entrypoint;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;

import java.nio.file.Path;

public interface EntryPoint {

    Path configDirectory();


    Packet<?> getEntitySpawnPacket(Entity entity);
}
