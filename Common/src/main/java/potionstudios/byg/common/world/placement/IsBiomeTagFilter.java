package potionstudios.byg.common.world.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.Random;
import java.util.stream.Stream;

public class IsBiomeTagFilter extends PlacementModifier {

    public static final Codec<IsBiomeTagFilter> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            TagKey.codec(Registry.BIOME_REGISTRY).fieldOf("valid_biome").forGetter(isBiomeTagFilter -> isBiomeTagFilter.biomeTag)
        ).apply(builder, IsBiomeTagFilter::new));

    private final TagKey<Biome> biomeTag;

    public IsBiomeTagFilter(TagKey<Biome> biomeTag) {
        this.biomeTag = biomeTag;
    }

    @Override
    public Stream<BlockPos> getPositions(PlacementContext placementContext, Random random, BlockPos blockPos) {
        return placementContext.getLevel().getBiome(blockPos).is(this.biomeTag) ? Stream.of(blockPos) : Stream.of();
    }

    @Override
    public PlacementModifierType<?> type() {
        return BYGPlacementModifierType.IS_BIOME_TAG_FILTER;
    }
}