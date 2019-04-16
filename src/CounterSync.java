
public class CounterSync {
	
	private int value;
	public CounterSync(int v) {
		value = v;
	}
	
	public synchronized void inc() {
		int t = 0;
		while ( t < 100000000) {
			t++;
		}
		value = value + 1;
	}
	public void print() {
		System.out.println(value);
	}

}
