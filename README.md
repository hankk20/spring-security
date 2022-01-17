# spring-security

## PreAuthentication
인증처리는 되었다고 가정하고 검증에 대한 처리만 담당한다.
* 요청헤더에 인증처리된 사용자 정보를 받아서 검증
* JWT 검증

### 설정정보
* H2 Embedded 사용
* 서버 구동시 jpa ddl 자동으로 생성
* ddl 생성후 resource 폴더의 import.sql 사용하여 초기 데이터 insert
