package src;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppendStringBuilderTask implements Runnable {

	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";
	
	@Override
	public void run() {
		readFileToStringBuilder(ALICE);
	}
	
	private static String readFileToStringBuilder(String filename) {
		InputStream in;
		StringBuilder read = new StringBuilder();
		try {
			in = HelperOpenUrl.openUrl(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int i;
			while (true) {
				i = reader.read();
				if (i < 0)
					break;
				read = read.append((char) i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return read.toString();
	}
	
	public String toString() {
		return "Reading " + ALICE + " using FileReader,append to StringBuilder. Read " + readFileToStringBuilder(ALICE).length()
				+ " chars.";
	} 
}
