package potionstudios.byg.common.world.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Optional;

public class AncientSequoiaTreeStructure extends Structure {


    public static final Codec<AncientSequoiaTreeStructure> CODEC = RecordCodecBuilder.<AncientSequoiaTreeStructure>mapCodec(builder ->
            builder.group(
                    settingsCodec(builder),
                    Config.CODEC.fieldOf("config").forGetter(ancientSequoiaTreeStructure -> ancientSequoiaTreeStructure.config)
            ).apply(builder, AncientSequoiaTreeStructure::new)
    ).codec();
    private final Config config;

    protected AncientSequoiaTreeStructure(StructureSettings structureSettings, Config config) {
        super(structureSettings);
        this.config = config;
    }

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, GenerationContext context, Config config) {
        Optional<StructureTemplate> structureTemplateOptional = context.structureTemplateManager().get(config.location);

        if (structureTemplateOptional.isEmpty()) {
            throw new IllegalArgumentException("Invalid structure template id \"%s\"".formatted(config.location));
        }

        WorldgenRandom random = context.random();

        ChunkPos chunkPos = context.chunkPos();
        int blockX = chunkPos.getBlockX(random.nextInt(16));
        int blockZ = chunkPos.getBlockZ(random.nextInt(16));
        int blockY = context.chunkGenerator().getFirstFreeHeight(blockX, blockZ, Heightmap.Types.OCEAN_FLOOR_WG, context.heightAccessor(), context.randomState()) + 1;

        piecesBuilder.addPiece(new AncientTreePiece(structureTemplateOptional.get(), config.location, new BlockPos(blockX, blockY, blockZ), getWritableArea(chunkPos, context.heightAccessor())));
    }

    public static BoundingBox getWritableArea(ChunkPos chunkPos, LevelHeightAccessor accessor) {
        int i = chunkPos.getMinBlockX();
        int j = chunkPos.getMinBlockZ();
        int k = accessor.getMinBuildHeight() + 1;
        int l = accessor.getMaxBuildHeight() - 1;
        return new BoundingBox(i, k, j, i + 15, l, j + 15);
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext generationContext) {
        return onTopOfChunkCenter(generationContext, Heightmap.Types.WORLD_SURFACE_WG, (piecesBuilder) -> {
            generatePieces(piecesBuilder, generationContext, this.config);
        });
    }

    @Override
    public StructureType<?> type() {
        return BYGStructureTypes.ANCIENT_SEQUOIA_TREE.get();
    }

    public record Config(ResourceLocation location, boolean stripsAir) {

        public static final Codec<Config> CODEC = RecordCodecBuilder.create(builder ->
                builder.group(
                        ResourceLocation.CODEC.fieldOf("location").forGetter(config -> config.location),
                        Codec.BOOL.fieldOf("no_air").forGetter(config -> config.stripsAir)
                ).apply(builder, Config::new)
        );
    }
}
