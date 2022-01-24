4. 배열과 컬렉션 공략하기

# 1. 배열이란

- 동일 타입의 값을 여러 개 취급 할 수 있는 기능

```java

int[] array = new int[10]; // 크기만을 지정
int[] array = {1,2,3,4,5}; // 초기값 지정
int[] array = new int[] {5,6,7,8,9}; // 초기값과 타입 지정

System.out.println(array.length); // 길이를 출력
```

- 존재하지 않는 인덱스를 참조 할 경우

```java
int[] array = new int[10];
System.out.println(int[-1], int[10]);
```
Exception : ArrayIndexOutOfBoundException

- 배열의 검색은 binary Search로 처리

# 2. 컬렉션 프레임워크

|인터페이스|이유|
|-|-|
|List|인덱스를 지정해서 값의 취득이나 설정을 하고 싶은 경우|
|Set|값에 중복이 없고 검색/정렬을 고속으로 하고 싶은 경우|
|Map|키와 값을 나누어서 요소를 취급하고 싶은 경우|

# 3. List

## 3-1. 리스트 작성하기

```java
List<Integer> list = new ArrayList<>();
list.add(0);
list.add(1);
list.add(2); // list = [0,1,2]
```

## 3-2. 정렬과 검색

```java
Comparator <Integer> c = new Comparator<Integer>(){
	@Override
	public int compare(Interger a, Integer b){
		return b.compareTo(a);
	}
};

Collections.sort(list.c); // 정렬

int found = Collections.binarySearch(list, 0); // 0을 찾아 변수에 저장
```

## 3-3. 반복자

```java

for(String elem : list)
	System.out.println(elem); // for-each
	
for(Iterator iterator = list.iterator() ; iterator.hasNext() ; ){
	String elem = iterator.next();
	System.out.println(elem); // iterator를 사용
}
```

|클래스 분류|특징|
|-|-|
|ArrayList|반복처리 용이|
|LinkedList|추가와 삭제 간편|
|CopyInWriteArrayList|복수의 스레드 액세스|

## 3-2. Map

- 맵 작성하기
```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");
map.put(3. "Thr"); // (instance).put(key, val)로 추가
```

|클래스 분류|특징|
|-|-|
|TreeMap|Key의 대소를 의식한 부분집합 취급 가능|
|LinkedHashMap|요소의 순서를 유지|
|ConcurrentHashMap|복수 스레드로 동시에 액세스|
|HashMap|etc.|

## 3-3. Set

- 집합 작성하기
```java
Set<Integer> intSet = new HashSet<>(); // 초기화

List<Integer> intList = new ArrayList<>();
Set<Integer> intSet = new HashSet<>(intList); // 컬렉션을 set으로 변환(Array -> List -> Set)
```

|클래스 분류|특징|
|-|-|
|HashSet|검색이 빠름|
|LinkedHashSet|요소의 열거 시 유리|
|TreeSet|BST 알고리즘에 의해 요소를 정렬하는 클래스|

## 4. Another Interface

1. Queue(FIFO)

```java
Queue<Interger> queue = new ArrayQueue<>(10);
queue.offer(1);
queue.offer(2);
System.out.println(queue.poll()); // 값을 취득 후 기존 값 삭제
System.out.println(queue.peek()); // 유지
```

2. Deque

- 값의 추가 : offerFirst / offerLast
- 값의 취득 : pollFirst / pollLast
