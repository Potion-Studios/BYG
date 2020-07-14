//package voronoiaoc.byg.common.world.feature.placements;
//
//import com.mojang.serialization.Codec;
//import net.minecraft.class_5444;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.world.WorldAccess;
//import net.minecraft.world.gen.chunk.ChunkGenerator;
//import net.minecraft.world.gen.decorator.CountDecoratorConfig;
//import net.minecraft.world.gen.decorator.Decorator;
//
//import java.util.Random;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//public class AnyWaterOrSolidSurfaceSurface extends Decorator<CountDecoratorConfig> {
//    public static final Decorator<CountDecoratorConfig> WWATERORSOLIDSURFACE = new AnyWaterOrSolidSurfaceSurface(CountDecoratorConfig.field_24985);
//
//    public AnyWaterOrSolidSurfaceSurface(Codec<CountDecoratorConfig> config) {
//        super(config);
//    }
//
//    @Override
//    public Stream<BlockPos> getPositions(class_5444 arg, Random random, CountDecoratorConfig decoratorConfig, BlockPos blockPos) {
//        return null;
//    }
//
//    public Stream<BlockPos> getPositions(WorldAccess world, ChunkGenerator generator, Random random, CountDecoratorConfig config, BlockPos pos) {
//        return IntStream.range(0, config.count).mapToObj((obj) -> {
//            int x = random.nextInt(16) + pos.getX();
//            int z = random.nextInt(16) + pos.getZ();
//            BlockPos.Mutable mutable = new BlockPos.Mutable(x, 255, z);
//            while (mutable.getY() > 0 && !world.getBlockState(mutable).isSolidBlock(world, mutable) && world.getBlockState(mutable).getFluidState().isEmpty())
//                mutable.move(Direction.DOWN);
//
//            return mutable.toImmutable();
//        });
//    }
//}