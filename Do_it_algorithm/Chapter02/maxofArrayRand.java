package Do_it_algorithm.Chapter02;

import java.util.Random;
import java.util.Scanner;

public class maxofArrayRand {

    static int maxOf(int[] a){
        int max = a[0];
        for(int i:a){
            if(i > max) max = i;
        }
        return max;
    }
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최대값을 구합니다.");
        System.out.print("사람 수 : ");
        int num = stdIn.nextInt();
        stdIn.close();

        int[] height = new int[num];

        System.out.println("키 값은 아래와 같습니다.");
        for(int i = 0; i < num; i++){
            height[i] = 100 + rand.nextInt(90); // 100부터 189까지
            System.out.println(i+1+" : "+height[i]);
        }

        System.out.println("max : "+maxOf(height));
    }
}
