# 9. 날짜 처리 공략하기

## 1. Date와 Calendar 구분하여 사용하기

### 1-1. Date
```java
Date now = new Date(); // 현재 시각으로 클래스 생성
System.out.println(now);

Date date = new Date(5000); // 1970년1월1일부터 5,000ms경과한 시간
System.out.println(date);
```

- Date 클래스의 인스턴스에 ms단위의 시간을 인수로 넣어줌
- 연, 월, 일, 시, 분등의 생성자가 존재하지만 deprecated

### 1-2. Calendar

```java
Calendar calendar = Calendar.getInstance();
System.out.println(calendar.getTime);

calendar.set(Calendar.MINUTE, 18);
calendar.set(2022, 1, 16, 23, 27, 0);
System.out.println(Calendar.getTime());
System.out.println(Calendar.get(Calendar.DATE));
calendar.add(Calendar.YEAR, 2);
calendar.add(Calendar.YEAR, -3);
```

- Calendar 클래스는 추상클래스이기 때문에 getInstance 메서드를 이용해 인스턴스를 취득한다.
- getTime()메서드로 Date 클래스로 변환된 결과를 출력
- set메서드로 지정 가능
- (yyyy, mm, dd, h, m, s)순으로 모두 지정 가능
- add()메서드로 날짜를 더하거나 뺼 수 있음

> 캘린더 필드

|인스턴드|필드|인스턴드|필드|
|-|-|-|-|
|연|Calendar.YEAR|월|Calendar.MONTH|
|일|Calendar.DAY_OF_MONTH|시|Calendar.HOUR|
|분|Calendar.MINUTE|초|Calendar.SECOND|

* * 클래스의 월은 0-11까지의 값으로 관리하고 있기 때문에 헷갈릴 수 있어 캘린더상수 이용을 권장함( 0 -> 1월)

> 캘린더 상수

|상수|월|상수|월|
|-|-|-|-|
|Calendar.JANUARY|1월|Calendar.FEBRUARY|2월|
|Calendar.MARCH|3월|Calendar.APRIL|4월|
|Calendar.MAY|5월|Calendar.JUNE|6월|
|Calendar.JULY|7월|Calendar.AUGUST|8월|
|Calendar.SEPTEMBER|9월|Calendar.OCTOBER|10월|
|Calendar.NOVEMBER|11월|Calendar.DECEMBER|12월|

```java
set(int year, int month, int date);
set(int year, int month, int date, int hourOfDay, int minute); // 이외의 값은 이전 필드의 값을 유지
```

### 1-3. Date 클래스와 Calendar 클래스의 상호 교환

1. Calendar 클래스의 메서드 이용하기
- - getTime 메서드는 캘린더 인스턴스가 보관한 시간을 Date 클래스의 인스턴스로 반환한다
```java
Calendar calendar = Calendar.getInstance();
Date date = calendar.getTime();
```
2. 기준시부터의 경과시간(ms)을 사용하기
- - 1970년 1월 1일 0시 부터 경과한 시간의 값으로 반환한다
```java
Calendar calendar = Calendar.getInstance();
Date date = new Date(calendar.getTimeInMillis());
```

>1)의 방법이 직관적

>2)는 직관적이진 않지만 시간 정보를 기본형(long)으로 처리 할 수 있는 장점이 있다. 경과시간을 유지해야 하는 경우에도 사용됨

3. Calendar로의 변환
- - setTime메서드는 Date클래스의 인스턴스를 인수로 취해 캘린더 클래스에서의 보관시간을 변경함
```java
Date date = new Date();
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
```

## 2.Date and Time API 사용하기

### 2-1. Date and Time API의 장점

- 날짜, 시간, 일시를 각각 다른 클래스로 처리해 필요에 따라 나누어 사용 할 수 있음(불필요한 정보의 보유 X)

    - 날짜 : java.time.localDate    (2022-01-17)

    - 시간 : java.time.localTime    (00:27:12.153)

    - 일시 : java.time.localDateTime    (2022-01-17T00:27:12.153)

- 연, 월, 일을 지정하여 인스턴스를 생성 할 수 있음

    - LocalDateTime.now() 메서드로 현재 날짜와 시간을 반환

    - 날짜 문자열을 지정하여 인스턴스를 얻을 수 있음

        - LocalDateTime.parse("2022-01-17T13:53:25:00") 형식으로 parse 메서드를 이용하여 지정 가능<p>

    - (yyyy, mm, dd, h, m, s)를 각각 지정 가능 (Month는 월을 나타내는 enum 클래스. ex) Month.JANUARY...)

|클래스|메서드|
|-|-|
|LocalDate|of(int year, int month, int dayOfMonth)|
||of(int year, Month month, int dayOfMonth)|
|LocalTime|of(int hour, int minute)|
||of(int hour, int minute, int second)|
||of(int hour, int minute,int second, int nanoOfSecond)|
|LocalDateTIme|of(int year, int month, int dayOfMonth, int hour, int minute)|
||of(int year, int month, int dayOfMonth, int hour, int minute, int second)|
||of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)|
||of(int year, Month month, int dayOfMonth, int hour, int minute)|
||of(int year, Month month, int dayOfMonth, int hour, int minute, int second)|
||of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)|

> Calendar 클래스에서는 0~11까지의 값을 할당하였지만 Month 클래스는 1~12까지의 값을 할당함

- 연, 월, 일의 필드값을 개별적으로 취득 할 수 있음

