package com.javaworm.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

	private static Callable<String> callableTask = () -> {
		TimeUnit.MILLISECONDS.sleep(3000L);
		return "Returned from the Callable task";
	};

	private static Runnable runnableTask = () -> {
		System.out.println("Task running through runnable.");
	};

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		checkExecutorService();
		checkScheduledExecutorService();
	}

	private static void checkScheduledExecutorService() throws InterruptedException, ExecutionException {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		Future<String> resultFuture = executorService.schedule(callableTask, 10, TimeUnit.SECONDS);
		System.out.println("Obtaining result at scheduleExecutorService-->" + resultFuture.get());
		executorService.scheduleAtFixedRate(runnableTask, 100, 450, TimeUnit.MILLISECONDS);
		executorService.scheduleWithFixedDelay(runnableTask, 100, 150, TimeUnit.MILLISECONDS);
		Thread.sleep(2000);
		executorService.shutdown();
	}

	private static void checkExecutorService() throws InterruptedException, ExecutionException {
		ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		Runnable runnableTask = () -> {
			System.out.println("Task running through runnable.");
		};

		List<Callable<String>> taskList = new ArrayList<>();
		taskList.add(callableTask);
		taskList.add(callableTask);

		executorService.execute(runnableTask);
		Future<String> future = executorService.submit(callableTask);
		System.out.println("Exeuction using submit: " + future.get());

		String resultFromTaskList = executorService.invokeAny(taskList);
		System.out.println("Execution using invoke any : " + resultFromTaskList);

		List<Future<String>> futures = executorService.invokeAll(taskList);

		futures.forEach(item -> {
			try {
				String result = item.get();
				System.out.println("Execution using invoke all : " + result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		executorService.shutdown();
	}
}
