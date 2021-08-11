package one.Chapter14.sungwon.c.exception.practice;

public class Calculator {
    public static void main(String[] args){
        Calculator cal=new Calculator();
        try{
        cal.printDivide(1,2);
        cal.printDivide(1,0);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void printDivide(double d1,double d2) throws Exception{       
            if(d2==0)
                throw new Exception("Second value can't be Zero");
            double result=d1/d2;
            System.out.println(result);
    }
}
