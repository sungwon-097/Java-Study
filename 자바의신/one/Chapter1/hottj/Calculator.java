package one.Chapter1.hottj;

public class Calculator{

    public int plus(int num1, int num2){
        return num1 + num2;
    }

    public int minus(int num1, int num2){
        return num1 > num2 ? num1 - num2 : num2 - num1;
    }

    public int multiply(int num1, int num2){
        return num1 * num2;
    }

    public int divide(int num1, int num2){
        return num1 / num2;
    }

    public static void main(String[] args){
        Calculator calculator = new Calculator();
        int a1 = calculator.minus(5, 3);
        int a2 = calculator.minus(3, 5);
        System.out.println(a1);
        System.out.print(a2);
    }
}