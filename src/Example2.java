import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		executor.submit(()->{
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello: "+threadName);
		}); // new task created, passed to a executor submit method.
		
		/*executor.submit(()->{
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello 1: "+threadName);
		});*/ // new task created, passed to a executor submit method.
		
		try {
			TimeUnit.SECONDS.sleep(1); // main thread sleeps 1 second.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
			System.out.println("attempt of shutdown executor successfully.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(!executor.isTerminated()) {
				System.err.println("cancel non finished tasks");
				executor.shutdownNow();
				System.out.println("shutdown finished.");
			}
			
		}
		
		System.out.println("Main Thread Done! ");
	}

}
