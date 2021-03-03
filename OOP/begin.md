# 객체 지향 입문 정리

Nest로 개발하면서 애매한 OOP 기초 지식을 정리하기 위해 공부하였다.

## 1-1. 객체

### 절차 지향 vs 객체 지향

절차 지향 - 처음엔 쉬우나, 시간이 흐를수록 데이터가 공유하는 방식이나 구조가 복잡해짐. (수정을 어렵게 만드는 요인)

요구 사항 변경에 따른 비용 증가

객체 지향 - 데이터와 프로시저를 객체라는 단위로 묶는다.

특정 객체가 가지고 있는 데이터는 그 **객체의 프로시저만 접근 가능**하고, 다른 객체에서는 바로 접근이 불가능

프로시저를 호출함으로써 객체와 서로 연결함

### 객체란

객체의 핵심 -> 기능 제공. 내부적으로 가진 필드가 아닌, **객체를 제공하는 기능**으로 정의

### 기능 명세

메소드를 이용하여 기능을 명세한다.

```java
public class VolumeController { public void increase(int inc) { // ... } public void decrease(int dec) { // ... } public void volume() { // ... } }
```

### 객체와 객체

객체와 객체는 기능을 사용해서 연결

기능 사용 = 메서드 호출

```java
VolumnController volCont = new VolumeController(); volCont.increase(4); volCont.decrease(3); int currentVol = volCont.volumne();
```

### 용어 - 메시지

객체와 객체의 상호 작용. **메시지를 주고 받는다**라고 표현

## 1-2. 캡슐화

### 캡슐화란?

- 데이터 + 관련 기능 묶기
- 객체가 기능을 어떻게 구현했는지 외부에 감춤
- 정보 은닉 의미 포함
- **외부에 영향 없이** 객체 내부 구현 변경 가능

캡슐화하지 않을 경우, 요구사항이 수정 시 데이터 사용 방법 변화 -> 데이터를 사용하는 코드의 수정 발생

반면 캡슐화하면 기능을 제공하고 구현 상세를 감춤 -> 내부 구현만 변경하면 되므로 수정해야 할 코드의 양이 줄어들게 됨

캡슐화 시도를 통해 기능에 대한 (의도) 이해를 높인다.

### 캡슐화를 위한 규칙

> Tell, Don't Ask - 데이터를 달라 하지 말고 해달라고 하라

**안좋은 예:**

```java
if (acc.getMebership() === REGULAR) { // ...정회원 기능 }
```

**좋은 예:**

```java
if (acc.hasRegularPermission()) { // ...정회원 기능 }
```

> 데미테르 법칙

- 메서드에서 생성한 객체의 메서드만 호출
- 파라미터로 받은 객체의 메서드만 호출
- 필드로 참조하는 객체의 메서드만 호출

**안좋은 예:**

```java
acc.getExpDate.isAfter(now); Date date = acc.getExpDate(); date.isAfter(now);
```

**좋은 예:**

```java
acc.isExpired(); acc.isValid(now);
```

## 2-1. 다형성과 추상화

### 다형성

여러 모습을 갖는 것 (객체 지향에서는 한 객체가 여러 타입을 갖는 것)

한 객체가 여러 타입의 기능을 제공 - **타입 상속**으로 다형성 구현

### 추상화

데이터나 프로세스 등을 의미가 비슷한 개념이나 의미 있는 표현으로 정의하는 과정

**특정한 성질, 공통 설징(일반화)** 등의 2가지 방식으로 추상화

### 서로 다른 구현 추상화

