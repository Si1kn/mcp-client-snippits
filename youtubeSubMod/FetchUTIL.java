package clientname.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class FetchUTIL {

	static String apiBase;
	static JsonArray js0n;
	public static volatile int subCount = 0;
	static boolean alreadyExecuted;

	/**
	 * Just starts the api.
	 * 
	 * @author Si1kn
	 * 
	 * @since 1.0
	 */

	public static String getApiBase() {
		return apiBase;
	}

	//

	public static int getSubCount() {
		return subCount;
	}

	public static void start() {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					Packages.start1();
					Thread.sleep(2000);
				}
			}
		}).start();

	}

	//

	static class Packages {

		static int subCount;
		static int prevSubCount;

		/**
		 * @author Si1kn
		 * 
		 * @since 1.0
		 */

		public static void start1() {
			String json;
			try {

				json = readUrl(
					/* INPUT URL HERE  ==>*/	"https://www.googleapis.com/youtube/v3/channels?part=statistics&id=UCDO0hEkGSvujLnb3cZb0XCA&fields=items/statistics/subscriberCount&key=AIzaSyDUUfmvtaHY3lQ11CbkF8gplSJSXwgLe2g");

				Gson gson = new Gson();

				clientFormateJson page = gson.fromJson(json, clientFormateJson.class);

				// friend1 = page.items;


				String raw = page.items.toString();

				String[] parts = raw.split(":");

				String numberAndExtras = parts[2];

				numberAndExtras = numberAndExtras.replace("\"", ""); 
				numberAndExtras = numberAndExtras.replace("}", ""); 
				numberAndExtras = numberAndExtras.replace("]", ""); 
				
				subCount = Integer.parseInt(numberAndExtras);
				FetchUTIL.subCount = subCount;
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		/**
		 * Gets the info of anyPage
		 * 
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

				while ((read = reader.read(chars)) != -1)
					buffer.append(chars, 0, read);

				return buffer.toString();
			} finally {
				if (reader != null)
					reader.close();
			}
		}

		static class clientFormateJson {
			JsonArray items;
		}

	}

}
