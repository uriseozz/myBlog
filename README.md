# 🚢나만의 항해 블로그

스프링 심화주차 과제 : 나만의 블로그만들기
http://yuuuri.shop/
</br>
</br>

## 📖프로젝트 미리보기
<p text-align="center">
<img src="https://postfiles.pstatic.net/MjAyMjAyMDZfOTkg/MDAxNjQ0MTU1MDg4MDgw.-OFoFvGN4jOqQuH5doJ3V6n-lyc17_XfGwL5OhGapicg.u_77me67f1pZEYW5PGYYCFK8ro5WsmWCulnT_OdMRIQg.JPEG.iyoule/%EC%83%81%EC%84%B8.JPG?type=w966" width="600px" alt="page" />
<img src="https://postfiles.pstatic.net/MjAyMjAyMDZfMjM3/MDAxNjQ0MTU1MDIyNjA5.jsMC-xmtlpgGfJOsX5I_F8ndO1vNACj-oiRqWzcYA7Mg.OySyghjJh1wXiF8gVMQd4Su1JP6uqQ52Fc50w-_wds0g.JPEG.iyoule/%EB%A9%94%EC%9D%B8.JPG?type=w966" width="500px" alt="page" />
<img src="https://postfiles.pstatic.net/MjAyMjAyMDZfMTc3/MDAxNjQ0MTU1MDg0MTgw.Xr7FqFoPV_maAw91HlmK_wtZeNK0hEutR02H-bdCo6sg.zW2htqNkDpO6d1eP3Yv_1rg36cQrGcVm0S4ku8b9Kgwg.JPEG.iyoule/%EA%B8%80%EC%93%B0%EA%B8%B0_%ED%8E%98%EC%9D%B4%EC%A7%80.JPG?type=w966" width="500px" alt="page" />
<img src="https://postfiles.pstatic.net/MjAyMjAyMDZfMjI4/MDAxNjQ0MTU1MDQ4MzI2.zBwCgCLCepi3bFX1DdnQ7Dk6dy0hgMd49YZquS2Adgog.QTAx6tYhClUswpkrja69LGfz7ZXQBPvM-M6IrdiiadYg.JPEG.iyoule/%EB%A1%9C%EA%B7%B8%EC%9D%B8.JPG?type=w966" width="275px" alt="page" />
<img src="https://postfiles.pstatic.net/MjAyMjAyMDZfOCAg/MDAxNjQ0MTU1MDUxNzg1.1vlYWJqrEYljtbZ8KBpP3f0cxFxvu4xQNxurp4GMS4Qg.0hr7swzH5mTSJgh5DQQSfzlZcq4aWW6sn1OA9vw8OTIg.JPEG.iyoule/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85.JPG?type=w966" width="300px" alt="page" />
</p> 
</br>

## 주요기능
* 로그인 / 로그아웃 / 소셜로그인(카카오톡) / 회원가입
* 메인페이지
  * 게시글 목록보기, 최신순 정렬
  * 글작성
* 상세페이지
  * 게시글 삭제
  * 댓글 CRUD
</br>

## 🛠기술 스택

<div>
  <img height="35" src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
  <img height="35" src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white">
  <img height="35" src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white">
  <img height="35" src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
  <img height="35" src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  <img height="35" src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white">
  <img height="35" src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
  <img height="35" src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white">
  <img height="35" src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
  <img height="35" src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
</br>
</br>