![](https://t1.daumcdn.net/cfile/tistory/995C1045603C6DBD0F)

### 타입 추상화

여러 구현 클래스를 대표하는 상위 타입 도출

- 흔히 인터페이스 타입으로 추상화
- 추상화 타입과 구현은 타입 상속으로 연결
- 인터페이스는 기능에 대한 의미 제공하고, 구현은 제공하지 않음
- 구현을 제공하는 클래스는 콘크리트 클래스 라고 함

### 추상 타입 사용

```java
Notifier notifier = getNotifier(...); notifier.notify(someNoti);
```

추상 타입은 구현을 감춤 - 기능의 구현이 아닌 의도를 더 잘 드러냄

콘크리트 클래스를 직접 사용하는 것과 달리 **변경에 유용함**

### 추상화하는 시점

추상화는 **의존 대상이 변경하는 시점**에 하는 것이 좋음

추상화 -> 추상 타입 증가 -> 복잡도 증가

아직 존재하지 않는 기능에 대한 이른 추상화는 좋지 않음

실제 변경/확장이 발생할 때 추상화 시도

### 추상화를 잘 하려면

구현을 한 이유가 무엇 때문인지, 어느 공통점이 있는지 생각해야 함 (구현 의도 파악)

## 3-1. 상속보단 조립

### 상속을 통한 재사용시 단점

- 상위 클래스 변경의 어려움
- 클래스 증가
- 상속 오용

### 상속의 단점 해결 방법 - 조립

- 여러 객체를 묶어서 더 복잡한 기능을 제공
- 보통 필드로 다른 객체를 참조하는 방식으로 조립 또는 객체를 필요 시점에 생성/구함

```java
public class FlowController { private Encryptor encryptor = new Encryptor(); // 필드로 조립 public void process() { // ... byte[] encryptedData = encryptor.encrypt(data); // ... } }
```

### 유의점

- 상속하기에 앞서 **조립으로 풀 수 없는지** 검토
- 진짜 하위 타입인 경우에만 상속

## 4-1. 기능과 책임 분리

### 기능 분해

기능은 하위 기능으로 분해 가능하다

![](https://t1.daumcdn.net/cfile/tistory/9945B446603C6DBD0F)

### 기능을 누가 제공할 것인가?

기능은 곧 책임이고, 분리한 각 기능을 알맞게 분배

![](https://t1.daumcdn.net/cfile/tistory/99960E36603C6DBD0F)

### 큰 클래스, 큰 메서드

클래스나 메서드가 커지면 절차 지향의 문제가 발생한다.

- 큰 클래스 -> 많은 필드를 많은 메서드가 공유
- 큰 메서드 -> 많은 변수를 많은 코드가 공유
- 여러 기능이 한 클래스/메서드에 섞일 가능성

따라서 `책임에 따라 알맞게 코드를 분리할 필요`가 있다.

### 책임 분배/분리 방법

#### 패턴 적용

- 간단한 웹 -> 컨트롤러, 서비스, DAO
- 복잡한 도메인 -> 엔티티, 밸류, 리포지토리, 도메인 서비스
- AOP -> Aspect(공통 기능)
- GoF -> 팩토리, 빌더, 전략, 템플릿 메서드, 프록시/데코레이터 등

#### 계산 기능 분리

계산하는 과정을 클래스로 분리

#### 외부 연동 분리

네트워크, 메시징, 파일 등 연동 처리 코드 분리

#### 조건별 분기는 추상화

연속적인 if-else는 추상화 고민

### 주의사항

의도가 잘 드러나는 이름을 사용해야 함

### 역할 분리 시 장점

특정 기능에 대한 테스트를 용이하게 할 수 있다

## 5-1 의존과 DI

### 의존

- 기능 구현을 위해 다른 구성 요소를 사용하는 것(객체 생성, 메서드 호출, 데이터 사용 등)
- 의존은 변경이 전파될 가능성을 의미 -> 의존하는 대상이 바뀌면 바뀔 가능성이 높아짐(메서드 파라미터 변경, 익셉션 타입 추가 등)

### 순환 의존

A->B가 의존하고 B->A에 영향을 주는 케이스

모둔 수준에서 반드시 없어야 하는 의존 관계

### 의존 대상이 많은 경우

한 클래스에서 많은 기능 제공할 때는

- 각 기능마다 의존하는 대상이 다를 수 있음
- 한 기능 변경이 다른 기능에 영향을 줄 수 있음
- 기능 별로 분리 고려

혹은 몇 가지 의존 대상을 **단일 기능으로 묶어서** 생각하여 해결

### 의존 대상 객체를 직접 생성하면?

- 생성 클래스가 바뀌면 의존하는 코드도 바뀜
- 의존 대상 객체를 직접 생성하지 않는 방법
  - 팩토리, 빌더
  - 의존성 주입
  - 서비스 로케이터

### 의존성 주입 (DI)

의존하는 대상을 직접 생성하지 않고, 생성자나 메서드로 전달받는 방식

조립기가 객체 생성, 의존 주입을 처리

- DI의 장점
  - 상위 타입을 사용할 경우 의존 대상이 바뀌면 조립기(설정)만 변경하면 됨
  - 의존하는 객체 없이 대역 객체를 사용해서 테스트 가능

## 정리하며…

소프트웨어의 가치는 변화를 통해 이루어지고, 적은 비용으로 변화할 수 있는 방법 중 하나는 객체 지향이다

**개발자는 코드를 변경해야 하는 사람**이고, 변경 비용을 낮추기 위한 노력이 필요함