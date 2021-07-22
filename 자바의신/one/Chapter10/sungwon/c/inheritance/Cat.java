package one.Chapter10.sungwon.c.inheritance;

public class Cat extends Animal{
    Animal animal=new Animal();
    public void info(String name, String kind, int legCount, int iq){
        System.out.println(name+" : "+kind+", \nLeg : "+legCount+"\nIQ : "+iq);
    }
    public void move(){}
    public void eatFood(){}
    public void lifeTime(){}
    public void livePlace(){}
}
