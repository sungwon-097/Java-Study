package Do_it_algorithm.Chapter01;

import java.util.ArrayList;
import java.util.Arrays;

public class maxList {
    static ArrayList<Integer> int_List = new ArrayList<Integer>(Arrays.asList(1,2,7,4,5));
    public static void main(String[] args) {
        int max = int_List.get(0);  // list의 요소를 가져오는 메소드 .get(index)
        for(int i:int_List){
            if(i > max)    max = i;
        }
        System.out.println("max = " + max);
    }
}