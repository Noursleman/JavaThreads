import java.util.Random;

public class SendThread extends Thread {
	private BlockingQueue queue;
	public SendThread(BlockingQueue q) {
		queue = q;
	}
	
	private String generateRandomString() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    Random random = new Random();
	    byte[] l = new byte[1];
	    random.nextBytes(l);
	    if (l[0] < 0) {
	    	l[0] = (byte) (l[0] * -1);
	    }
	    int targetStringLength = (int)l[0];
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
		return buffer.toString();
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			try {
				queue.add(generateRandomString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
