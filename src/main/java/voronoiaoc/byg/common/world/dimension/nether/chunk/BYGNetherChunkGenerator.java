package voronoiaoc.byg.common.world.dimension.nether.chunk;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.ModList;
import voronoiaoc.byg.common.world.worldtype.chunk.simplex.Simplex3DNoiseChunkGenerator;
import voronoiaoc.byg.config.BYGWorldConfig;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BYGNetherChunkGenerator extends Simplex3DNoiseChunkGenerator<BYGNetherGenSettings> {
    public final double[] constHeightThresholds = this.generateConstHeightThresholds();

    private final BYGNetherGenSettings genSettings;

    public static int netherHeight() {
        return (BYGWorldConfig.tallNether.get() ? 256 : 128);
    }

    public BYGNetherChunkGenerator(World world, BiomeProvider provider, BYGNetherGenSettings settings) {
        super(world, provider, 4, netherHeight(), settings, 4, 2, 684.412, 2053.236, 8.555150000000001, 34.2206);
        this.genSettings = settings;
    }

    protected double[] getColumnBiomeParams(int biomeParam1, int biomeParam2) {
        return new double[]{0.0D, 0.0D};
    }

    protected double getHeightThreshold(double biomeParam1, double biomeParam2, int y) {
        return constHeightThresholds[y];
    }

    private double[] generateConstHeightThresholds() {
        double[] thresholds = new double[256];

        // In place of top fade from Vanilla NoiseChunkGenerator
        double g = 13.0;
        double gd = 3.0;
        double gg = -10.0;

        for (int y = 0; y < netherHeight(); y++) {
            thresholds[y] = Math.cos(y * 3.141592653589793 * 6.0 / netherHeight()) * 2.0;
            double yc = y / 8.0;
            if (yc > (netherHeight() / 16.0)) {
                yc = (netherHeight() / 8.0) - 1 - yc;
            }

            if (yc < 4.0) {
                yc = 4.0 - yc;
                thresholds[y] -= yc * yc * yc * 10.0;
            }

            // In place of top fade from Vanilla NoiseChunkGenerator
            // Not actually sure what this does for the nether, but it's here in case I missed its purpose.
            if (yc > g) {
                double t = (yc - g) / gd;
                if (t > 1) t = 1; // clamp
                else t = t * t * (3 - 2 * t); // Not from Vanilla originally. But might as well make it smooth.
                //else t = t * t; // Only the beginning matters to be smooth, actually.
                thresholds[y] -= (t * gg) / (1 - t);
            }

        }

        return thresholds;
    }

    public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
        if (creatureType == EntityClassification.MONSTER) {
            if (Feature.NETHER_BRIDGE.isPositionInsideStructure(this.world, pos)) {
                return Feature.NETHER_BRIDGE.getSpawnList();
            }

            if (Feature.NETHER_BRIDGE.isPositionInStructure(this.world, pos) && this.world.getBlockState(pos.down()).getBlock() == Blocks.NETHER_BRICKS) {
                return Feature.NETHER_BRIDGE.getSpawnList();
            }
        }

        return super.getPossibleCreatures(creatureType, pos);
    }

    @Override
    protected void makeBedrock(IChunk chunkIn, Random rand) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        int i = chunkIn.getPos().getXStart();
        int j = chunkIn.getPos().getZStart();
        int k = genSettings.getBedrockFloorHeight();
        int l = genSettings.getBedrockRoofHeight();
        Iterator var9 = BlockPos.getAllInBoxMutable(i, 0, j, i + 15, 0, j + 15).iterator();

        if (ModList.get().isLoaded("immersive_portals")) {
            while (true) {
                BlockPos blockpos;
                int j1;
                do {
                    if (!var9.hasNext()) {
                        return;
                    }

                    blockpos = (BlockPos) var9.next();
                    if (l > 0) {
                        for (j1 = l; j1 >= l - 4; --j1) {
                            if (j1 >= l - rand.nextInt(5)) {
                                chunkIn.setBlockState(blockpos$mutable.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.OBSIDIAN.getDefaultState(), false);
                            }
                        }
                    }
                } while (k >= 256);

                for (j1 = k + 4; j1 >= k; --j1) {
                    if (j1 <= k + rand.nextInt(5)) {
                        chunkIn.setBlockState(blockpos$mutable.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.OBSIDIAN.getDefaultState(), false);
                    }
                }
            }
        } else {
            while (true) {
                BlockPos blockpos;
                int j1;
                do {
                    if (!var9.hasNext()) {
                        return;
                    }

                    blockpos = (BlockPos) var9.next();
                    if (l > 0) {
                        for (j1 = l; j1 >= l - 4; --j1) {
                            if (j1 >= l - rand.nextInt(5)) {
                                chunkIn.setBlockState(blockpos$mutable.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
                            }
                        }
                    }
                } while (k >= 256);

                for (j1 = k + 4; j1 >= k; --j1) {
                    if (j1 <= k + rand.nextInt(5)) {
                        chunkIn.setBlockState(blockpos$mutable.setPos(blockpos.getX(), j1, blockpos.getZ()), Blocks.BEDROCK.getDefaultState(), false);
                    }
                }
            }
        }
    }

    public int getGroundHeight() {
        return this.world.getSeaLevel() + 1;
    }

    public int getMaxHeight() {
        return netherHeight();
    }

    public int getSeaLevel() {
        return 32;
    }
}
