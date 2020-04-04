package com.alex.training.app;

public class Calculator {
	
	public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return this.add(a, -b);
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide (int a, int b){
        return a / b;
    }

    public int fib(int a){
        if(a<2){
            return a;
        } else {
            return fib(a-1) + fib(a-2);
        }
    }

    public int exp(int a, int b){
        int result = 1;
        for(int i=0; i<b; i++){
            result *= a;
        }
        return result;
    }

}
