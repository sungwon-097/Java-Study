# 7. 문자열 조작 공략하기

## 1. String

### 1-1. 문자열 클래스

- String은 char의 배열을 유지하고 있음
- 한 번 만들면 변경 할 수 없음

### 1-2. 문자열 결합

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
String str = a + b;
System.out.println(str);
```
3. String 클래스의 concat메서드 사용하기
```java
String str = a.concat(b);
System.out.println(str);
```
> 문자열의 길이만큼 루프를 돌려 메모리를 확보하는 2, 3에 비해 1의 경우가 처리 시간이 비교적 빠르다. 

### 1-3. 문자열 분할

```java
String sentence = "This is a pen";
String[] words = sentence.split(" ");

for (String word : words)
    System.out.println(word); 
    // split메서드는 분할할 구분 문자를 정규 표현으로 지정 할 수 있다.
```

### 1-4. 여러 문자열 결합하기

+ join("sentence1", "sentence2"...) 메서드 사용

### 1-5. 문자열 치환하기

+ replace("before", "after") 메서드 사용

### 1-6. 문자열 검색하기

+ indexOf("index") 메서드 사용

## 2. 정규 표현으로 문자열 유연하게 지정

```java
Pattern pattern = Pattern.compile("This is a .*\\.");
// 정규 표현의 패턴을 생성

String sentence = "This is a pen.";
// 정규 표현에 적합한지 체크할 문자열

Matcher matcher = pattern.matcher(sentence);
// 정규표현 처리를 실시하기 위한 클래스 취득

if(matcher.matches()) { System.out.println("적합하다"); }
// 정규표현의 패턴에 적합한지 체크
```

## 3. 문자열의 포맷과 출력

### 3-1. 문자열 출력
```java
System.out.printf("I have %d, %s.", number, parameter);
```
### 3-2. MessageFormat
```java
int numbver = 13;
String parameter = "apples";

String message = MessageFormat.format("I have {0} {1}.", number, parameter);
System.out.println(message);
```