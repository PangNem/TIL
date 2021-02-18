# docker-guide-for-beginners

https://subicura.com/2017/01/19/docker-guide-for-beginners-1.html

### 도커란?

> 도커는 컨테이너 기반의 오픈소스 가상화 플랫폼

- 컨테이너는 다양한 프로그램, 실행환경을 추상화하고 동일한 인터페이스를 제공
  - 백엔드 프로그램, DB 서버, 메시지 큐등 어떤 프로그램도 추상화 할 수 있으며,
  - 조립PC, AWS, Google Cloud등 어디에서든 실행할 수 있음.

### 컨테이너란?

> 격리된 공간에서 프로세스가 동작하는 기술

- 가상화 기술이긴 하나, 기존의 OS를 가상화 하는 방식과는 차이가 있음.
- OS를 설치하여 가상화하는 방법은 성능문제가 있었고, 이를 개선하기 위해 프로세스를 격리하는 방식이 등장

### 이미지

> 컨테이너 실행에 필요한 파일과 설정값등을 포함하고 있는 것

- 예시로 ubuntu 이미지는 ubuntu를 실행하기 위한 모든 파일을 가지고 있음

### 이미지 경로

> url 방식으로 관리하며 태그를 붙일 수 있음

- ubuntu는 `docker.io/library/ubuntu:14.04`

### Dockerfile

> 도커는 이미지를 만들기 위해 Dockerfile 이라는 파일에 자체 언어를 이용하여 생성 과정을 적는다.

- 서버에 어떤 프로그램을 설치하려고 이것저것 하는 과정을 블로깅이나 메모장 대신 Dockerfile로 관리할 수 있다!

### 레이어 저장방식

- 기존 이미지에 파일에서 새로운 것을 추가할 때, 기존 이미지 파일을 다시 다운받지 않고 기존 이미지에서 추가하는 방식

![](https://subicura.com/assets/article_images/2017-01-19-docker-guide-for-beginners-1/image-layer.png)
