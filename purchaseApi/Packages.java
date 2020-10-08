package io.github.Si1kn.PurchaseApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public class Packages {
	public static boolean enabled;

	
	/**
	 * @author Si1kn
	 * 
	 * @since 1.0
	 * 
	 * @param username type: STRING
	 */
	public static void onStart(String username) {
		String json;
		try {
			json = readUrl(PurchaseApi.apiBase); // + username + "/" + "Json.json");
			
			Gson gson = new Gson();
			
			clientFormateJson page = gson.fromJson(json, clientFormateJson.class);
			
			System.out.println("cape" + " Is " + page.cape + " Also Wings Is " + page.wings);
			
			enabled = page.cape;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the info of anyPage
	 * @author Si1kn
	 * 
	 * @since 1.0
	 * 
	 * @category URL
	 */
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
				URL url = new URL(urlString);
			
				reader = new BufferedReader(new InputStreamReader(url.openStream()));
			
				StringBuffer buffer = new StringBuffer();
			
				int read;
			
				char[] chars = new char[1024];
			
				while ((read = reader.read(chars)) != -1) buffer.append(chars, 0, read);

				return 
					buffer.toString();
			} finally {
				if (reader != null) reader.close();
		}
	}

	static class clientFormateJson {
		boolean cape;
		boolean wings;
	}
}
