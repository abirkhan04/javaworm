package com.java8.methodreference;

import java.util.ArrayList;
import java.util.Arrays;

public class MethodReferenceTypes {

	public String[] referToInstanceMethod() {
		String[] nameArray = new String[] { "Rashed", "Abir", "Sumon" };
		Arrays.sort(nameArray, new ComparisonService()::compareName);
		return nameArray;
	}

	public String[] referToMethodOfArbitrayType() {
		String[] nameArray = new String[] { "Rashed", "Abir", "Sumon" };
		Arrays.sort(nameArray,  String::compareToIgnoreCase);
		return nameArray;
	}

	public ArrayList<String> referToConstructor(SUPPLIER listFactory) {
		ArrayList<String> result = listFactory.get();
		result.add("Abir");
		return result;
	}
}

class ComparisonService {
	public int compareName(String a, String b) {
		return a.compareToIgnoreCase(b);
	}

	public boolean compareAge(Integer a, Integer b) {
		return a > b;
	}
}