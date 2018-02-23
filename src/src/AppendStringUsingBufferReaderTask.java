package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Task which is using BufferReader,append to String.
 * 
 * @author Korawit Rupanya
 *
 */
public class AppendStringUsingBufferReaderTask implements Runnable {

	/** The URL of the file */
	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";

	/** Perform the task. */
	@Override
	public void run() {
		readFileToStringUsingBufferReader(ALICE);
	}

	/**
	 * Read the file by BufferReader and append to String.
	 * 
	 * @param filename
	 *            is the fileURL that is used to read.
	 * @return the reader of this file by toString.
	 */
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
		return "Reading " + ALICE + " using BufferedReader, append lines to String. Read "
				+ readFileToStringUsingBufferReader(ALICE).length() + " chars.";
	}
}