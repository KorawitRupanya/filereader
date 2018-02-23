package src;

/**
 * A Stopwatch that measures elapsed time in seconds between a starting time and
 * stopping time, or until the present time.
 * 
 * @author Korawit Rupanya
 *
 */
public class Stopwatch {
	/** constant which is used to converting nanoseconds to seconds */
	private static final double NANOSECONDS = 1.0E-9;
	/** The time that stopwatch starts running */
	private long startTime;
	/** The time that stopwatch stops running */
	private long stopTime;
	/** boolean to check if the stopwatch is running */
	private boolean running;

	/** Initialize the starTime,stopTime,and time running to be 0 */
	public Stopwatch() {
		this.startTime = 0;
		this.stopTime = 0;
		this.running = false;
	}

	/** Start the stopwatch to run */
	public void start() {
		if (!isRunning()) {
			this.stopTime = 0;
			this.startTime = System.nanoTime();
			this.running = true;
		}
	}

	/** Stop the stopwatch */
	public void stop() {
		if (isRunning()) {
			this.stopTime = System.nanoTime();
			this.running = false;
		}
	}

	/**
	 * check for the stopwatch status
	 * 
	 * @return true if the stopwatch is running,false if the stopwatch is stopped.
	 */
	public boolean isRunning() {
		return this.running;
	}

	/**
	 * get the elapsed time form using the stopwatch
	 * 
	 * @return time since start until the current time if the stopwatch is running
	 *         time between the start and stop times if the stopwatch is stopped
	 */
	public double getElapsed() {
		if (isRunning())
			return (System.nanoTime() - this.startTime) * NANOSECONDS;
		else {
			return (this.stopTime - this.startTime) * NANOSECONDS;
		}
	}
}