package potionstudios.byg.common.world.structure;

import corgitaco.corgilib.world.level.feature.gen.TreeFromStructureNBTFeature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.mixin.access.StructureTemplateAccess;

import java.util.HashSet;
import java.util.List;

public class AncientTreePiece extends StructurePiece {
    private final StructureTemplate structureTemplate;
    private final ResourceLocation structureId;
    private final BlockPos placePos;

    protected AncientTreePiece(StructureTemplate template, ResourceLocation structureId, BlockPos placePos, BoundingBox bb) {
        super(BYGStructurePieceTypes.ANCIENT_TREE_PIECE.get(), 0, bb);
        this.structureTemplate = template;
        this.structureId = structureId;
        this.placePos = placePos;
    }

    public AncientTreePiece(StructurePieceSerializationContext context, CompoundTag tag) {
        super(BYGStructurePieceTypes.ANCIENT_TREE_PIECE.get(), tag);
        this.placePos = NbtUtils.readBlockPos(tag.getCompound("place_pos"));

        this.structureId = new ResourceLocation(tag.getString("structure_id"));

        this.structureTemplate = context.structureTemplateManager().get(this.structureId).orElseThrow();
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
        compoundTag.put("place_pos", NbtUtils.writeBlockPos(this.placePos));
        compoundTag.putString("structure_id", this.structureId.toString());
    }

    @Override
    public void postProcess(WorldGenLevel worldGenLevel, StructureManager structureManager, ChunkGenerator chunkGenerator, RandomSource randomSource, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
        StructurePlaceSettings placeSettings = new StructurePlaceSettings().setRotation(Rotation.getRandom(randomSource));
        List<StructureTemplate.Palette> basePalettes = ((StructureTemplateAccess) this.structureTemplate).byg_getPalettes();

        Vec3i size = structureTemplate.getSize();

        BlockPos localOffset = new BlockPos(-size.getX() / 2, 0, -size.getZ() / 2);
        BlockPos offsettedPlacePos = this.placePos.offset(localOffset);
        structureTemplate.getBoundingBox(placeSettings, offsettedPlacePos);

        StructureTemplate.Palette randomPalette = placeSettings.getRandomPalette(basePalettes, offsettedPlacePos);
        TreeFromStructureNBTFeature.fillLogsUnder(randomSource, SimpleStateProvider.simple(BYGWoodTypes.REDWOOD.log().defaultBlockState()), worldGenLevel, this.placePos, placeSettings, localOffset, randomPalette.blocks(Blocks.RED_WOOL), 200, BlockPredicate.matchesTag(BlockTags.DIRT));

        HashSet<BlockPos> trunkPositions = new HashSet<>();

        TreeFromStructureNBTFeature.placeLogsWithRotation(SimpleStateProvider.simple(BYGWoodTypes.REDWOOD.log().defaultBlockState()), worldGenLevel, this.placePos, randomSource, placeSettings, localOffset, randomPalette.blocks(BYGWoodTypes.REDWOOD.log().get()), trunkPositions);

        HashSet<BlockPos> leavePositions = new HashSet<>();

        TreeFromStructureNBTFeature.placeLeavesWithCalculatedDistanceAndRotation(SimpleStateProvider.simple(BYGWoodTypes.REDWOOD.leaves().defaultBlockState()), worldGenLevel, this.placePos, randomSource, placeSettings, randomPalette.blocks(BYGWoodTypes.REDWOOD.leaves().get()), leavePositions, localOffset, BlockPredicate.replaceable());

        TreeFromStructureNBTFeature.placeTreeDecorations(List.of(), worldGenLevel, randomSource, leavePositions, trunkPositions);

        this.boundingBox = structureTemplate.getBoundingBox(placeSettings, this.placePos.offset(localOffset));

    }
}
