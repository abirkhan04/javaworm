package com.javaworm;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class GradedStudentSubscriber implements Subscriber<GradedStudent> {
	
	private Subscription subscription;

	private int counter = 0;
	
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		this.subscription.request(1); //requesting data from publisher
	}

	@Override
	public void onNext(GradedStudent entry) {
		System.out.println("Processing Student "+entry);
		counter++;
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable e) {
		System.out.println("Some error occured.");
		e.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("All Processing Done !");
	}

	public int getCounter() {
		return counter;
	}
}