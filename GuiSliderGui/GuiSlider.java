
import java.io.IOException;

import clientname.event.EventManager;
import clientname.gui.button.GuiAnimatedButton;
import clientname.gui.button.GuiSliderButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;

public class GuiSlider extends GuiScreen
{
	private GuiAnimatedButton refreshButton;
	int i = 50;
	public int test1 = 200;

	public int test2 = 300;

	public boolean buttonEnabled = true;

	public GuiSlider()
	{
		EventManager.register(this);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
	{
	}

	@Override
	public void initGui()
	{

		this.buttonList.clear();

		if (buttonEnabled == true)
		{
			// this.buttonList.add(new ExitButton(0, width / 2 - 100, height - 25, 98, 20,
			// EnumChatFormatting.RED + "Close"));
			this.buttonList
					.add(new GuiButton(0, width / 2 - 100, height - 25, 98, 20, EnumChatFormatting.RED + "Close"));

			this.buttonList.add(new GuiSliderButton(2, 100, 100, 100, 10, "Disable"));
		}

	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		if (button.id == 0)
		{
			mc.displayGuiScreen(null);
		}

	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{

		if (i != 175)
		{
			i++;
		} else
		{
			buttonEnabled = true;
		}

		drawRect(0, 0, i, 500, 0xF0828282);

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
	{
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

}
