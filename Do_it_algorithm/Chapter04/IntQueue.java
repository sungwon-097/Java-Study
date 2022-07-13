package Do_it_algorithm.Chapter04;

public class IntQueue { // circular queue
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){}
    }

    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){}
    }

    public IntQueue(int capacity){ // constructor
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException{
        if (num >= max)
            throw new OverflowIntQueueException(); // full
        que[rear++] = x;
        num++;
        if(rear == max)
            rear = 0;
        return x;
    }

    public int deque() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    public int peek() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    public int indexOf(int x){
        for(int i = 0; i<num ;i++){
            int idx = (i + front)%max;
            if(que[idx] == x)
                return idx;
        }
        return -1;
    }
    public void dump(){
        if(num<=0)
            System.out.println("err : queue is empty!");
        else{
            for(int i=0; i<num ; i++)
                System.out.print(que[(i+front)%max] + " ");
            System.out.println();
        }
    }

    public int size(){return num;}

    public int capacity(){return max;}
}
