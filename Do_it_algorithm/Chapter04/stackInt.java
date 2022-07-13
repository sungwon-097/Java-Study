package Do_it_algorithm.Chapter04;

public class stackInt {
    private int max;
    private int ptr;
    private int[] stk;

    public class EmptyStackException extends RuntimeException{ // stack empty
        public EmptyStackException(){}
    }

    public class OverflowStackException extends RuntimeException{ // stack full
        public OverflowStackException(){}
    }

    public stackInt(int capacity){
        ptr = 0;
        max = capacity;
        try{
            stk = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int push(int x) throws OverflowStackException{ // insert
        if (ptr >= max)
            throw new OverflowStackException();
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyStackException{ // out
        if(ptr <= 0)
            throw new EmptyStackException();
        return stk[--ptr];
    }

    public int peek() throws EmptyStackException{ // stack의 peek를 조회
        if(ptr <= 0)
            throw new EmptyStackException();
        return stk[ptr - 1];
    }

    public int indexOf(int x){
        for(int i = ptr - 1 ; i >= 0 ; i--)
            if(stk[i] == x)
                return i;
        return -1;
    }

    public void clear(){ptr = 0;}

    public int capacity(){return max;}

    public int size(){return ptr;}

    public boolean isFull(){return ptr >= max;}

    public void dump(){
        if(ptr <= 0)
            System.out.println("stack is empty");
        else{
            for(int i = 0;i<ptr;i++)
                System.out.println(stk[i] + " ");
            System.out.println();
        }
    }
}