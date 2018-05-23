package com.java8.methodreference;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class MethodReferenceTest {
    
    private static MethodReference mreference;

    @BeforeClass
    public static void setup(){   
        System.out.println("test");
       mreference = new MethodReference();
   }

   @Test
   public void methodreferencetest1(){
       assertTrue(mreference.traditionalSort());
   }

   @Test
   public void methodreferencetest2(){
       assertTrue(mreference.lambdaSort());
   }

   @Test
   public void methodreferencetest3(){
       assertTrue(mreference.methodReferenceSort());
   }

}