package voronoiaoc.byg.common.world.dimension.nether.hooks;

import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.NetherDimension;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import voronoiaoc.byg.common.biomes.BiomeFog;
import voronoiaoc.byg.common.world.dimension.nether.biome.BYGNetherBiomeProvider;
import voronoiaoc.byg.common.world.dimension.nether.chunk.BYGNetherChunkGenerator;
import voronoiaoc.byg.common.world.dimension.nether.chunk.BYGNetherGenSettings;

public class ClientNetherDimensionHook extends NetherDimension {

    public static ChunkGeneratorType<BYGNetherGenSettings, BYGNetherChunkGenerator> SIMPLEXTALLCAVES = new ChunkGeneratorType<>(BYGNetherChunkGenerator::new, true, BYGNetherGenSettings::new);

    private static final Vec3d NETHERDEFAULTVEC3D = new Vec3d(0.2F, 0.03F, 0.03F);

    public ClientNetherDimensionHook(World worldIn, DimensionType typeIn) {
        super(worldIn, typeIn);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        BYGNetherGenSettings nethergensettings = SIMPLEXTALLCAVES.createSettings();
        nethergensettings.setDefaultBlock(Blocks.NETHERRACK.getDefaultState());
        nethergensettings.setDefaultFluid(Blocks.LAVA.getDefaultState());
        return SIMPLEXTALLCAVES.create(world, new BYGNetherBiomeProvider(world.getSeed()), nethergensettings);
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        final Minecraft client = Minecraft.getInstance();
        final World world = client.world;
        assert world != null;

        Vec3d original = super.getFogColor(celestialAngle, partialTicks);
        double defaultR = original.getX();
        defaultR *= defaultR;
        double defaultG = original.getY();
        defaultG *= defaultG;
        double defaultB = original.getZ();
        defaultB *= defaultB;

        assert client.player != null;
        final BlockPos playerPos = client.player.getPosition();
        final int x = playerPos.getX();
        final int z = playerPos.getZ();

        boolean modified = false;

        // use squares for colour blending because of how colour is perceived
        float accumulatedR = 0.0f;
        float accumulatedG = 0.0f;
        float accumulatedB = 0.0f;

        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int sampleX = x - 8; sampleX <= x + 8; ++sampleX) {
            pos.setX(sampleX);

            for (int sampleZ = z - 8; sampleZ <= z + 8; ++sampleZ) {
                pos.setZ(sampleZ);

                Biome biome = world.getBiome(pos); // get biome

                if (biome instanceof BiomeFog) {
                    modified = true; // faster than checking if it's already set to true first

                    Vec3d biomeFogColour = ((BiomeFog) biome).getBiomeFogColor(sampleX, sampleZ, original);

                    // Micro Optimisation: Halve method calls
                    double
                            r = biomeFogColour.getX(),
                            g = biomeFogColour.getY(),
                            b = biomeFogColour.getZ();

                    accumulatedR += r * r;
                    accumulatedG += g * g;
                    accumulatedB += b * b;
                } else {
                    accumulatedR += defaultR;
                    accumulatedG += defaultG;
                    accumulatedB += defaultB;
                }
            }
        }

        if (modified) { // set return value if modified
            final double divisor = 17 * 17;
            return new Vec3d(Math.sqrt(accumulatedR / divisor), Math.sqrt(accumulatedG / divisor), Math.sqrt(accumulatedB / divisor));
        }
        else return NETHERDEFAULTVEC3D;
    }
}
