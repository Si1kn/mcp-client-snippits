package kangaClient.gui.button;

import kangaClient.gui.uiBuilder.UIBuilder;
import kangaClient.module.Module;
import kangaClient.utils.RenderUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

import java.awt.*;

@RequiredArgsConstructor
public class ScrollableButton {


    @NonNull
    private final Module module;


    @NonNull
    final UIBuilder uiBuilder;
    public int scrollAmount;

    @NonNull
    @Setter
    private int x, y, width, height;
    private boolean mouseDown;

    public void draw(int mouseX, int mouseY) {
        boolean hovered = mouseX >= this.x && mouseY >= (this.y - scrollAmount) && mouseX < this.x + this.width && mouseY < (this.y - scrollAmount) + this.height;
        if (!Mouse.isButtonDown(0)) {
            this.mouseDown = false;
        }

        if (hovered && Mouse.isButtonDown(0) && !mouseDown) {
            this.mouseDown = true;
            this.module.setToggled(!this.module.isToggled());
        }

        Color toggled = this.module.isToggled() ? Color.green : Color.red;
        RenderUtil.getInstance().drawOutlinedRect(x, y - scrollAmount, x + width + 25, y + height - scrollAmount, new Color(80, 80, 80, 80).getRGB(), toggled.getRGB());


        RenderUtil.getInstance().drawVerticalLine(x + 275, y + 4 - scrollAmount, y + 18 - scrollAmount, -1);


        RenderUtil.getInstance().drawSquareTexture(new ResourceLocation("kangaClient/gear.png"), 20, x + width - 8, y - 9 - scrollAmount);



        if (isMouseOver(mouseX, mouseY, x + width + 2, y + 1, 25, 25) && Mouse.isButtonDown(0)) {


            Minecraft.getMinecraft().displayGuiScreen(uiBuilder.build());
        }


        GlStateManager.pushMatrix();
        RenderUtil.getInstance().getMinecraftFont().drawString(module.getClass().getSimpleName().replace("Mod", " Mod"), x + 4, y + 7 - scrollAmount, Color.white.getRGB());
        GlStateManager.popMatrix();
    }

    public boolean isMouseOver(double mouseX, double mouseY, int x, int y, int width, int height) {
        double maxX = (double) x + width;
        double maxY = (double) y + height;
        return mouseX > (double) x && mouseY > (double) y && mouseX < maxX && mouseY < maxY;
    }
}
