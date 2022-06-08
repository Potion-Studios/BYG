package potionstudios.byg.mixin.access;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import javax.annotation.Nullable;
import java.util.function.Predicate;

@Mixin(VillagerProfession.class)
public interface VillagerProfessionAccess {

    @Invoker("<init>")
    static VillagerProfession byg_invokeCreate(String $$0, Predicate<Holder<PoiType>> $$1, Predicate<Holder<PoiType>> $$2, ImmutableSet<Item> $$3, ImmutableSet<Block> $$4, @Nullable SoundEvent $$5) {
        throw new Error("Mixin did not apply!");
    }

    @Invoker("register")
    static VillagerProfession byg_invokeRegister(String $$0, ResourceKey<PoiType> $$1, @Nullable SoundEvent $$2) {
        throw new Error("Mixin did not apply!");

    }
}
