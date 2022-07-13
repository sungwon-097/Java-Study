package Do_it_algorithm.Chapter01;

import java.util.Scanner;

public class max{
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in); // 입력을 받음

        System.out.println("세 정수의 최대값을 구합니다.");
        System.out.print("a : ");int a = stdIn.nextInt();
        System.out.print("b : ");int b = stdIn.nextInt();
        System.out.print("c : ");int c = stdIn.nextInt();

        stdIn.close(); // resource leak이 생기지 않도록 close()

        int max = a;
        if(b > max)max = b;
        if(c > max)max = c;
        System.out.println("최대값은" + max + " 입니다.");
    }
}