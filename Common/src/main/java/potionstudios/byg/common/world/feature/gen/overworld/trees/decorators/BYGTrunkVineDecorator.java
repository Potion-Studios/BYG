package potionstudios.byg.common.world.feature.gen.overworld.trees.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class BYGTrunkVineDecorator extends TreeDecorator {

    public static final Codec<BYGTrunkVineDecorator> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Registry.BLOCK.byNameCodec().flatXmap(BYGLeavesVineDecorator.mustExtendVineBlock(), BYGLeavesVineDecorator.mustExtendVineBlock()).fieldOf("vine_block").forGetter(bygLeavesVineDecorator -> bygLeavesVineDecorator.vineBlock),
                    Codec.FLOAT.fieldOf("probability").forGetter(bygLeavesVineDecorator -> bygLeavesVineDecorator.probability)
            ).apply(builder, ((vineBlock, probability) -> new BYGTrunkVineDecorator((VineBlock) vineBlock, probability)))
    );


    private final VineBlock vineBlock;
    private final float probability; // Vanilla is 0.66 chance.

    public BYGTrunkVineDecorator(VineBlock vineBlock, float probability) {
        this.vineBlock = vineBlock;
        this.probability = probability;
    }

    protected TreeDecoratorType<?> type() {
        return BYGTreeDecoratorTypes.TRUNK_VINE.get();
    }

    public void place(TreeDecorator.Context context) {
        RandomSource randomSource = context.random();
        context.logs().forEach((pos) -> {
            BlockPos pos1;
            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.west();
                if (context.isAir(pos1)) {
                    placeVine(context, pos1, VineBlock.EAST);
                }
            }

            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.east();
                if (context.isAir(pos1)) {
                    placeVine(context, pos1, VineBlock.WEST);
                }
            }

            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.north();
                if (context.isAir(pos1)) {
                    placeVine(context, pos1, VineBlock.SOUTH);
                }
            }

            if (randomSource.nextFloat() <= this.probability) {
                pos1 = pos.south();
                if (context.isAir(pos1)) {
                    placeVine(context, pos1, VineBlock.NORTH);
                }
            }
        });
    }

    public void placeVine(Context context, BlockPos blockPos, BooleanProperty booleanProperty) {
        context.setBlock(blockPos, this.vineBlock.defaultBlockState().setValue(booleanProperty, true));
    }
}
