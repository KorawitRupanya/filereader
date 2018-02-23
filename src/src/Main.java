package src;

public class Main {

	public static void main(String[] args) {
		Runnable[] tasks = { new AppendStringTask(), new AppendStringBuilderTask(),
				new AppendStringUsingBufferReader() };
		for (Runnable task : tasks) {
			TaskTimer.measureAndPrint(task);
		}
	}
}
