package corgiaoc.byg.mixin;

import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.mixin.access.TileEntityTypeBuilderAccess;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(TileEntityType.class)
public class MixinTileEntityType {

    @Inject(method = "register", at = @At("HEAD"))
    private static <T extends TileEntity> void addCampFireBlocks(String id, TileEntityType.Builder<T> builder, CallbackInfoReturnable<TileEntityType<T>> cir) {

        if (id.equals("campfire")) {
            TileEntityTypeBuilderAccess builderAccess = (TileEntityTypeBuilderAccess) (Object) builder;
            Set<Block> validBlocks = new ObjectOpenHashSet<>(builderAccess.getValidBlocks());
            validBlocks.add(BYGBlocks.CRYPTIC_CAMPFIRE);
            validBlocks.add(BYGBlocks.BORIC_CAMPFIRE);
            builderAccess.setValidBlocks(validBlocks);
        }
    }
}
