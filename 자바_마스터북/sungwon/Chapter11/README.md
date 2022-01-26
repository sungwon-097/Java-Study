11. 스레드 세이프 구현하기

# 1. 멀티스레드

- 여러 작업을 동시에 수행하는 방식
- 멀티스레드의 장점

    1. 하나의 장시간을 요하는 작업 떄문에 뒤에 있는 간단한 작업이 기다릴 필요가 없다

    2. 태스크의 대기 시간을 효율적으로 활용 할 수 있다

    3. 대량의 테스크를 빨리 끝낼 수 있다

- 멀티스레드의 단점

    1. 메모리 사용량이 증가한다

    2. 처리량이 감소한다

        - 스레드 전환 시 오버헤드가 발생해 총 처리시간이 증가

    3. 동시성 특유의 문제가 발생한다(메소드가 스레드 세이프한지 확인)

## 1-1. 동시에 작업하는 경우에 일어나는 문제

1. 데이터 덮어쓰기

- >은행 예금인출 예시

2. 교착 상태 발생, 처리 정지

- DeadLockSample.java
```java
import java.util.Arraylist;
import java.util.List;

public class DeadLockSample{

    public static void main(String... args){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("ilst1-1");
        list2.add("list2-1");

        new Thread(new ResourceLocker("스레드1", list1, list2)).start(); // list1에서 객체를 취득해 list2에 기록
        new Thread(new ResourceLocker("스레드2", list2, list1)).start(); // list2에서 객체를 취득해 list1에 기록
    }
}
```

- ResourceLocker.java
```java
import java.util.List;

public class ResourceLocker implements Runnable{
    private String name;
    private List<String> fromList;
    private List<String> toList;

    public ResourceLocker(String name, List<String> fromList, List<String> toList){
        this.name = name;
        this.fromList = fromList;
        this.toList = toList;
    }

    @Override
    public void run(){
        String str = null;
        try{
            System.out.printf("%s, %n", name);
            Thread.sleep(500L);
            System.out.printf("%s, %s, %n", name, fromList);

            synchronized(fromList){
                System.out.printf("%s, %s", name, fromList);
                str = fromList.get(0);
                System.out.printf("%s, %s", name, str, fromList);
                Thread.sleep(500L);

                System.out.printf("%s, %s", name, toList);
                synchronized(toList){
                    System.out.printf("%s, %s", name, toList);
                    toList.add(str);
                    System.out.printf("%s, %s, %s", name, str, toList);
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally{
            System.out.printf("%s, %n", name);
        }
    }
}
// Dead Lock : 둘 이상의 프로세스가 다른 프로세스가 점유하고 있는 자원을 서로 기다릴 때 무한 대기에 빠지는 상태
```

3. Exception 발생

4. Infinity Loof 발생