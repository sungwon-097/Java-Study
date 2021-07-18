# 3부. 객체지향

##    11장. 모든 클래스의 부모 클래스는 Object에요

1. 모든 클래스의 최상위 부모 클래스인 Object클래스는 어떤 패키지에 선언되어 있나요?

    java.lang패키지

2. 클래스가 어떻게 선언되어 있는지 확인할 수 있는 명령어(실행파일)의 이름은 무엇인가요?

    javap

3. Object 클래스에 선언되어 있는 모든 메소드는 여러분들이 Overriding해야 하나요?

    No

4. Object 클래스의 clone() 메소드의 용도는 무엇인가요?

    원본 객체의 필드값과 동일한 값을 갖는 새로운 객체를 생성한다. 복제 메소드

5. System.out.println() 메소드를 사용하여 클래스를 출력했을 때 호출되는 Object클래스에 있는 메소드는 무엇인가요?

    System.out.println(output) == System.out.println(output.toString());

6. 객체의 주소를 비교하는 것이 아닌, 값을 비교하려면 Object클래스에 선언되어 있는 어떤 메소드를 Overriding해야 하나요?

    equal()

7. Object 클래스에 선언되어 있는 hashCode()라는 메소드는 어떤 타입의 값을 리턴하나요?

    hashCode()는 객체의 주소값을 변환하여 생성한 객체의 고유한 정수값(int)이다.