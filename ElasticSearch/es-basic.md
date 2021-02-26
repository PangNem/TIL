# ElasticSearch 가이드 및 개요

### ElasticSearch란?

> Java 기반의 오픈소스 무료 검색엔진

### 특징

- 간단한 REST API
- 분산형 특징
- 빠른 속도
- 확장성

### ELK 스택

ElasicSeach, Logstash, Kibana의 첫글자를 따서 만든 스택

- ElasticSearch: 검색 및 분석
- Logstash: 로그 수집, 집계, 파싱
- Kibana: 시각화 도구

### 관계형 DB와의 용어 비교

| RDB         | ElasticSearch |
| ----------- | ------------- |
| Database    | Index         |
| Table       | Type          |
| Column      | Field         |
| Row         | Document      |
| Index       | Analyze       |
| Primary Key | \_id          |
| SQL         | Query DSL     |

### ElasticSearch 아키텍처

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile27.uf.tistory.com%2Fimage%2F99A97A355C98D42D2E5196)

클러스터 (cluster)

- ElasticSearch에서 가장 큰 단위, 하나 이상의 노드로 구성
- cluster는 서로 독립적

노드 (node)

- ElasticSearch를 구성하는 하나의 단위 프로세스
- 역할에 따라 `Master-eligible`, `Data`, `Ingest`, `Tribe` 노드로 구분

인덱스 (index)

- ElasticSearch에서 index는 RDBMS에서의 database와 대응

샤드 (shard)

- 샤딩은 데이터들을 쪼개어 저장하는 기법
- ElasticSearch에서 index들을 여러 shard로 나누어 저장
- 기본으로 1개 존재, 성능 향상을 위해 샤드 갯수를 바꾸기도 함

복제 (replica)

- 노드 손실을 대비하여 샤드를 복제
- 데이터의 **신뢰성** 보장
- 각 노드마다 1개 이상 존재 권장

### ElasticSearch가 빠른 이유

inverted index(역색인) 방식을 사용하기 때문이다.

- ElasticSearch에서 텍스트 파싱 -> 검색어 사전 만듦 -> inverted index 방식으로 저장
- 책으로 따지자면 맨 뒤에잇는 키워드로 페이지 찾기
- 그렇기에 RDBMS에 비해 **전문검색(Full Text Search)**에 높은 성능을 지님

### 참고링크

- [공식문서 - ElasticSearch란 무엇인가요?](https://www.elastic.co/kr/what-is/elasticsearch)
- [victolee - [ElasticSearch] 기본 개념잡기](https://victorydntmd.tistory.com/308)
