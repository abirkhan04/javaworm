package com.javaworm.generic;

public class TestGeneric<T, S> {

	private T parameter1;
	private S parameter2;

	public TestGeneric(T parameter1, S parameter2) {
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
	}

	public T getParameter1() {
		return parameter1;
	}

	public void setParameter1(T parameter1) {
		this.parameter1 = parameter1;
	}

	public S getParameter2() {
		return parameter2;
	}

	public void setParameter2(S parameter2) {
		this.parameter2 = parameter2;
	}

	public boolean compareParameters() {
		return parameter1 == parameter2;
	}
}
