package one.Chapter11.sungwon;

public class Student {
    String name;
    String address;
    String phone;
    String email;
    public Student(String name){
        this.name=name;
    }
    public Student(String name, String address, String phone, String email){
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.email=email;
    }
    @Override
    public String toString(){
        return name+" "+address+" "+phone+" "+email;
    }
    @Override
    public boolean equals(Object obj){
        Student param=(Student) obj;
        if(param.name!=this.name) return false;
        if(param.address!=this.address) return false;
        if(param.phone!=this.phone) return false;
        if(param.email!=this.email) return false;
        
        return true;
    }
}