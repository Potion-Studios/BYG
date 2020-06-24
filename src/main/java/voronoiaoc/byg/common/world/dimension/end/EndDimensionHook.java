package voronoiaoc.byg.common.world.dimension.end;

import net.minecraft.block.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.provider.BiomeProviderType;
import net.minecraft.world.biome.provider.EndBiomeProviderSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.EndDimension;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraft.world.gen.EndGenerationSettings;
import voronoiaoc.byg.common.world.dimension.end.biome.BYGEndBiomeProvider;
import voronoiaoc.byg.common.world.dimension.end.chunk.EndChunkGeneratorImproved;
import voronoiaoc.byg.common.world.dimension.end.chunk.MaxHeightEndChunkGenerator;

import java.util.Objects;

public class EndDimensionHook extends EndDimension {
    public static BiomeProviderType<EndBiomeProviderSettings, BYGEndBiomeProvider> BYG_END = new BiomeProviderType<>(BYGEndBiomeProvider::new, EndBiomeProviderSettings::new);

    public static final ChunkGeneratorType<EndGenerationSettings, EndChunkGeneratorImproved> BYGENDCHUNKGEN = new ChunkGeneratorType<>(EndChunkGeneratorImproved::new, true, EndGenerationSettings::new);
    public static final ChunkGeneratorType<EndGenerationSettings, MaxHeightEndChunkGenerator> MAXHEIGHTEND = new ChunkGeneratorType<>(MaxHeightEndChunkGenerator::new, true, EndGenerationSettings::new);

    public EndDimensionHook(World worldIn, DimensionType typeIn) {
        super(worldIn, typeIn);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        EndGenerationSettings endgenerationsettings = BYGENDCHUNKGEN.createSettings();
        endgenerationsettings.setDefaultBlock(Blocks.END_STONE.getDefaultState());
        endgenerationsettings.setDefaultFluid(Blocks.AIR.getDefaultState());
        endgenerationsettings.setSpawnPos(Objects.requireNonNull(this.getSpawnCoordinate()));
        return ChunkGeneratorType.FLOATING_ISLANDS.create(this.world, BYG_END.create(BYG_END.createSettings(this.world.getWorldInfo())), endgenerationsettings);

    }

}
