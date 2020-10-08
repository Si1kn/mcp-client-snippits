import java.text.DecimalFormat;

import clientname.event.EventTarget;
import clientname.event.impl.AttackPlayerEvent;
import clientname.event.impl.ClientTickEvent;
import clientname.gui.hud.ScreenPosition;
import clientname.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class ReachDisplayMod extends ModDraggable
{

	String ReachDisplay = "";
	private long lastAttack;
	private boolean enabled = true;
	private int decimals;

	@Override
	public int getWidth()
	{
		return this.font.FONT_HEIGHT;
	}

	@Override
	public int getHeight()
	{
		return 64;
	}

	@Override
	public void render(ScreenPosition pos)
	{
		this.font.drawString(ReachDisplay, pos.getAbsoluteX(), pos.getAbsoluteY(), -1, false);
	}

	@EventTarget
	public void onHit(AttackPlayerEvent event)
	{
		final Vec3 vec3 = this.mc.getRenderViewEntity().getPositionEyes(1.0F);
		double hitRange = this.mc.objectMouseOver.hitVec.distanceTo(vec3);

		ReachDisplay = this.getFormatter().format(hitRange) + " blocks";

		this.lastAttack = System.nanoTime();
	}

	private DecimalFormat getFormatter()
	{
		StringBuilder format = new StringBuilder("0.");
		for (int i = 0; this.decimals > i; i++)
		{
			format.append('0');
		}
		return new DecimalFormat(format.toString());
	}

	@EventTarget
	public void onTick(ClientTickEvent event)
	{
		if (System.nanoTime() - this.lastAttack >= 2.0E9 && this.enabled)
		{
			ReachDisplay = "Hasn't attacked";
		}
	}

}
