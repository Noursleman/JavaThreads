import java.util.LinkedList;

public class Main {

	public static void main(String[] args)throws InterruptedException {
		// Java Thread using first method
		JavaThread1 jt1 = new JavaThread1();
		jt1.start();
		
		// Java Thread using second method
		JavaThread2 jt2 = new JavaThread2();
		Thread th1 = new Thread(jt2);
		th1.start();
		
		// Join is used to wait for other threads to finish
		jt1.join();
		th1.join();
		Thread mainThread = Thread.currentThread();
		String p = String.format("Main thread name is %s", mainThread.getName());
		System.out.println(p);
		
		// Sleep is used to make a thread wait for few milliseconds
		Thread.sleep(1000);
		System.out.println("After waiting for one second");
		
		// Now we will test synchronization
		
		// First we will use a Counter class without synchronization
		Counter counter = new Counter(0);
		// Create two threads that increment counter 100 times
		CounterThread ct1 = new CounterThread(counter);
		CounterThread ct2 = new CounterThread(counter);
		ct1.start();
		ct2.start();
		ct1.join();
		ct2.join();
		counter.print(); // Here the output should be 200 but you will notice it is not
		
		// Now we will use thread safe Counter objects
		CounterSync counterSync = new CounterSync(0);
		// Create two threads to increment the object 100 times in each one
		CounterSyncThread cth1 = new CounterSyncThread(counterSync);
		CounterSyncThread cth2 = new CounterSyncThread(counterSync);
		cth1.start();
		cth2.start();
		cth1.join();
		cth2.join();
		counterSync.print(); // Here the output will always be 200
		
		// Now we will test the Linked Lists in java
		LinkedList ll = new LinkedList();
		ll.add("hello");
		ll.add(90);
		ll.add(32.1);
		ll.add('a');
		ll.add(new Counter(1));
		ll.remove(2);
		System.out.println(String.format("Number of elements is %d", ll.size()));
		Object firstItem = ll.get(0);
		ll.set(1, "hi");
		if (ll.contains('a')) {
			System.out.println("The list contains letter 'a'");
		}
		else {
			System.out.println("The list does not contain 'a'");
		}
		System.out.println(ll.indexOf(32));
		for (Object item : ll) {
			System.out.println(item);
		}
		
		BlockingQueue bq = new BlockingQueue(10);
		SendThread st = new SendThread(bq);
		ReceiveThread rt = new ReceiveThread(bq);
		st.start();
		rt.start();
		st.join();
		rt.join();
		
		NumberThread[] nts = new NumberThread[4];
		for(int i = 0; i < nts.length; i++) {
			nts[i] = new NumberThread(i*10, i*10+10);
			nts[i].start();
		}
		for (NumberThread nt : nts) {
			nt.join();
		}
		System.out.println("Done");
	}

}
