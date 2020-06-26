//package voronoiaoc.byg.common.world.dimension;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.vector.Vector3d;
//import net.minecraft.world.World;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.dimension.DimensionType;
//import net.minecraft.world.dimension.OverworldDimension;
//import voronoiaoc.byg.BYG;
//import voronoiaoc.byg.common.biomes.BiomeFog;
//import voronoiaoc.byg.config.BYGConfig;
//
//public class ClientOverworldDimensionHook extends OverworldDimension {
//    public ClientOverworldDimensionHook(World worldIn, DimensionType typeIn) {
//        super(worldIn, typeIn);
//    }
//
//    @Override
//    public double getVoidFogYFactor() {
//        if (BYGConfig.biomeFogEffects.get() == BYGConfig.BiomeFogSettings.DENSEFOG || BYGConfig.biomeFogEffects.get() == BYGConfig.BiomeFogSettings.DENSEFOGCOLOR) {
//            final Minecraft client = Minecraft.getInstance();
//            assert client.player != null;
//            final BlockPos playerPos = client.player.getPosition();
//
//            double originalValue = super.getVoidFogYFactor();
//
//            final int xPos = playerPos.getX();
//            final int zPos = playerPos.getZ();
//            BlockPos.Mutable pos = new BlockPos.Mutable();
//            boolean modified = false;
//            double voidY = 0.0f;
//
//            for (int sampleX = xPos - 8; sampleX <= xPos + 8; ++sampleX) {
//                pos.setX(sampleX);
//
//                for (int sampleZ = zPos - 8; sampleZ <= zPos + 8; ++sampleZ) {
//                    pos.setZ(sampleZ);
//
//                    Biome biomePos = world.getBiome(pos);
//
//                    if (biomePos instanceof BiomeFog) {
//                        modified = true;
//                        voidY = ((BiomeFog) biomePos).getBiomeVoidFogYFactor(sampleX, sampleZ, originalValue);
//
//                    }
//                }
//            }
//            if (modified) {
//                return voidY;
//            } else return super.getVoidFogYFactor();
//        } else return super.getVoidFogYFactor();
//    }
//
//
//    @Override
//    public boolean doesXZShowFog(int x, int z) {
//        if (BYGConfig.biomeFogEffects.get() == BYGConfig.BiomeFogSettings.DENSEFOG || BYGConfig.biomeFogEffects.get() == BYGConfig.BiomeFogSettings.DENSEFOGCOLOR && !BYG.isUsingMixin) {
//            final Minecraft client = Minecraft.getInstance();
//            assert client.player != null;
//            final BlockPos playerPos = client.player.getPosition();
//
//            final int xPos = playerPos.getX();
//            final int zPos = playerPos.getZ();
//            BlockPos.Mutable pos = new BlockPos.Mutable();
//            boolean modified = false;
//
//            for (int sampleX = xPos; sampleX <= xPos; ++sampleX) {
//                pos.setX(sampleX);
//
//                for (int sampleZ = zPos; sampleZ <= zPos; ++sampleZ) {
//                    pos.setZ(sampleZ);
//
//                    Biome biomePos = world.getBiome(pos);
//
//                    if (biomePos instanceof BiomeFog) {
//                        modified = ((BiomeFog) biomePos).doesBiomeXZShowFog(sampleX, sampleZ);
//
//                    }
//                }
//            }
//            if (modified) {
//                return true;
//            } else return super.doesXZShowFog(x, z);
//        } else return super.doesXZShowFog(x, z);
//    }
//
//    @Override
//    public Vector3d getFogColor(float celestialAngle, float partialTicks) {
//        if (BYGConfig.biomeFogEffects.get() == BYGConfig.BiomeFogSettings.FOGCOLOR || BYGConfig.biomeFogEffects.get() == BYGConfig.BiomeFogSettings.DENSEFOGCOLOR) {
//            final Minecraft client = Minecraft.getInstance();
//            final World world = client.world;
//            assert world != null;
//
//            Vector3d original = super.getFogColor(celestialAngle, partialTicks);
//            double defaultR = original.getX();
//            defaultR *= defaultR;
//            double defaultG = original.getY();
//            defaultG *= defaultG;
//            double defaultB = original.getZ();
//            defaultB *= defaultB;
//
//            assert client.player != null;
//            final BlockPos playerPos = client.player.getPosition();
//            final int x = playerPos.getX();
//            final int z = playerPos.getZ();
//
//            boolean modified = false;
//
//            // use squares for colour blending because of how colour is perceived
//            float accumulatedR = 0.0f;
//            float accumulatedG = 0.0f;
//            float accumulatedB = 0.0f;
//
//            BlockPos.Mutable pos = new BlockPos.Mutable();
//
//            for (int sampleX = x - 8; sampleX <= x + 8; ++sampleX) {
//                pos.setX(sampleX);
//
//                for (int sampleZ = z - 8; sampleZ <= z + 8; ++sampleZ) {
//                    pos.setZ(sampleZ);
//
//                    Biome biome = world.getBiome(pos); // get biome
//
//                    if (biome instanceof BiomeFog) {
//                        modified = true; // faster than checking if it's already set to true first
//
//                        Vector3d biomeFogColour = ((BiomeFog) biome).getBiomeFogColor(sampleX, sampleZ, original);
//
//                        // Micro Optimisation: Halve method calls
//                        double r = biomeFogColour.getX(), g = biomeFogColour.getY(), b = biomeFogColour.getZ();
//
//                        accumulatedR += r * r;
//                        accumulatedG += g * g;
//                        accumulatedB += b * b;
//                    } else {
//                        accumulatedR += defaultR;
//                        accumulatedG += defaultG;
//                        accumulatedB += defaultB;
//                    }
//                }
//            }
//
//            if (modified) { // set return value if modified
//                final double divisor = 17 * 17;
//                return new Vector3d(Math.sqrt(accumulatedR / divisor), Math.sqrt(accumulatedG / divisor), Math.sqrt(accumulatedB / divisor));
//            } else return super.getFogColor(celestialAngle, partialTicks);
//        } else return super.getFogColor(celestialAngle, partialTicks);
//    }
//}
