## 🗺️ Studyroom resevation system

### 🛠️사용 기술
- DB : OracleDB
- 언어 / 프레임워크 : Java / SpringBoot

### 🤖 LLM 사용
#### 사용 LLM 
- ChatGPT 사용
#### 사용 구간
1) Docker 설정
- Oracle DB와 SpringBoot 앱 컨테이너 구성
- docker-compose.yml 예시 작성</br>
  프롬프트 : Spring Boot + OracleDB를 Docker Compose로 실행 가능한 구조로 예제 만들어줘
2) 동시성 처리 로직 설계
  - 동일 스터디룸/시간대 예약 겹침 방지
  - 트랜잭션과 FOR UPDATE 잠금 적용</br>
    프롬프트 :  Spring Boot + MyBatis 환경에서 예약 시간 겹침 방지 트랜잭션 예제 코드 작성해줘
3) 간단 토큰 기반 인증/인가 설정
  - ADMIN/USER 구분</br>
    프롬프트 : Spring Boot REST API에서 단순 문자열 토큰으로 ADMIN/USER 권한 체크 예제 만들어줘

