# 3. 타입 공략하기

## 3-1. 기본형과 참조형

1. 자바는 변수의 선언 시 타입을 명기하여 컴파일 시 타입의 정합성을 체크하는 정적 타입 언어

2. 기본형 : {byte, short, int, long, char, float, double, boolean}

    - 형변환 시 타입의 데이터 크기가 커지는 확장변환의 경우 호환성이 보장됨, 반대의 경우로 축소변환을 하면 오버플로우 발생 가능

3. 참조형 : 생성한 객체의 인스턴스가 특정하는 정보를 참조(포인터)라고 함

    - 클래스로부터 인스턴스를 생성하려면 new키워드를 사용, String의 경우 문자열 리터럴 사용 가능
    - 인스턴스에 null이 들어있을 가능성이 있다면 null체크 필요

4. 래퍼클래스 : 기본형을 내포하여 해당 기본형의 값을 조작하는 기능을 마련한 래퍼클래스를 제공

|기본형|래퍼클래스|//|상수|설명|
|-|-|-|-|-|
|byte|Java.lang.Byte||SIZE|비트 수|
|short|Java.lang.Short||BYTES|바이트 수|
|int|Java.lang.Int||MAX_VALUE|최댓값|
|long|Java.lang.Long||MIN_Value|최솟값|
|char|Java.lang.Char|
|float|Java.lang.Float|
|double|Java.lang.Double|
|boolean|Java.lang.Boolean|


```java
System.out.println("Byte : { SIZE(bit) : }" + Byte.SIZE
    +", BYTE: " + Byte.BYTES
    +",  MIN: " + Byte.MIN_Value
    +",  MAX: " + Byte.MAX_Value
    +" }");

System.out.println("Integer : { SIZE(bit) : }" + Integer.SIZE
    +", BYTE: " + Integer.BYTES
    +",  MIN: " + Integer.MIN_Value
    +",  MAX: " + Integer.MAX_Value
    +" }");
```
>result
```java
Byte : {SIZE(bit) : 8, BYTES : 1, MIN : -128, MAX : 127}
Integer : {SIZE(bit) : 32, BYTES : 4 MIN : -2147483648, MAX : 2147483647}
```

## 3-2 클래스 작성하기

1. 패키지 : 클래스를 계층적으로 이용하기 위해 사용
```java
package 자바마스터북/Chapter03

```

2. 접근제한자 : 인스턴스를 사용 할 수 있는 범위를 정의

- 필드, 메서드 : public / private / (non) : package private / protected

- static : 클래스 멤버로 지정 / final : 변경 없음

3. 계승 : extend한 자식 클래스에서 부모클래스의 메소드 사용 가능

4. 추상클래스 : 계승될 것을 전제로 처리의 일부분을 자식 클래스에서 수행 하도록 동작

5. 인터페이스 : 확장성을 높이기 위해 객체의 동작만을 규정

6. 익명클래스 : 특정한 한 곳에서만 클래스를 사용 할 때 유리
