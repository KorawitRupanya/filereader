package src;

/**
 * TaskTimer runs a task using a Stopwatch and prints the elapsed time.
 * 
 * @author Korawit Rupanya
 *
 */
public class TaskTimer {

	/**
	 * Runs a task, measures and prints its running time to the console.
	 * 
	 * @param runnable
	 *            is the task that is running.
	 */
	public static void measureAndPrint(Runnable runnable) {
		System.out.println(runnable);
		Stopwatch sw = new Stopwatch();
		sw.start();
		runnable.run();
		sw.stop();
		System.out.println("in " + sw.getElapsed() + " sec.");
	}
}