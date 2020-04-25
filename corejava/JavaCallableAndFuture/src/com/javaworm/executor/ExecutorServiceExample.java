package com.javaworm.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		Runnable runnableTask = () -> {
			System.out.println("Task running through runnable.");
		};

		Callable<String> callableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(3000L);
			return "Returned from the Callable task";
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
	}
}
