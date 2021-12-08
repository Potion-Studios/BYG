package corgiaoc.byg.util;

import com.google.common.collect.Sets;
import net.minecraft.block.*;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.IWorldWriter;

import java.util.Random;
import java.util.Set;
//Credits to BetterEnd & Pauelevs
public class BlockHelper
{
	public static final BooleanProperty ROOTS = BooleanProperty.create("roots");
	
	public static final int FLAG_UPDATE_BLOCK = 1;
	public static final int FLAG_SEND_CLIENT_CHANGES = 2;
	public static final int FLAG_NO_RERENDER = 4;
	public static final int FORSE_RERENDER = 8;
	public static final int FLAG_IGNORE_OBSERVERS = 16;

	public static final int SET_SILENT = FLAG_UPDATE_BLOCK | FLAG_IGNORE_OBSERVERS | FLAG_SEND_CLIENT_CHANGES;
	public static final int SET_OBSERV = FLAG_UPDATE_BLOCK | FLAG_SEND_CLIENT_CHANGES;
	
	public static final Direction[] HORIZONTAL_DIRECTIONS = makeHorizontal();
	public static final Direction[] DIRECTIONS = Direction.values();
	
	private static final BlockPos.Mutable POS = new BlockPos.Mutable();
	protected static final BlockState AIR = Blocks.AIR.defaultBlockState();
	protected static final BlockState WATER = Blocks.WATER.defaultBlockState();
	
	public static int upRay(IWorldReader world, BlockPos pos, int maxDist)
	{
		int length = 0;
		for (int j = 1; j < maxDist && (world.isEmptyBlock(pos.above(j))); j++)
			length++;
		return length;
	}
	
	public static int downRay(IWorldReader world, BlockPos pos, int maxDist) 
	{
		int length = 0;
		for (int j = 1; j < maxDist && (world.isEmptyBlock(pos.below(j))); j++)
			length++;
		return length;
	}
	
	public static int downRayRep(IWorldReader world, BlockPos pos, int maxDist) 
	{
		POS.set(pos);
		for (int j = 1; j < maxDist && (world.getBlockState(POS)).getMaterial().isReplaceable(); j++)
		{
			POS.setY(POS.getY() - 1);
		}
		return pos.getY() - POS.getY();
	}
	
	public static Direction[] makeHorizontal() 
	{
		return new Direction[] { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST };
	}
	
	public static Direction randomHorizontal(Random random)
	{
		return HORIZONTAL_DIRECTIONS[random.nextInt(4)];
	}
	
	public static Direction randomDirection(Random random) 
	{
		return DIRECTIONS[random.nextInt(6)];
	}
	
	public static BlockState rotateHorizontal(BlockState state, Rotation rotation, DirectionProperty facing) {
		return (BlockState) state.setValue(facing, rotation.rotate((Direction) state.getValue(facing)));
	}

	public static BlockState mirrorHorizontal(BlockState state, Mirror mirror, DirectionProperty facing) {
		return state.rotate(mirror.getRotation((Direction) state.getValue(facing)));
	}
	
	public static Direction getRandomHorizontalDirection(Random rand)
	{
		return HORIZONTAL_DIRECTIONS[rand.nextInt(4)];
	}
	
	public static void setWithoutUpdate(IWorldWriter world, BlockPos pos, BlockState state)
	{
		world.setBlock(pos, state, SET_SILENT);
	}
	
	public static void setWithUpdate(IWorldWriter world, BlockPos pos, BlockState state) {
		world.setBlock(pos, state, SET_OBSERV);
	}
	
	public static void setWithUpdate(IWorldWriter world, BlockPos pos, Block block) {
		world.setBlock(pos, block.defaultBlockState(), SET_OBSERV);
	}
	
	public static void setWithoutUpdate(IWorldWriter world, BlockPos pos, Block block) 
	{
		world.setBlock(pos, block.defaultBlockState(), SET_SILENT);
	}
	
