package com.javaworm;

import java.time.LocalDate;
import java.util.logging.Logger;
import com.javaworm.entity.FootBall;
import com.javaworm.generics.GenericDemo;
import com.javaworm.generics.TestGeneric;

public class GenericsExample {

	private static Logger logger = Logger.getLogger(GenericsExample.class.getCanonicalName());

	public static void main(String args[]) {
		TestGeneric<Integer, Integer> testGeneric = new TestGeneric<Integer, Integer>(2, 2);
		logger.info("Test Generic: " + testGeneric.compareParameters());
		FootBall footBall = new FootBall(LocalDate.now(), "Dhaka");
		footBall.makeGame(footBall);

		GenericDemo<String> genericDemo = new GenericDemo<String>();
		genericDemo.set("Test");
		String t = genericDemo.get();
		logger.info("T: " + t);
	}

}
