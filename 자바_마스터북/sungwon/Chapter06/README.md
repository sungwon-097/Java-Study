6. 예외 공략하기

# 1. 예외

## 1-1. 세가지 예외
1. 검사 예외(Exception)
```
프로그램 작성 시에 예상 할 수 있는 비정상 상태를 통지하기 위해서 사용됨
```
2. 실행 시 예외(RuntimeException)
```
예상 할 수 없는 오류를 통지하기 위해 사용
```
3. 오류(Error)
```
예외와는 다리 시스템의 동작을 계속 할 수 없는 치명적인 오류
```
## 1-2. 예외를 나타내는 클래스

1. java.lang.Excepton

2. java.lang.RuntimeExcepton

3. java.lang.Error

## 1-3. 예외처리

>try 구문이 길어지면 가독성이 떨어짐

1. try-catch-fianlly
```java
try{
// someException 예외가 발생하는 코드를 포함하는 처리
}catch(SomeException ex){
// someException 예외를 catch한 경우의 처리
}finally{
// try-catch 블록을 종료 할 때에 반드시 실행 해야하는 처리
}
```
2. try-with-resources
```java
try(InputStream is = Files.newInputStream(path)){
    is.read(contents);
}catch(IOException ex){
    // 예외를 포착한 경우의 처리
}
```
3. 다중캐치
```java
try{
    Class<?> clazz = Class.forName(className);
    SomeClass objSomeclass = clazz.newInstance();
}catch(ClassNotFoundException ex){

}catch(InstantiationException ex){

}catch(IllegalAccessException ex){

}
// 각각의 예외에 상응하는 예외 처리
```

# 2. 예외처리 심화

1. 오류 코드를 return 하지 않기
```java
public String getValueFromFile(File file) throws IOException{
    Properties props = new Properties();
    props.load(Files.newInputStream(file.getPath()));
    // 파일 오픈에 실패 한 경우에는 다음으로 넘어 갈 수 없음
    // if문으로 판정이 불필요하다
    String value = props.getString("key");
    return value;
}
```
2. 에외를 제거하지 않기
```java
String strValue = "123";
try{
    int intValue = Integer.valueOf(strVlaue);
    System.out.println("intVlaue is" + intValue);
}catch(NumberFormatException ex){
    // 아무것도 할 필요가 없을 경우
}
```
```java
// 1. 로그출력을 잊지 않는다
catch(NumberFormatException ex){
    log.warn("Exception", ex);
}
```
```java
// 2. 처리를 계속 할지 판단한다(여부를 명확하게)
String strVlaue = null;
try{
    strValue = props.get("key");
}catch(IOException ex){
    log.warn("프로퍼티의 로딩에 실패하였습니다", ex);
    strValue = "defeult"; // 처리를 계속 하는 경우에 default값을 부여
}
// key 의 길이를 판정함
if(strValue.length() < LENGTH){
    log.error("length Err");
    return;
}
```
3. throw Exception 감염
```java
// 1. 호출하는 곳에서 Exception을 포착해야 한다
public void caller(){
    try{
        callee();
    }catch(Exception ex){
        // 포착해야 한다
    }
}
private void callee() throws Exception{ }
```
```java
// 2. 도중에 IOException 등 구체적인 예외가 발생한다.
public void caller(){
    try{
        callee();
    }catch(Exception ex){
        // 예외의 종류로 catch를 나눌 수 없다
}
```
```java
// 3. 도중에 RuntimeException이 발생해도 Exception에 휩쓸려버린다
public void caller(){
    try{
        callee();
    }catch(Exception ex){
        
    }
}
private void callee() throws Exception{
    String str = null;
    // NullPointerException 발생
    System.out.println("str.length = " + str.length());
}
```