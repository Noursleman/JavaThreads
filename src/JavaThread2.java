
public class JavaThread2 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName());

	}

}
