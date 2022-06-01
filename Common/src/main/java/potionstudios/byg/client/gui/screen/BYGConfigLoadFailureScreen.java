package potionstudios.byg.client.gui.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.FastColor;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.client.KillClient;
import potionstudios.byg.client.gui.biomepedia.widget.ScrollableText;
import potionstudios.byg.config.ConfigVersionTracker;
import potionstudios.byg.mixin.access.client.ScreenAccess;
import potionstudios.byg.server.command.UpdateConfigsCommand;
import potionstudios.byg.util.ModPlatform;

import java.io.PrintWriter;
import java.io.StringWriter;

public class BYGConfigLoadFailureScreen extends Screen {

    private static final Component VALIDATE_CONFIGS_MESSAGE = new TranslatableComponent("byg.screen.configloadfail.validate");
    private static final Component VALIDATE_CONFIGS_HOVER = new TranslatableComponent("byg.screen.configloadfail.validate.hover");
    private static final Component OPEN_CONFIG_DIR_MESSAGE = new TranslatableComponent("byg.screen.configloadfail.openconfigdir");
    private static final Component OPEN_CONFIG_DIR_HOVER = new TranslatableComponent("byg.screen.configloadfail.openconfigdir.hover");
    private static final Component RECREATE_CONFIGS_MESSAGE = new TranslatableComponent("byg.screen.configloadfail.recreateconfigs");
    private static final Component RECREATE_CONFIGS_HOVER = new TranslatableComponent("byg.screen.configloadfail.recreateconfigs.hover");
    private static final Component RECREATE_CONFIGS_TITLE = new TranslatableComponent("byg.screen.configloadfail.title");

    private final Exception exception;
    private final Runnable runnable;
    private int errorBoxTop;


    public BYGConfigLoadFailureScreen(Exception exception, Runnable runnable) {
        super(RECREATE_CONFIGS_TITLE);
        this.exception = exception;
        this.runnable = runnable;
    }

    @Override
    protected void init() {
        super.init();
        this.errorBoxTop = this.height / 4 - 25;
        int errorBoxLength = (int) Math.ceil(this.width / 1.3);

        StringWriter stringWriter = new StringWriter();
        this.exception.printStackTrace(new PrintWriter(stringWriter));

        int errorBoxBottom = errorBoxTop + (this.height / 2);
        ScrollableText text = new ScrollableText(new TextComponent("\n" + stringWriter.toString()), errorBoxLength, errorBoxTop, errorBoxTop, errorBoxBottom, FastColor.ARGB32.color(255, 255, 255, 255), true, true);
        text.setLeftPos(this.width / 2 - (errorBoxLength / 2));
        this.addRenderableWidget(text);

        int buttonWidth = (int) Math.ceil(errorBoxLength / 3.5);
        int buttonHeight = 20;
        int buttonY = errorBoxBottom + 10 + (buttonHeight / 2);
        Button validateConfigs = new Button((errorBoxLength / 3) - buttonWidth / 2, buttonY, buttonWidth, buttonHeight, VALIDATE_CONFIGS_MESSAGE,
                button -> this.runnable.run(), (button, poseStack, mouseX, mouseZ) -> renderTooltip(poseStack, VALIDATE_CONFIGS_HOVER, mouseX, mouseZ)
        );

        this.addRenderableWidget(new Button(((errorBoxLength / 3) * 2) - buttonWidth / 2, buttonY, buttonWidth, buttonHeight, OPEN_CONFIG_DIR_MESSAGE,
                button -> ((ScreenAccess) this).byg_invokeOpenLink(ModPlatform.INSTANCE.configPath().toUri()),
                (button, poseStack, mouseX, mouseZ) -> renderTooltip(poseStack, OPEN_CONFIG_DIR_HOVER, mouseX, mouseZ)
        ));

        this.addRenderableWidget(new Button(errorBoxLength - (buttonWidth / 2), buttonY, buttonWidth, buttonHeight, RECREATE_CONFIGS_MESSAGE, button -> {
            UpdateConfigsCommand.backupConfigs(new ConfigVersionTracker(BYGConstants.CONFIG_VERSION));
            KillClient.kill();
        },
                (button, poseStack, mouseX, mouseZ) -> renderTooltip(poseStack, RECREATE_CONFIGS_HOVER, mouseX, mouseZ)
        ));


        this.addRenderableWidget(validateConfigs);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTick);
        int width = this.minecraft.font.width(this.getTitle());
        this.minecraft.font.draw(poseStack, this.getTitle(), ((float) this.width / 2) - ((float) width / 2), this.errorBoxTop - 10, FastColor.ARGB32.color(255, 255, 0, 0));
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(null);
        super.onClose();
    }
}
