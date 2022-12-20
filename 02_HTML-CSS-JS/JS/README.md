# Javascript

* [script 실행순서](#script-실행순서)
* [use strict](#use-strict)
* [변수](#변수)
* [자료형](#자료형)
* [연산자](#연산자)
* [DOM  Document Object Model](#dom--document-object-model)
* [이벤트](#이벤트)
* [LocalStorage](#localstorage)
* [SessionStorage](#sessionstorage)
* [JSON](#json)

## script 실행순서
- <script> : 파싱하는 도중 파싱을 멈추고 다운 + 바로 실행한 뒤 나머지 파싱을 진행함
- <script async> : 파싱하는 과정에 비동기적으로 다운로드를 받고 다운이 끝나면 바로 실행
- <script defer> : html 파싱하는 과정에서 다운을 받고 파싱이 끝난 후에 자바스크립트 파일 실행 -> 가장 이상적

## use strict
- 기존의 오류들을 throwing해줌

## 변수
- var : 재선언O, 재할당O : 하지만 사용하지 않는편이 이롭
- const : 재선언X, 재할당X
    *const로 선언된 객체의 경우 해당 객체를 변경할 수는 없지만 객체 내부의 값들은 변경할 수 있다.
- let : 재선언X, 재할당O

## 자료형
가변적 : 문자열 또는 숫자가 될 수 있음, 컴파일시가 아닌 실행 시점에 자료형이 결정되기 때문
1. 숫자형
    - 무한대
    - NaN : NOT A NUMBER
    - BigInt : 정수 리터럴 끝에 n 붙이기
2. 문자형
    - 역 따옴표(백틱, backtick) : `marco`
${변수명}  또는 표현식 ${ 100 + 200}을 문자열 중간에 손쉽게 넣을 수 있습니다.

## 연산자
- == : 값 겁사(3 과 '3'은 같다)
- === : 값과 타입까지 검사

## DOM  Document Object Model
- 웹 페이지를 이루는 테그들을 자바스크립트가 이용할 수 있게끔 브라우저가 트리구조로 만든 객체 모델
- 자바스크립트는 Dom을 제어할 수 있게 Dom이 제공하는 메서드와 프로프티를 사용하여 데이터를 추출하거나 발생한 이벤트를 받아 추가적인 처리를 수행

   ![image](https://user-images.githubusercontent.com/68840566/194845636-426e66b4-ccf1-44cc-ba7c-ab391e75e3fb.png)
   
- html 문서를 javascript를 통해서 접근할 수 있도록 트리 구조로 구조화한 객체 모델

   ![image](https://user-images.githubusercontent.com/68840566/194845661-a7f9b789-1fe6-4f45-814e-b38ff8a59d0c.png)

1. element 생성 및 삽입

`const 변수명 = document.createElement("태그명");`

`변수명.appendChild("엘리먼트명");`

2. element 참조
    - 아이디 : 반환값이 하나
    `const 변수명 = document.getElementById("아이디명");`
    
    - 클래스 return 배열 
    `const 변수명 = document.getElementsByClassName("클래스명");`

    - 태그 return 배열
    `const 변수명 = document.getElementsByTagName("태그명");`

3. querySelector 
    - querySelector : 반환값이 하나
    `document.querySelector("#heading");`

    - querySelectorAll : 반환값이 여러개
    `document.querySelectorAll(".bright");`
    `document.querySelectorAll("p");`

## 이벤트
1. 이벤트 등록 
    `이벤트대상.addEventListener()`

    ```html
    window.addEventListener("load", function(event) {
        alert("hello!");
    });
    ```

2. 마우스 이벤트
    |이벤트명|설명|
    |:---|:---|
    |["click"](https://developer.mozilla.org/ko/docs/Web/API/Element/click_event)|포인팅 장치 버튼이 엘리먼트에서 눌렸다가 놓였을 때|
    |["dbclick"](https://developer.mozilla.org/en-US/docs/Web/API/Element/dblclick_event)|포인팅 장치 버튼이 엘리먼트에서 두 번 클릭되었을 때|
    |["mousedown"](https://developer.mozilla.org/en-US/docs/Web/API/Element/mousedown_event)|포인팅 장치 버튼이 엘리먼트 위에서 눌렸을 때|
    |["mousemove"](https://developer.mozilla.org/en-US/docs/Web/API/Element/mousemove_event)|포인팅 장치가 엘리먼트 우위에서 움직일 때|
    |["mouseover"](https://developer.mozilla.org/en-US/docs/Web/API/Element/mouseover_event)|포인팅 장치가 리스너가 등록된 엘리먼트나 그 자식 엘리먼트 위로 이동 했을 때|

3. 키보드 이벤트
    |이벤트명|설명|
    |:---|:---|
    |["keydown"](https://developer.mozilla.org/ko/docs/Web/API/Document/keydown_event)|키가 눌렸을 때|
    |["keyup"](https://developer.mozilla.org/en-US/docs/Web/API/Document/keyup_event)|키 누름이 해제될 때|
    
4. 문서 로딩 이벤트
    |이벤트명|설명|
    |:---|:---|
    |["abort"](https://developer.mozilla.org/en-US/docs/Web/API/HTMLMediaElement/abort_event)|리소스 로딩이 중단되었을 때.|
    |["load"](https://developer.mozilla.org/ko/docs/Web/API/Window/load_event)|리소스와 그 의존 리소스의 로딩이 끝났을 때|
    |["DOMContentLoaded"](https://developer.mozilla.org/ko/docs/Web/API/Window/DOMContentLoaded_event)|초기 HTML 문서를 완전히 불러오고 분석했을 때 발생, 스타일 시트, 이미지, 하위 프레임의 로딩은 기다리지 않습니다.|
    |["unload"](https://developer.mozilla.org/en-US/docs/Web/API/Window/unload_event)|사용자가 사이트에서 떠나기 전에 사용자 분석 정보를 담은 통계자료를 전송하고자 할 때|
    |["resize"](https://developer.mozilla.org/ko/docs/Web/API/Window/resize_event)|다큐먼트 뷰가 리사이즈 되었을 때|
    |["scroll"](https://developer.mozilla.org/en-US/docs/Web/API/Document/scroll_event)|다큐먼트 뷰나 엘리먼트가 스크롤 되었을 때|

5. form 이벤트
    |이벤트명|설명|
    |:---|:---|
    |["blur"](https://developer.mozilla.org/ko/docs/Web/API/Element/blur_event)|엘리먼트의 포커스가 해제되었을 때|
    |["change"](https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/change_event)|목록이나 체크상태 등이 변경이 되었을 때|
    |["focus"](https://developer.mozilla.org/en-US/docs/Web/API/Element/focus_event)|폼 요소에 포커스가 놓였을 때|
    |["reset"](ttps://developer.mozilla.org/en-US/docs/Web/API/HTMLFormElement/reset_event)|폼이 다시 시작되었을 때|
    |["submit"](https://developer.mozilla.org/en-US/docs/Web/API/HTMLFormElement/submit_event)|폼이 전송되었을 때|

## LocalStorage
- 브라우저 내에 키 -값 쌍을 저장할 수 있게 해줍니다.
- 저장된 데이터는 브라우저가 종료되어도 사라지지 않습니다.
- 쿠키와 다르게 웹 스토리지 객체는 네트워크 요청시 서버로 전송되지 않습니다.( 쿠키값은 전송됨)
- 서버가 HTTP 헤더를 통해 스토리지 객체를 조작할 수 없습니다. ( 모든 조작은 자바스크립트 내에서 수행됩니다.)
- 대부분의 브라우저가 최소 2M 혹은 그 이상의 웹스토리지 객체를 저장할 수 있도록 해줍니다.
    ```html
    localStorage.setItem('test', 1);
    console.log( localStorage.getItem('test') ); // 1
    ```
- 일반 객체처럼 사용하기
    ```html
    localStorage.test = 2;
    alert( localStorage.test ); // 2

    // 키 삭제하기 
    delete localStorage.test;```


## SessionStorage
- sessionStorage는 현재 떠 있는 탭 내에서만 유지됩니다.
- 페이지를 새로 고침할 때 sessionStorage에 저장된 데이터는 사라지지 않습니다.
- 탭을 닫고 새로 열 때는 사라집니다.
- sessionStorage 객체는 localStorage에 비해 자주 사용되진 않습니다.

## JSON
1. [JSON](https://www.json.org/json-ko.html)  
    - Json  객체는 자바스크립트 객체와 마찬가지로 key/value가 존재할 수 있으며 키값이나 문자열은 쌍따옴표를 이용하여 표기해야 한다.

2. json을 이용한 객체 저장하기
    - `JSON.stringify(오브젝트변수)`
        - https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/JSON/stringify
        - Javascript 값이나 객체를 JSON문자열로 변환합니다.
        
    - `JSON.parse(제이슨객체)`
        - https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/JSON/parse
        - JSON문자열의 구문을 분석하고, 그 결과에서 Javascript 값이나 객체를 생성합니다.

```html
sessionStorage.user = JSON.stringify({name: "Marco"});

let user = JSON.parse( sessionStorage.user ); 
alert( user.name ); // Marco
```


---
이벤트 드리븐 polling
컴파일러-오토마타 , 계산이론, 형식언어이론
