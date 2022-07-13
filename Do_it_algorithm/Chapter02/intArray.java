package Do_it_algorithm.Chapter02;

public class intArray {
    public static void main(String[] args) {
        int[] a = new int[5];
        // int[] b = new int[]{1,2,3,4,5};
        // int[] c = a.clone() : a의 복제를 참조하는 배열 c

        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        a[3] = 40;
        a[4] = 50;
        
        for(int i:a)
            System.out.print(i+" ");
    }
}
