
public class ReceiveThread extends Thread {
	private BlockingQueue queue;
	public ReceiveThread(BlockingQueue q) {
		queue = q;
	}
	public void run() {
		for (int i = 0; i < 10; i++ ) {
			try {
				String s = (String)queue.pop();
				String p = String.format("%s: %d", s, s.length());
				System.out.println(p);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
