package com.alex.training.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Calculator calc = new Calculator();
        int a = 14;
        int b = 8;
        System.out.println("a+b="+calc.add(a, b));
        System.out.println("a-b="+calc.subtract(a, b));
        System.out.println("a*b="+calc.multiply(a, b));
        System.out.println("a/b="+calc.divide(a, b));
        System.out.println("a^b="+calc.exp(a, b));
        System.out.println("fib(a)="+calc.fib(a));
    }
}
