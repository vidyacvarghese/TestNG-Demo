package com.qburst.samples.tests;

import org.testng.annotations.Test;

public class TestGrouping {

     @Test(groups = { "group1", "group2" })
     public void testMethod1() throws InterruptedException {
    	 System.out.println(" in group1, group2");
     }
     
     @Test(groups = {"group2"} )
     public void testMethod2() {
    	 System.out.println(" in group2");
     }
    
     @Test(groups = { "group1" })
     public void testMethod3() {
    	 System.out.println("in group1");
     }

}

