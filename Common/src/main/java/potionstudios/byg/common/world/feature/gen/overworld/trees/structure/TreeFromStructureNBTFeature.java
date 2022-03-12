package potionstudios.byg.common.world.feature.gen.overworld.trees.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.LeavesBlockAccess;
import potionstudios.byg.mixin.access.StructureTemplateAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TreeFromStructureNBTFeature extends Feature<NoneFeatureConfiguration> {
    public TreeFromStructureNBTFeature(Codec<NoneFeatureConfiguration> $$0) {
        super($$0);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {

        BlockStateProvider stateProvider = BlockStateProvider.simple(BYGBlocks.MANGROVE_LOG);
        BlockStateProvider leavesProvider = BlockStateProvider.simple(BYGBlocks.MANGROVE_LEAVES);

        WorldGenLevel level = featurePlaceContext.level();
        StructureManager templateManager = level.getLevel().getStructureManager();
        ResourceLocation baseLocation = BYG.createLocation("features/trees/mangrove_tree3_base");
        Optional<StructureTemplate> baseTemplateOptional = templateManager.get(baseLocation);
        ResourceLocation canopyLocation = BYG.createLocation("features/trees/mangrove_tree3_canopy");
        Optional<StructureTemplate> canopyTemplateOptional = templateManager.get(canopyLocation);

        if (baseTemplateOptional.isEmpty()) {
            throw noTreePartPresent(baseLocation);
        }
        if (canopyTemplateOptional.isEmpty()) {
            throw noTreePartPresent(canopyLocation);
        }
        StructureTemplate baseTemplate = baseTemplateOptional.get();
        StructureTemplate canopyTemplate = canopyTemplateOptional.get();
        List<StructureTemplate.Palette> basePalettes = ((StructureTemplateAccess) baseTemplate).byg_getPalettes();
        List<StructureTemplate.Palette> canopyPalettes = ((StructureTemplateAccess) canopyTemplate).byg_getPalettes();
        BlockPos origin = featurePlaceContext.origin();
        StructurePlaceSettings placeSettings = new StructurePlaceSettings();
        StructureTemplate.Palette randomBasePalette = placeSettings.getRandomPalette(basePalettes, origin);
        StructureTemplate.Palette randomCanopyPalette = placeSettings.getRandomPalette(canopyPalettes, origin);

        List<StructureTemplate.StructureBlockInfo> leaves = randomCanopyPalette.blocks(BYGBlocks.MANGROVE_LEAVES);
        List<StructureTemplate.StructureBlockInfo> canopyLogs = randomCanopyPalette.blocks(BYGBlocks.MANGROVE_LOG);
        List<StructureTemplate.StructureBlockInfo> logs = randomBasePalette.blocks(BYGBlocks.MANGROVE_LOG);
        List<StructureTemplate.StructureBlockInfo> logBuilders = randomBasePalette.blocks(Blocks.RED_WOOL);
        List<StructureTemplate.StructureBlockInfo> trunkBuilder = randomBasePalette.blocks(Blocks.YELLOW_WOOL);

        int trunkLength = 15;

        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = logBuilder.pos.offset(origin);
            int maxTrunkBuildingDepth = 5;
            int yDifference = pos.getY() - level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ());
            if (yDifference > maxTrunkBuildingDepth) {
                return false;
            }
        }

        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = logBuilder.pos.offset(origin);
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(pos);
            while (!level.getBlockState(mutableBlockPos).canOcclude()) {
                level.setBlock(mutableBlockPos, stateProvider.getState(level.getRandom(), mutableBlockPos), 2);
                mutableBlockPos.move(Direction.DOWN);
            }
        }

        for (StructureTemplate.StructureBlockInfo trunk : logs) {
            BlockPos pos = trunk.pos.offset(origin);
            level.setBlock(pos, stateProvider.getState(featurePlaceContext.random(), pos), 2);
        }

        for (StructureTemplate.StructureBlockInfo trunk : trunkBuilder) {
            BlockPos pos = trunk.pos.offset(origin);
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);

            for (int i = 0; i < trunkLength; i++) {
                level.setBlock(mutable, stateProvider.getState(featurePlaceContext.random(), mutable), 2);
                mutable.move(Direction.UP);
            }
        }
        BlockPos canopyPos = origin.offset(0, trunkLength, 0);

        for (StructureTemplate.StructureBlockInfo canopyLog : canopyLogs) {
            BlockPos pos = canopyLog.pos.offset(canopyPos);
            level.setBlock(pos, stateProvider.getState(featurePlaceContext.random(), pos), 2);
        }

        List<Runnable> leavesPostApply = new ArrayList<>(leaves.size());
        for (StructureTemplate.StructureBlockInfo leaf : leaves) {
            BlockPos pos = leaf.pos.offset(canopyPos);

            BlockState state = leavesProvider.getState(featurePlaceContext.random(), pos);
            if (level.getBlockState(pos).isAir()) {
                level.setBlock(pos, state, 2);
                Runnable postProcess = () -> {
                    BlockState blockState = LeavesBlockAccess.byg_invokeUpdateDistance(state, level, pos);
                    if (blockState.getValue(LeavesBlock.DISTANCE) < LeavesBlock.DECAY_DISTANCE) {
                        level.setBlock(pos, blockState, 2);
                        BlockPos below = pos.below();
                        if (level.getBlockState(below).isAir()) {
                            // Bottom positions here
                        }

                    } else {
                        level.removeBlock(pos, false);
                    }
                };
                leavesPostApply.add(postProcess);
            }
            leavesPostApply.forEach(Runnable::run);
        }
        return false;
    }

    public static IllegalArgumentException noTreePartPresent(ResourceLocation location) {
        throw new IllegalArgumentException(String.format("\"%s\" is not a valid tree part.", location));
    }
}
