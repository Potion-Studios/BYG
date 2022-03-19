package potionstudios.byg.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import potionstudios.byg.common.block.sapling.SaplingPatterns;

public record SaplingPatternsPacket(SaplingPatterns patterns) implements BYGS2CPacket {

    public static SaplingPatternsPacket read(FriendlyByteBuf buf) {
        try {
            return new SaplingPatternsPacket(buf.readWithCodec(SaplingPatterns.CODEC));
        } catch (Exception e) {
            throw new IllegalStateException("Saplings Patterns packet could not be read. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        try {
            buf.writeWithCodec(SaplingPatterns.CODEC, this.patterns);
        } catch (Exception e) {
            throw new IllegalStateException("Saplings Patterns packet could not be written. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void handle(Level level) {
        SaplingPatterns.setInstance(this.patterns);
    }
}
