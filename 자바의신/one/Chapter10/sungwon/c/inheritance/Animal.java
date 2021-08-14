package one.Chapter10.sungwon.c.inheritance;

public class Animal {
    String name;
    String kind;
    int legCount;
    int iq;
    boolean hasWing;
    public void info(String name, String kind, int legCount, int iq){
        System.out.println(name+" : "+kind+", \nLeg : "+legCount+"\nIQ : "+iq);
    }
    public void move(){}
    public void eatFood(){}
    public void lifeTime(){}
    public void livePlace(){}
    public static void main(String[] args){}
}