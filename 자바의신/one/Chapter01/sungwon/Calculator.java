package one.Chapter01.sungwon;

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
    public double divide(int num1, int num2){
      if(num2==0) {
        System.out.println("Error, divider is '0'"); return 0;}
      return(num1/num2);
      }
    public static void main(String[] args){
      Calculator calculator = new Calculator();

      System.out.println(calculator.add(10,0));
      System.out.println(calculator.subtract(10,0));
      System.out.println(calculator.multiply(10,0));
      System.out.println(calculator.divide(10,0));
    }
}