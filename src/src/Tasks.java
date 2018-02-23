package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Tasks {

	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";

	private static String readFileToString(String filename) {
		InputStream in;
		String read = "";
		try {
			in = openUrl(filename);
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

	private static String readFileToStringBuilder(String filename) {
		InputStream in;
		StringBuilder read = new StringBuilder();
		try {
			in = openUrl(filename);
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

	private static String readFileToStringUsingBufferReader(String filename) {
		InputStream in;
		String read = "";
		try {
			in = openUrl(filename);
			InputStreamReader readerIn = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(readerIn);
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
	
	private static InputStream openUrl(String urlstr) throws IOException {
		URL url = null;
		try {
			url = new URL(urlstr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url.openStream();
	}


	public static void main(String[] args) {
		System.out.println("Reading Alice-in-Wonderland.txt using FileReader, append to String.");
		Stopwatch sw = new Stopwatch();
		sw.start();
		String alice1 = readFileToString(ALICE);
		sw.stop();
		System.out.printf("Read %s chars in %f sec.\n", alice1.length(), sw.getElapsed());

		System.out.println("Reading Alice-in-Wonderland.txt using FileReader, append to StringBuilder.");
		sw.start();
		String alice2 = readFileToStringBuilder(ALICE);
		sw.stop();
		System.out.printf("Read %s chars in %f sec.\n", alice2.length(), sw.getElapsed());

		System.out.println("Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String.");
		sw.start();
		String alice3 = readFileToStringUsingBufferReader(ALICE);
		sw.stop();
		System.out.printf("Read %s chars in %f sec.", alice3.length(), sw.getElapsed());
	}

}