package one.Chapter1.sungwon;

public class Calculator{
  
    public int add(int num1, int num2){
      return(num1+num2);
      }
    public int subtract(int num1, int num2){
      return(num1-num2);
      }
    public int multiply(int num1, int num2){
      return(num1*num2);
      }
    public int divide(int num1, int num2){
      if(num2==0) {
        System.out.println("Error, divider is '0'"); return 0;}
      return(num1/num2);
      }
    public static void main(String[] args){
      Calculator calculator=new Calculator();
      int value=calculator.divide(10,0);
      System.out.println(value);
    }
}