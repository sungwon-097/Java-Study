package one.Chapter04.sungwon;

public class ProfilePrint{
    int age;
    String name;
    boolean isMarried;
    
    public void setAge(int num){
      age = num;
    }
    public int getAge(){
      return age;
    }
    public void setName(String str){
      name = str;
    }
    public String getName(){
      return name;
    }
    public void setMarried(boolean flag){
      isMarried=flag;
    }
    public boolean isMarried(){
      return isMarried;
    }
    public static void main(String[] args){
      ProfilePrint profilePrint = new ProfilePrint();
      profilePrint.setAge(25);
      profilePrint.setName("Sungwon");
      profilePrint.setMarried(false);
      System.out.println(profilePrint.getAge());
      System.out.println(profilePrint.getName());
      System.out.println(profilePrint.isMarried());
    }
  }