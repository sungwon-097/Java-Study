package Do_it_algorithm.Chapter03;

import java.util.Arrays;

class BinSearch {
    
    static int binSearch(int[] a, int n, int key){ // sorted array 일 경우에만 유효함
        int begin = 0, end = n-1;

        do{
            int pivot = (begin + end) / 2;

            if(a[pivot] == key) return pivot;
            else if(a[pivot] < key) begin = ++pivot;
            else end = --pivot;
        }while(begin <= end);

        return -1;
    }

    public static void main(String[] args) {
        int len = 10;
        int[] arr = new int[len];
        for(int i = 0 ; i < len ; i++)  
            arr[i] = i;

        int key = 3;
        System.out.println(binSearch(arr, len, key));
        System.out.println(Arrays.binarySearch(arr, key)); // java.util.Arrays의 메소드를 사용해서 찾을 수도 있음
    }
}
