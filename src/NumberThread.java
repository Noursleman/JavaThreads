
public class NumberThread extends Thread {
	private int n1;
	private int n2;
	public NumberThread(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	public void run() {
		for (int i = n1; i < n2; i++) {
			System.out.println(i);
		}
	}
}
