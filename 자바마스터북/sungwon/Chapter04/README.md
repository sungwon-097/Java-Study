# 4. 배열과 컬렉션 공략하기

## 1 배열이란

> 동일 타입의 값을 여러 개 취급 할 수 있는 기능

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

## 2. 컬렉션 프레임워크

|인터페이스|이유|
|-|-|
|List|인덱스를 지정해서 값의 취득이나 설정을 하고 싶은 경우|
|Set|값에 중복이 없고 검색/정렬을 고속으로 하고 싶은 경우|
|Map|키와 값을 나누어서 요소를 취급하고 싶은 경우|

## 3. List

1. 리스트 작성하기

```java
List<Integer> list = new ArrayList<>();
list.add(0);
list.add(1);
list.add(2); // list = [0,1,2]
```

2. 정렬과 검색
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

3. 반복자
```java

for(String elem : list)
	System.out.println(elem); // for-each
	
for(Iterator iterator = list.iterator() ; iterator.hasNext() ; ){
	String elem = iterator.next();
	System.out.println(elem); // iterator를 사용
}
