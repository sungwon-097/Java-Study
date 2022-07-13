package Do_it_algorithm.Chapter04;

import java.util.Scanner;

public class stackIntTester {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        stackInt s = new stackInt(64); // 최대 64개를 push 할 수 있는 스택

        while(true){
            System.out.println("Number of Current Data : " + s.size() + " / " + s.capacity());
            System.out.print("(1) push (2) pop (3) peek (4) dump (any) quit : ");

            int menu = stdIn.nextInt();
            int x;
            switch(menu){
                case 1 :
                    System.out.println("Data : ");
                    x = stdIn.nextInt();
                    try{
                        s.push(x);
                    }catch(stackInt.OverflowStackException e){
                        System.out.println("err : stack is full!");
                    }
                    break;
                case 2:
                    try{
                        x = s.pop();
                        System.out.println("pop "+ x);
                    }catch(stackInt.EmptyStackException e){
                        System.out.println("err : stack is empty");
                    }
                    break;
                case 3:
                    try{
                        x = s.peek();
                        System.out.println("peek : "+ x);
                    }catch(stackInt.EmptyStackException e){
                        System.out.println("err : stack is empty");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
                default:
                    stdIn.close();
            }
        }
    }
}
