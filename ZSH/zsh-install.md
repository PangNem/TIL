# Zsh 설치
Mac 운영체제에서의 Zsh 설치
## Zsh의 장점 
기본 쉘로도 많은 기능을 할 수 있지만 zsh은 더 강력하고 다양한 기능을 제공한다.

대표적인 기능으로는 다음과 같다.
- 경로 자동추정
- 타이핑 교정
- 명령어 추천
- 다양한 플러그인

## brew 설치

```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

## zsh 설치

```
brew install zsh
```

## Oh my ZSH설치

```
sh -c "$(curl -fsSL https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
```

### 삭제

Oh my ZSH을 예전에 설치하였거나, too many open files 등의 오류로 제대로 실행이 되지 않는 경우 다음과 같이 삭제 후 다시 설치한다.

파일 권한 수정
```
sudo chmod 777 ~/.oh-my-zsh/tools/uninstall.sh
```
삭제
```
~/.oh-my-zsh/tools/uninstall.sh
```

## agnoster 테마 설치

agnoster 테마는 현재 디렉토리에서 git의 상태를 알려준다. (master branch에 실수로 커밋하는 일을 방지할 수 있다.)

```
vim ~/.zshrc
```
이 명령어 실행 후, `ZSH_THEME=”robyrussell”` 부분을 agnoster로 수정한다.

다음 명령어로 zshrc 파일을 적용시킨다.
```
source ~/.zshrc
```

`command + ,` 로 설정에서 폰트를 수정하면 글자 깨짐 현상이 수정된다.