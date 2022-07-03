2. 기본적인 작성법 익히기

# 2. 표기법

## 1. 문장과 블록
```java
public class HelloWorld{
    public static void main(String... args){
        System.out.println("HelloWorld");
    }
}
/* Comment*/
```

## 2. 변수, 리터럴
```java
int i;
boolean flag;
String S;
```

## 3. 연산자

|종류|기호|의미|
|-|-|-|
|관계연산자|A instanceof B|A의 객체가 B 클래스의 인스턴스면 참|
|비트연산자|<<|산술연산 (unsigned)|
|비트연산자|<<|논리연산 (signed)|

## 4. 제어 구문

```java
switch(flag){
    case 1:
    case 2:
        break;
    default;
        break;
}
```

## 5. 반복문
```java
// for
    for(int i=0; i<len ;i++){}
// foreach
    for(int i:arr){}
// while
    while(flag){}
//do while
    do{}while(flag);
```

# 2. 클래스와 매서드

## 1. Class

> 변수나 메서드를 모아둔 틀 또는 그릇
```java
class student{
    String name;
    int score;
    // static int 변하지 않는 상수
    static final int MAX_SCORE = 100;
}
```

## 2. Method
> 처리를 기술하는 블록, 결과값을 호출자에 반환 가능
```java
void printScore(int score){
    System.out.println(score);
}
```

## 3. 수식자
> 클래스나 메서드, 필드 등에 효과나 제약을 부여하는 수단

|수식자|설명|
|-|-|
|접근 제한자|클래스,메서드,필드 등에 대해 어떤 스코프에서의 액세스를 허가할지 결정|
|abstract|클래스, 인터페이스, 메서드가 추상적인 것임을 지정|
|static|클래스가 인스턴스화 되어있지 않아도 멤버에 액세스 가능|
|final|멤버변경 금지|
|transient|객체 직렬화시 대상에서 제외|
|volatile|멀티스레드부터 액세스되는 필드가 스레드마다 캐시되지 않도록 한다|
|synchoronized|동기처리를(one thread) 실행 할 수 있도록 지정|
|native|자바 이외의 네이티브한 코드를 호출한다는 것을 지정|
|strictfp|부동소수점수 IEEE754|

## 4. 오버로딩
> 인수의 타입이나 인수의 수가 다르다면 동일 명칭으로 지정 가능
```java
public class Overloading{

    void printScore(int score){
        System.out.println(score);
    }
    void printScore(){
        System.out.println(MAX);
    }
}
```