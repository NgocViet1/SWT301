package viettn;


public class Calculator{
    public int add(int a, int b){
        return a+b;
    }
    public int divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Cannot divide by zero");
        return a / b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        System.out.println("helol");
    }
}