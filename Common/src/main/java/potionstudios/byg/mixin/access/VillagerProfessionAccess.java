package potionstudios.byg.mixin.access;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import javax.annotation.Nullable;

@Mixin(VillagerProfession.class)
public interface VillagerProfessionAccess {

    @Invoker("<init>")
    static VillagerProfession byg_invokeCreate(String name, PoiType jobPoiType, ImmutableSet<Item> requestedItems, ImmutableSet<Block> secondaryPoi, @Nullable SoundEvent workSound) {
        throw new Error("Mixin did not apply!");
    }
}
