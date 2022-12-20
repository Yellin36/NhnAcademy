# 브라우저와 웹서버의 관계

네트워크 엣지 : 끝단
네트어크 코어 : 라우터 등 끝단과 끝단의 사이

# 스위칭 switching
	- 서킷 스위칭
		- 회로망으로 구성.
		- 구성된 회선 독점, 안정적(트래픽이 몰릴 일이 없어 효율적임)
		- 옛날 전화망
	- 패킷 스위칭 : 현재 사용
		- 현재의 인터넷
		- 작은 패킷 단위로 데이터를 전송(패킷들의 이동)
		- 
# 네트워크 프로토콜
	- 컴퓨터나 원거리 통신 장비 사이에서 메세지를 주고받는 양식과 규칙의 체계

# OSI 7계층
- Application
- Presentation
- Session
- Transport
- Network
- DataLink
- Physical

: 상위 레이어는 하위레이어의 서비스를 받는 구조

ip주소를 알아오는 dns 도메인 네임 시스템, ip를 알아야만 주소를 알 수 있음

ip변환과정을 내부적으로 진행하는데 도메인을 보고 해당 도메인의 ip가 있으면 쓰고 없으면 ㅇns를 통해서 알아오는 과정을 거쳐 알아낸 ip를 가지고 웹서버에 접근한다

# DNS 
일종의 주소록 
메일과 관련한 중요한 서비스 제공

mx를 가지고 다른 서비스도 같이 해줌

1. 지원하는 기능- 레코드 타입
mx : 메일 송수신 서비스
txt : 아무 문자열이나 가져다슬 수있으며 메일을 발송할때 보안기능을 체크하는용도로도 쓰임


dns에서 여러 랜덤한 주소를 주기에 아무거나 가져다 쓰면 됨
***nslookup :cmd 명령어

***nslookup -q=mx : cmd 명령어
--> 결과창(mail exchanger)

C:\Users\yerin>nslookup -q=mx naver.com
서버:    172.20.nate.com
Address:  172.20.10.1

권한 없는 응답:
naver.com       MX preference = 10, mail exchanger = mx3.naver.com
naver.com       MX preference = 10, mail exchanger = mx2.naver.com
naver.com       MX preference = 10, mail exchanger = mx1.naver.com

local dns는 모든 dns를 탐색하여 결과 ip값을 알려줌

***dig naver.com :cmd 명령어

```
C:\Users\yerin>nslookup gmail.com
서버:    172.20.nate.com
Address:  172.20.10.1

권한 없는 응답:
이름:    gmail.com
Addresses:  2404:6800:4004:80c::2005
          142.250.196.133
```

```
C:\Users\yerin>nslookup -q=a gmail.com
서버:    172.20.nate.com
Address:  172.20.10.1

권한 없는 응답:
이름:    gmail.com
Address:  142.250.196.133
```

```
C:\Users\yerin>nslookup -q=mx gmail.com
서버:    172.20.nate.com
Address:  172.20.10.1

권한 없는 응답:
gmail.com       MX preference = 20, mail exchanger = alt2.gmail-smtp-in.l.google.com
gmail.com       MX preference = 40, mail exchanger = alt4.gmail-smtp-in.l.google.com
gmail.com       MX preference = 30, mail exchanger = alt3.gmail-smtp-in.l.google.com
gmail.com       MX preference = 10, mail exchanger = alt1.gmail-smtp-in.l.google.com
gmail.com       MX preference = 5, mail exchanger = gmail-smtp-in.l.google.com
```

```
C:\Users\yerin>nslookup -q=ns gmail.com
서버:    172.20.nate.com
Address:  172.20.10.1

권한 없는 응답:
gmail.com       nameserver = ns3.google.com
gmail.com       nameserver = ns2.google.com
gmail.com       nameserver = ns4.google.com
gmail.com       nameserver = ns1.google.com
```

