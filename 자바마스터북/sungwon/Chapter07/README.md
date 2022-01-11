# 7. 문자열 조작 공략하기

## 1-1. String Class

- String은 char의 배열을 유지하고 있음
- 한 번 만들면 변경 할 수 없음

## 1-2. 문자열 결합

1. StringBuilder 클래스 사용하기
```java
String a = "aaa", b = "bbb";

StringBuilder builder = new StringBuilder();
builder.append(a);
builder.append(b);

String str = builder.toString();
System.out.println(str);
```
2. \+ 연산자 사용
```java
String a = "aaa", b = "bbb";
String str = a + b;
System.out.println(str);
```
3. String 클래스의 concat메서드 사용하기