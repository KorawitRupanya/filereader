package src;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Task which is using FileReader,append to StringBuilder.
 * 
 * @author Korawit Rupanya
 *
 */
public class AppendStringBuilderTask implements Runnable {

	/** The URL of the file */
	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";

	/** Perform the task. */
	@Override
	public void run() {
		readFileToStringBuilder(ALICE);
	}

	/**
	 * Read the file by InputSteam and append to StringBuilder.
	 * 
	 * @param filename
	 *            is the fileURL that is used to read.
	 * @return the reader of this file by toString.
	 */
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
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return read.toString();
	}

	/**
	 * Return a description of the task.
	 */
	public String toString() {
		return "Reading " + ALICE + " using FileReader,append to StringBuilder. Read "
				+ readFileToStringBuilder(ALICE).length() + " chars.";
	}
}