package io.github.Si1kn.PurchaseApi;

/**
 * Used For Fetching data from clients. Uses: Fetch.getIgn();
 * 
 * @author Si1kn
 * 
 * @since 1.0
 */
public class Fetch {

	String ign = Minecraft.getMinecraft().getSession().getUsername();
	String uuid = "331274";

	public String getIgn() {
		return ign;
	}

	public String getUUID() {
		return uuid;
	}

}
