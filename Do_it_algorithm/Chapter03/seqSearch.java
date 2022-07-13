package Do_it_algorithm.Chapter03;

import java.util.Scanner;

class SeqSearch{
    static int seqSearch(int[] a, int n, int key){ // 선형검색
        int i = 0;
        for(;;i++){
            if(i == n) return -1;
            if(a[i] == key) return i;
        }
        // <sentinel> : 종료조건 검사의 cost를 줄임
        // a[n] = key;
        // while()
        //  //  sequential search
        // return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("length : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for(int i = 0 ; i < num ; i ++){
            System.out.print("x" + i + " : " );
            x[i] = stdIn.nextInt();
        }

        System.out.print("search : ");
        int key = stdIn.nextInt();

        if(seqSearch(x, num, key) == -1)
            System.out.println("Not Exist");
        System.out.println(seqSearch(x, num, key));

        stdIn.close();
    }
}