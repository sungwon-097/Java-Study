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
        list1.add("list1-1");
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
// 서로의 스레드가 list의 잠금을 해제하기를 기다리는 상태가 된다.
```
3. Exception 발생

4. Infinity Loof 발생

## 1-2. 멀티스레드 문제에 대응하기 어려운 이유

- 멀티스레드 문제는 타이밍에 따라 발생하거나 그러지 않는 경우가 존재(버그의 재현성이 낮음)

- 대응 방식
    1. 문제가 발생 할 때 까지 기다린다
    2. 문제가 발생 할 수 있을 것 같은 상황(대량의 입력을 발생시키는 등)을 의도적으로 만들어 문제가 발생할 확률을 높인 후 기다린다
    3. 문제가 발생 할 수 있을 것 같은 프로그램의 부분을 잘 찾아서 문제를 추측한다

- 해결에 오랜 시간을 필요로 하거나 스레드의 깊은 이해를 필요로 할 가능성이 있다 -> 문제의 대응이 어려워짐

- 확실한 방법은 스레드를 만들지 않는 것

- 멀티스레드 환경에선 스레드세이프하게 설계를 하도록 노력해야함

# 2. 스레드세이프 구현하기

## 2-1. 스레드 세이프

- 스레드세이프의 조건

    - 여러 스레드에서 읽거나 쓸 경우에도 데이터가 파괴되지 않는다
    - 여러 스레드에서 읽거나 쓸 경우에도 처리 오류가 발생하지 않는다
    - 여러 스레드에서 읽거나 쓸 경우에도 교착 상태/처리 정지가 발생하지 않는다

### 스레드 세이프 하지 않은 경우

```java
private static int NUM = 0;
int a = NUM;
a++;
// int의 증가 처리
// 여러 스레드에서 동시에 증가시켰는데도 값이 증가하지 않을 수 있다

SimpleDateFormat format = new SimpleDateFormat();
Date date = format.parse("yyyy년 mm월 dd일 HH시 mm분 ss초");
// parse 메서드
// 

HashMap<int> map;
map.put(NUM);
// HashMap 의 put 메서드

ArrayList<int> list;
list.add(NUM);
list.remove(NUM);
// Arraylist 의 add, remove 메서드

import javax.xml.bind.Marshaller


```