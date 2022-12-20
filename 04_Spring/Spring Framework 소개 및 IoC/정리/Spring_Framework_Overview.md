# Spring FrameWork

## Spring Framework

:자바 엔터프라이즈 개발을 편하게 해주는 오픈소스 경량급 애플리케이션 프레임 워크

- 경량 엔터프라이즈용 애플리케이션을 구축할 수 있는 원스톱 숍
- 모듈러 방식 -> 확장성
- 프레임워크로 변환하기 위해 순수 자바 코드만을 사용해 의존성을 낮춤
- 자바 플랫폼
- 개발하는데 필요한 것들(기능적/비기능적 요구사항)은 스프링에서 제공하므로 비즈니즈 로직에 집중 가능
- JDK를 이용해 만든 객체인 POJO기반

## 특징
1. 경량 컨테이너로서, Spring Bean을 직접 관리
    - Spring Bean : Ioc 컨테이너에 의해 관리되는 객체
    - Spring Bean객체의 라이프 사이클 관리, 자동 생성/사용/종료
    - Container : spring bean 객체의 생성/보관/제거하는 일을 처리하는 컨테이너

2. POJO(Plain Old Java Object) 기반의 프레임워크
    - 순수 자바

3. 제어 역전 IoC(Inversion of Control)
    - 오브젝트의 생명주기와 의존관계에 대한 프로그래밍 모델
    - 컨트롤의 제어권이 사용자가 아니라 프레임워크에 있어서, 필요에 따라 Spring에서 사용자의 코드를 호출
    - 의존성 주입 DI(Dependency Injection)
4. 관점 지향 프로그래밍(AOP: Aspect-Oriented Programming)지원
    - 복잡한 비즈니스 영역의 문제와 공통된 지원 영역의 문제를 분리 가능
    - 문제 해결을 위한 집중


    springweb : cliend 관련 함수
    spring-webmvc : server 관련 함수
    spring-websocket 


## Spring Boot & Spring Core
1. Spring boot 
    - 라이브러리만 가져오면 구성 및 실행을 자동으로 해줌
    
