package corgiaoc.byg.entrypoint;

import net.minecraft.entity.Entity;
import net.minecraft.network.IPacket;

import java.nio.file.Path;

public interface EntryPoint {

    Path configDirectory();


    IPacket<?> getEntitySpawnPacket(Entity entity);
}
