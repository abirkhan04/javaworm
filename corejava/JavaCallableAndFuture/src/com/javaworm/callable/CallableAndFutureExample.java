package com.javaworm.callable;

import java.util.concurrent.*;

public class CallableAndFutureExample {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		long startTime = System.nanoTime();
		Callable<String> callable = () -> {
			Thread.sleep(2000);
			return "Some results";
		};

		System.out.println("Submitting Callable");
		Future<String> future = executorService.submit(callable);
		int i = 0;
		while (!future.isDone()) {
			System.out.println("Task is still not done , We are doing something here while task is not done....");
			i++;
			System.out.println(i);
			Thread.sleep(200);
			double elapsedTimeInSec = (System.nanoTime() - startTime) / 1000000000.0;

			if (elapsedTimeInSec > 1) {
				// future.cancel(true);
			}

		}
		System.out.println("retrieved result -->" + future.get());
		executorService.shutdown();
	}
}
