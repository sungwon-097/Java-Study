// p.61 QUIZ
package Do_it_algorithm.Chapter02;

public class sortReverse {
    static int[] reverse(int[] array){
        int[] array_clone = array.clone();

        for(int i = 0; i < array.length ; i++){
            array_clone[array_clone.length - i - 1] = array[i];
        }
        return array_clone;
    }

    static void printArray(int[] array){
        for(int i:array)
            System.out.print(i+" ");
    }

    static int sumOf(int[] array){
        int max = 0;
        for(int i:array)
            max+=i;
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,5,4,2,6,8,3,4};
        printArray(a);
        System.out.println("max : "+sumOf(a));
        printArray(reverse(a));
        System.out.println("max : "+sumOf(reverse(a)));
    }
}