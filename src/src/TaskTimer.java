package src;

public class TaskTimer {

	public static void measureAndPrint(Runnable runnable) {
		System.out.println(runnable);
		Stopwatch sw = new Stopwatch();
		sw.start();
		runnable.run();
		sw.stop();
		System.out.println("in " + sw.getElapsed() + " sec.");
	}
}
