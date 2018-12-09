package com.javaworm;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class OurProcessor extends SubmissionPublisher<GradedStudent> implements Processor<Student, GradedStudent> {

	
	private Subscription subscription;
	private Function<Student,GradedStudent> function;
	
	
	public OurProcessor(Function<Student, GradedStudent> function) {  
	    super();  
	    this.function = function;  
	  }
	
	
	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(Student entry) {
		// TODO Auto-generated method stub
		submit((GradedStudent) function.apply(entry));  
	    subscription.request(1);  
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		System.out.println("Done .");
	}
   
}
