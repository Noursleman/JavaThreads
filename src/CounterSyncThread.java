
public class CounterSyncThread extends Thread {
	
	private CounterSync counter;
	public CounterSyncThread(CounterSync c) {
		counter = c;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			counter.inc();
		}
	}

}
