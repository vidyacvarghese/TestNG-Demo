package com.qburst.samples.tests;

import org.testng.annotations.Test;

public class AnnotationExample2 {
	@Test(priority = 1)
	public void c_test() {
		System.out.println("c_test");
	}
	
	@Test(priority = 3)
	public void a_test() {
		System.out.println("a_test");
	}
	
	@Test(priority = 2)
	public void b_test() {
		System.out.println("b_test");
	}
}
