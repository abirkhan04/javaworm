package com.javaworm;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class OurSubscriber implements Subscriber<Student> {

	private Subscription subscription;

	private int itemProcessed = 0;

	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(Student entry) {
		System.out.println("Processing:" +entry.getName());
		this.subscription.request(1);
		itemProcessed++;
	}

	@Override
	public void onError(Throwable e){
		System.out.println("Error Occured !");
		e.printStackTrace();
	}

	@Override
	public void onComplete(){
		System.out.println("Processing done. ");
	}

	public int getNumberofProcessedItems(){
		return itemProcessed;
	}
}
