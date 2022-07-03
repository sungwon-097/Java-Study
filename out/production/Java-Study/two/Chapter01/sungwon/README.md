# 1부. 기본 API

## 1장. 매번 만들기 귀찮은데 누가 만들어 놓은 거 쓸 수 없나요?

    직접해봅시다

        BigDecimal
        1. 수를 정밀하게 저장하고 표현 할 수 있는 방법, 금액이나 소숫점 사용 시 필수
        2. API문서에 따르면 Constructor Summary는 총 16개
        3. abs()는 absolute value
        4. subtract 메소드를 통해 this에서 특정 값 빼기를 수행
        5. Divide와 관련된 메소드는 아래와 같다. <http://docs.oracle.com/javase/>

```
+ BigDecimal	divide(BigDecimal divisor) Returns a BigDecimal whose value is (this / divisor), and whose preferred scale is (this.scale() - divisor.scale()); if the exact quotient cannot be represented (because it has a non-terminating decimal expansion) an ArithmeticException is thrown.

+ BigDecimal	divide(BigDecimal divisor, int roundingMode)
Returns a BigDecimal whose value is (this / divisor), and whose scale is this.scale().

+ BigDecimal	divide(BigDecimal divisor, int scale, int roundingMode)
Returns a BigDecimal whose value is (this / divisor), and whose scale is as specified.

+ BigDecimal	divide(BigDecimal divisor, int scale, RoundingMode roundingMode)
Returns a BigDecimal whose value is (this / divisor), and whose scale is as specified.

+ BigDecimal	divide(BigDecimal divisor, MathContext mc)
Returns a BigDecimal whose value is (this / divisor), with rounding according to the context settings.

+ BigDecimal	divide(BigDecimal divisor, RoundingMode roundingMode)
Returns a BigDecimal whose value is (this / divisor), and whose scale is this.scale().

+ BigDecimal[]	divideAndRemainder(BigDecimal divisor)
Returns a two-element BigDecimal array containing the result of divideToIntegralValue followed by the result of remainder on the two operands.

+ BigDecimal[]	divideAndRemainder(BigDecimal divisor, MathContext mc)
Returns a two-element BigDecimal array containing the result of divideToIntegralValue followed by the result of remainder on the two operands calculated with rounding according to the context settings.

+ BigDecimal	divideToIntegralValue(BigDecimal divisor)
Returns a BigDecimal whose value is the integer part of the quotient (this / divisor) rounded down.

+ BigDecimal	divideToIntegralValue(BigDecimal divisor, MathContext mc)
Returns a BigDecimal whose value is the integer part of (this / divisor).
```

1. API문서를 자동으로 생성하는 명령어를 무엇이라고 하나요?

        javadoc

2. API의 왼쪽 상단에는 어떤 내용이 제공되나요?

        API패키지의 리스트  

3. API의 왼쪽 하단에는 어떤 내용이 제공되나요?

        2에서 선택한 패키지의 리스트

4. API 우측 화면에는 보통 어떤 내용이 제공되나요?

        3에서 선택한 클래스의 멤버를 보여주는 리스트

5. Deprecated라는 것의 의미는 무엇인가요?

        사용하지 않는 생성자, 상수 필드, 메소드에 사용한다. 요소가 더 이상 필요하지 않을 때 사용하며 경고를 표시하지만 작동은 가능하다.