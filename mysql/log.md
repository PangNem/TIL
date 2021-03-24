# log

### 로그의 종류

- Error log: mysql의 시작, 운영, 종료 때 나오는 문제들의 로그
- General log: 클라이언트로부터 접속된 접속 내용과 수행된 SQL문
- Slow query log: long_query_time 파라미터에서 설정된 시간보다 오래 수행될 경우
- Binary log: 변경된 데이터 혹은 수행된 SQL문
- Relay log: 복메 마스터 서버로부터 변경된 데이터 수신

### Error log

기본적으로 /var/log/mysql/error.log로 저장

/etc/mysql/my.cnf에 `log_error=경로.log`로 지정 가능

### General log

확인법

> SHOW VARIABLES LIKE 'general%';

변경법

> SET GLOBAL general_log = ON;

## 링크

- https://who1sth1s.tistory.com/entry/mysql-log%EB%B3%B4%EB%8A%94%EB%B2%95#:~:text=General%20log%20%ED%99%95%EC%9D%B8%EB%B2%95,GLOBAL%20general_log%20%3D%20ON%3B%20%EC%9E%85%EB%8B%88%EB%8B%A4.
- https://myinfrabox.tistory.com/10
