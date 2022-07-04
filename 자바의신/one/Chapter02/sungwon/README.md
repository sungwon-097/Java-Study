# 1부. 시작하기

##   2장. Hello Basic Java

```java
public class HelloBasicJava{
    public static void main(String[] args){
        // fill
    }
}

$ java -version
$ javac HelloBasicJava.java
```
### 출력함수

1. System.out,println() : 출력 후 줄바꿈

2. System.out,print() : 출력

### 메소드의 6가지 요소
```java

@AllArgsConstructor
public class userController{
    private User user;
    public boolean checkUser(User user){
        this.user == user ? return True : return False;
    }
    
    public static void main(String[] args){

        User user1 = new User();
        User user2 = new User();
        
        userController controller = new userController();
        controller.setUser(user1);
                
        System.out.println(controller.checkUser(user1));
    }
}
```
1. 접근 제어자 : public, private, protected
2. 리턴 타입 : String, int, Class
3. 매개 변수 목록 : method(type name)
4. 메소드 이름 : public String Name(){}
5. 예외 목록 : exception
6. 메소드 내용 : { // fill }