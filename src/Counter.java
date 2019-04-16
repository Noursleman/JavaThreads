
public class Counter {
	
	private int value;
	public Counter(int v) {
		value = v;
	}
	
	public void inc() {
		int t = 0;
		while ( t < 100000000) {
			t++;
		}
		value = value + 1;
	}
	public synchronized void incSync() {
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
