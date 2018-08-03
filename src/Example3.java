import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// In addition to Runnable executors support another kind of task named
		// Callable. Callables are functional interfaces just like runnables but instead
		// of being void they return a value.
		Callable<Integer> task = () -> {
			TimeUnit.SECONDS.sleep(2);
			return 123;
		};

		// Callables can be submitted to executor services just like runnables.
		// The executor service cannot return the result of the callable directly.
		// Instead the executor returns a special result of type Future which can be
		// used to retrieve the actual result at a later point in time.
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task); // passed callable to executor.
		// Future<Integer> future1 = executor.submit(task);

		System.out.println("future done? " + future.isDone());
		// System.out.println("future1 done? " + future1.isDone());
		try {
			// Integer result = future.get(); // Calling the method get() blocks the current
			// thread and waits until the
			// callable completes before returning the actual result 123.
			Integer result = future.get(1, TimeUnit.SECONDS); // in worst case, if executor runs forever, thus making
																// your application unresponsive. You can simply
																// counteract those scenarios by passing a timeout. Here
																// we will get TimeoutException, because task has 2
																// seconds delay, which is more than 1 second passed in
																// future.get.
			System.out.println("result " + result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("future done? " + future.isDone());
		// System.out.println("future1 done? " + future1.isDone());
		executor.shutdownNow();
	}

}
