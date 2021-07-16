package one.Chapter06.sungwon;

public class InterestManager {
    public double getInterestRate(int day){
        if(day<91)       return 0.050;
        else if(day<181) return 0.01;
        else if(day<365) return 0.02;
        else             return 0.056;
    }
    public double calculateAmount(int day, long amount){
        double interestRate=getInterestRate(day)*amount;
        return amount+interestRate;
    }
    public static void main(String[] args){
        InterestManager interestManager=new InterestManager();
        long amount=0;
        for(int day=1;day<366;day+=10){
            amount+=1000000;
            System.out.println(interestManager.calculateAmount(day, amount));
        }
    }
}
