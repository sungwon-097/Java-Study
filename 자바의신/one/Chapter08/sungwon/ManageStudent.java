package one.Chapter08.sungwon;

public class ManageStudent {
    public static void main(String[] args){
        Student student[]=null;
        ManageStudent manageStudent=new ManageStudent();
        student=manageStudent.addStudent();
        manageStudent.printStudent(student);
    }
    public Student[] addStudent(){
        Student[] student = new Student[3];
        student[0]=new Student("Lim");
        student[1]=new Student("Min");
        student[2]=new Student("Sook", "Seoul", "010XXXXXXXX", "ask@godofjava.com");
        return student;
    }
    public void printStudent(Student[] student){
        for(Student data:student){
            System.out.println(data);
        }
    }
}