# git init

기존 폴더와 새로운 github repository 연결

git remote add 명령어에는 해당 name과 repository를 알맞게 넣어야 한다.

```bash
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/NAME/REPOSITORY_NAME.git
git push -u origin main
```

git push 명령어를 했을 때 repository를 찾을 수 없다고 하는 경우, 오타나 github 내에서 access가 있는지 확인하자.
