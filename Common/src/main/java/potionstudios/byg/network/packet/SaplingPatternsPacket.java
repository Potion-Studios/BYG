package potionstudios.byg.network.packet;

import net.minecraft.nbt.NbtOps;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import potionstudios.byg.common.block.sapling.GrowingPatterns;

public record SaplingPatternsPacket(GrowingPatterns patterns) implements BYGS2CPacket {

    public static SaplingPatternsPacket read(FriendlyByteBuf buf) {
        try {
            return new SaplingPatternsPacket(buf.readWithCodec(NbtOps.INSTANCE, GrowingPatterns.CODEC));
        } catch (Exception e) {
            throw new IllegalStateException("Saplings Patterns packet could not be read. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        try {
            buf.writeWithCodec(NbtOps.INSTANCE, GrowingPatterns.CODEC, this.patterns);
        } catch (Exception e) {
            throw new IllegalStateException("Saplings Patterns packet could not be written. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void handle(Level level) {
        GrowingPatterns.setInstance(this.patterns);
    }
}
