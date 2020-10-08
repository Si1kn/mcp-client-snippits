import com.blizard.si1kn.client.events.EventTarget;
import com.blizard.si1kn.client.events.imple.ClientTickEvent;
import com.blizard.si1kn.client.gui.hud.ScreenPosition;
import com.blizard.si1kn.client.mods.ModDraggable;
import com.blizard.si1kn.client.mods.utils.GetFps;

import net.minecraft.client.Minecraft;

public class FpsMod extends ModDraggable {

	private ScreenPosition pos;
	private int setting;
	@Override
	public int getWidth() {
		return font.getStringWidth("FPS: " + GetFps.fps);
	}

	@Override
	public int getHeight() {
		return font.FONT_HEIGHT;
	}
	private void chroma()
	{
		for(int i = 0; 1 < 255; i++)
		{
			setting = (int) (System.currentTimeMillis() / 1000);
		}
	}

	@Override
	public void render(ScreenPosition pos) {
		
		font.drawString("FPS: " + Minecraft.getDebugFps(), pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0xffff00);

	}

	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}

}