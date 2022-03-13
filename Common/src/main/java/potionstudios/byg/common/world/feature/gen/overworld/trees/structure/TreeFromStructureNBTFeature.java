package potionstudios.byg.common.world.feature.gen.overworld.trees.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import potionstudios.byg.mixin.access.LeavesBlockAccess;
import potionstudios.byg.mixin.access.StructureTemplateAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TreeFromStructureNBTFeature extends Feature<TreeFromStructureNBTConfig> {

    private static final boolean DEBUG = false;

    public TreeFromStructureNBTFeature(Codec<TreeFromStructureNBTConfig> $$0) {
        super($$0);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeFromStructureNBTConfig> featurePlaceContext) {
        TreeFromStructureNBTConfig config = featurePlaceContext.config();

        BlockStateProvider stateProvider = config.logProvider();
        BlockStateProvider leavesProvider = config.leavesProvider();

        WorldGenLevel level = featurePlaceContext.level();
        StructureManager templateManager = level.getLevel().getStructureManager();
        ResourceLocation baseLocation = config.baseLocation();
        Optional<StructureTemplate> baseTemplateOptional = templateManager.get(baseLocation);
        ResourceLocation canopyLocation = config.canopyLocation();
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
        if (DEBUG) {
            level.setBlock(origin, Blocks.DIAMOND_BLOCK.defaultBlockState(), 2);
        }
        Random random = featurePlaceContext.random();
        StructurePlaceSettings placeSettings = new StructurePlaceSettings().setRotation(Rotation.getRandom(random));
        StructureTemplate.Palette randomBasePalette = placeSettings.getRandomPalette(basePalettes, origin);
        StructureTemplate.Palette randomCanopyPalette = placeSettings.getRandomPalette(canopyPalettes, origin);

        List<StructureTemplate.StructureBlockInfo> center = randomBasePalette.blocks(Blocks.WHITE_WOOL);
        if (center.size() > 1) {
            throw new IllegalArgumentException("There cannot be more than one central position.");
        }
        BlockPos centerOffset = center.get(0).pos;
        centerOffset = new BlockPos(-centerOffset.getX(), 0, -centerOffset.getZ());

        List<StructureTemplate.StructureBlockInfo> leaves = randomCanopyPalette.blocks(config.leavesTarget());
        List<StructureTemplate.StructureBlockInfo> canopyLogs = randomCanopyPalette.blocks(config.logTarget());
        List<StructureTemplate.StructureBlockInfo> logs = randomBasePalette.blocks(config.logTarget());
        List<StructureTemplate.StructureBlockInfo> logBuilders = randomBasePalette.blocks(Blocks.RED_WOOL);
        if (logBuilders.isEmpty()) {
            throw new UnsupportedOperationException(String.format("\"%s\" is missing log builders.", baseLocation));
        }

        List<StructureTemplate.StructureBlockInfo> trunkBuilder = randomBasePalette.blocks(Blocks.YELLOW_WOOL);

        int trunkLength = config.height().sample(random);

        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = getModifiedPos(placeSettings, logBuilder, centerOffset, origin);
            int maxTrunkBuildingDepth = 5;
            int yDifference = pos.getY() - level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ());
            if (yDifference > maxTrunkBuildingDepth) {
                return false;
            }
        }

        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = getModifiedPos(placeSettings, logBuilder, centerOffset, origin);
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(pos);
            while (!level.getBlockState(mutableBlockPos).canOcclude()) {
                level.setBlock(mutableBlockPos, stateProvider.getState(level.getRandom(), mutableBlockPos), 2);
                mutableBlockPos.move(Direction.DOWN);
            }
        }

        for (StructureTemplate.StructureBlockInfo trunk : logs) {
            BlockPos pos = getModifiedPos(placeSettings, trunk, centerOffset, origin);
            level.setBlock(pos, stateProvider.getState(random, pos), 2);
        }

        for (StructureTemplate.StructureBlockInfo trunk : trunkBuilder) {
            BlockPos pos = getModifiedPos(placeSettings, trunk, centerOffset, origin);
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);

            for (int i = 0; i <= trunkLength; i++) {
                level.setBlock(mutable, stateProvider.getState(random, mutable), 2);
                mutable.move(Direction.UP);
            }


        }
        {
            List<StructureTemplate.StructureBlockInfo> canopyCenter = randomCanopyPalette.blocks(Blocks.WHITE_WOOL);
            if (center.size() > 1) {
                throw new IllegalArgumentException("There cannot be more than one central position.");
            }
            StructureTemplate.StructureBlockInfo structureBlockInfo = canopyCenter.get(0);
            BlockPos canopyCenterOffset = structureBlockInfo.pos;
            canopyCenterOffset = new BlockPos(-canopyCenterOffset.getX(), canopyTemplate.getSize().getY() + trunkLength, -canopyCenterOffset.getZ());

            BlockPos placingPos = getModifiedPos(placeSettings, structureBlockInfo, new BlockPos(0, 0, 0), origin);
            level.setBlock(placingPos, stateProvider.getState(random, placingPos), 2);

            for (StructureTemplate.StructureBlockInfo canopyLog : canopyLogs) {
                BlockPos pos = getModifiedPos(placeSettings, canopyLog, canopyCenterOffset, origin);
                level.setBlock(pos, stateProvider.getState(random, pos), 2);
            }

            List<Runnable> leavesPostApply = new ArrayList<>(leaves.size());
            for (StructureTemplate.StructureBlockInfo leaf : leaves) {
                BlockPos pos = getModifiedPos(placeSettings, leaf, canopyCenterOffset, origin);

                BlockState state = leavesProvider.getState(random, pos);
                if (!level.getBlockState(pos).canOcclude()) {
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
            }
            leavesPostApply.forEach(Runnable::run);
        }
        return false;
    }

    private static BlockPos getModifiedPos(StructurePlaceSettings settings, StructureTemplate.StructureBlockInfo placing, BlockPos partCenter, BlockPos featureOrigin) {
        return StructureTemplate.calculateRelativePosition(settings, placing.pos).offset(featureOrigin).offset(StructureTemplate.calculateRelativePosition(settings, partCenter));
    }

    public static IllegalArgumentException noTreePartPresent(ResourceLocation location) {
        throw new IllegalArgumentException(String.format("\"%s\" is not a valid tree part.", location));
    }
}
