package one.Chapter4.hottj;

public class ProfilePrint {
    int age;
    String name;
    boolean isMarried;

    public void setAge(int val){
        age = val;
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
        isMarried = flag;
    }

    public boolean isMarried(){
        return isMarried;
    }

    public static void main(String[] args) {
        ProfilePrint profilePrint = new ProfilePrint();
        profilePrint.setAge(29);
        System.out.println(profilePrint.getAge());
    }
}
