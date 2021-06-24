package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.entity.tileentities.BYGCampfireTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BYGTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(
            ForgeRegistries.TILE_ENTITIES, BYG.MOD_ID);

    public static final RegistryObject<TileEntityType<BYGCampfireTE>> BYGCAMPFIRE = TILE_ENTITY_TYPES
            .register("bygcampfire", () -> TileEntityType.Builder
                    .of(BYGCampfireTE::new, BYGBlocks.BORIC_CAMPFIRE, BYGBlocks.CRYPTIC_CAMPFIRE).build(null));

}