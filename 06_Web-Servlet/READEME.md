# WEB/Servelt

## 웹 애플리케이션 아키텍처

1. 클라이언트-서버 아키텍처
2. 웹 어플리케이션 아키텍쳐
    - 전송 프로토콜 표준화: http
    - 클라이언트 프로그램 표준화 - 웹 브라우저
    - 콘텐츠 표준화-html, css, javascript

## 웹 서버
 http 프로토콜읉= 통해 웹 브라우저에서 요청하는 (정적인 컨텐츠)오브젝ㅌ를 전송해주는 프로그램

nginx : 웹서버에 html하나 만들기
1. 정적 웹 콘텐츠
2. 동적 웹 콭넽츠
    - 특정한 요인이나 요청에 따라 변경되는 콘텐츠
    - 사용자와의 상호작용에 다라 변경

## CGI common gateway interface

: 웹 서버가 외부 프ㅗ그램을 실행할 수 있도록 해주는 인터페이스 명세
- python, ruby등이 프로그램을 실행하고 m

웹 어플리케이션
- 클라이언트 : 브라우저
- 서버 - 웹 서버 : 정적 파일 서비스
- 동적 서버 : cgi스크립트 짜고 자ㅏㅂ로 자는 데 시간어랙 ㅓㄹ리지 헤더도 추가해주야하ㅡㄴㄴ데 너무 복잡한 문제가 있다
## CGI 문제점
 매 htttp욫어마다 새로운 프로세스가 생성
    - 매 요청- 소스 해석- 리소스 사용 - 속도가 매우 느림
    -ddo 공격있으면 ㅐㄱ락 문제 해결함

## CGI-해결책
1. fastcgi : pㅐㅐㅣ==ㅑㅣu 방식, 미리 만들어 두고 시작하면 시키고 끝나면 돌아가고
2. servelt


## servlet
메이븐은 빌드 툴
provided scope은 무엇일까
lombok : getter, setter,등 반복적으로 되는 코드들을 자동으로 생성해주는 라이브러리
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor 등등이 있음

웹의 jar는 war 대신에 단독 실행이 불가능하고 tomcat을 같이 사용해야 함
springboot에서는 jar로 생성해도 상관이 없음

: java를 사용하여 동적 웹 콘텐츠를 생성하는 서버측 프로그램 : java로 만든 cgi프로그램

## php : fastcgi : 전부 만들어놓고 골라쓰기

## was (web application server)

## java 언어 플랫폼 : java언어로 작성된 프로그램이 실행되는 특정한 환경
환경별로 언어를 나눈 것
- java se Standar Edition : 일반적인 응용 프로그램 개발 용도
- java ee Enterprise Edition : SE를 확장하여 분산 컴퓨팅, 웹 서비스와 같은 엔터프라이즈 환경을 지원
- java me Micro Edition : 임베디드 시스템이나 모바일 디바이스를 위한 개발 환경
- Javafx : 화려한 클라이언트를 만드는 경우 그래픽이 화려함

오픈소스 sw를 지원하는 비영리 단체 eclipse 재단에서 2017 이후 중단된 java ee 프로젝트를 이관하여 jakarta ee로 제공


## tomcat 
apache 재단에서 개발한 무료 오픈 소스 was로 
servlet contatiner의 레퍼런스 구현 
내가 짠 코드 돌려주는 서버라고 생각을 해봅시다

## Servlet도 API 다!

PROVIED API를 참조만하고 구

## logback 을 통한 로거 사용

설정을 읽어 빈을 생성하고 의존관계를 가진 문맥정보를 어플리케이션 콘텍스ㅡ라고 한다.
웹과 그냥 어플리케이션 콘텍스트의 차이는 서블릿 컨텍스트가 차이다.
추가로 들어있냐 없냐의 차ㅣ를 가짐
서블릿과 서블릿 컨테이너간의 설정 정보
서블릿의 컨테이너의 실행혼경으로

cookie은 사용자 브라우저에 저장되며 민감한 개인정보는 절대 저장하지 않는다. 작은 데이터 블록. 인증정보(로그인을 했는지 안했는지)
웹 사이트를 방문할때 웹사이트의


## Session
서블릿 컨테이너,  was, tomacat등 웹 서버에 저장됨.

쿠키와 세션의 차이는 ?


# 10/25

새로운 요청을 만드는게 아니라 그
요청이 다른 경우에는  
이 요청을 끝내고 다른 요청을 시작할때는 sendDirect
이 요청을 다른 이에게 넘기고 나는 다른 리퀘스트를 받고싶을 때 forward

servlet의 경우 들어오는 값에 따라 post, get 메소드를 꼭 선언해줘야하는 제약이 있다. 

어떤 요청에 대하여 여러 필터를 가질 수 있다.
체인 형태로 제공

filter 또한 context가 관리하는 생명주기 모델이다


## JSP

## attribute
servlet context : 서블릿 전체가 공유 가능한
session : 한 사용자의 한 디바이스 안에 공유 가능한
request : 짧은 구간, 다음 요청에 보낼 데이터 값