## ❗❕프로젝트 요구사항
1. 회원 가입 페이지
    - 회원가입 버튼을 클릭하기
    - 닉네임, 비밀번호, 비밀번호 확인을 입력하기
    - 닉네임은 `최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성하기
    - 비밀번호는 `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패`로 만들기
    - 비밀번호 확인은 비밀번호와 정확하게 일치하기
    - 데이터베이스에 존재하는 닉네임을 입력한 채 회원가입 버튼을 누른 경우 "중복된 닉네임입니다." 라는 에러메세지를 프론트엔드에서 보여주기
    - 회원가입 버튼을 누르고 에러메세지가 발생하지 않는다면 `로그인 페이지`로 이동시키기
2. 로그인 페이지
    - 로그인, 회원가입 버튼을 만들기
    - 닉네임, 비밀번호 입력란 만들기
    - 로그인 버튼을 누른 경우 닉네임과 비밀번호가 데이터베이스에 등록됐는지 확인한 뒤, 하나라도 맞지 않는 정보가 있다면 "닉네임 또는 패스워드를 확인해주세요"라는 메세지를 프론트엔드에서 보여주기
    - 로그인 버튼을 눌러서 에러 메세지가 발생하지 않는다면 `전체 게시글 목록 조회 페이지`로 이동시키기
3. 로그인 검사
    - `아래 페이지를 제외하고` 모두 로그인 한 경우만 볼 수 있도록 하기
        - 회원가입 페이지
        - 로그인 페이지
        - 게시글 목록 조회 페이지
        - 게시글 조회 페이지
    - 로그인을 하지 않거나 올바르지 않은 경로로 접속한 사용자가 로그인이 필요한 경로에 접속한 경우 "로그인이 필요합니다." 라는 메세지를 프론트엔드에서 띄워주고 `로그인 페이지`로 이동시키기
    - 로그인 한 사용자가 로그인 페이지 또는 회원가입 페이지에 접속한 경우 "이미 로그인이 되어있습니다."라는 메세지를 띄우고 `전체 게시글 목록 조회 페이지`로 이동시키기
4. 소셜 로그인 기능 만들기
    - 카카오 소셜 로그인이 가능하도록 하기
5. 게시글 조회 페이지 > 댓글 목록 조회
    - 로그인 하지 않은 사용자도 댓글 목록 조회가 가능하도록 하기
    - 현재 조회중인 게시글에 작성된 모든 댓글을 목록 형식으로 볼 수 있도록 하기
    - 댓글 목록 위에 댓글 작성란 만들기
        - 댓글 작성에 관한 기능은 5번 요구사항으로 연결하기
    - 댓글 목록 중, 내가 작성한 댓글인 경우 댓글 수정, 댓글 삭제 버튼 만들기
        - 댓글 수정 버튼을 누르면 6번 요구사항으로 연결하기
        - 댓글 삭제 버튼을 누르면 7번 요구사항으로 연결하기
    - 제일 최근 작성된 댓글을 맨 위에 띄우기
6. 게시글 조회 페이지 > 댓글 작성
    - 로그인 한 사용자만 댓글 작성이 가능하도록 하기
    - 게시글 조회 페이지 하단에 댓글 내용을 입력할 수 있는 댓글 작성 버튼 만들기
    - 로그인 하지 않은 사용자가 댓글 작성란을 누르면 "로그인이 필요한 기능입니다." 라는 메세지를 띄우고 `로그인 페이지`로 이동시키기
    - 댓글 내용란을 비워둔 채 댓글 작성 버튼을 누르면 "댓글 내용을 입력해주세요" 라는 메세지를 띄우기
    - 댓글 내용을 입력하고 댓글 작성 버튼을 누른 경우 작성한 댓글을 추가하기
7. 게시글 조회 페이지 > 댓글 수정
    - 내가 작성한 댓글만 수정 가능하도록 하기
    - 댓글 본문이 사라지고, 댓글 내용, 저장 버튼 생성하기
    - 댓글 내용에는 이전에 입력했던 댓글 내용을 기본 값으로 채우기
    - 수정할 댓글 내용은 비어 있지 않도록 하기
    - 저장 버튼을 누른 경우 기존 댓글의 내용을 새로 입력한 댓글 내용으로 바꾸기
8. 게시글 조회 페이지 > 댓글 삭제
    - 내가 작성한 댓글만 삭제 가능하도록 하기
    - "정말로 삭제하시겠습니까?" 메세지를 띄우고, 확인/취소 버튼 중 "확인" 버튼을 누른 경우 목록에서 해당 댓글을 삭제하기
    - 취소를 누른 경우 삭제되지 않고 그대로 유지하기
</br>
</br>

## 😎느낀점 / 배운점
* 스프링을 시작하고 처음 만들어본 프로젝트이다.
* 강의를 통해 API를 설계하는 법을 배웠고, 프로젝트 시작과 동시에 와이어프레임과 API설계부터 구상해 보았다.
* html, css, javascript의 Ajax를 이용해 뷰를 만들었고 일부는 Thymeleaf를 이용해 데이터를 입력하였다.
* html파일에서 작성해도 Thymeleaf문법은 주석처리가 다르다는 것을 알게되었다
* AWS도 강의를 보며 사용하긴 했지만 아직 손에 익지 않아 연습이 많이 필요할 것 같다.
