package potionstudios.byg.mixin.access;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Set;
import java.util.function.Predicate;

@Mixin(PoiType.class)
public interface PoiTypeAccess {

    @Invoker("<init>")
    static PoiType byg_invokeCreate(String name, Set<BlockState> matchingStates, int maxTickets, Predicate<PoiType> predicate, int validRange) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("<init>")
    static PoiType byg_invokeCreate(String name, Set<BlockState> matchingStates, int maxTickets, int validRange) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("getBlockStates")
    static Set<BlockState> byg_invokeGetBlockStates(Block block) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("registerBlockStates")
    static PoiType byg_invokeRegisterBlockStates(PoiType poiType) {
        throw new Error("Mixin did not apply!");
    }
}
