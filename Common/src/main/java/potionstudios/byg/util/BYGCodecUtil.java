package potionstudios.byg.util;

import com.mojang.serialization.Codec;
import corgitaco.corgilib.serialization.codec.CodecUtil;
import corgitaco.corgilib.serialization.codec.CollectionCodec;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.biome.Biome;

import java.util.Set;

public class BYGCodecUtil {

    public static final Codec<VillagerProfession> VILLAGER_PROFESSION_CODEC = CodecUtil.createLoggedExceptionRegistryCodec(BuiltInRegistries.VILLAGER_PROFESSION);
    public static final CollectionCodec<ResourceKey<Biome>, Set<ResourceKey<Biome>>> BIOME_SET_CODEC = new CollectionCodec<>(CodecUtil.BIOME_CODEC, ObjectOpenHashSet::new);

}
