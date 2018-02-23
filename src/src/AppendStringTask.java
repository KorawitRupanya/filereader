package src;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppendStringTask implements Runnable {

	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";
	
	@Override
	public void run() {
	 readFileToString(ALICE);
	}
	
	private static String readFileToString(String filename) {
		InputStream in;
		String read = "";
		try {
			in = HelperOpenUrl.openUrl(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int i;
			while (true) {
				i = reader.read();
				if (i < 0)
					break;
				read = read + (char) i;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return read;
	}
	public String toString() {
		return "Reading " + ALICE + " using FileReader,append to String. Read " + readFileToString(ALICE).length()
				+ " chars.";
	} 
}
	