package clientname.mods.emote;

import clientname.Client;
import clientname.event.EventTarget;
import clientname.event.impl.ClientTickEvent;

public class InputEvent {

	public static final int MAX_DABBING_HELD =  8;
	public static int dabbingHeld;
	public static int prevDabbingHeld;
	public static float firstPersonPartialTicks;

	@EventTarget
	public void on(ClientTickEvent e) {
		prevDabbingHeld = dabbingHeld;

		if (Client.getInstance().dab == true && dabbingHeld < MAX_DABBING_HELD) {
			dabbingHeld++;
		} else if (Client.getInstance().dab == false && dabbingHeld > 0) {
			dabbingHeld--;
		}
	}
}
