import java.util.LinkedList;

public class BlockingQueue {
	private LinkedList queue;
	private int limit;
	public BlockingQueue(int l) {
		limit = l;
		queue = new LinkedList();
	}
	public synchronized void add(Object item) throws InterruptedException {
		while(queue.size() == limit) wait();
		if (queue.size() == 0) notifyAll();
		queue.add(item);
	}
	
	public synchronized Object pop() throws InterruptedException {
		while (queue.size() == 0) wait();
		if (queue.size() == limit) notifyAll();
		return queue.remove(0);
	}

}
