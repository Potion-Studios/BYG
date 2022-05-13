package potionstudios.byg.common.world.feature.gen.overworld.trees.structure;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import potionstudios.byg.util.MLBlockTags;
import potionstudios.byg.util.codec.CodecUtil;

import java.util.function.Supplier;

public record TreeFromStructureNBTConfig(ResourceLocation baseLocation, ResourceLocation canopyLocation,
                                         IntProvider height, BlockStateProvider logProvider,
                                         BlockStateProvider leavesProvider, Block logTarget,
                                         Block leavesTarget, TagKey<Block> growableOn, int maxLogDepth, boolean allowUnderwater) implements FeatureConfiguration {
    public TreeFromStructureNBTConfig(ResourceLocation baseLocation, ResourceLocation canopyLocation,
                                      IntProvider height, BlockStateProvider logProvider,
                                      BlockStateProvider leavesProvider, Supplier<? extends Block> logTarget,
                                      Supplier<? extends Block> leavesTarget, TagKey<Block> growableOn, int maxLogDepth, boolean allowUnderwater) {
        this(baseLocation, canopyLocation, height, logProvider, leavesProvider, logTarget.get(), leavesTarget.get(), growableOn, maxLogDepth, allowUnderwater);
    }

    public static final Codec<TreeFromStructureNBTConfig> CODEC = RecordCodecBuilder.create(builder ->
            builder.group
                            (
                                    ResourceLocation.CODEC.fieldOf("base_location").forGetter(TreeFromStructureNBTConfig::baseLocation),
                                    ResourceLocation.CODEC.fieldOf("canopy_location").forGetter(TreeFromStructureNBTConfig::canopyLocation),
                                    IntProvider.CODEC.fieldOf("height").forGetter(TreeFromStructureNBTConfig::height),
                                    BlockStateProvider.CODEC.fieldOf("log_provider").forGetter(TreeFromStructureNBTConfig::logProvider),
                                    BlockStateProvider.CODEC.fieldOf("leaves_provider").forGetter(TreeFromStructureNBTConfig::leavesProvider),
                                    CodecUtil.BLOCK_CODEC.fieldOf("log_target").forGetter(TreeFromStructureNBTConfig::logTarget),
                                    CodecUtil.BLOCK_CODEC.fieldOf("leaves_target").forGetter(TreeFromStructureNBTConfig::leavesTarget),
                                    TagKey.hashedCodec(Registry.BLOCK_REGISTRY).optionalFieldOf("growable_on", BlockTags.DIRT).forGetter(TreeFromStructureNBTConfig::growableOn),
                                    Codec.INT.optionalFieldOf("max_log_depth", 5).forGetter(TreeFromStructureNBTConfig::maxLogDepth),
                                    Codec.BOOL.optionalFieldOf("allow_underwater_growth", false).forGetter(TreeFromStructureNBTConfig::allowUnderwater)

                            )
                    .apply(builder, TreeFromStructureNBTConfig::new)
    );
}
