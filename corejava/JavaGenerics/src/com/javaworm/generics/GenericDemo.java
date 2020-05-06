package com.javaworm.generics;

public class GenericDemo<T> {

	private T t;

	public GenericDemo(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
}
