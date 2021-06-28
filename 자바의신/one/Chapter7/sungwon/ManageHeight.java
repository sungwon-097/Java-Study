package one.Chapter7.sungwon;

public class ManageHeight {
    int [] studentHeight[];
    public void setData(){
        int [][]gradeHeight={
            {170,180,173,175,177},
            {160,165,167,186},
            {158,177,187,176},
            {173,182,181},
            {170,180,165,177,172}
        };
            studentHeight=gradeHeight;
    }
    public void printHeight(int classNo){
        int student=studentHeight[classNo].length;
        System.out.println("Class No : "+(classNo+1));
        for(int i=0; i<student; i++){
            int Height=studentHeight[classNo][i];
            System.out.println(Height);         
        }
    }
    public void printAverage(){
        int classNo=studentHeight.length;
        for(int classNum=0; classNum<classNo;classNum++){
            int student=studentHeight[classNum].length;
            int sum=0;
            for(int studentNum=0; studentNum<student;studentNum++){
                sum+=studentHeight[classNum][studentNum];
            }
            double avg=(double)sum/student;
            System.out.println("Class No : "+(classNum+1));
            System.out.println("Height Average : "+avg);
        }
    }
    public static void main(String[] args){
        ManageHeight manageHeight=new ManageHeight();
        manageHeight.setData();
        int classNum=0, classLength=5;
        while(classNum<classLength){
            manageHeight.printHeight(classNum);
            ++classNum;
        }
        manageHeight.printAverage();
    }
}
