
public class CounterThread extends Thread {
	
	private Counter counter;
	public CounterThread(Counter c) {
		counter = c;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			counter.inc();
		}
	}

}
