package src;

/**
 * Main is responsible for creating the specific tasks we want to measure and
 * calling TaskTimer.
 * 
 * @author Korawit Rupanya
 *
 */
public class Main {

	/**
	 * Creates the tasks and pass each task to the TaskTimer.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable[] tasks = { new AppendStringTask(), new AppendStringBuilderTask(),
				new AppendStringUsingBufferReaderTask() };
		for (Runnable task : tasks) {
			TaskTimer.measureAndPrint(task);
		}
	}
}