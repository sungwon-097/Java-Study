package Do_it_algorithm.Chapter05;

import java.util.Scanner;

public class Factorial {
    static int factorial(int n){
        if(n>0)
            return n*factorial(n-1);
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("input Number : ");
        int x = stdIn.nextInt();
        stdIn.close();

        System.out.println("output : " + factorial(x));
    }
}