package Do_it_algorithm.Chapter04;

import java.util.Scanner;

class LastNElements { // Ring Buffer(Replacement Policy : FIFO) or Circular Buffer
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        final int N = 10;
        int[] a = new int[N];
        int cnt = 0;
        int retry;

        System.out.println("input Number : ");

        do{
            System.out.printf("%d : ", cnt + 1);
            a[cnt++ % N] = stdIn.nextInt();

            System.out.print("Keep going? (y.1/n.0) : ");
            retry = stdIn.nextInt();
        }while(retry == 1);
        stdIn.close();

        int i= cnt - N;
        if(i<0) 
            i=0;
        for(;;)
            System.out.printf("%2d => %d\n", i+1, a[i%N]);
    }
}
