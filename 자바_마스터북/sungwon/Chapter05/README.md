# 5. 스트림처리

## 1-1. Stream API

1. 작성 : Stream 인스턴스를 생성
2. 중간
3. 종료 : 이름을 표시

- Stream API에서는 HOW가 아닌 WHAT을 기술함. 개별 처리의 열거가 아닌 처리의 목적을 열거한다.
```java
students.stream()   // Stream 작성
    .filter(s->s.getScore() >= 70) // 중간
    .foreach(s->System.out.println(s.getName())); // 종료
```

## 1-2. 람다식 작성법

+ 정렬을 수행 할 Student 클래스
```java
public class Student{

    private String name;

    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){return this.name;}

    public int getScore(){return this.score;}

    @Override
    public String toString(){return name + ":" + score;}
}
```

+ 람다식을 이용한 정렬
```java
List<Student> studentList = new ArrayList<>();
studentList.add(new Student("Choi", 100));
studentList.add(new Student("Kim", 90));
studentList.add(new Student("Lee", 80));

System.out.println(studentList);

Collections.sort(studentList, (student1, student2) -> Integer
    .compare(student1.getScore, student2.getScore()));

System.out.println(studentList);
```
```
[Choi:100, Kim:90, Lee:80]
[Lee:80, Kim:90, Choi:100]
```

+ 람다식의 기본 문법 : (인수) -> {처리}
```java
(Student student1, Student student2) -> {
    return Integer.compare(student1.getScore(), student2.getScore());
}
```