# JVM의 가비지컬렉터

### JVM

운영체제의 메모리 영역에 접근하여 메모리를 관리하는 프로그램

메모리 관리, Garbage Collector 수행

동적으로 할당한 메모리 영역 중 사용하지 않는 영역을 탐지하여 해제하는 기능

### Stack, Heap

Stack: 정적으로 할당한 메모리 영역

- 원시 타입의 데이터가 값과 함께 할당
- Heap영역에 생성된 Object타입의 데이터의 참조 값 할당

Heap: 동적으로 할당한 메모리 영역

- 모든 Object 타입의 데이터가 할당
- 자바에서는 최상위 Object 클래스를 상속받은 데이터가 해당
- Heap 영역의 Object를 가리키는 참조 변수가 Stack에 할당

### Garbage Collector 과정

1. Garbage Collector가 Stack의 모든 변수를 스캔하면서 각각 어떤 객체를 참조하고 잇는지 찾아서 마킹
2. Reachable Object(Stack에서 가리키고 있는)가 참조하고 있는 객체도 찾아서 마킹
3. Unrachable Object(마킹되지 않은 객체)를 Heap에서 제거

1~2번의 과정을 마킹한다고 해서 mark, 3번의 제거하는 과정을 sweep이라고 함

### Garbage Collection은 언제 일어날까?

Heap 구조는 크게 `New Gerneration`과 `Old Gerneration으로` 나뉘고, 그 안에서 각각의 영역이 다 찰때마다 GC가 발생

영역이 찰때마다 Unreachable Object들은 메모리에서 해제되고, 살아남은 Reachable Object들은 다른 영역으로 이동

New Gerneration

- Eden
  - 새로운 객체가 저장되는 공간
- Survival 0 / 1
  - Eden 영역에서 Reachable Object들이 이 영역으로 이동
  - Survival에서 이미 객체가 쌓여 있는 곳으로만 이동하게 됨(이로 인해 Survival 한 영역은 반드시 비어있음)
  - Survival에서 Reachable Object들은 age를 증가시키고 다른 Survival로 이동
- Minor GC가 발생

Old Gerneration

- Survival 영역에서 특정 age수가 넘어가는 Reacheable Object들이 이 영역으로 이동(이 과정을 Promotion 이라고 함)
- Majar GC가 발생

이러한 과정이 반복되면서 Garbage Collector가 메모리를 관리

## 링크

[우아한Tech 유튜브 - [10분 테코톡] 👌던의 JVM의 Garbage Collector](https://www.youtube.com/watch?v=vZRmCbl871I&t=205s)
