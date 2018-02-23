package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppendStringUsingBufferReader implements Runnable {

	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";

	@Override
	public void run() {
		readFileToStringUsingBufferReader(ALICE);
	}

	private static String readFileToStringUsingBufferReader(String filename) {
		InputStream in;
		String read = "";
		try {
			in = HelperOpenUrl.openUrl(filename);
			InputStreamReader readerIn = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(readerIn);
			String i;
			while ((i = reader.readLine()) != null) {
				read = read + i + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return read;
	}
	
	public String toString() {
		return "Reading " + ALICE + " using BufferedReader, append lines to String. Read " + readFileToStringUsingBufferReader(ALICE).length()
				+ " chars.";
	} 
}