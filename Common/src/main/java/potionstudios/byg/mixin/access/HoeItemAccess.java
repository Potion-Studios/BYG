package potionstudios.byg.mixin.access;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Mixin(HoeItem.class)
public interface HoeItemAccess {

    @Invoker("<init>")
    static HoeItem byg_create(Tier tier, int i, float f, Item.Properties properties) {
        throw new Error("Mixin did not apply");
    }

    @Accessor("TILLABLES")
    static Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> byg_getTILLABLES() {
        throw new Error("Mixin did not apply");
    }

    @Accessor("TILLABLES")
    @Mutable
    static void byg_setTILLABLES(Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> newMap) {
        throw new Error("Mixin did not apply");
    }
}