	public static void fixBlocks(IWorld world, BlockPos start, BlockPos end)
	{
		BlockState state;
		Set<BlockPos> doubleCheck = Sets.newHashSet();
		for (int x = start.getX(); x <= end.getX(); x++) 
		{
			POS.setX(x);
			for (int z = start.getZ(); z <= end.getZ(); z++) 
			{
				POS.setZ(z);
				for (int y = start.getY(); y <= end.getY(); y++) 
				{
					POS.setY(y);
					state = world.getBlockState(POS);
					
//					if (state.getBlock() instanceof FurBlock)
//					{
//						doubleCheck.add(POS.toImmutable());
//					}
					// Liquids
					 if (!state.getFluidState().isEmpty())
					{
						if (!state.canSurvive(world, POS)) 
						{
							setWithoutUpdate(world, POS, WATER);
							POS.setY(POS.getY() - 1);
							state = world.getBlockState(POS);
							while (!state.canSurvive(world, POS)) 
							{
								state = state.getFluidState().isEmpty() ? AIR : WATER;
								setWithoutUpdate(world, POS, state);
								POS.setY(POS.getY() - 1);
								state = world.getBlockState(POS);
							}
						}
						POS.setY(y - 1);
						if (world.isEmptyBlock(POS)) 
						{
							POS.setY(y);
							while (!world.getFluidState(POS).isEmpty()) 
							{
								setWithoutUpdate(world, POS, AIR);
								POS.setY(POS.getY() + 1);
							}
							continue;
						}
						for (Direction dir : HORIZONTAL_DIRECTIONS)
						{
							if (world.isEmptyBlock(POS.relative(dir))) 
							{
								world.getLiquidTicks().scheduleTick(POS, state.getFluidState().getType(), 0);
								break;
							}
						}
					}
					else if (!state.canSurvive(world, POS)) 
					{
						// Chorus
						if (state.is(Blocks.CHORUS_PLANT)) 
						{
							Set<BlockPos> ends = Sets.newHashSet();
							Set<BlockPos> add = Sets.newHashSet();
							ends.add(POS.immutable());

							for (int i = 0; i < 64 && !ends.isEmpty(); i++) 
							{
								ends.forEach((pos) -> {
									setWithoutUpdate(world, pos, AIR);
									for (Direction dir : HORIZONTAL_DIRECTIONS) 
									{
										BlockPos p = pos.relative(dir);
										BlockState st = world.getBlockState(p);
										if ((st.is(Blocks.CHORUS_PLANT) || st.is(Blocks.CHORUS_FLOWER)) && !st.canSurvive(world, p)) 
										{
											add.add(p);
										}
									}
									BlockPos p = pos.above();
									BlockState st = world.getBlockState(p);
									if ((st.is(Blocks.CHORUS_PLANT) || st.is(Blocks.CHORUS_FLOWER)) && !st.canSurvive(world, p))
									{
										add.add(p);
									}
								});
								ends.clear();
								ends.addAll(add);
								add.clear();
							}
						}
						// Vines
						else if (state.getBlock() instanceof VineBlock)
						{
							while (world.getBlockState(POS).getBlock() instanceof VineBlock)
							{
								setWithoutUpdate(world, POS, AIR);
								POS.setY(POS.getY() - 1);
							}
						}
						// Falling blocks
						else if (state.getBlock() instanceof FallingBlock)
						{
							BlockState falling = state;

							POS.setY(POS.getY() - 1);
							state = world.getBlockState(POS);

							int ray = downRayRep(world, POS.immutable(), 64);
							if (ray > 32) 
							{
								BlockHelper.setWithoutUpdate(world, POS, Blocks.END_STONE.defaultBlockState());
								if (world.getRandom().nextBoolean()) 
								{
									POS.setY(POS.getY() - 1);
									state = world.getBlockState(POS);
									BlockHelper.setWithoutUpdate(world, POS, Blocks.END_STONE.defaultBlockState());
								}
							}
							else 
							{
								POS.setY(y);
								BlockState replacement = AIR;
								for (Direction dir : HORIZONTAL_DIRECTIONS) 
								{
									state = world.getBlockState(POS.relative(dir));
									if (!state.getFluidState().isEmpty()) 
									{
										replacement = state;
										break;
									}
								}
								BlockHelper.setWithoutUpdate(world, POS, replacement);
								POS.setY(y - ray);
								BlockHelper.setWithoutUpdate(world, POS, falling);
							}
						}
						// Blocks without support
//						else
//						{
//							// Blue Vine
//							if (state.getBlock() instanceof BlueVineBlock)
//							{
//								while (state.isIn(ModBlocks.BLUE_VINE.get()) || state.isIn(ModBlocks.BLUE_VINE_LANTERN.get()) || state.isIn(ModBlocks.BLUE_VINE_FUR.get()))
//								{
//									BlockHelper.setWithoutUpdate(world, POS, AIR);
//									POS.setY(POS.getY() + 1);
//									state = world.getBlockState(POS);
//								}
//							}
//							// Double plants
//							if (state.getBlock() instanceof DoublePlantBlock)
//							{
//								BlockHelper.setWithoutUpdate(world, POS, AIR);
//								POS.setY(POS.getY() + 1);
//								BlockHelper.setWithoutUpdate(world, POS, AIR);
//							}
//							// Other blocks
//							else
//							{
//								BlockHelper.setWithoutUpdate(world, POS, getAirOrFluid(state));
//							}
//						}
					}
				}
			}
		}
		
		doubleCheck.forEach((pos) -> {
			if (!world.getBlockState(pos).canSurvive(world, pos)) 
			{
				BlockHelper.setWithoutUpdate(world, pos, AIR);
			}
		});
	}
	
	private static BlockState getAirOrFluid(BlockState state) 
	{
		return state.getFluidState().isEmpty() ? AIR : state.getFluidState().createLegacyBlock();
	}
	
	public static boolean isEndNylium(Block block) 
	{
		return block.is(BlockTags.NYLIUM) && block.is(MLBlockTags.END_STONES);
	}
	
	public static boolean isEndNylium(BlockState state) 
	{
		return isEndNylium(state.getBlock());
	}
}