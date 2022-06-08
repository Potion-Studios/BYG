package potionstudios.byg.mixin.access;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(StructureTemplatePool.class)
public interface StructureTemplatePoolAccess {

    @Accessor("templates")
    ObjectArrayList<StructurePoolElement> byg_getTemplates();

    @Accessor("rawTemplates")
    List<Pair<StructurePoolElement, Integer>> byg_getRawTemplates();

    @Mutable
    @Accessor("rawTemplates")
    void byg_setRawTemplates(List<Pair<StructurePoolElement, Integer>> rawTemplates);
}