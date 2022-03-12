package potionstudios.byg.mixin.access;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(StructureTemplate.class)
public interface StructureTemplateAccess {

    @Accessor("palettes")
    List<StructureTemplate.Palette> byg_getPalettes();
}
