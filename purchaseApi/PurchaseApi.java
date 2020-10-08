package io.github.Si1kn.PurchaseApi;

public class PurchaseApi {
	public static String apiBase = "https://si1kn.github.io/c-api/congenial-Api/Json.json";// "https://si1kn.github.io/c-api/congenial-Api/";

	private static Fetch fetch = new Fetch();

	/**
	 * Just starts the api.
	 * @author Si1kn
	 * 
	 * @since 1.0
	 */
	public static void start() {
		Packages.onStart(fetch.getIgn());
	}
}
