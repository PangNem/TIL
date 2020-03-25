# 아마존 리눅스1 서버 세팅
아마존 리눅스 1을 처음 받았다면 몇가지 설정을 해야 한다.

- 언어 설치 (언어마다 설치 방법이 다를 수 있음)
- 타임존 변경
- Hostname 변경

EC2 서버에 접속한 후 다음 과정을 진행하면 된다.
## 설치

### JAVA 

자바 설치 
```
sudo yum install -y java-1.8.0-openjdk-devel.x86_64
```

버전을 8로 변경
```
sudo /usr/sbin/alternatives --config java
```

사용하지 않는 JAVA 7 삭제
```
sudo yum remove java-1.7.0-openjdk
```

자바 버전 확인
```
java -version
```

## 타임존 변경

```
sudo rm /etc/localtime
sudo ln -s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```

## Hostname 변경

이 명령어 입력 후, HOSTNAME을 자신이 원하는 서비스명으로 변경한다.
```
sudo vim /etc/sysconfig/network
```

재부팅
```
sudo reboot
```

다시 접속 후, /etc/hosts 파일을 열어본다.
```
sudo vim /etc/hosts
```

다음과 같은 화면에 방금 등록한 HOSTNAME을 등록한다. (4번째 줄에 새로 추가)
```
127.0.0.1 등록한 HOSTNAME
```

`:wq`로 저장하고 종료 후 정상 등록되었는지 확인
```
curl 등록한 호스트 이름
```
