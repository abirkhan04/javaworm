package com.javaworm.generics.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.javaworm.generics.TestGeneric;

public class GenericsMethodTest {

	@Test
	void testGenericMethod() {
		String[] a = { "test1", "test2" };
		List<String> testList = new ArrayList<String>();
		testList = TestGeneric.addArrayToAList(a, testList);
		assertEquals(testList.size(), 2);
	}
	
	@Test
	void testCompareParametersMethodShouldReturnTrue() {
		TestGeneric<Integer, Integer> testGeneric = new TestGeneric<Integer, Integer>(2, 2);
		assertTrue(testGeneric.compareParameters());
	}
	
	@Test
	void testCompareParametersMethodShouldReturnFalse() {
		TestGeneric<Integer, Integer> testGeneric = new TestGeneric<Integer, Integer>(2,3);
		assertFalse(testGeneric.compareParameters());
	}

}
