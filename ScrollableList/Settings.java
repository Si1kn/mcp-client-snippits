package kangaClient.gui.settings;

import kangaClient.KangaClient;
import kangaClient.gui.Hud;
import kangaClient.gui.button.ScrollableButton;
import kangaClient.gui.uiBuilder.UIBuilder;
import kangaClient.utils.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Settings extends GuiScreen {

    private final List<ScrollableButton> buttons = new ArrayList<>();
    private int scrollY;


    @Override
    public void initGui() {
        buttons.clear();
        RenderUtil.getInstance().drawBlur();

        buttonList.add(new GuiButton(0, 200, 200, "hud"));
        int yPos = -50;
        for (int i = 0; i < KangaClient.getInstance().getModuleManager().getAllModules().size(); i++) {
            UIBuilder a = new UIBuilder(KangaClient.getInstance().getModuleManager().getAllModules().get(i));
            this.buttons.add(new ScrollableButton(KangaClient.getInstance().getModuleManager().getAllModules().get(i), a, this.width / 2 - 150, this.height / 2 - yPos, 275, 20));
            yPos += 25;
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        int x = this.width / 2;
        int y = this.height / 2;

        GlStateManager.resetColor();
        RenderUtil.getInstance().drawRoundedRect(x - 200, y - 100, x + 200, y + 100, 5, new Color(80, 80, 80, 71).getRGB());
        RenderUtil.getInstance().getMinecraftFont().drawString("Mod Display", x - 20, y - 105 - 10, Color.white.getRGB());

        GlStateManager.pushMatrix();
       

        this.scrollY = Math.min(scrollY, 0);
        this.scrollY = Math.max(scrollY, -305);

        for (ScrollableButton button : buttons) {
            button.draw(mouseX, mouseY);
        }
        int eventDWheel = Mouse.getDWheel();

        if (eventDWheel < 0) {
            this.scrollY -= 3;
        } else if (eventDWheel > 0) {
            this.scrollY += 3;
        }

        for (ScrollableButton button : this.buttons) {
            button.scrollAmount = scrollY;
        }
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
        if (button.id == 0) {
            Minecraft.getMinecraft().displayGuiScreen(new Hud());
        }
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
    }
}
