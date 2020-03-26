# 아마존 EC2 서버에 프로젝트 배포하기

ssh 서버에 접속하여 진행

## 프로젝트 빌드

깃 설치
```
sudo yum install git
```

깃 버전확인
```
git --version
```

프로젝트를 저장할 디렉토리 생성
```
mkdir ~/app && mkdir ~/app/step1
```

디렉토리 이동
```
cd ~/app/step1
```

주소를 통해 저장소 내려받기
```
git clone 복사한 주소
```

빌드
```
./gradlew test
```

권한이 없을 경우 다음 명령어 실행
```
chmod +x ./gradlew
```

## 쉘 스크립트 작성하여 자동으로 배포하기

```
vim ~/app/step1/deploy.sh
```

~/app/step1/deploy.sh
```
REPOSITORY=/home/ec2-user/app/step1
PROJECT_NAME=프로젝트 이름

cd $REPOSITORY/$PROJECT_NAME/

echo "> Git Pull"

git pull

echo "> 프로젝트 Build 시작"

./gradlew build

echo "> step1 디렉토리로 이동"

cd $REPOSITORY

echo "> Build 파일복사"

cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/

echo "> 현재 구동 중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -f ${PROJECT_NAME}*.jar)

echo "> 현재 구동 중인 애플리케이션pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
	echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
	echo "> kill -15 $CURRENT_PID"
	kill -15 $CURRENT_PID
	sleep 5
fi

echo "> 새 애플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/ | grep *.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

nohup java -jar $REPOSITORY/$JAR_NAME 2>&1 &
```


스크립트 파일 실행권한 추가
```
chmod +x ./deploy.sh
```

실행
```
./deploy.sh
```

nohup.out 로그 확인
```
vim nohup.out
```

## 외부 Security 파일 등록
gitignore 등을 통해 github로 다운받지 못한 파일을 등록하는 과정이다.
```
vim /home/ec2-user/app/application-oauth.properties
```

```
nohup java -jar \
	-Dspring.config.location=classpath:/application.properties, /home/ec2-user/app/application-oauth.properties \
	$REPOSITORY/$JAR_NAME 2>&1 &
```
