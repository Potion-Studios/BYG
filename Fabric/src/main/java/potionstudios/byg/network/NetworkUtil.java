package potionstudios.byg.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.Vec3;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockFamilies;
import potionstudios.byg.common.entity.boat.BYGBoat;
import potionstudios.byg.mixin.access.client.ClientLevelAccess;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class NetworkUtil {
    public static ResourceLocation SPAWN_PACKET_ID = BYG.createLocation("custom_spawn_packet");

    public static Packet<?> getEntitySpawnPacket(Entity e) {
        if (e == null) {
            return null;
        }
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        buf.writeVarInt(e.getId());
        buf.writeUUID(e.getUUID());
        buf.writeVarInt(BuiltInRegistries.ENTITY_TYPE.getId(e.getType()));
        buf.writeDouble(e.getX());
        buf.writeDouble(e.getY());
        buf.writeDouble(e.getZ());
        buf.writeFloat(e.getXRot());
        //buf.writeByte(MathHelper.floor(e.pitch * 256.0F / 360.0F));
        buf.writeFloat(e.getYRot());
        //buf.writeByte(MathHelper.floor(e.yaw * 256.0F / 360.0F));
        if (e instanceof Projectile) {
            Entity ownerEntity = ((Projectile) e).getOwner();
            int owner = ownerEntity != null ? ownerEntity.getId() : 0;
            buf.writeInt(owner);
        }
        if (e instanceof BYGBoat) { // because the datatracker doesn't seem to be sending the data at the right time?
            String owner = ((BYGBoat) e).getBYGBoatType().getBaseName();
            byte[] byteArray = owner.getBytes(StandardCharsets.UTF_8);
            buf.writeInt(byteArray.length);
            buf.writeByteArray(byteArray);
        }

        Vec3 velocity = e.getDeltaMovement();
        buf.writeDouble(velocity.x);
        buf.writeDouble(velocity.y);
        buf.writeDouble(velocity.z);
        return ServerPlayNetworking.createS2CPacket(SPAWN_PACKET_ID, buf);
    }

    
    public static void receiveSpawnPacket(Minecraft client, FriendlyByteBuf buf) {
        if (client == null || client.level == null)
            return;

        int id = buf.readVarInt();
        UUID uuid = buf.readUUID();
        EntityType<?> entityTypeId = BuiltInRegistries.ENTITY_TYPE.byId(buf.readVarInt());
        double x = buf.readDouble();
        double y = buf.readDouble();
        double z = buf.readDouble();
        float pitch = buf.readFloat();
        float yaw = buf.readFloat();
        int entityData = buf.readInt();

        Entity entity = entityTypeId.create(client.level);

        if (entity == null) {
            return;
        }

        if (entity instanceof Projectile) {
            ((Projectile) entity).setOwner(client.level.getEntity(entityData));
        } else if (entity instanceof BYGBoat) {
            ((BYGBoat) entity).setBYGBoatType(BYGBlockFamilies.woodFamilyMap
                    .get(new String(buf.readByteArray(entityData), StandardCharsets.UTF_8)));
        }

        double velocityX = buf.readDouble();
        double velocityY = buf.readDouble();
        double velocityZ = buf.readDouble();

        entity.setId(id);
        entity.setUUID(uuid);
        entity.absMoveTo(x, y, z);
        entity.setPos(x, y, z);
        entity.setXRot(pitch);
        entity.setYRot(yaw);
        entity.setDeltaMovement(velocityX, velocityY, velocityZ);
        client.execute(() -> ((ClientLevelAccess) client.level).byg_invokeAddEntity(id, entity));
    }
}
