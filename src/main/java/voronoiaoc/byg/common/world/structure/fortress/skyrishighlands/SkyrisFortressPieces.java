package voronoiaoc.byg.common.world.structure.fortress.skyrishighlands;

import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTables;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class SkyrisFortressPieces {
   private static final SkyrisFortressPieces.PieceWeight[] PRIMARY_COMPONENTS = new SkyrisFortressPieces.PieceWeight[]{new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Straight.class, 30, 0, true), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Crossing3.class, 10, 4), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Crossing.class, 10, 4), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Stairs.class, 10, 3), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Throne.class, 5, 2), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Entrance.class, 5, 1)};
   private static final SkyrisFortressPieces.PieceWeight[] SECONDARY_COMPONENTS = new SkyrisFortressPieces.PieceWeight[]{new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Corridor5.class, 25, 0, true), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Crossing2.class, 15, 5), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Corridor2.class, 5, 10), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Corridor.class, 5, 10), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Corridor3.class, 10, 3, true), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.Corridor4.class, 7, 2), new SkyrisFortressPieces.PieceWeight(SkyrisFortressPieces.NetherStalkRoom.class, 5, 2)};

   public static BlockState DACITEBRICKS = BYGBlockList.DACITE_BRICKS.getDefaultState();
   public static BlockState DACITEBRICKSTAIRS = BYGBlockList.DACITE_BRICK_STAIRS.getDefaultState();
   public static BlockState IRONBARS = Blocks.IRON_BARS.getDefaultState();

   private static SkyrisFortressPieces.Piece findAndCreateBridgePieceFactory(SkyrisFortressPieces.PieceWeight pieceWeight, List<StructurePiece> structurePieceList, Random rand, int p_175887_3_, int p_175887_4_, int p_175887_5_, Direction direction, int p_175887_7_) {
      Class<? extends SkyrisFortressPieces.Piece> oclass = pieceWeight.weightClass;
      SkyrisFortressPieces.Piece fortresspieces$piece = null;
      if (oclass == SkyrisFortressPieces.Straight.class) {
         fortresspieces$piece = SkyrisFortressPieces.Straight.createPiece(structurePieceList, rand, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.Crossing3.class) {
         fortresspieces$piece = SkyrisFortressPieces.Crossing3.createPiece(structurePieceList, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.Crossing.class) {
         fortresspieces$piece = SkyrisFortressPieces.Crossing.createPiece(structurePieceList, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.Stairs.class) {
         fortresspieces$piece = SkyrisFortressPieces.Stairs.createPiece(structurePieceList, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_7_, direction);
      } else if (oclass == SkyrisFortressPieces.Throne.class) {
         fortresspieces$piece = SkyrisFortressPieces.Throne.createPiece(structurePieceList, p_175887_3_, p_175887_4_, p_175887_5_, p_175887_7_, direction);
      } else if (oclass == SkyrisFortressPieces.Entrance.class) {
         fortresspieces$piece = SkyrisFortressPieces.Entrance.createPiece(structurePieceList, rand, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.Corridor5.class) {
         fortresspieces$piece = SkyrisFortressPieces.Corridor5.createPiece(structurePieceList, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.Corridor2.class) {
         fortresspieces$piece = SkyrisFortressPieces.Corridor2.createPiece(structurePieceList, rand, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.Corridor.class) {
         fortresspieces$piece = SkyrisFortressPieces.Corridor.createPiece(structurePieceList, rand, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.Corridor3.class) {
         fortresspieces$piece = SkyrisFortressPieces.Corridor3.createPiece(structurePieceList, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.Corridor4.class) {
         fortresspieces$piece = SkyrisFortressPieces.Corridor4.func_214814_a(structurePieceList, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.Crossing2.class) {
         fortresspieces$piece = SkyrisFortressPieces.Crossing2.createPiece(structurePieceList, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      } else if (oclass == SkyrisFortressPieces.NetherStalkRoom.class) {
         fortresspieces$piece = SkyrisFortressPieces.NetherStalkRoom.createPiece(structurePieceList, p_175887_3_, p_175887_4_, p_175887_5_, direction, p_175887_7_);
      }

      return fortresspieces$piece;
   }

   public static class Corridor extends SkyrisFortressPieces.Piece {
      private boolean chest;

      public Corridor(int p_i45615_1_, Random p_i45615_2_, MutableBoundingBox p_i45615_3_, Direction p_i45615_4_) {
         super(IStructurePieceType.NESCLT, p_i45615_1_);
         this.setCoordBaseMode(p_i45615_4_);
         this.boundingBox = p_i45615_3_;
         this.chest = p_i45615_2_.nextInt(3) == 0;
      }

      public Corridor(TemplateManager templateManager, CompoundNBT nbt) {
         super(IStructurePieceType.NESCLT, nbt);
         this.chest = nbt.getBoolean("Chest");
      }

      /**
       * (abstract) Helper method to read subclass data from NBT
       */
      protected void readAdditional(CompoundNBT tagCompound) {
         super.readAdditional(tagCompound);
         tagCompound.putBoolean("Chest", this.chest);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentX((SkyrisFortressPieces.Start)componentIn, listIn, rand, 0, 1, true);
      }

      public static SkyrisFortressPieces.Corridor createPiece(List<StructurePiece> structurePieceList, Random rand, int p_175879_2_, int p_175879_3_, int p_175879_4_, Direction direction, int p_175879_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175879_2_, p_175879_3_, p_175879_4_, -1, 0, 0, 5, 7, 5, direction);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(structurePieceList, mutableboundingbox) == null ? new SkyrisFortressPieces.Corridor(p_175879_6_, rand, mutableboundingbox, direction) : null;
      }

      public boolean create(IWorld world, ChunkGenerator<?> chunkGenerator, Random rand, MutableBoundingBox mutable, ChunkPos chunkPos) {
         this.fillWithBlocks(world, mutable, 0, 0, 0, 4, 1, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         BlockState blockstate = IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true));
         BlockState blockstate1 = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));
         this.fillWithBlocks(world, mutable, 4, 2, 0, 4, 5, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 4, 3, 1, 4, 4, 1, blockstate1, blockstate1, false);
         this.fillWithBlocks(world, mutable, 4, 3, 3, 4, 4, 3, blockstate1, blockstate1, false);
         this.fillWithBlocks(world, mutable, 0, 2, 0, 0, 5, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 0, 2, 4, 3, 5, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 1, 3, 4, 1, 4, 4, blockstate, blockstate, false);
         this.fillWithBlocks(world, mutable, 3, 3, 4, 3, 4, 4, blockstate, blockstate, false);
         if (this.chest && mutable.isVecInside(new BlockPos(this.getXWithOffset(3, 3), this.getYWithOffset(2), this.getZWithOffset(3, 3)))) {
            this.chest = false;
            this.generateChest(world, mutable, rand, 3, 2, 3, LootTables.CHESTS_PILLAGER_OUTPOST);
         }

         this.fillWithBlocks(world, mutable, 0, 6, 0, 4, 6, 4, DACITEBRICKS, DACITEBRICKS, false);

         for(int i = 0; i <= 4; ++i) {
            for(int j = 0; j <= 4; ++j) {
               this.replaceAirAndLiquidDownwards(world, DACITEBRICKS, i, -1, j, mutable);
            }
         }

         return true;
      }
   }

   public static class Corridor2 extends SkyrisFortressPieces.Piece {
      private boolean chest;

      public Corridor2(int p_i45613_1_, Random p_i45613_2_, MutableBoundingBox p_i45613_3_, Direction p_i45613_4_) {
         super(IStructurePieceType.NESCRT, p_i45613_1_);
         this.setCoordBaseMode(p_i45613_4_);
         this.boundingBox = p_i45613_3_;
         this.chest = p_i45613_2_.nextInt(3) == 0;
      }

      public Corridor2(TemplateManager p_i50266_1_, CompoundNBT p_i50266_2_) {
         super(IStructurePieceType.NESCRT, p_i50266_2_);
         this.chest = p_i50266_2_.getBoolean("Chest");
      }

      /**
       * (abstract) Helper method to read subclass data from NBT
       */
      protected void readAdditional(CompoundNBT tagCompound) {
         super.readAdditional(tagCompound);
         tagCompound.putBoolean("Chest", this.chest);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentZ((SkyrisFortressPieces.Start)componentIn, listIn, rand, 0, 1, true);
      }

      public static SkyrisFortressPieces.Corridor2 createPiece(List<StructurePiece> p_175876_0_, Random p_175876_1_, int p_175876_2_, int p_175876_3_, int p_175876_4_, Direction p_175876_5_, int p_175876_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175876_2_, p_175876_3_, p_175876_4_, -1, 0, 0, 5, 7, 5, p_175876_5_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175876_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Corridor2(p_175876_6_, p_175876_1_, mutableboundingbox, p_175876_5_) : null;
      }

      public boolean create(IWorld world, ChunkGenerator<?> chunkGenerator, Random rand, MutableBoundingBox mutable, ChunkPos chunkPos) {
         this.fillWithBlocks(world, mutable, 0, 0, 0, 4, 1, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         BlockState blockstate = IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true));
         BlockState blockstate1 = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));
         this.fillWithBlocks(world, mutable, 0, 2, 0, 0, 5, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 0, 3, 1, 0, 4, 1, blockstate1, blockstate1, false);
         this.fillWithBlocks(world, mutable, 0, 3, 3, 0, 4, 3, blockstate1, blockstate1, false);
         this.fillWithBlocks(world, mutable, 4, 2, 0, 4, 5, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 1, 2, 4, 4, 5, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 1, 3, 4, 1, 4, 4, blockstate, blockstate, false);
         this.fillWithBlocks(world, mutable, 3, 3, 4, 3, 4, 4, blockstate, blockstate, false);
         if (this.chest && mutable.isVecInside(new BlockPos(this.getXWithOffset(1, 3), this.getYWithOffset(2), this.getZWithOffset(1, 3)))) {
            this.chest = false;
            this.generateChest(world, mutable, rand, 1, 2, 3, LootTables.CHESTS_PILLAGER_OUTPOST);
         }

         this.fillWithBlocks(world, mutable, 0, 6, 0, 4, 6, 4, DACITEBRICKS, DACITEBRICKS, false);

         for(int i = 0; i <= 4; ++i) {
            for(int j = 0; j <= 4; ++j) {
               this.replaceAirAndLiquidDownwards(world, DACITEBRICKS, i, -1, j, mutable);
            }
         }

         return true;
      }
   }

   public static class Corridor3 extends SkyrisFortressPieces.Piece {
      public Corridor3(int p_i50280_1_, MutableBoundingBox p_i50280_2_, Direction p_i50280_3_) {
         super(IStructurePieceType.NECCS, p_i50280_1_);
         this.setCoordBaseMode(p_i50280_3_);
         this.boundingBox = p_i50280_2_;
      }

      public Corridor3(TemplateManager p_i50281_1_, CompoundNBT p_i50281_2_) {
         super(IStructurePieceType.NECCS, p_i50281_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((SkyrisFortressPieces.Start)componentIn, listIn, rand, 1, 0, true);
      }

      public static SkyrisFortressPieces.Corridor3 createPiece(List<StructurePiece> p_175883_0_, int p_175883_1_, int p_175883_2_, int p_175883_3_, Direction p_175883_4_, int p_175883_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175883_1_, p_175883_2_, p_175883_3_, -1, -7, 0, 5, 14, 10, p_175883_4_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175883_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Corridor3(p_175883_5_, mutableboundingbox, p_175883_4_) : null;
      }

      public boolean create(IWorld world, ChunkGenerator<?> chunkGen, Random rand, MutableBoundingBox mutable, ChunkPos chunkPos) {
         BlockState blockstate = DACITEBRICKSTAIRS.with(StairsBlock.FACING, Direction.SOUTH);
         BlockState blockstate1 = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));

         for(int i = 0; i <= 9; ++i) {
            int j = Math.max(1, 7 - i);
            int k = Math.min(Math.max(j + 5, 14 - i), 13);
            int l = i;
            this.fillWithBlocks(world, mutable, 0, 0, i, 4, j, i, DACITEBRICKS, DACITEBRICKS, false);
            this.fillWithBlocks(world, mutable, 1, j + 1, i, 3, k - 1, i, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            if (i <= 6) {
               this.setBlockState(world, blockstate, 1, j + 1, i, mutable);
               this.setBlockState(world, blockstate, 2, j + 1, i, mutable);
               this.setBlockState(world, blockstate, 3, j + 1, i, mutable);
            }

            this.fillWithBlocks(world, mutable, 0, k, i, 4, k, i, DACITEBRICKS, DACITEBRICKS, false);
            this.fillWithBlocks(world, mutable, 0, j + 1, i, 0, k - 1, i, DACITEBRICKS, DACITEBRICKS, false);
            this.fillWithBlocks(world, mutable, 4, j + 1, i, 4, k - 1, i, DACITEBRICKS, DACITEBRICKS, false);
            if ((i & 1) == 0) {
               this.fillWithBlocks(world, mutable, 0, j + 2, i, 0, j + 3, i, blockstate1, blockstate1, false);
               this.fillWithBlocks(world, mutable, 4, j + 2, i, 4, j + 3, i, blockstate1, blockstate1, false);
            }

            for(int i1 = 0; i1 <= 4; ++i1) {
               this.replaceAirAndLiquidDownwards(world, DACITEBRICKS, i1, -1, l, mutable);
            }
         }

         return true;
      }
   }

   public static class Corridor4 extends SkyrisFortressPieces.Piece {
      public Corridor4(int p_i50277_1_, MutableBoundingBox p_i50277_2_, Direction p_i50277_3_) {
         super(IStructurePieceType.NECTB, p_i50277_1_);
         this.setCoordBaseMode(p_i50277_3_);
         this.boundingBox = p_i50277_2_;
      }

      public Corridor4(TemplateManager p_i50278_1_, CompoundNBT p_i50278_2_) {
         super(IStructurePieceType.NECTB, p_i50278_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         int i = 1;
         Direction direction = this.getCoordBaseMode();
         if (direction == Direction.WEST || direction == Direction.NORTH) {
            i = 5;
         }

         this.getNextComponentX((SkyrisFortressPieces.Start)componentIn, listIn, rand, 0, i, rand.nextInt(8) > 0);
         this.getNextComponentZ((SkyrisFortressPieces.Start)componentIn, listIn, rand, 0, i, rand.nextInt(8) > 0);
      }

      public static SkyrisFortressPieces.Corridor4 func_214814_a(List<StructurePiece> structurePieceList, int p_214814_1_, int p_214814_2_, int p_214814_3_, Direction direction, int p_214814_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_214814_1_, p_214814_2_, p_214814_3_, -3, 0, 0, 9, 7, 9, direction);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(structurePieceList, mutableboundingbox) == null ? new SkyrisFortressPieces.Corridor4(p_214814_5_, mutableboundingbox, direction) : null;
      }

      public boolean create(IWorld world, ChunkGenerator<?> chunkGen, Random rand, MutableBoundingBox mutable, ChunkPos p_225577_5_) {
         BlockState blockstate = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));
         BlockState blockstate1 = IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true));
         this.fillWithBlocks(world, mutable, 0, 0, 0, 8, 1, 8, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 0, 2, 0, 8, 5, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(world, mutable, 0, 6, 0, 8, 6, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 0, 2, 0, 2, 5, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 6, 2, 0, 8, 5, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 1, 3, 0, 1, 4, 0, blockstate1, blockstate1, false);
         this.fillWithBlocks(world, mutable, 7, 3, 0, 7, 4, 0, blockstate1, blockstate1, false);
         this.fillWithBlocks(world, mutable, 0, 2, 4, 8, 2, 8, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 1, 1, 4, 2, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(world, mutable, 6, 1, 4, 7, 2, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(world, mutable, 1, 3, 8, 7, 3, 8, blockstate1, blockstate1, false);
         this.setBlockState(world, IRONBARS.with(FenceBlock.EAST, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true)), 0, 3, 8, mutable);
         this.setBlockState(world, IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true)), 8, 3, 8, mutable);
         this.fillWithBlocks(world, mutable, 0, 3, 6, 0, 3, 7, blockstate, blockstate, false);
         this.fillWithBlocks(world, mutable, 8, 3, 6, 8, 3, 7, blockstate, blockstate, false);
         this.fillWithBlocks(world, mutable, 0, 3, 4, 0, 5, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 8, 3, 4, 8, 5, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 1, 3, 5, 2, 5, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 6, 3, 5, 7, 5, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(world, mutable, 1, 4, 5, 1, 5, 5, blockstate1, blockstate1, false);
         this.fillWithBlocks(world, mutable, 7, 4, 5, 7, 5, 5, blockstate1, blockstate1, false);

         for(int i = 0; i <= 5; ++i) {
            for(int j = 0; j <= 8; ++j) {
               this.replaceAirAndLiquidDownwards(world, DACITEBRICKS, j, -1, i, mutable);
            }
         }

         return true;
      }
   }

   public static class Corridor5 extends SkyrisFortressPieces.Piece {
      public Corridor5(int p_i50268_1_, MutableBoundingBox p_i50268_2_, Direction p_i50268_3_) {
         super(IStructurePieceType.NESC, p_i50268_1_);
         this.setCoordBaseMode(p_i50268_3_);
         this.boundingBox = p_i50268_2_;
      }

      public Corridor5(TemplateManager p_i50269_1_, CompoundNBT p_i50269_2_) {
         super(IStructurePieceType.NESC, p_i50269_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((SkyrisFortressPieces.Start)componentIn, listIn, rand, 1, 0, true);
      }

      public static SkyrisFortressPieces.Corridor5 createPiece(List<StructurePiece> p_175877_0_, int p_175877_1_, int p_175877_2_, int p_175877_3_, Direction p_175877_4_, int p_175877_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175877_1_, p_175877_2_, p_175877_3_, -1, 0, 0, 5, 7, 5, p_175877_4_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175877_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Corridor5(p_175877_5_, mutableboundingbox, p_175877_4_) : null;
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 0, 0, 4, 1, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         BlockState blockstate = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 0, 5, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 2, 0, 4, 5, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 3, 1, 0, 4, 1, blockstate, blockstate, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 3, 3, 0, 4, 3, blockstate, blockstate, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 3, 1, 4, 4, 1, blockstate, blockstate, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 3, 3, 4, 4, 3, blockstate, blockstate, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 6, 0, 4, 6, 4, DACITEBRICKS, DACITEBRICKS, false);

         for(int i = 0; i <= 4; ++i) {
            for(int j = 0; j <= 4; ++j) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i, -1, j, p_225577_4_);
            }
         }

         return true;
      }
   }

   public static class Crossing extends SkyrisFortressPieces.Piece {
      public Crossing(int p_i50258_1_, MutableBoundingBox p_i50258_2_, Direction p_i50258_3_) {
         super(IStructurePieceType.NERC, p_i50258_1_);
         this.setCoordBaseMode(p_i50258_3_);
         this.boundingBox = p_i50258_2_;
      }

      public Crossing(TemplateManager p_i50259_1_, CompoundNBT p_i50259_2_) {
         super(IStructurePieceType.NERC, p_i50259_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((SkyrisFortressPieces.Start)componentIn, listIn, rand, 2, 0, false);
         this.getNextComponentX((SkyrisFortressPieces.Start)componentIn, listIn, rand, 0, 2, false);
         this.getNextComponentZ((SkyrisFortressPieces.Start)componentIn, listIn, rand, 0, 2, false);
      }

      public static SkyrisFortressPieces.Crossing createPiece(List<StructurePiece> p_175873_0_, int p_175873_1_, int p_175873_2_, int p_175873_3_, Direction p_175873_4_, int p_175873_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175873_1_, p_175873_2_, p_175873_3_, -2, 0, 0, 7, 9, 7, p_175873_4_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175873_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Crossing(p_175873_5_, mutableboundingbox, p_175873_4_) : null;
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 0, 0, 6, 1, 6, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 6, 7, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 1, 6, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 6, 1, 6, 6, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 2, 0, 6, 6, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 2, 6, 6, 6, 6, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 0, 6, 1, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 5, 0, 6, 6, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 2, 0, 6, 6, 1, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 2, 5, 6, 6, 6, DACITEBRICKS, DACITEBRICKS, false);
         BlockState blockstate = IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true));
         BlockState blockstate1 = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 6, 0, 4, 6, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 0, 4, 5, 0, blockstate, blockstate, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 6, 6, 4, 6, 6, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 6, 4, 5, 6, blockstate, blockstate, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 6, 2, 0, 6, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 2, 0, 5, 4, blockstate1, blockstate1, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 6, 2, 6, 6, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 5, 2, 6, 5, 4, blockstate1, blockstate1, false);

         for(int i = 0; i <= 6; ++i) {
            for(int j = 0; j <= 6; ++j) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i, -1, j, p_225577_4_);
            }
         }

         return true;
      }
   }

   public static class Crossing2 extends SkyrisFortressPieces.Piece {
      public Crossing2(int p_i50273_1_, MutableBoundingBox p_i50273_2_, Direction p_i50273_3_) {
         super(IStructurePieceType.NESCSC, p_i50273_1_);
         this.setCoordBaseMode(p_i50273_3_);
         this.boundingBox = p_i50273_2_;
      }

      public Crossing2(TemplateManager p_i50274_1_, CompoundNBT p_i50274_2_) {
         super(IStructurePieceType.NESCSC, p_i50274_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((SkyrisFortressPieces.Start)componentIn, listIn, rand, 1, 0, true);
         this.getNextComponentX((SkyrisFortressPieces.Start)componentIn, listIn, rand, 0, 1, true);
         this.getNextComponentZ((SkyrisFortressPieces.Start)componentIn, listIn, rand, 0, 1, true);
      }

      public static SkyrisFortressPieces.Crossing2 createPiece(List<StructurePiece> p_175878_0_, int p_175878_1_, int p_175878_2_, int p_175878_3_, Direction p_175878_4_, int p_175878_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175878_1_, p_175878_2_, p_175878_3_, -1, 0, 0, 5, 7, 5, p_175878_4_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175878_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Crossing2(p_175878_5_, mutableboundingbox, p_175878_4_) : null;
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 0, 0, 4, 1, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 4, 5, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 0, 5, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 2, 0, 4, 5, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 4, 0, 5, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 2, 4, 4, 5, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 6, 0, 4, 6, 4, DACITEBRICKS, DACITEBRICKS, false);

         for(int i = 0; i <= 4; ++i) {
            for(int j = 0; j <= 4; ++j) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i, -1, j, p_225577_4_);
            }
         }

         return true;
      }
   }

   public static class Crossing3 extends SkyrisFortressPieces.Piece {
      public Crossing3(int p_i50286_1_, MutableBoundingBox p_i50286_2_, Direction p_i50286_3_) {
         super(IStructurePieceType.NEBCR, p_i50286_1_);
         this.setCoordBaseMode(p_i50286_3_);
         this.boundingBox = p_i50286_2_;
      }

      protected Crossing3(Random p_i2042_1_, int p_i2042_2_, int p_i2042_3_) {
         super(IStructurePieceType.NEBCR, 0);
         this.setCoordBaseMode(Direction.Plane.HORIZONTAL.random(p_i2042_1_));
         if (this.getCoordBaseMode().getAxis() == Direction.Axis.Z) {
            this.boundingBox = new MutableBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
         } else {
            this.boundingBox = new MutableBoundingBox(p_i2042_2_, 64, p_i2042_3_, p_i2042_2_ + 19 - 1, 73, p_i2042_3_ + 19 - 1);
         }

      }

      protected Crossing3(IStructurePieceType p_i50287_1_, CompoundNBT p_i50287_2_) {
         super(p_i50287_1_, p_i50287_2_);
      }

      public Crossing3(TemplateManager p_i50288_1_, CompoundNBT p_i50288_2_) {
         this(IStructurePieceType.NEBCR, p_i50288_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((SkyrisFortressPieces.Start)componentIn, listIn, rand, 8, 3, false);
         this.getNextComponentX((SkyrisFortressPieces.Start)componentIn, listIn, rand, 3, 8, false);
         this.getNextComponentZ((SkyrisFortressPieces.Start)componentIn, listIn, rand, 3, 8, false);
      }

      public static SkyrisFortressPieces.Crossing3 createPiece(List<StructurePiece> p_175885_0_, int p_175885_1_, int p_175885_2_, int p_175885_3_, Direction p_175885_4_, int p_175885_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175885_1_, p_175885_2_, p_175885_3_, -8, -3, 0, 19, 10, 19, p_175885_4_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175885_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Crossing3(p_175885_5_, mutableboundingbox, p_175885_4_) : null;
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 7, 3, 0, 11, 4, 18, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 3, 7, 18, 4, 11, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 8, 5, 0, 10, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 8, 18, 7, 10, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 7, 5, 0, 7, 5, 7, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 7, 5, 11, 7, 5, 18, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 11, 5, 0, 11, 5, 7, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 11, 5, 11, 11, 5, 18, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 7, 7, 5, 7, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 11, 5, 7, 18, 5, 7, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 11, 7, 5, 11, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 11, 5, 11, 18, 5, 11, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 7, 2, 0, 11, 2, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 7, 2, 13, 11, 2, 18, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 7, 0, 0, 11, 1, 3, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 7, 0, 15, 11, 1, 18, DACITEBRICKS, DACITEBRICKS, false);

         for(int i = 7; i <= 11; ++i) {
            for(int j = 0; j <= 2; ++j) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i, -1, j, p_225577_4_);
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i, -1, 18 - j, p_225577_4_);
            }
         }

         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 7, 5, 2, 11, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 13, 2, 7, 18, 2, 11, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 0, 7, 3, 1, 11, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 15, 0, 7, 18, 1, 11, DACITEBRICKS, DACITEBRICKS, false);

         for(int k = 0; k <= 2; ++k) {
            for(int l = 7; l <= 11; ++l) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, k, -1, l, p_225577_4_);
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, 18 - k, -1, l, p_225577_4_);
            }
         }

         return true;
      }
   }

   public static class End extends SkyrisFortressPieces.Piece {
      private final int fillSeed;

      public End(int p_i45621_1_, Random p_i45621_2_, MutableBoundingBox p_i45621_3_, Direction p_i45621_4_) {
         super(IStructurePieceType.NEBEF, p_i45621_1_);
         this.setCoordBaseMode(p_i45621_4_);
         this.boundingBox = p_i45621_3_;
         this.fillSeed = p_i45621_2_.nextInt();
      }

      public End(TemplateManager p_i50285_1_, CompoundNBT p_i50285_2_) {
         super(IStructurePieceType.NEBEF, p_i50285_2_);
         this.fillSeed = p_i50285_2_.getInt("Seed");
      }

      public static SkyrisFortressPieces.End createPiece(List<StructurePiece> p_175884_0_, Random p_175884_1_, int p_175884_2_, int p_175884_3_, int p_175884_4_, Direction p_175884_5_, int p_175884_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175884_2_, p_175884_3_, p_175884_4_, -1, -3, 0, 5, 10, 8, p_175884_5_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175884_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.End(p_175884_6_, p_175884_1_, mutableboundingbox, p_175884_5_) : null;
      }

      /**
       * (abstract) Helper method to read subclass data from NBT
       */
      protected void readAdditional(CompoundNBT tagCompound) {
         super.readAdditional(tagCompound);
         tagCompound.putInt("Seed", this.fillSeed);
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         Random random = new Random((long)this.fillSeed);

         for(int i = 0; i <= 4; ++i) {
            for(int j = 3; j <= 4; ++j) {
               int k = random.nextInt(8);
               this.fillWithBlocks(p_225577_1_, p_225577_4_, i, j, 0, i, j, k, DACITEBRICKS, DACITEBRICKS, false);
            }
         }

         int l = random.nextInt(8);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 0, 0, 5, l, DACITEBRICKS, DACITEBRICKS, false);
         l = random.nextInt(8);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 5, 0, 4, 5, l, DACITEBRICKS, DACITEBRICKS, false);

         for(int i1 = 0; i1 <= 4; ++i1) {
            int k1 = random.nextInt(5);
            this.fillWithBlocks(p_225577_1_, p_225577_4_, i1, 2, 0, i1, 2, k1, DACITEBRICKS, DACITEBRICKS, false);
         }

         for(int j1 = 0; j1 <= 4; ++j1) {
            for(int l1 = 0; l1 <= 1; ++l1) {
               int i2 = random.nextInt(3);
               this.fillWithBlocks(p_225577_1_, p_225577_4_, j1, l1, 0, j1, l1, i2, DACITEBRICKS, DACITEBRICKS, false);
            }
         }

         return true;
      }
   }

   public static class Entrance extends SkyrisFortressPieces.Piece {
      public Entrance(int p_i45617_1_, Random p_i45617_2_, MutableBoundingBox p_i45617_3_, Direction p_i45617_4_) {
         super(IStructurePieceType.NECE, p_i45617_1_);
         this.setCoordBaseMode(p_i45617_4_);
         this.boundingBox = p_i45617_3_;
      }

      public Entrance(TemplateManager p_i50276_1_, CompoundNBT p_i50276_2_) {
         super(IStructurePieceType.NECE, p_i50276_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((SkyrisFortressPieces.Start)componentIn, listIn, rand, 5, 3, true);
      }

      public static SkyrisFortressPieces.Entrance createPiece(List<StructurePiece> p_175881_0_, Random p_175881_1_, int p_175881_2_, int p_175881_3_, int p_175881_4_, Direction p_175881_5_, int p_175881_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175881_2_, p_175881_3_, p_175881_4_, -5, -3, 0, 13, 14, 13, p_175881_5_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175881_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Entrance(p_175881_6_, p_175881_1_, mutableboundingbox, p_175881_5_) : null;
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 3, 0, 12, 4, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 0, 1, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 11, 5, 0, 12, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 11, 4, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 8, 5, 11, 10, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 9, 11, 7, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 0, 4, 12, 1, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 8, 5, 0, 10, 12, 1, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 9, 0, 7, 12, 1, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 11, 2, 10, 12, 10, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 8, 0, 7, 8, 0, IRONBARS, IRONBARS, false);
         BlockState blockstate = IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true));
         BlockState blockstate1 = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));

         for(int i = 1; i <= 11; i += 2) {
            this.fillWithBlocks(p_225577_1_, p_225577_4_, i, 10, 0, i, 11, 0, blockstate, blockstate, false);
            this.fillWithBlocks(p_225577_1_, p_225577_4_, i, 10, 12, i, 11, 12, blockstate, blockstate, false);
            this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 10, i, 0, 11, i, blockstate1, blockstate1, false);
            this.fillWithBlocks(p_225577_1_, p_225577_4_, 12, 10, i, 12, 11, i, blockstate1, blockstate1, false);
            this.setBlockState(p_225577_1_, DACITEBRICKS, i, 13, 0, p_225577_4_);
            this.setBlockState(p_225577_1_, DACITEBRICKS, i, 13, 12, p_225577_4_);
            this.setBlockState(p_225577_1_, DACITEBRICKS, 0, 13, i, p_225577_4_);
            this.setBlockState(p_225577_1_, DACITEBRICKS, 12, 13, i, p_225577_4_);
            if (i != 11) {
               this.setBlockState(p_225577_1_, blockstate, i + 1, 13, 0, p_225577_4_);
               this.setBlockState(p_225577_1_, blockstate, i + 1, 13, 12, p_225577_4_);
               this.setBlockState(p_225577_1_, blockstate1, 0, 13, i + 1, p_225577_4_);
               this.setBlockState(p_225577_1_, blockstate1, 12, 13, i + 1, p_225577_4_);
            }
         }

         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true)), 0, 13, 0, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.SOUTH, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true)), 0, 13, 12, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.SOUTH, Boolean.valueOf(true)).with(FenceBlock.WEST, Boolean.valueOf(true)), 12, 13, 12, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.WEST, Boolean.valueOf(true)), 12, 13, 0, p_225577_4_);

         for(int k = 3; k <= 9; k += 2) {
            this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 7, k, 1, 8, k, blockstate1.with(FenceBlock.WEST, Boolean.valueOf(true)), blockstate1.with(FenceBlock.WEST, Boolean.valueOf(true)), false);
            this.fillWithBlocks(p_225577_1_, p_225577_4_, 11, 7, k, 11, 8, k, blockstate1.with(FenceBlock.EAST, Boolean.valueOf(true)), blockstate1.with(FenceBlock.EAST, Boolean.valueOf(true)), false);
         }

         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 2, 0, 8, 2, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 4, 12, 2, 8, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 0, 0, 8, 1, 3, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 0, 9, 8, 1, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 0, 4, 3, 1, 8, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 9, 0, 4, 12, 1, 8, DACITEBRICKS, DACITEBRICKS, false);

         for(int l = 4; l <= 8; ++l) {
            for(int j = 0; j <= 2; ++j) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, l, -1, j, p_225577_4_);
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, l, -1, 12 - j, p_225577_4_);
            }
         }

         for(int i1 = 0; i1 <= 2; ++i1) {
            for(int j1 = 4; j1 <= 8; ++j1) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i1, -1, j1, p_225577_4_);
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, 12 - i1, -1, j1, p_225577_4_);
            }
         }

         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 5, 5, 7, 5, 7, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 1, 6, 6, 4, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.setBlockState(p_225577_1_, DACITEBRICKS, 6, 0, 6, p_225577_4_);
         this.setBlockState(p_225577_1_, Blocks.LAVA.getDefaultState(), 6, 5, 6, p_225577_4_);
         BlockPos blockpos = new BlockPos(this.getXWithOffset(6, 6), this.getYWithOffset(5), this.getZWithOffset(6, 6));
         if (p_225577_4_.isVecInside(blockpos)) {
            p_225577_1_.getPendingFluidTicks().scheduleTick(blockpos, Fluids.LAVA, 0);
         }

         return true;
      }
   }

   public static class NetherStalkRoom extends SkyrisFortressPieces.Piece {
      public NetherStalkRoom(int p_i50264_1_, MutableBoundingBox p_i50264_2_, Direction p_i50264_3_) {
         super(IStructurePieceType.NECSR, p_i50264_1_);
         this.setCoordBaseMode(p_i50264_3_);
         this.boundingBox = p_i50264_2_;
      }

      public NetherStalkRoom(TemplateManager p_i50265_1_, CompoundNBT p_i50265_2_) {
         super(IStructurePieceType.NECSR, p_i50265_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((SkyrisFortressPieces.Start)componentIn, listIn, rand, 5, 3, true);
         this.getNextComponentNormal((SkyrisFortressPieces.Start)componentIn, listIn, rand, 5, 11, true);
      }

      public static SkyrisFortressPieces.NetherStalkRoom createPiece(List<StructurePiece> p_175875_0_, int p_175875_1_, int p_175875_2_, int p_175875_3_, Direction p_175875_4_, int p_175875_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175875_1_, p_175875_2_, p_175875_3_, -5, -3, 0, 13, 14, 13, p_175875_4_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175875_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.NetherStalkRoom(p_175875_5_, mutableboundingbox, p_175875_4_) : null;
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 3, 0, 12, 4, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 0, 12, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 0, 1, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 11, 5, 0, 12, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 11, 4, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 8, 5, 11, 10, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 9, 11, 7, 12, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 0, 4, 12, 1, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 8, 5, 0, 10, 12, 1, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 9, 0, 7, 12, 1, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 11, 2, 10, 12, 10, DACITEBRICKS, DACITEBRICKS, false);
         BlockState blockstate = IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true));
         BlockState blockstate1 = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));
         BlockState blockstate2 = blockstate1.with(FenceBlock.WEST, Boolean.valueOf(true));
         BlockState blockstate3 = blockstate1.with(FenceBlock.EAST, Boolean.valueOf(true));

         for(int i = 1; i <= 11; i += 2) {
            this.fillWithBlocks(p_225577_1_, p_225577_4_, i, 10, 0, i, 11, 0, blockstate, blockstate, false);
            this.fillWithBlocks(p_225577_1_, p_225577_4_, i, 10, 12, i, 11, 12, blockstate, blockstate, false);
            this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 10, i, 0, 11, i, blockstate1, blockstate1, false);
            this.fillWithBlocks(p_225577_1_, p_225577_4_, 12, 10, i, 12, 11, i, blockstate1, blockstate1, false);
            this.setBlockState(p_225577_1_, DACITEBRICKS, i, 13, 0, p_225577_4_);
            this.setBlockState(p_225577_1_, DACITEBRICKS, i, 13, 12, p_225577_4_);
            this.setBlockState(p_225577_1_, DACITEBRICKS, 0, 13, i, p_225577_4_);
            this.setBlockState(p_225577_1_, DACITEBRICKS, 12, 13, i, p_225577_4_);
            if (i != 11) {
               this.setBlockState(p_225577_1_, blockstate, i + 1, 13, 0, p_225577_4_);
               this.setBlockState(p_225577_1_, blockstate, i + 1, 13, 12, p_225577_4_);
               this.setBlockState(p_225577_1_, blockstate1, 0, 13, i + 1, p_225577_4_);
               this.setBlockState(p_225577_1_, blockstate1, 12, 13, i + 1, p_225577_4_);
            }
         }

         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true)), 0, 13, 0, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.SOUTH, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true)), 0, 13, 12, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.SOUTH, Boolean.valueOf(true)).with(FenceBlock.WEST, Boolean.valueOf(true)), 12, 13, 12, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.WEST, Boolean.valueOf(true)), 12, 13, 0, p_225577_4_);

         for(int j1 = 3; j1 <= 9; j1 += 2) {
            this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 7, j1, 1, 8, j1, blockstate2, blockstate2, false);
            this.fillWithBlocks(p_225577_1_, p_225577_4_, 11, 7, j1, 11, 8, j1, blockstate3, blockstate3, false);
         }

         BlockState blockstate4 = DACITEBRICKSTAIRS.with(StairsBlock.FACING, Direction.NORTH);

         for(int j = 0; j <= 6; ++j) {
            int k = j + 4;

            for(int l = 5; l <= 7; ++l) {
               this.setBlockState(p_225577_1_, blockstate4, l, 5 + j, k, p_225577_4_);
            }

            if (k >= 5 && k <= 8) {
               this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 5, k, 7, j + 4, k, DACITEBRICKS, DACITEBRICKS, false);
            } else if (k >= 9 && k <= 10) {
               this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 8, k, 7, j + 4, k, DACITEBRICKS, DACITEBRICKS, false);
            }

            if (j >= 1) {
               this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 6 + j, k, 7, 9 + j, k, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }
         }

         for(int k1 = 5; k1 <= 7; ++k1) {
            this.setBlockState(p_225577_1_, blockstate4, k1, 12, 11, p_225577_4_);
         }

         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 6, 7, 5, 7, 7, blockstate3, blockstate3, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 7, 6, 7, 7, 7, 7, blockstate2, blockstate2, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 13, 12, 7, 13, 12, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 2, 3, 5, 3, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 9, 3, 5, 10, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 4, 2, 5, 8, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 9, 5, 2, 10, 5, 3, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 9, 5, 9, 10, 5, 10, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 10, 5, 4, 10, 5, 8, DACITEBRICKS, DACITEBRICKS, false);
         BlockState blockstate5 = blockstate4.with(StairsBlock.FACING, Direction.EAST);
         BlockState blockstate6 = blockstate4.with(StairsBlock.FACING, Direction.WEST);
         this.setBlockState(p_225577_1_, blockstate6, 4, 5, 2, p_225577_4_);
         this.setBlockState(p_225577_1_, blockstate6, 4, 5, 3, p_225577_4_);
         this.setBlockState(p_225577_1_, blockstate6, 4, 5, 9, p_225577_4_);
         this.setBlockState(p_225577_1_, blockstate6, 4, 5, 10, p_225577_4_);
         this.setBlockState(p_225577_1_, blockstate5, 8, 5, 2, p_225577_4_);
         this.setBlockState(p_225577_1_, blockstate5, 8, 5, 3, p_225577_4_);
         this.setBlockState(p_225577_1_, blockstate5, 8, 5, 9, p_225577_4_);
         this.setBlockState(p_225577_1_, blockstate5, 8, 5, 10, p_225577_4_);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 3, 4, 4, 4, 4, 8, Blocks.LAVA.getDefaultState(), Blocks.LAVA.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 8, 4, 4, 9, 4, 8, Blocks.LAVA.getDefaultState(), Blocks.LAVA.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 3, 5, 4, 4, 5, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 8, 5, 4, 9, 5, 8, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 2, 0, 8, 2, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 4, 12, 2, 8, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 0, 0, 8, 1, 3, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 0, 9, 8, 1, 12, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 0, 4, 3, 1, 8, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 9, 0, 4, 12, 1, 8, DACITEBRICKS, DACITEBRICKS, false);

         for(int l1 = 4; l1 <= 8; ++l1) {
            for(int i1 = 0; i1 <= 2; ++i1) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, l1, -1, i1, p_225577_4_);
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, l1, -1, 12 - i1, p_225577_4_);
            }
         }

         for(int i2 = 0; i2 <= 2; ++i2) {
            for(int j2 = 4; j2 <= 8; ++j2) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i2, -1, j2, p_225577_4_);
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, 12 - i2, -1, j2, p_225577_4_);
            }
         }

         return true;
      }
   }

   abstract static class Piece extends StructurePiece {
      protected Piece(IStructurePieceType p_i50260_1_, int p_i50260_2_) {
         super(p_i50260_1_, p_i50260_2_);
      }

      public Piece(IStructurePieceType p_i50261_1_, CompoundNBT p_i50261_2_) {
         super(p_i50261_1_, p_i50261_2_);
      }

      /**
       * (abstract) Helper method to read subclass data from NBT
       */
      protected void readAdditional(CompoundNBT tagCompound) {
      }

      private int getTotalWeight(List<SkyrisFortressPieces.PieceWeight> p_74960_1_) {
         boolean flag = false;
         int i = 0;

         for(SkyrisFortressPieces.PieceWeight fortresspieces$pieceweight : p_74960_1_) {
            if (fortresspieces$pieceweight.maxPlaceCount > 0 && fortresspieces$pieceweight.placeCount < fortresspieces$pieceweight.maxPlaceCount) {
               flag = true;
            }

            i += fortresspieces$pieceweight.weight;
         }

         return flag ? i : -1;
      }

      private SkyrisFortressPieces.Piece generatePiece(SkyrisFortressPieces.Start p_175871_1_, List<SkyrisFortressPieces.PieceWeight> p_175871_2_, List<StructurePiece> p_175871_3_, Random p_175871_4_, int p_175871_5_, int p_175871_6_, int p_175871_7_, Direction p_175871_8_, int p_175871_9_) {
         int i = this.getTotalWeight(p_175871_2_);
         boolean flag = i > 0 && p_175871_9_ <= 30;
         int j = 0;

         while(j < 5 && flag) {
            ++j;
            int k = p_175871_4_.nextInt(i);

            for(SkyrisFortressPieces.PieceWeight fortresspieces$pieceweight : p_175871_2_) {
               k -= fortresspieces$pieceweight.weight;
               if (k < 0) {
                  if (!fortresspieces$pieceweight.doPlace(p_175871_9_) || fortresspieces$pieceweight == p_175871_1_.lastPlaced && !fortresspieces$pieceweight.allowInRow) {
                     break;
                  }

                  SkyrisFortressPieces.Piece fortresspieces$piece = SkyrisFortressPieces.findAndCreateBridgePieceFactory(fortresspieces$pieceweight, p_175871_3_, p_175871_4_, p_175871_5_, p_175871_6_, p_175871_7_, p_175871_8_, p_175871_9_);
                  if (fortresspieces$piece != null) {
                     ++fortresspieces$pieceweight.placeCount;
                     p_175871_1_.lastPlaced = fortresspieces$pieceweight;
                     if (!fortresspieces$pieceweight.isValid()) {
                        p_175871_2_.remove(fortresspieces$pieceweight);
                     }

                     return fortresspieces$piece;
                  }
               }
            }
         }

         return SkyrisFortressPieces.End.createPiece(p_175871_3_, p_175871_4_, p_175871_5_, p_175871_6_, p_175871_7_, p_175871_8_, p_175871_9_);
      }

      private StructurePiece generateAndAddPiece(SkyrisFortressPieces.Start p_175870_1_, List<StructurePiece> p_175870_2_, Random p_175870_3_, int p_175870_4_, int p_175870_5_, int p_175870_6_, @Nullable Direction p_175870_7_, int p_175870_8_, boolean p_175870_9_) {
         if (Math.abs(p_175870_4_ - p_175870_1_.getBoundingBox().minX) <= 112 && Math.abs(p_175870_6_ - p_175870_1_.getBoundingBox().minZ) <= 112) {
            List<SkyrisFortressPieces.PieceWeight> list = p_175870_1_.primaryWeights;
            if (p_175870_9_) {
               list = p_175870_1_.secondaryWeights;
            }

            StructurePiece structurepiece = this.generatePiece(p_175870_1_, list, p_175870_2_, p_175870_3_, p_175870_4_, p_175870_5_, p_175870_6_, p_175870_7_, p_175870_8_ + 1);
            if (structurepiece != null) {
               p_175870_2_.add(structurepiece);
               p_175870_1_.pendingChildren.add(structurepiece);
            }

            return structurepiece;
         } else {
            return SkyrisFortressPieces.End.createPiece(p_175870_2_, p_175870_3_, p_175870_4_, p_175870_5_, p_175870_6_, p_175870_7_, p_175870_8_);
         }
      }

      /**
       * Gets the next component in any cardinal direction
       */
      @Nullable
      protected StructurePiece getNextComponentNormal(SkyrisFortressPieces.Start p_74963_1_, List<StructurePiece> p_74963_2_, Random p_74963_3_, int p_74963_4_, int p_74963_5_, boolean p_74963_6_) {
         Direction direction = this.getCoordBaseMode();
         if (direction != null) {
            switch(direction) {
            case NORTH:
               return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ - 1, direction, this.getComponentType(), p_74963_6_);
            case SOUTH:
               return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX + p_74963_4_, this.boundingBox.minY + p_74963_5_, this.boundingBox.maxZ + 1, direction, this.getComponentType(), p_74963_6_);
            case WEST:
               return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, direction, this.getComponentType(), p_74963_6_);
            case EAST:
               return this.generateAndAddPiece(p_74963_1_, p_74963_2_, p_74963_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74963_5_, this.boundingBox.minZ + p_74963_4_, direction, this.getComponentType(), p_74963_6_);
            }
         }

         return null;
      }

      /**
       * Gets the next component in the +/- X direction
       */
      @Nullable
      protected StructurePiece getNextComponentX(SkyrisFortressPieces.Start p_74961_1_, List<StructurePiece> p_74961_2_, Random p_74961_3_, int p_74961_4_, int p_74961_5_, boolean p_74961_6_) {
         Direction direction = this.getCoordBaseMode();
         if (direction != null) {
            switch(direction) {
            case NORTH:
               return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, Direction.WEST, this.getComponentType(), p_74961_6_);
            case SOUTH:
               return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX - 1, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ + p_74961_5_, Direction.WEST, this.getComponentType(), p_74961_6_);
            case WEST:
               return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, Direction.NORTH, this.getComponentType(), p_74961_6_);
            case EAST:
               return this.generateAndAddPiece(p_74961_1_, p_74961_2_, p_74961_3_, this.boundingBox.minX + p_74961_5_, this.boundingBox.minY + p_74961_4_, this.boundingBox.minZ - 1, Direction.NORTH, this.getComponentType(), p_74961_6_);
            }
         }

         return null;
      }

      /**
       * Gets the next component in the +/- Z direction
       */
      @Nullable
      protected StructurePiece getNextComponentZ(SkyrisFortressPieces.Start p_74965_1_, List<StructurePiece> p_74965_2_, Random p_74965_3_, int p_74965_4_, int p_74965_5_, boolean p_74965_6_) {
         Direction direction = this.getCoordBaseMode();
         if (direction != null) {
            switch(direction) {
            case NORTH:
               return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, Direction.EAST, this.getComponentType(), p_74965_6_);
            case SOUTH:
               return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.maxX + 1, this.boundingBox.minY + p_74965_4_, this.boundingBox.minZ + p_74965_5_, Direction.EAST, this.getComponentType(), p_74965_6_);
            case WEST:
               return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, Direction.SOUTH, this.getComponentType(), p_74965_6_);
            case EAST:
               return this.generateAndAddPiece(p_74965_1_, p_74965_2_, p_74965_3_, this.boundingBox.minX + p_74965_5_, this.boundingBox.minY + p_74965_4_, this.boundingBox.maxZ + 1, Direction.SOUTH, this.getComponentType(), p_74965_6_);
            }
         }

         return null;
      }

      /**
       * Checks if the bounding box's minY is > 10
       */
      protected static boolean isAboveGround(MutableBoundingBox p_74964_0_) {
         return p_74964_0_ != null && p_74964_0_.minY > 10;
      }
   }

   static class PieceWeight {
      public final Class<? extends SkyrisFortressPieces.Piece> weightClass;
      public final int weight;
      public int placeCount;
      public final int maxPlaceCount;
      public final boolean allowInRow;

      public PieceWeight(Class<? extends SkyrisFortressPieces.Piece> p_i2055_1_, int p_i2055_2_, int p_i2055_3_, boolean p_i2055_4_) {
         this.weightClass = p_i2055_1_;
         this.weight = p_i2055_2_;
         this.maxPlaceCount = p_i2055_3_;
         this.allowInRow = p_i2055_4_;
      }

      public PieceWeight(Class<? extends SkyrisFortressPieces.Piece> p_i2056_1_, int p_i2056_2_, int p_i2056_3_) {
         this(p_i2056_1_, p_i2056_2_, p_i2056_3_, false);
      }

      public boolean doPlace(int p_78822_1_) {
         return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
      }

      public boolean isValid() {
         return this.maxPlaceCount == 0 || this.placeCount < this.maxPlaceCount;
      }
   }

   public static class Stairs extends SkyrisFortressPieces.Piece {
      public Stairs(int p_i50255_1_, MutableBoundingBox p_i50255_2_, Direction p_i50255_3_) {
         super(IStructurePieceType.NESR, p_i50255_1_);
         this.setCoordBaseMode(p_i50255_3_);
         this.boundingBox = p_i50255_2_;
      }

      public Stairs(TemplateManager p_i50256_1_, CompoundNBT p_i50256_2_) {
         super(IStructurePieceType.NESR, p_i50256_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentZ((SkyrisFortressPieces.Start)componentIn, listIn, rand, 6, 2, false);
      }

      public static SkyrisFortressPieces.Stairs createPiece(List<StructurePiece> p_175872_0_, int p_175872_1_, int p_175872_2_, int p_175872_3_, int p_175872_4_, Direction p_175872_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175872_1_, p_175872_2_, p_175872_3_, -2, 0, 0, 7, 11, 7, p_175872_5_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175872_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Stairs(p_175872_4_, mutableboundingbox, p_175872_5_) : null;
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 0, 0, 6, 1, 6, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 6, 10, 6, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 1, 8, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 2, 0, 6, 8, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 1, 0, 8, 6, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 2, 1, 6, 8, 6, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 2, 6, 5, 8, 6, DACITEBRICKS, DACITEBRICKS, false);
         BlockState blockstate = IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true));
         BlockState blockstate1 = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 3, 2, 0, 5, 4, blockstate1, blockstate1, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 3, 2, 6, 5, 2, blockstate1, blockstate1, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 3, 4, 6, 5, 4, blockstate1, blockstate1, false);
         this.setBlockState(p_225577_1_, DACITEBRICKS, 5, 2, 5, p_225577_4_);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 2, 5, 4, 3, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 3, 2, 5, 3, 4, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 2, 5, 2, 5, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 2, 5, 1, 6, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 7, 1, 5, 7, 4, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 8, 2, 6, 8, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 6, 0, 4, 8, 0, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 5, 0, 4, 5, 0, blockstate, blockstate, false);

         for(int i = 0; i <= 6; ++i) {
            for(int j = 0; j <= 6; ++j) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i, -1, j, p_225577_4_);
            }
         }

         return true;
      }
   }

   public static class Start extends SkyrisFortressPieces.Crossing3 {
      public SkyrisFortressPieces.PieceWeight lastPlaced;
      public List<SkyrisFortressPieces.PieceWeight> primaryWeights;
      public List<SkyrisFortressPieces.PieceWeight> secondaryWeights;
      public final List<StructurePiece> pendingChildren = Lists.newArrayList();

      public Start(Random p_i2059_1_, int p_i2059_2_, int p_i2059_3_) {
         super(p_i2059_1_, p_i2059_2_, p_i2059_3_);
         this.primaryWeights = Lists.newArrayList();

         for(SkyrisFortressPieces.PieceWeight fortresspieces$pieceweight : SkyrisFortressPieces.PRIMARY_COMPONENTS) {
            fortresspieces$pieceweight.placeCount = 0;
            this.primaryWeights.add(fortresspieces$pieceweight);
         }

         this.secondaryWeights = Lists.newArrayList();

         for(SkyrisFortressPieces.PieceWeight fortresspieces$pieceweight1 : SkyrisFortressPieces.SECONDARY_COMPONENTS) {
            fortresspieces$pieceweight1.placeCount = 0;
            this.secondaryWeights.add(fortresspieces$pieceweight1);
         }

      }

      public Start(TemplateManager p_i50253_1_, CompoundNBT p_i50253_2_) {
         super(IStructurePieceType.NESTART, p_i50253_2_);
      }
   }

   public static class Straight extends SkyrisFortressPieces.Piece {
      public Straight(int p_i45620_1_, Random p_i45620_2_, MutableBoundingBox p_i45620_3_, Direction p_i45620_4_) {
         super(IStructurePieceType.NEBS, p_i45620_1_);
         this.setCoordBaseMode(p_i45620_4_);
         this.boundingBox = p_i45620_3_;
      }

      public Straight(TemplateManager p_i50283_1_, CompoundNBT p_i50283_2_) {
         super(IStructurePieceType.NEBS, p_i50283_2_);
      }

      /**
       * Initiates construction of the Structure Component picked, at the current Location of StructGen
       */
      public void buildComponent(StructurePiece componentIn, List<StructurePiece> listIn, Random rand) {
         this.getNextComponentNormal((SkyrisFortressPieces.Start)componentIn, listIn, rand, 1, 3, false);
      }

      public static SkyrisFortressPieces.Straight createPiece(List<StructurePiece> p_175882_0_, Random p_175882_1_, int p_175882_2_, int p_175882_3_, int p_175882_4_, Direction p_175882_5_, int p_175882_6_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175882_2_, p_175882_3_, p_175882_4_, -1, -3, 0, 5, 10, 19, p_175882_5_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175882_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Straight(p_175882_6_, p_175882_1_, mutableboundingbox, p_175882_5_) : null;
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 3, 0, 4, 4, 18, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 5, 0, 3, 7, 18, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 0, 0, 5, 18, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 5, 0, 4, 5, 18, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 4, 2, 5, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 13, 4, 2, 18, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 0, 0, 4, 1, 3, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 0, 15, 4, 1, 18, DACITEBRICKS, DACITEBRICKS, false);

         for(int i = 0; i <= 4; ++i) {
            for(int j = 0; j <= 2; ++j) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i, -1, j, p_225577_4_);
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i, -1, 18 - j, p_225577_4_);
            }
         }

         BlockState blockstate1 = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));
         BlockState blockstate2 = blockstate1.with(FenceBlock.EAST, Boolean.valueOf(true));
         BlockState blockstate = blockstate1.with(FenceBlock.WEST, Boolean.valueOf(true));
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 1, 1, 0, 4, 1, blockstate2, blockstate2, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 3, 4, 0, 4, 4, blockstate2, blockstate2, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 3, 14, 0, 4, 14, blockstate2, blockstate2, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 1, 17, 0, 4, 17, blockstate2, blockstate2, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 1, 1, 4, 4, 1, blockstate, blockstate, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 3, 4, 4, 4, 4, blockstate, blockstate, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 3, 14, 4, 4, 14, blockstate, blockstate, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 4, 1, 17, 4, 4, 17, blockstate, blockstate, false);
         return true;
      }
   }

   public static class Throne extends SkyrisFortressPieces.Piece {
      private boolean hasSpawner;

      public Throne(int p_i50262_1_, MutableBoundingBox p_i50262_2_, Direction p_i50262_3_) {
         super(IStructurePieceType.NEMT, p_i50262_1_);
         this.setCoordBaseMode(p_i50262_3_);
         this.boundingBox = p_i50262_2_;
      }

      public Throne(TemplateManager p_i50263_1_, CompoundNBT p_i50263_2_) {
         super(IStructurePieceType.NEMT, p_i50263_2_);
         this.hasSpawner = p_i50263_2_.getBoolean("Mob");
      }

      /**
       * (abstract) Helper method to read subclass data from NBT
       */
      protected void readAdditional(CompoundNBT tagCompound) {
         super.readAdditional(tagCompound);
         tagCompound.putBoolean("Mob", this.hasSpawner);
      }

      public static SkyrisFortressPieces.Throne createPiece(List<StructurePiece> p_175874_0_, int p_175874_1_, int p_175874_2_, int p_175874_3_, int p_175874_4_, Direction p_175874_5_) {
         MutableBoundingBox mutableboundingbox = MutableBoundingBox.getComponentToAddBoundingBox(p_175874_1_, p_175874_2_, p_175874_3_, -2, 0, 0, 7, 8, 9, p_175874_5_);
         return isAboveGround(mutableboundingbox) && StructurePiece.findIntersecting(p_175874_0_, mutableboundingbox) == null ? new SkyrisFortressPieces.Throne(p_175874_4_, mutableboundingbox, p_175874_5_) : null;
      }

      public boolean create(IWorld p_225577_1_, ChunkGenerator<?> p_225577_2_, Random p_225577_3_, MutableBoundingBox p_225577_4_, ChunkPos p_225577_5_) {
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 2, 0, 6, 7, 7, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 0, 0, 5, 1, 7, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 2, 1, 5, 2, 7, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 3, 2, 5, 3, 7, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 4, 3, 5, 4, 7, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 2, 0, 1, 4, 2, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 2, 0, 5, 4, 2, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 5, 2, 1, 5, 3, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 5, 5, 2, 5, 5, 3, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 5, 3, 0, 5, 8, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 5, 3, 6, 5, 8, DACITEBRICKS, DACITEBRICKS, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 5, 8, 5, 5, 8, DACITEBRICKS, DACITEBRICKS, false);
         BlockState blockstate = IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.EAST, Boolean.valueOf(true));
         BlockState blockstate1 = IRONBARS.with(FenceBlock.NORTH, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true));
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)), 1, 6, 3, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.EAST, Boolean.valueOf(true)), 5, 6, 3, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.EAST, Boolean.valueOf(true)).with(FenceBlock.NORTH, Boolean.valueOf(true)), 0, 6, 3, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.NORTH, Boolean.valueOf(true)), 6, 6, 3, p_225577_4_);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 0, 6, 4, 0, 6, 7, blockstate1, blockstate1, false);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 6, 6, 4, 6, 6, 7, blockstate1, blockstate1, false);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.EAST, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true)), 0, 6, 8, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)).with(FenceBlock.SOUTH, Boolean.valueOf(true)), 6, 6, 8, p_225577_4_);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 1, 6, 8, 5, 6, 8, blockstate, blockstate, false);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.EAST, Boolean.valueOf(true)), 1, 7, 8, p_225577_4_);
         this.fillWithBlocks(p_225577_1_, p_225577_4_, 2, 7, 8, 4, 7, 8, blockstate, blockstate, false);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)), 5, 7, 8, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.EAST, Boolean.valueOf(true)), 2, 8, 8, p_225577_4_);
         this.setBlockState(p_225577_1_, blockstate, 3, 8, 8, p_225577_4_);
         this.setBlockState(p_225577_1_, IRONBARS.with(FenceBlock.WEST, Boolean.valueOf(true)), 4, 8, 8, p_225577_4_);
         if (!this.hasSpawner) {
            BlockPos blockpos = new BlockPos(this.getXWithOffset(3, 5), this.getYWithOffset(5), this.getZWithOffset(3, 5));
            if (p_225577_4_.isVecInside(blockpos)) {
               this.hasSpawner = true;
               p_225577_1_.setBlockState(blockpos, Blocks.SPAWNER.getDefaultState(), 2);
               TileEntity tileentity = p_225577_1_.getTileEntity(blockpos);
               if (tileentity instanceof MobSpawnerTileEntity) {
                  ((MobSpawnerTileEntity)tileentity).getSpawnerBaseLogic().setEntityType(EntityType.VEX);
               }
            }
         }

         for(int i = 0; i <= 6; ++i) {
            for(int j = 0; j <= 6; ++j) {
               this.replaceAirAndLiquidDownwards(p_225577_1_, DACITEBRICKS, i, -1, j, p_225577_4_);
            }
         }

         return true;
      }
   }
}