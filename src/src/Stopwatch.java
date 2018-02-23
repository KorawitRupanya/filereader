package src;

public class Stopwatch {
	private static final double NANOSECONDS = 1.0E-9;// nano per one second
	private long startTime;
	private long stopTime;
	private boolean running;

	public Stopwatch() {
		this.startTime = 0;
		this.stopTime = 0;
		this.running = false;
	}

	public void start() {
		if (!isRunning()) {
			this.stopTime = 0;
			this.startTime = System.nanoTime();
			this.running = true;
		}
	}

	public void stop() {
		if (isRunning()) {
			this.stopTime = System.nanoTime();
			this.running = false;
		}
	}

	public boolean isRunning() {
		return this.running;
	}

	public double getElapsed() {
		if (isRunning())
			return (System.nanoTime() - this.startTime) * NANOSECONDS;
		else {
			return (this.stopTime - this.startTime) * NANOSECONDS;
		}
	}
}