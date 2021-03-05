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
3. 마킹되지 않은 객체를 Heap에서 제거

## 링크

[우아한Tech 유튜브 - [10분 테코톡] 👌던의 JVM의 Garbage Collector](https://www.youtube.com/watch?v=vZRmCbl871I&t=205s)
