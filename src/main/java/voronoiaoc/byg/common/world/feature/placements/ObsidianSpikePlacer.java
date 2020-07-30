package voronoiaoc.byg.common.world.feature.placements;

//public class ObsidianSpikePlacer extends Decorator<CountDecoratorConfig> {
//    public static final Decorator<CountDecoratorConfig> OBBY_SPIKE = new ObsidianSpikePlacer(CountDecoratorConfig.field_24985);
//
//    public ObsidianSpikePlacer(Codec<CountDecoratorConfig> config) {
//        super(config);
//    }
//
//    public Stream<BlockPos> getPositions(WorldAccess world, ChunkGenerator generator, Random random, CountDecoratorConfig config, BlockPos pos) {
//        int i = random.nextInt(config.count);
//        return IntStream.range(0, i).mapToObj((idx) -> {
//            int j = random.nextInt(16) + pos.getX();
//            int k = random.nextInt(16) + pos.getZ();
//            int l = random.nextInt(75) + 54;
//            return new BlockPos(j, l, k);
//        });
//    }
//}