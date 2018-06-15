package com.java8.methodreference;

import static org.junit.Assert.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class MethodReferenceTest {

    private static MethodReference mreference;

    @BeforeClass
    public static void setup() {
        mreference = new MethodReference();
    }

    @Test
    public void methodreferencetest1() {
        assertTrue(mreference.traditionalSort());
    }

    @Test
    public void methodreferencetest2() {
        assertTrue(mreference.lambdaSort());
    }

    @Test
    public void methodreferencetest3() {
        assertTrue(mreference.methodReferenceSort());
    }

    @Test
    public void referToInstanceMethodTest() {
        assertThat(new MethodReferenceTypes().referToInstanceMethod()[0], equalTo("Abir"));
        assertThat(new MethodReferenceTypes().referToInstanceMethod()[1], equalTo("Eugen"));
    }

    @Test
    public void referToMethodOfArbitrayType() {
        assertThat(new MethodReferenceTypes().referToInstanceMethod()[0], equalTo("Abir"));
        assertThat(new MethodReferenceTypes().referToInstanceMethod()[1], equalTo("Eugen"));
    }

    @Test
    public void referToConstructor() {
        assertThat(new MethodReferenceTypes().referToConstructor(() -> {
            return new ArrayList<String>();
        })
            .size(), equalTo(1));
        assertThat(new MethodReferenceTypes().referToConstructor(ArrayList<String>::new)
            .size(), equalTo(1));
    }

    @Test
    public void referToConstructorValueTest() {
        assertThat(new MethodReferenceTypes().referToConstructor(ArrayList<String>::new)
            .get(0), equalTo("Abir"));
    }

}