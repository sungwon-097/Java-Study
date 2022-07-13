package Do_it_algorithm.Chapter03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class compSearch {

        static class PhysicsData{
            private String name;
            private int height;
            private double vision;
        
        public PhysicsData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
        public String toString(){ // 객체의 정보 확인
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhysicsData> HEIGHT_ORDER 
        = new HeightOrderComparator(); // 오름차순으로 정렬하기 위한 comparator

        private static class HeightOrderComparator implements Comparator<PhysicsData>{ // height 기준 정렬
            public int compare(PhysicsData d1, PhysicsData d2){
                return (d1.height > d2.height) ? 1 
                    : (d1.height < d2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhysicsData[] x = { // 오름차순 정렬된 데이터
            new PhysicsData("Kim", 163, 1.5),
            new PhysicsData("Choi", 179, 1.0),
            new PhysicsData("Lee", 185, 0.2)
        };

        System.out.print("input height : ");
        int height = stdIn.nextInt();
        stdIn.close();
        int idx = Arrays.binarySearch( // array x에서 data를 찾음
            x,
            new PhysicsData("", height, 0.0),
            PhysicsData.HEIGHT_ORDER
        );

        if(idx < 0)
            System.out.println("not exist");
        else{
            System.out.print(idx);
            System.out.println(" : "+ x[idx]);
        }
    }
}