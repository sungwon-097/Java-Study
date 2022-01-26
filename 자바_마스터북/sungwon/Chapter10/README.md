10. 객체지향

# 1. 기본형과 참조형의 값 전달하기

## 1-1. 값 전달 방법

1. 기본형의 값을 전달하는 경우는 수신자에서 값을 변경해도 호출자에 영향을 주지 못한다
```java
public class CallByValueSample{
    public static void main(String[] arg){
        int value = 1;
        callByValue(value);
        System.out.println("호출자 : " + value);
    }
    public static void callByValue(int value){
        value++;
        System.out.println("수신자 : " + value);
    }
}
// 수신자 : 2
// 호출자 : 1
```
2. 참조형의 값을 전달 할 때는 호출된 메서드의 변경사항이 호출자에게 반영된다
```java
public class Entity{
    public int value;
}
public class CallByReferenceSample{
    public static void main(String[] arg){
        Entity entity = new Entity();
        entity.value = 1;
        callByReference(entity);
        System.out.println("호출자 : " + entity.value);
    }
    public static void callByReference(int value){
        entity.value++;
        System.out.println("수신자 : " + entity.value);
    }
}
// 수신자 : 2
// 호출자 : 2
```
3. 참조형의 값을 전달 할 때, 인수에 다른 값을 할당한 경우에 호출자의 값은 변경되지 않는다
```java
public class Entity{
    public int value;
}
public class CallByReferenceSample{
    public static void main(String[] arg){
        Entity entity = new Entity();
        entity.value = 1;
        callByReference(entity);
        System.out.println("호출자 : " + entity.value);
    }
    public static void callByReference(int value){
        entity = new Entity();
        entity.value = 2;
        System.out.println("수신자 : " + entity.value);
    }
}
// 수신자 : 2
// 호출자 : 1
```

## 1-2. 조작하면 값이 변경되는 변경 가능 클래스

```java
String text1 = "This is an Apple.";
String text2 = text1.replace("apple", "orange");
System.out.println(text1);
System.out.println(text2);
```