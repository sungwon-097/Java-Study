# 1부. 시작하기

##    1장. 프로그래밍이란 무엇인가?

```java
public class DoorLockManager{ // class
    
    private password; // state
    
    public boolean checkPassword(String password){ // method => behavior
        return this.password == password ? True : False;
    }
    public void setPassword(String password){
        this.password = password
    }
    public void resetPassword(){
        this.password = '1234';
    }
}

```
1. 자바의 가장 작은 단위는 클래스이다.
2. 메소드는 클래스 안에 포함되어야 한다.
3. 클래스는 상태(state)와 행동(behavior)을 가지고 있어야 한다.
