package src;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Task which is using FileReader,append to String.
 * 
 * @author Korawit Rupanya
 *
 */
public class AppendStringTask implements Runnable {

	/** The URL of the file */
	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";

	/** Perform the task. */
	@Override
	public void run() {
		readFileToString(ALICE);
	}

	/**
	 * Read the file by InputStream and append to String.
	 * 
	 * @param filename
	 *            is the fileURL that is used to read.
	 * @return the reader of this file by toString.
	 */
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
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return read;
	}

	/**
	 * Return a description of the task.
	 */
	public String toString() {
		return "Reading " + ALICE + " using FileReader,append to String. Read " + readFileToString(ALICE).length()
				+ " chars.";
	}
}