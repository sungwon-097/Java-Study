// final class는 서브 클래스를 가질 수 없다
package Do_it_algorithm.Chapter02;

public class physicalExam {
    
    static final int VMAX = 21;

    static class PhyscData{

        private
            String name;
            int height;
            double vision;

        public
            PhyscData(String name, int height, double vision){
                this.name = name;
                this.height = height;
                this.vision = vision;
            }
            String getname(){
                return name;
            }
    }

    static double aveHeight(PhyscData[] dat){
        double sum = 0;
        for(PhyscData i:dat)
            sum += i.height;
        return sum/dat.length;
    }

    public static void main(String[] args) {
        PhyscData[] person = {
            new PhyscData("java", 180, 2.0),
            new PhyscData("cpp", 178, 1.0),
            new PhyscData("python", 192, 0.5)
        };
        System.out.println("average height : "+aveHeight(person));
    }
}
