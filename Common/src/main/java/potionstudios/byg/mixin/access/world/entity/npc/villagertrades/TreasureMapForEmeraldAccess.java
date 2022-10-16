package potionstudios.byg.mixin.access.world.entity.npc.villagertrades;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VillagerTrades.TreasureMapForEmeralds.class)
public interface TreasureMapForEmeraldAccess {

    @Accessor("emeraldCost")
    int byg_getEmeraldCost();

    @Accessor("destination")
    TagKey<Structure> byg_getDestination();

    @Accessor("displayName")
    String byg_getDisplayName();

    @Accessor("destinationType")
    MapDecoration.Type byg_getDestinationType();

    @Accessor("maxUses")
    int byg_getMaxUses();

    @Accessor("villagerXp")
    int byg_getVillagerXp();
}
