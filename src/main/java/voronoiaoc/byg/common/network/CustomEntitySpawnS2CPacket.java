package voronoiaoc.byg.common.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.PacketContext;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.Vec3;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;

import java.util.UUID;

public class CustomEntitySpawnS2CPacket {
    public static ResourceLocation SPAWN_PACKET_ID = new ResourceLocation(BYG.MODID, "custom_spawn_packet");


    public static Packet<?> createSpawnPacket(Entity e) {
        if (e == null) {
            return null;
        }
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        buf.writeVarInt(e.getId());
        buf.writeUUID(e.getUUID());
        buf.writeVarInt(Registry.ENTITY_TYPE.getId(e.getType()));
        buf.writeDouble(e.getX());
        buf.writeDouble(e.getY());
        buf.writeDouble(e.getZ());
        buf.writeFloat(e.xRot);
        //buf.writeByte(MathHelper.floor(e.pitch * 256.0F / 360.0F));
        buf.writeFloat(e.yRot);
        //buf.writeByte(MathHelper.floor(e.yaw * 256.0F / 360.0F));
        Integer owner = 0;
        if (e instanceof Projectile) {
            Entity ownerEntity = ((Projectile) e).getOwner();
            owner = ownerEntity != null ? ownerEntity.getId() : 0;
        }
        if (e instanceof BYGBoatEntity) { // because the datatracker doesnt seem to be sending the data at the right time?
            owner = ((BYGBoatEntity) e).getBYGBoatType().ordinal();
        }
        buf.writeInt(owner);
        Vec3 velocity = e.getDeltaMovement();
        buf.writeDouble(velocity.x);
        buf.writeDouble(velocity.y);
        buf.writeDouble(velocity.z);
        //buf.writeShort((int)(MathHelper.clamp(velocity.x, -3.9D, 3.9D) * 8000.0D));
        //buf.writeShort((int)(MathHelper.clamp(velocity.y, -3.9D, 3.9D) * 8000.0D));
        //buf.writeShort((int)(MathHelper.clamp(velocity.z, -3.9D, 3.9D) * 8000.0D));
        return ServerSidePacketRegistry.INSTANCE.toPacket(SPAWN_PACKET_ID, buf);
    }

    @Environment(EnvType.CLIENT)
    public static void receiveSpawnPacket(PacketContext context, FriendlyByteBuf buf) {
        Minecraft client = Minecraft.getInstance();
        if (client == null || client.level == null)
            return;

        int id = buf.readVarInt();
        UUID uuid = buf.readUUID();
        EntityType entityTypeId = Registry.ENTITY_TYPE.byId(buf.readVarInt());
        double x = buf.readDouble();
        double y = buf.readDouble();
        double z = buf.readDouble();
        float pitch = buf.readFloat();
        float yaw = buf.readFloat();
        int entityData = buf.readInt();
        double velocityX = buf.readDouble();
        double velocityY = buf.readDouble();
        double velocityZ = buf.readDouble();

        Entity entity = entityTypeId.create(client.level);

        if (entity == null) {
            return;
        }

        if (entity instanceof Projectile) {
            ((Projectile) entity).setOwner(client.level.getEntity(entityData));
        } else if (entity instanceof BYGBoatEntity) {
            ((BYGBoatEntity) entity).setBYGBoatType(BYGBoatEntity.BYGType.byId(entityData));
        }
        entity.setId(id);
        entity.setUUID(uuid);
        entity.setPos(x, y, z);
        entity.setPacketCoordinates(x, y, z);
        entity.xRot = pitch;
        entity.yRot = yaw;
        entity.setDeltaMovement(velocityX, velocityY, velocityZ);

        context.getTaskQueue().execute(() -> {
            client.execute(() -> {

                client.level.putNonPlayerEntity(id, entity);

            });
        });
    }
}
