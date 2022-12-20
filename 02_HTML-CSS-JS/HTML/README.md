# HTML

  * [웹페이지의 3가지 구성요소](#◾-웹페이지의-3가지-구성요소)
  * [HTML](#◾-html)
  * [Element 요소](#◾-element-요소)
  * [Attribute 속성](#◾-attribute-속성)
  * [공백과 특수 문자](#◾-공백과-특수-문자)
  * [HTML 문서의 구조](#◾-html-문서의-구조)
  * [TAG 태그](#◾-tag-태그)
  * [Layout 레이아웃](#◾-layout-레이아웃)
  * [Form Elements](#◾-form-elements)
  * [Input Tag](#◾-input-tag)
  * [그 외의 태그들 ](#◾-그-외의-태그들)

  
## ◾ 웹페이지의 3가지 구성요소
1. HTML
2. CSS
3. JS

## ◾ HTML 
: Hypertext Markup Language, 웹페이지를 위한 지배적 마크업 언어

- 제목, 단락, 목록 등과 같은 본문을 위한 구조적 의미
- 링크, 인용과 그 밖의 항목으로 구조적 문서를 만들 수 있는 방법 제공
- 이미지와 객체를 내장하고 대화형 양식을 생성하는데 사용

=> 웹 페이지가 어떻게 구조화되어 있는지 브라우저가 알 수 있게 하는 마크업 언어로 element들로 구성되어 있음

## ◾ Element 요소
![image](https://user-images.githubusercontent.com/68840566/194823618-dace7dd0-f4a6-4f74-9b19-6a7c52b6c1de.png)
1. 여는 태그 Opening tag 
    - 요소의 이름과 열고 닫는 꺽쇠 괄호로 구성. 
    - 태그 시작 부분부터 효과 적용
    - 괄호 안에는 Attribute들이 있음
2.  닫는 태그 Closing tag
    - 요소의 앞에 슬래시(/)가 있는 것을 제외하면 여는 태그과 같음. 
    - 요소를 종료

## ◾ Attribute 속성
: 요소에 실제로는 나타내고 싶지 않지만 추가적인 내용을 담고 싶을 때 사용
![image](https://user-images.githubusercontent.com/68840566/194823636-bcbfa0b5-fcbc-4c7b-984c-040b819082df.png)
- 속성은 공백으로 구분
- 속성 이름 다음에는 등호(=)가 붙고 속성값을 부여한다.
- 이때 속성값은 따옴표로 감싸야 함.

## ◾ 공백과 특수 문자
1. HTML은 공백을 표시하지 않음
2. 특수문자
    |Literal Character|Character reference equivalent|
    |:---:|:---:|
    |&lt;| `&lt`|
    |&gt;| `&gt`|
    |&quot;| `&quot`|
    |&apos;| `&apos`|
    |&amp;| `&amp`|
3. 주석  
    `<!--주석 내용-->`


## ◾ HTML 문서의 구조
``` html
<!DOCTYPE html>
<html> 
    <head>  
        <meta charset="utf-8">
        <title> My test page</title>
    </head>
    <body>
        <p>This is my page.</p>
    </body>
</html>
```
1. `<!DOCTYPE html>` : 문서 형식
2. `<html>` : HTML 전체 페이지의 콘텐츠 포함
    - HTML 전체를 감싸는 태그
    - lang 속성 `lang="ko` :  웹 접근성을 준수하고, 검색과 음성장치에서 사용한다. 또한, User-Agent가 언어를 해석할 수 있도록하여 구글번역기가 이를 사용함
3. `<head>` : 사용자에게 보이지 않지만 검색결과에 노출될 키워드, 홈페이지 설명, CSS스타일, Charset등 HTML 페이지의 내용을 담는 곳
    - 페이지에 대한 metadata 포함 
        - `<title>` : 제목 표시
        - `<style>` : css 파일 참조
        - `<link>` : 파일 참조
        - `<script>` : javascript 파일 참조
    - `<meta>` 속성
        - `charset = "UTF-8"` : 인코딩 설정
        - `http-equiv="" content=""` : IE 호환성
        - `name="" content=""` : 페이지 설명

4. `<body>` : 텍스트, 이미지, 비디오 게임, 재생 가능한 오디오 트랙 등 HTML 페이지의 표시되는 모든 콘텐츠를 포함


## ◾ TAG 태그
1. 제목
    - `<h1></h1> ~ <h6></h6>` : 제목, 숫자는 문자 크기(클수록 작아짐)
2. 단락 : `<p></p>`
3. 줄바꿈 : `<br>`
4. 목록
    - 순서 없는 목록 `<ul></ul>` : unordered list
        ```html
        <ul>
            <li> milk </li>
            <li> egg </li>
            <li> bread </li>
        </ul>
        ```
    - 순서 있는 목록 `<ol></ol>` : ordered list
        ```html
        <ol>
            <li> milk </li>
            <li> egg </li>
            <li> bread </li>
        </ol>
        ```
    - 목록의 항목 `<li></li>` : list
5. 중요와 강조
    - 중요 `<strong></strong>`
    - 강조 
        - `<b></b>` : 굵게
        - `<i></i>` : 기울임
        - `<u></u>` : 밑줄
6. 태그 인용구  `<blockquote></blockquote>`
7. 위첨자 `<sup></sup>`와 아래첨자 `<sub></sub>` : 작은 글씨
8. 연락처 세부사항 `<address></address>` : 기울기
9. 설명 리스트 
    ```html
    <dl>
        <dt>단어</dt>
        <dd>설명</dd>
        <dt>단어</dt>
        <dd>설명</dd>
    </dl>
    ```
10. 출처 `<cite></cite>`
11. 약어 `<abbr></abbr>` : 점선 밑줄
12. 코드
    |태그|설명|
    |:---|:---|
    |`<code>`|일반적인 컴퓨터 코드|
    |`<pre>`|공백 유지|
    |`<var>`|변수 이름을 특별하게 표시|
    |`<kbd>`|컴퓨터에 입력된 키도브 입력을 표시|
    |`<samp>`|컴퓨터 프로그램의 출력 표시|
13. 시간과 날짜 표시 `<time datetime=""></time>`

    <datetime 형식>

    |표현|설명|
    |:---|:---|
    |2022-10-10 | 년-월-일|
    |2022-10 | 년-월|
    |10-10 | 월-일|
    |16:23 | 시-분|
    |16:23:01.546 | 시-분-초|
    |2022-10-10-T16:23 | 년-월-일-시-분|
    |2022-10-10-T16:23+01:00 | 년-월-일-시-분-초|
14. 하이퍼링크 `<a hred="링크주소">텍스트 또는 이미지</a>`
15. 이메일 링크 `<a mailto:"이메일주소"></a>`
16. 이미지 `<img src="이미지 경로/이미지이름.파일형식" alt="대체용 텍스트">`
17. 테이블 

    <기본 태그>

    |태그|설명|
    |:---|:---|
    |`<table>`| 테이블의 시작|
    |`<tr>`|행 생성|
    |`<th>`|제목 열(가운데 + 굵게) 생성|
    |`<td>`|열 생성|

    <구조 태그>

    |태그|설명|
    |:---|:---|
    |`<caption>`|테이블의 제목|
    |`<thead>`|테이블 헤더|
    |`<tbody>`|테이블 내용|
    |`<tfoot>`|테이블 푸터 지정|

    <테이블 속성>
    - 행합치기 `<colspan="합칠 행 개수">`
    - 열합치기 `<rowspan="합칠 열 개수">`


    |태그|설명|
    |:---|:---|
    |`border=""`|테이블의 경계선 굵기를 지정|
    |`width=""`|테이블의 너비를 지정: pixel, %|
    |`height=""`|테이블의 높이를 지정: pixel, %|
    |`align=""`|셀의 가로 줄을 오른쪽ight, 왼쪽left, 중앙center 등으로 정렬|
    |`valign=""`|셀의 세로 줄을 위top, 중앙middle, 아래bottom 등으로 정렬|
    |`bgcolor=""`|배경색 지정|
    |`bordercolor=""`|경계선 색상 지정|


## ◾ Layout 레이아웃
![image](https://user-images.githubusercontent.com/68840566/194823680-512265e9-9e00-4d76-bcaa-0b5b2e8109cc.png)
1. Element
- `<div>` : Block level element
- `<span>` : Inline level element

2. Semantic tag

    |태그|설명|
    |:---|:---|
    |`<main>`|문서의 주요 콘텐츠를 포함, 문서 내에 단 하나만 존재|
    |`<header>`|문서 소개나 탐색을 돕는 요소들의 그룹|
    |`<nav>`|현재 페이지 내, 또 다른 페이지로의 링크|
    |`<aside>`|주요 내용과 간접적으로만 연관된 부분|
    |`<section>`|문서의 일반적인 구획, 여러 중심 내용을 감싸는 공간|
    |`<footer>`|문서의 아래쪽 작성자 구획, 저작권 데이터, 관련된 문서의 링크에 대한 정보|
    |`<figure>`|문서의 멀티미디어 요소|
    |`<article>`|글자가 많이 들어가는 부분(그 자체로 독립적으로 구분되거나 재사용 가능한 영역|

## ◾ Form Elements 
- `<form></form>`
- HTML 페이지가 사용자와 상호작용할 수 있는 도구
- 사용자가 웹 사이트에 데이터를 전송하는 것을 허용

    |태그|설명|
    |:---|:---|
    |`method=""`|전송 방식 선택 <br>1. get: 256~ 4096byte 까지만 전송 <br>2. post: 제한X|
    |`name=""`|javascript로 form을 제어하거나 서버로 보내질 때의 이름|
    |`action=""`|태그 안의 내용을 처리해 줄 서버 프로그램 지정|
    |`target=""`|Action속성에서 지정한 script파일을 현재 창이 아닌 다른 위치에서 열도록 지정|
    |`autocomplete=""`|자동완성을 허용 또는 허용하지 않음|

## ◾ Input Tag `
- `<input></input>` : <input></input>
- type 종류
![image](https://user-images.githubusercontent.com/68840566/194823709-6bc5c73b-f7b7-41e1-a01d-cb1dc5baeadc.png)

## ◾ 그 외의 태그들
1. `<textarea></textarea>`
    
    ```html
    <textarea cols="30" row="5" placeholder="클릭하면 사라지는 힌트"></textarea>
    ```

    <textarea cols="30" row="5" placeholder="클릭하면 사라지는 힌트"></textarea>

    - 여러 줄의 텍스트 입력하는 창

2. `<label></label>`
3. `<select><option></option></select>`
    ```html
    <select name="" id="">
        <option vlaue="1">one</option>
        <option vlaue="2">two</option>
        <option vlaue="3">three</option>
        <option vlaue="4">four</option>
    </select>
    ```
    <select name="" id="">
        <option vlaue="1">one</option>
        <option vlaue="2">two</option>
        <option vlaue="3">three</option>
        <option vlaue="4">four</option>
    </select>