```
C:\Users\yerin>nslookup -q=mx gmail.com ns1.google.com
서버:    ns1.google.com
Address:  216.239.32.10

gmail.com       MX preference = 40, mail exchanger = alt4.gmail-smtp-in.l.google.com
gmail.com       MX preference = 5, mail exchanger = gmail-smtp-in.l.google.com
gmail.com       MX preference = 10, mail exchanger = alt1.gmail-smtp-in.l.google.com
gmail.com       MX preference = 30, mail exchanger = alt3.gmail-smtp-in.l.google.com
gmail.com       MX preference = 20, mail exchanger = alt2.gmail-smtp-in.l.google.com
alt4.gmail-smtp-in.l.google.com internet address = 142.250.152.27
alt4.gmail-smtp-in.l.google.com AAAA IPv6 address = 2607:f8b0:4001:c56::1b
gmail-smtp-in.l.google.com      internet address = 142.251.8.27
gmail-smtp-in.l.google.com      AAAA IPv6 address = 2404:6800:4008:c15::1b
alt1.gmail-smtp-in.l.google.com internet address = 142.250.141.27
alt1.gmail-smtp-in.l.google.com AAAA IPv6 address = 2607:f8b0:4023:c0b::1b
alt3.gmail-smtp-in.l.google.com internet address = 64.233.171.27
alt3.gmail-smtp-in.l.google.com AAAA IPv6 address = 2607:f8b0:4003:c15::1a
alt2.gmail-smtp-in.l.google.com internet address = 142.250.115.26
alt2.gmail-smtp-in.l.google.com AAAA IPv6 address = 2607:f8b0:4023:1004::1a
```


# UDP
- 전화와 같은 전송도중 잘못되지는 않았는지 정도만 알 수 있으면 되는 서비스에서는 사용
- TCP보다 상대적으로 빠른 속도를 가졌다.
- DNS도 여기에 포함

* RFC : 인터넷 관련 표준 모음

*Tcp close()를 해주지않는다면 연결된 형태를 띄기 때문에 close해주는것을 잊지말자

IPv4의 TTL Time To Live 
1. rudfh fkdnxldeh aledmf tn djdjqtdmf 경로 라우팅도 믿을 수 없을정도의 데이터가 홉을 넘거나는데 그 홉의 수를 제한하는것

# NAT
- IP고갈을 막을 수 있지만
- 내부 호스트를 서버로 사용할 수 없다. 외부에서 접근이 불가능

양방항 쓰레드 동작 방식을 사용한 NC를 만들어보는게 우리의 과제입니다


# 10/18

## 라우팅 알고리즘
- 라우팅 알고리즘 빠르고 정확하게
1. Shortest Path Algorithm : 다익스트라
2. OSPF : Open sHORTEST pATH fIRST


## MAC Media Access Control
: 충돌이 나지 않도록 관리해주어야함
1. 채널을 나누어
- TDMA
-  FDMA

2. 무작위로
눈체게임마냥 무작위로 보내고 기다렸다가 다시 시도
	- CSMA
	- CSMA/CD -> COLLISION dEtection 많이 사용
	- CSMA/CA

## HTTP
1. URL & URI

## URL
<스킴>://<사용자이름>:<비밀번호>@<호스트>:<포트>/<경로>;<파라미터>?<질의>#<프레그먼트>

EX) https://nhnent.dooray.com/project/to?userWorkflowClass=registered,working

- 스킴: https, http, ftp, file (= 프로토콜)
- 호스트: nhnent.dooray.com (= 서버)
- 경로: /project/to
- 질의: userWorkflowClass=registered,working

nc -> tcp로 들어오늘 걸 출력만 하고
python -> 들어오는 걸 해석해서 기능을 실행시키는 것 응답을 해주는것이다
	요청을 받아 get/ : 루트 정보를 받아줘
	nc로 웹서버를 만든것과 같은 동작

## HTTP 요청 헤더
:강제성은 없음 되면되고 안되면 안됨

- User-Agent : 요청자 정보
- Accept: 선호하는 순서대로 해석할 수 있는 것들
- Accept-Encoding: 
- Accept-Language: 

## HTTP 응답 헤더

## Cookie
- Set-Cookie: <cookie-name>=<cookie-value>; Secure -> https에서만 사용가능한 인증관련 쿠키

## 쿠키 사용 예
- 사용 세셴 관리 : 로그인
- 개인화 : 설정값을 브라우저에서 지정해서 여기저기 사룡하는  개인화의 설정값으로 사용 가능
- 사용자 추적 :  (DNT : 1 --> DO NOT TRACKING)

쿠키 - > 임시 가변적이므로 필요한것에 매칭해서 써야함, 보안(로그인정보)에는 취약

TLS는 가능한 1.3

