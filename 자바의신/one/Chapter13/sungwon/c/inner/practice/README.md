# 3부. 객체지향

## 13장. 클래스 안에 클래스가 들어갈 수도 있구나

1. Nested 클래스에 속하는 3가지 클래스에는 어떤 것들이 있나요?

        Static nested, Local inner, Anonymous inner

2. Nested 클래스를 컴파일하려면 Nested 클래스 파일의 이름은 어떻게 되나요?

        감싸고 있는 class이름 뒤에 $기호를 붙인 후 파일 이름

3. Static Nested 클래스는 다른 Nested클래스와 어떤 차이가 있나요?

        Static Nested 클래스 에서는 클래스의 static한 변수만 참조 가능

4. StaticNested 클래스의 객체 생성은 어떻게 하나요?

        Outer.Inner inner = new Outer.inner();

5. 일반적인 내부 클래스의 객체 생성은 어떻게 하나요?

        Outer outer = new Outer();
        Outer.Inner inner = new Outer.inner();

6. Nested클래스를 만드는 이유는 무엇인가요?

        - 한 곳에서만 사용되는 클래스를 논리적으로 묶어서 처리 하고 싶을 때
        - 캡슐화가 필요 할 때(Nested클래스를 외부에 노출시키고 싶지 않을 때)
        - 소스의 가독성과 유지보수성을 높이고 싶을 떄

7. Nested 클래스에서 감싸고 있는 클래스의 private로 선언된 변수에 접근 할 수 있나요?

        가능하다

8. 감싸고 있는 클래스에서 Nested클래스에 선언된 private로 선언된 변수에 접근 할 수 있나요?

        불가능하다