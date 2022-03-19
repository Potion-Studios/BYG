package potionstudios.byg.client;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.util.ModLoaderContext;
import potionstudios.byg.util.codec.CodecUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Supplier;

public record BiomepediaClientData(Set<ResourceKey<Biome>> favoriteBiomes) {
    public static final BiomepediaClientData DEFAULT = new BiomepediaClientData(new ObjectOpenHashSet<>());
    public static BiomepediaClientData INSTANCE = null;

    private static final Supplier<Path> FILE_PATH = () ->
        ModLoaderContext.getInstance().configPath().getParent().resolve("client_data").resolve("byg").resolve("biomepedia.dat");


    private static final Codec<BiomepediaClientData> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            CodecUtil.BIOME_SET_CODEC.fieldOf("favorite_biomes").forGetter(biomepediaClientData -> biomepediaClientData.favoriteBiomes)
        ).apply(builder, BiomepediaClientData::new));


    public static BiomepediaClientData getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        return INSTANCE;
    }

    private void save() {
        create(FILE_PATH.get(), this);
    }

    private static BiomepediaClientData readConfig() {
        Path path = FILE_PATH.get();
        if (!path.toFile().exists()) {
            create(path, DEFAULT);
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return CODEC.decode(NbtOps.INSTANCE, NbtIo.read(path.toFile())).result().orElseThrow().getFirst();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void create(Path path, BiomepediaClientData data) {
        Tag tag = CODEC.encodeStart(NbtOps.INSTANCE, data).result().orElseThrow();

        try {
            Files.createDirectories(path.getParent());
            NbtIo.write((CompoundTag) tag, path.toFile());
        } catch (IOException e) {
            BYG.LOGGER.error(e.toString());
        }
    }
}
