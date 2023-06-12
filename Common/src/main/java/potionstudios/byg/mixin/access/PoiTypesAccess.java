package potionstudios.byg.mixin.access;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Set;

@Mixin(PoiTypes.class)
public interface PoiTypesAccess {

    @Invoker("getBlockStates")
    static Set<BlockState> byg_invokeGetBlockStates(Block block) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("register")
    static PoiType byg_invokeRegister(Registry<PoiType> $$0, ResourceKey<PoiType> $$1, Set<BlockState> $$2, int $$3, int $$4) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("registerBlockStates")
    static void byg_invokeRegisterBlockStates(Holder<PoiType> $$0, Set<BlockState> $$1) {
        throw new Error("Mixin did not apply!");
    }
}