|클래스|메서드|||클래스|메서드||
|-|-|-|-|-|-|-|
|LocalDate|getYear|||LocalDateTime|getYear|
||getMonth|Month클래스의 월을 반환|||getMonth|Month클래스의 월을 반환|
||getMonthValue|1~12까지의 월을 반환|||getMonthValue|1~12까지의 월을 반환|
||getDayOfMonth||||getDayOfMonth|
|LocalTime|getHour||||getHour|
||getMinute||||getMinute|
||getSecond||||getSecond|
||getNano||||getNano|

- 연, 월, 일의 계산이 가능

|클래스|메서드|클래스|메서드|
|-|-|-|-|
|LocalDate|plusYears|LocalDateTime|plusYears||
||minusYears||minusYears|
||plusMonths||plusMonths|
||minusMonths||minusMonths|
||plusWeeks||plusWeeks|
||minusWeeks||minusWeeks|
||plusDays||plusDays|
||minusDays||minusDays|
|LocalTime|plusHours||plusHours|
||minusHours||minusHours|
||plusMinutes||plusMinutes|
||minusMinutes||minusMinutes|
||plusSecond||plusSeconds|
||minusSecond||minusSeconds|
||plusNanos||plusNanos|
||minusNanos||minusNanos|

```java
LocalDateTime dateTime = LocalDateTime.of(2022, 01, 17, 13 ,53 ,25 ,00);
// 시간을 지정하여 인스턴스를 생성
System.out.println(dateTime.plusDays(3));
// 3일 후
System.out.println(dateTime.minusWeeks(4));
// 4주 후
System.out.println(dateTime.minusSeconds(20));
// 20초 후
```

- >불변 객체이다.

## 3. 날짜 클래스의 문자열 상호 교환하기

### 3-1. 날짜 클래스를 임의의 형식으로 문자열 출력하기

- SimpleDataFormat클래스의 format메서드로 출력 형식을 문자열로 변환 가능

```java
import java.text.SimpleDataFormat;

...

Date date = new Date();

DataFormat format = new SimpleDataFormat("yyyy년 mm월 dd일 HH시 mm분 ss초");
System.out.println(format.format(date));
```

|문자|기호|문자|기호|문자|기호|문자|기호|
|-|-|-|-|-|-|-|-|
|G|기원|y|연도|M|월|w|연도애 대한 주|
|W|월에 대한 주|D|연도에 대한 일수|d|월에 대한 일수|F|월에 대한 요일|
|E|요일|a|오전 / 오후|H|1일에 대한 시간(0~23)|k|1일에 대한 시간(1~24)|
|K|오전/오후의 대한 시간(0~11)|h|오전/오후의 대한 시간(1~12)|m|분|s|초|
|S|밀리초|z|타임 존|Z|타임 존(4행의 숫자)|

### 3-2. 문자열로 표현된 날짜를 Date 클래스로 변환하기

- 2-1)과 같이 parse 메서드를 이용하여 지정 가능

```java
try{
    Date date = format.parse("yyyy년 mm월 dd일 HH시 mm분 ss초");
    System.out.println(date);
}catch(ParseException ex){
    System.out.println("파싱 에러");
}// 지정한 문자열이 패턴과 일치하지 않는 경우 파싱에러가 발생한다.
```

### 3-3. SimpleDateFormat 클래스는 스레드 세이프가 아니다

- Tread-Safe란 여러 스레드로부터 동시에 접근이 이루어졌을 때 실행에 문제가 없는 상태를 의미

- 멀티쓰레드 환경에서 DataFormat클래스의 인스턴스를 재사용하다보면 의도치 않은 값이 반환될 수 있다

- 날짜를 나타내는 문자열을 상수로 유지

    - 변환 직전에 DataFormat 클래스의 인스턴스를 생성

        - >재사용은 최대한 지양

### 3-4. Date ans Time API로 날짜/시간 클래스와 문자열 상호 교환하기

1. 날짜/시간 클래스를 임의의 형식으로 문자열 출력하기

- 패턴 문자를 이용하고 format메서드를 사용해서 문자열로 변환한다

```java
import java.time.format.DateTimeFormatter;

...

LocalDateTime date = LocalDateTime.now();
System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS").format(date));
// result : 2022/01/17 13:53:25.000

LocalDate date = LocalDate.now();
System.oyt.println(DateTimeFormatter
    .ofPattern("yyyy/MM/dd HH:mm:ss.SSS")
    .format(date));
// LocalDate 객체를 시간을 포함한 형식으로 변환하려 함 -> UnsupportedTemporalTypeException
```

2. 문자열로 표현된 날짜를 날짜/시간 클래스로 변환하기

- parse메서드를 사용해 문자열에서 날짜/시간 클래스로 변환

```java
TemporalAccessor parsed = DateTimeFormatter
    .ofPattern("yyyy/MM/dd HH:mm:ss.SSS")
    .parse("2022-01-17T13:53:25:00");

LocalDateTime date = LocalDateTime.from(parsed);
```

- parse메서드의 반환값은 TemporalAccessor 인터페이스로 되어있다

    - LocalDateTime클래스로 변환

3. DateTimeFormatter 클래스는 스레드 세이프다

- 여러 스레드에서 접근하여도 안전함

- 인스턴스 재사용 가능

|인스턴스|||
|-|-|-|
|ISO_LOCAL_DATE|ISO_LOCAL_TIME|ISO_LOCAL_DATE_TIME|

```java
TemporalAccessor parsed = DateTimeFormatter.ISO_LOCAL_DATE.parse("2017-02-25");
LocalDate date = LocalDate.from(parsed);
// yyyy-MM-dd 형식의 날짜로 취급하여 date 인스턴스에 저장
```