import java.util.concurrent.TimeUnit;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class Example1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runnable task = ()  -> {
			String threaName = Thread.currentThread().getName();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //current thread will slepp for 1 seconds.
			System.out.println("Hello: "+threaName);
		};

		task.run(); // will execute in main thread.
		
		Thread thread = new Thread(task); //created new thread of task.
		thread.start(); // new thread started.
		
		/*try {
			thread.join(); // main thread will stop untill 'thread' completes.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			TimeUnit.SECONDS.sleep(1); // main thread will sleep for 1 seconds.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Done!"); //main thread completed.
		
	}

}
