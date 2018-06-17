package com.javaworm;

import java.util.Random;

public final class Utils {

	private Utils() {

	}

	public static int generateUUID() {
		Random r = new Random();
		int next = r.nextInt();
		return next;
	}
}