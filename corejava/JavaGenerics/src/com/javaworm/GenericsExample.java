package com.javaworm;

import java.time.LocalDate;

import com.javaworm.entity.FootBall;
import com.javaworm.generic.TestGeneric;

public class GenericsExample {
	public static void main(String args[]) {
		TestGeneric<Integer, Integer> testGeneric = new TestGeneric<Integer, Integer>(2, 2);
		System.out.println("Test Generic Test: " + testGeneric.compareParameters());
		FootBall footBall = new FootBall(LocalDate.now(), "Dhaka");
		footBall.makeGame(footBall);
	}
}
