package com.alex.training.app;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class AppTest 
   
{
	private Calculator calc;

    public AppTest() {
        this.calc = new Calculator();
    }

    @Test
    public void additionTest() {
        System.out.println("Test: Addition");
        Assert.assertEquals(calc.add(2,2),4);
    }

    @Ignore
    @Test
    public void substractionTest() {
        System.out.println("Test: Subtract");
        Assert.assertEquals(calc.subtract(2,2),0);
    }

    @Test
    public void fibonacciTest() {
        System.out.println("Test: Fibonacci");
        Assert.assertEquals(calc.fib(10), 55);
    }

    @Test
    public void powTest(){
        System.out.println("Test: Pow");
        Assert.assertEquals(calc.exp(2,8), 256);
    }

    @Test
    @Parameters({"message"})
    public void messageTest(String message){
        System.out.println("Test: parameter message");
        Assert.assertEquals(message,"I'm a message");
    }

    @BeforeMethod
    public void beforeTest(){
        System.out.println("This will run BEFORE any method.");
    }

    @AfterMethod
    public void afterTest(){
        System.out.println("This will run AFTER any method.");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("This will run BEFORE the suite.");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("This will run AFTER the suite.");
    }
}
