package potionstudios.byg.common.world.feature.gen.overworld.trees.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import potionstudios.byg.util.codec.CodecUtil;

public record TreeFromStructureNBTConfig(ResourceLocation baseLocation, ResourceLocation canopyLocation,
                                         IntProvider height, BlockStateProvider logProvider,
                                         BlockStateProvider leavesProvider, Block logTarget,
                                         Block leavesTarget) implements FeatureConfiguration {
    public static final Codec<TreeFromStructureNBTConfig> CODEC = RecordCodecBuilder.create(builder ->
        builder.group
                (
                    ResourceLocation.CODEC.fieldOf("base_location").forGetter(TreeFromStructureNBTConfig::baseLocation),
                    ResourceLocation.CODEC.fieldOf("canopy_location").forGetter(TreeFromStructureNBTConfig::canopyLocation),
                    IntProvider.CODEC.fieldOf("height").forGetter(TreeFromStructureNBTConfig::height),
                    BlockStateProvider.CODEC.fieldOf("log_provider").forGetter(TreeFromStructureNBTConfig::logProvider),
                    BlockStateProvider.CODEC.fieldOf("leaves_provider").forGetter(TreeFromStructureNBTConfig::leavesProvider),
                    CodecUtil.BLOCK_CODEC.fieldOf("log_target").forGetter(TreeFromStructureNBTConfig::logTarget),
                    CodecUtil.BLOCK_CODEC.fieldOf("leaves_target").forGetter(TreeFromStructureNBTConfig::leavesTarget)
                )
            .apply(builder, TreeFromStructureNBTConfig::new)
    );
}
