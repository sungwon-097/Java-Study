package Do_it_algorithm.Chapter01;

import java.util.Scanner;

public class sumWhile {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 N까지의 합을 구합니다.");
        System.out.print("input n : ");
        int n = stdIn.nextInt();

        int sum = 0; int i = 1;

        stdIn.close();
        while( i <= n ){
            sum += i;
            i++;
        }
        System.out.println("sum : "+sum);
    }
}
