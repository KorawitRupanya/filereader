package src;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Utility class that used by the task to open the file for the URL.
 * 
 * @author Korawit Rupanya
 *
 */
public class HelperOpenUrl {

	/**
	 * Input the file from the URL.
	 * 
	 * @param urlstr
	 *            is the URL that is used to open.
	 * @return the openStream of the URL.
	 * @throws IOException
	 *             if can not reach the InputStream.
	 */
	public static InputStream openUrl(String urlstr) throws IOException {
		URL url = null;
		try {
			url = new URL(urlstr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url.openStream();
	}
}