# [과제] 추가 설명 & 조언
mulipart/form-data가 무엇이지

모든 cmd함수들은 변형을 가하지 않은 형태로 입력과 출력을 해야하기 때문에 read()로 다시 만들어봅시다
jcommand라이브러리를 사용하여 네트워크에 집중

# 2022.10.19 Network 3일차

## REST
	. 규모 확장석
	. 범용성
	. 독립적 배포
	. 중간적 구성요소

	캐시 : 지속적인 데이터를 주고받아야하는데 데이터의 전송량이 많아진다 - > 이러한 단점을 캐시를 통해 시스템의 안정성을 높여보쟈

	HTTP의 캐시 관련 헤더를 찾아보는게 좋을 듯
	캐시의 생명주기도 받아 요청하지 않고 재사용함으로써 매우 효율적으로 웹을 구성할 수 있다

## Layered System
강화벽 lv4 proxy api gateaip djqanrhksfus 메ㅑ 등으로 레이어링을 하고 레이어가 막혀있는 상황에서 그저 나는 바로 앞단까지므안...?
subside 캐싱을통해 proxy, gateway 등등 배치 가능

## 인터페이스 일관성
4. ->> 작업적 명시 표현 메시지 타협적

## REST API 디자인 해야할 것
URI / 메세지 보내고 받는것의 디자인

가독성을 위해 _를 대신에 -를 사용 ->> _가 스페이스처럼 보이나봐여 

서비스 도메인과 컬렉션
서비스도메이/컬렉션/아이디/컬렉션/아이디 너낌으로 배치


## URK 경로 디자인 
리소스의 아이디에 대한 소유권의 유무에 따라 COLLECTION(서버) STORE(클라이언트)로 구분
컴ㄹ렉션과 스토어는 복수명사
도큐먼트는 단수 명사
컨트롤러 이름으로는 동사나 동사구

- GET/POST
- PUT을 사용하여 전체 데이터를 오버라이트
- PATCH를 사용하여 이부분의 데이터를 오버라이드
- DELETE 사용하여 데이터 삭제
- POST + 마지막에 동사 다큐먼트를 사용
: 보통 그대로 사용하지 않고 변동성을 고려하여 도큐먼트들은 변수값을 주어진다.
```http://api.soccer.restapi.org/leagues/{leagueId}/teams/{teamId}/players/{playerId}```


데이터 변경이 있는 것을 기준으로 CRUD를 나눔
CUD CREATE, UPDATE, DELETE-> 데이터 변동O
R READ-> 데이터 변동X

GET
POST
PUT : UPDATE 오버라이트
DELETE
PATCH

## Idempotant 멱등성 : 여러번 변형해도 그대로인 경우
1. safe methods : GET, HEAD, OPTIONS, TRACE : 읽기 전용
2. Idempotant methods : put, delete : 전체 오버라이트와 그냥 삭제

만약 퀴리로 값이 없을 경우 200에 빈페이지를 보내주지만 아예 그냥 소주이면 인것이다.

204 no content -> delelte g할 때 발견
409 : 프로젝트 명이 무엇이든가 ㅇ르미 중복될 때 일어나는 일어낫다.

## RESTFUL의 기준
http://martinfowler.com/articles/images/richardsonMaturityModel/overview.png

# REST API 디자인 실습 [과제]
메세지 정의 X 
URI 정의 뽑는 방법 정도만 30부 정도만 고미나고 나올 양인지 ㄴ정말 너무 너무너무 고웁금하네요


GET ARTICLES
GET ARTICLES?PAGE=1& 
DEELEE /ARTICLES/1 (리소스가 진짜로 없을경우) --> 휴지통 느낌으로다가 어떡하지
좋아요 -> 내가 좋아한 게시글

# 과제  curl ->>  client 를 수정한 htttp접속
nc의 서버 모듈을 사용하여 19일의 과제 3를 하는 건가봐여 shttpd
content type -을 잘 맞춰서 해야하는데 브라우저가 잘 작동할 예정이라는데요 모르겠어ㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜ
contentlength 는 byte사이즈임
multipart-form은 파일을 내 컴퓨터에 저장해서 상용하믄될것 같음
호스트 디레고리에 저장하고 ㅏ일이 ㅅㅇ기면 리스팅했을때 있으면 되는거임
multipart-form을 나중에 하느게 좋을것 같다