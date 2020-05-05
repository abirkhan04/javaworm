package com.javaworm.generic;

public class TestGeneric<U, V> {

	private U parameter1;
	private V parameter2;

	public TestGeneric(U parameter1, V parameter2) {
		this.parameter1 = parameter1;
		this.parameter2 = parameter2;
	}

	public U getParameter1() {
		return parameter1;
	}

	public void setParameter1(U parameter1) {
		this.parameter1 = parameter1;
	}

	public V getParameter2() {
		return parameter2;
	}

	public void setParameter2(V parameter2) {
		this.parameter2 = parameter2;
	}

	public boolean compareParameters() {
		return parameter1 == parameter2;
	}
}
