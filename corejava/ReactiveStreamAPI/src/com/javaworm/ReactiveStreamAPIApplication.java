package com.javaworm;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamAPIApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubmissionPublisher<Student> publisher = new SubmissionPublisher<>();

		// Register Subscriber
		OurSubscriber subs = new OurSubscriber();
		publisher.subscribe(subs);

		List<Student> students = StudentListCreator.getStudents();

		// Publish items
		students.stream().forEach(i -> publisher.submit(i));

		// logic to wait till processing of all messages are over
		while (subs.getNumberofProcessedItems()!=students.size()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// close the Publisher
		publisher.close();
		System.out.println("Exiting the app");
	  }
  }
