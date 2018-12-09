package com.javaworm;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveAPPWithProcessor {

	public static void main(String[] args) throws InterruptedException {
		// Create End Publisher
		SubmissionPublisher<Student> publisher = new SubmissionPublisher<>();

		// Create Processor ; Here is the implementation of functional interface
		// function with return type R and argument T Function<T, R> function
		OurProcessor transformProcessor = new OurProcessor(s -> {
			return new GradedStudent(s.getId(), s.getId() + 100, s.getName());
		});

		// Create End Subscriber
		GradedStudentSubscriber subs = new GradedStudentSubscriber();

		// Create chain of publisher, processor and subscriber
		publisher.subscribe(transformProcessor); // publisher to processor
		transformProcessor.subscribe(subs); // processor to subscriber

		List<Student> sts = StudentListCreator.getStudents();

		// Publish items
		System.out.println("Publishing Items to Subscriber");
		sts.stream().forEach(i -> publisher.submit(i));

		// Logic to wait for messages processing to finish
		while (sts.size() != subs.getCounter()) {
			Thread.sleep(10);
		}

		// Closing publishers
		publisher.close();
		transformProcessor.close();

		System.out.println("Exiting the app");
	}

}
