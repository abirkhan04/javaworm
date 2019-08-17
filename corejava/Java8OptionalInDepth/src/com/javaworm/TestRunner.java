package com.javaworm;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestOptional.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Here" + failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}
}