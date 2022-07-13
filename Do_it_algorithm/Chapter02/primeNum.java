// char charAt(int i) : i위치의 문자를 반환
// int length() : 길이를 반환
// boolean equals(String s) : 문자열이 같은지를 반환

package Do_it_algorithm.Chapter02;

public class primeNum {
    public static void main(String[] args) {
        int counter = 0;

        for(int n = 2 ; n < 1000 ; n++){
            int i;
            for(i = 2 ; i < n ; i++){
                counter++;
                if(n % i == 0) break;
            }
            if(n == i)
                System.out.print(n + " ");
        }
        System.out.println("\n나눗셈을 수행 한 횟수 : " + counter);
    }
}