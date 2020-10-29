package corgiaoc.byg.common.network;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.entity.boat.BYGBoatEntity;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.PacketContext;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

public class CustomEntitySpawnS2CPacket {
    public static Identifier SPAWN_PACKET_ID = new Identifier(BYG.MOD_ID, "custom_spawn_packet");


    public static Packet<?> createSpawnPacket(Entity e) {
        if (e == null) {
            return null;
        }
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeVarInt(e.getEntityId());
        buf.writeUuid(e.getUuid());
        buf.writeVarInt(Registry.ENTITY_TYPE.getRawId(e.getType()));
        buf.writeDouble(e.getX());
        buf.writeDouble(e.getY());
        buf.writeDouble(e.getZ());
        buf.writeFloat(e.pitch);
        //buf.writeByte(MathHelper.floor(e.pitch * 256.0F / 360.0F));
        buf.writeFloat(e.yaw);
        //buf.writeByte(MathHelper.floor(e.yaw * 256.0F / 360.0F));
        Integer owner = 0;
        if (e instanceof ProjectileEntity) {
            Entity ownerEntity = ((ProjectileEntity) e).getOwner();
            owner = ownerEntity != null ? ownerEntity.getEntityId() : 0;
        }
        if (e instanceof BYGBoatEntity) { // because the datatracker doesnt seem to be sending the data at the right time?
            owner = ((BYGBoatEntity) e).getBYGBoatType().ordinal();
        }
        buf.writeInt(owner);
        Vec3d velocity = e.getVelocity();
        buf.writeDouble(velocity.x);
        buf.writeDouble(velocity.y);
        buf.writeDouble(velocity.z);
        //buf.writeShort((int)(MathHelper.clamp(velocity.x, -3.9D, 3.9D) * 8000.0D));
        //buf.writeShort((int)(MathHelper.clamp(velocity.y, -3.9D, 3.9D) * 8000.0D));
        //buf.writeShort((int)(MathHelper.clamp(velocity.z, -3.9D, 3.9D) * 8000.0D));
        return ServerSidePacketRegistry.INSTANCE.toPacket(SPAWN_PACKET_ID, buf);
    }

    @Environment(EnvType.CLIENT)
    public static void receiveSpawnPacket(PacketContext context, PacketByteBuf buf) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.world == null)
            return;

        int id = buf.readVarInt();
        UUID uuid = buf.readUuid();
        EntityType entityTypeId = Registry.ENTITY_TYPE.get(buf.readVarInt());
        double x = buf.readDouble();
        double y = buf.readDouble();
        double z = buf.readDouble();
        float pitch = buf.readFloat();
        float yaw = buf.readFloat();
        int entityData = buf.readInt();
        double velocityX = buf.readDouble();
        double velocityY = buf.readDouble();
        double velocityZ = buf.readDouble();

        Entity entity = entityTypeId.create(client.world);

        if (entity == null) {
            return;
        }

        if (entity instanceof ProjectileEntity) {
            ((ProjectileEntity) entity).setOwner(client.world.getEntityById(entityData));
        } else if (entity instanceof BYGBoatEntity) {
            ((BYGBoatEntity) entity).setBYGBoatType(BYGBoatEntity.BYGType.byId(entityData));
        }
        entity.setEntityId(id);
        entity.setUuid(uuid);
        entity.updatePosition(x, y, z);
        entity.updateTrackedPosition(x, y, z);
        entity.pitch = pitch;
        entity.yaw = yaw;
        entity.setVelocity(velocityX, velocityY, velocityZ);

        context.getTaskQueue().execute(() -> {
            client.execute(() -> {

                client.world.addEntity(id, entity);

            });
        });
    }
}