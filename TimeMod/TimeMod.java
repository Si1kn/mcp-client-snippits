package kangaClient.module.impl.hud;

import kangaClient.module.Module;
import net.minecraft.client.Minecraft;

import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeMod extends Module {
    @Override
    public void render() {
  
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.now();
        String time = dtf.format(localTime);
        Minecraft.getMinecraft().fontRendererObj.drawString(time, this.pos.x, this.pos.y, -1);
    }

    @Override
    public int getWidth() {
        return 30;
    }

    @Override
    public int getHeight() {
        return 10;
    }
}
