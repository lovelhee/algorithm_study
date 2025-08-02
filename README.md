# ==============알고리즘 방법================
1. 날짜 별로 폴더 만들기
2. 클래스 이름은 Main으로 자바 파일 만들기
3. 맨위에 자신이 푼문제 URL  주석처리해서 붙혀넣기
4. git에 push하기



# =========command로 git push하는법==========
터미널에서 입력
1. git branch 자기이름                             // 자기이름으로 branch 만들기
2. git checkout  자기이름(branch 이름)      // 만든 branch로 이동
3. git add .                                           //  어떤 파일을 push할지 결정 ( . 은 모든 파일을 말함)
4. git commit -m "메시지"                           // 수정된 파일을 업데이트(메시지에는 한줄평 올리기 - ex) 어려웠던점, 어떤 알고리즘을 사용)
5. git push origin 자기이름(branch 이름)  //  업데이트한 내용을 자신의 branch에 푸쉬

ex)
1. git branch junyong
2. git checkout junyong
3. git add .
4. git commit -m "쉽다"
5. git push orign junyong

# ================command로 git pull 하는법 
git pull origin main     // 메인(branch이름)으로 부터 수정된 내용 받아오기
