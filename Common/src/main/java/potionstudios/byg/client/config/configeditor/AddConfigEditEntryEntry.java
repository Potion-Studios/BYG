package potionstudios.byg.client.config.configeditor;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import potionstudios.byg.client.config.serializers.ConfigEntriesSerializer;

import java.util.List;
import java.util.function.BiFunction;

public class AddConfigEditEntryEntry extends ConfigEditEntry<ConfigEntriesSerializer<?>> {

    private final ConfigEditScreen.ConfigMap<?> map;
    private final EditBox entryKey;
    private final EditBox entryValue;
    private final Button addEntry;
    private final Button makeEntry;

    public AddConfigEditEntryEntry(Screen parent, ConfigEditScreen.ConfigMap<?> map, BiFunction<String, String, ConfigEditEntry<?>> toBuild, String key) {
        super(parent, key, "Type \"list\" to make a list\nType \"map\" to make a map.");
        this.map = map;
        this.entryKey = new EditBox(Minecraft.getInstance().font, 0, 0, 150, 20, new TextComponent("Key"));
        this.entryKey.visible = false;
        this.entryKey.active = false;

        this.entryValue = new EditBox(Minecraft.getInstance().font, 0, 0, 200, 20, new TextComponent("Value"));
        this.entryValue.visible = false;
        this.entryValue.active = false;
        Mutable<Button> getAddEntry = new MutableObject<>(null);

        this.makeEntry = new Button(0, 0, 50, 20, new TranslatableComponent("Make"), button -> {
            this.entryKey.visible = false;
            this.entryKey.active = false;
            this.entryValue.visible = false;
            this.entryValue.active = false;
            getAddEntry.getValue().visible = true;
            getAddEntry.getValue().active = true;

            List children = map.children();
            children.remove(this);


            children.add(toBuild.apply(this.entryKey.getValue(), this.entryValue.getValue()));
            children.add(this);
            this.entryKey.setValue("");
            this.entryValue.setValue("");
            button.visible = false;
        });
        this.makeEntry.visible = false;
        this.makeEntry.active = false;

        this.addEntry = new Button(0, 0, 200, 20, new TranslatableComponent("Add Entry"), button -> {
            button.active = false;
            button.visible = false;
            this.entryKey.visible = true;
            this.entryKey.active = true;
            this.entryValue.visible = true;
            this.entryValue.active = true;
            this.makeEntry.visible = true;
            this.makeEntry.active = !this.entryKey.getValue().isBlank() && !this.entryValue.getValue().isBlank();
        });
        getAddEntry.setValue(this.addEntry);
        this.entryKey.setResponder(s ->  {
            if (s.isBlank()) {
                this.makeEntry.active = false;
            } else {
                this.makeEntry.active = !this.entryValue.getValue().isBlank();
            }
        });

        this.entryValue.setResponder(s ->  {
            if (s.isBlank()) {
                this.makeEntry.active = false;
            } else {
                this.makeEntry.active = !this.entryKey.getValue().isBlank();
            }
        });
    }

    @Override
    public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
        float x = (float) ((pLeft) - (this.getRowWidth())) + pWidth;
        float y = (float) (pTop + pHeight / 2 - 9 / 2);

        this.keyScreenPosition.x = x;
        this.keyScreenPosition.y = y;

        this.addEntry.x = (int) this.keyScreenPosition.x + this.entryKey.getWidth() + 10;
        this.addEntry.y = (int) this.keyScreenPosition.y;
        this.addEntry.render(pPoseStack, pMouseX, pMouseY, pPartialTick);


        this.entryKey.x = (int) this.keyScreenPosition.x;
        this.entryKey.y = (int) this.keyScreenPosition.y;
        this.entryKey.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        this.entryValue.x = this.entryKey.x + this.entryKey.getWidth() + 10;
        this.entryValue.y = this.entryKey.y;
        this.entryValue.render(pPoseStack, pMouseX, pMouseY, pPartialTick);

        this.makeEntry.x = this.entryValue.x + this.entryValue.getWidth() + 10;
        this.makeEntry.y = this.entryValue.y;
        this.makeEntry.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public List<? extends NarratableEntry> narratables() {
        return ImmutableList.of(this.entryValue, this.entryKey, this.makeEntry, this.addEntry);
    }

    @Override
    public List<? extends GuiEventListener> children() {
        return ImmutableList.of(this.entryValue, this.entryKey, this.makeEntry, this.addEntry);
    }

    @Override
    public int getRowWidth() {
        return this.entryKey.getWidth() + this.entryValue.getWidth() + this.makeEntry.getWidth() + 10 + 10;
    }

    @Override
    public void tick() {
        super.tick();
        this.entryKey.tick();
        this.entryValue.tick();
    }
}
