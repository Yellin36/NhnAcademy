# CSS

  * [CSS](#css-1)
  * [CSS 적용 방법](#css-적용-방법)
  * [CSS 상속](#css-상속)
  * [CSS 셀렉터](#css-셀렉터)
  * [유사 클래스 셀렉터](#유사-클래스-셀렉터)
  * [유사 엘리먼트 셀렉터](#유사-엘리먼트-셀렉터)
  * [CSS 우선 순위](#css-우선-순위)
  * [박스 모델](#박스-모델)
  * [CSS 기본 속성](#css-기본-속성)
  * [Flexible 박스](#flexible-박스)
  * [Font](#font)
  * [Web Font](#web-font)
  * [Material Icon](#material-icon)

## CSS

: Cascading Style Sheet, 문서의 표현을 기술하는 스타일 시트 언어

![image](https://user-images.githubusercontent.com/68840566/194836598-262b2ab5-5fd2-48a0-ae7a-1687d3b4cfc2.png)

## CSS 적용 방법

![image](https://user-images.githubusercontent.com/68840566/194836616-6492e589-914f-492c-8773-89060522556f.png)

1. Inline
    - 각 태그마다 스타일을 모두 적어야 하므로 관리가 쉽지 않음
    - 우선순위가 가장 높기때문에 특별한 경우 쓰지 않는걸 권장
    - 메일 본문 스타일을 만들 때 주로 사용
2. Embedded
    - 보통 head안에 style을 감싸서 넣은 방식
    - css가 간단한 페이지일 경우 사용
    - 사용자에게 초기 로딩시 보여주는 화면을 구성할 때 사용
3. External
    - 별도의 css파일로 분리하는 방식
    - 관심사 분리와 재사용이 가능
    - 가장 많이 사용하는 방법

## CSS 상속

- Element의 속성 > 부모 Element의 속성 > 브라우저 기본 속성
- 일부 속서에 대해서만 상속
    - 상속되는 속성 : visibility, font, color, line-height, text-align, ... 등
    - 상속되지 않는 속성 : margin, padding, border, width, height, display, ... 등

## CSS 셀렉터

1. tag 셀렉터 : `태그명 {}`
2. id 셀렉터 : `#아이디명 {}`
3. class 셀렉터 : `.클래스명 {}`
4. attribute 셀렉터 : `[속성명="값"] {}`
5. 후손 셀렉터 : `공백`으로 연결 `부모 후손 {}`
6. 자식 셀렉터 : `>`로 연결  `부모 > 자식 {}`
7. 바로 뒤 형제 셀렉터 : `+`로 연결 `형제1 + 형제2 {}`
    - 형제1의 바로 뒤 형제2 태그에만 적용함
8. 뒤에 오는 모든 형제 셀렉터 : `~`로 연결 `형제1 ~ 형제2 {}`
    - 형제1 뒤에 오는 모든 형제 2 태그에 적용
9. 전체 셀렉터 : `* {}`
    - 성능에 좋지 않으니 남발하지 않는 것이 좋음

## 유사 클래스 셀렉터

|유사클래스 셀렉터|설명|
|:---|:---|
|`:hover`|마우스 오버|
|`:active`|선택된 상태|
|`:focus`|포커스가 있을 때|
|`:checked`|체크 상태일 때|
|`:disabled`|사용 불가능일 때|
|`:first-childm, :last-child`|해당 요소 중 첫 번째, 마지막|
|`:nth-child(n)`|해당 요소 중 n번 째|
|`:nth-of-type(n)`|해당 요소 중 n 번째 엘리먼트|
|`not(셀렉터)`|해당 요소가 아닌 것들|

## 유사 엘리먼트 셀렉터

|유사 엘리먼트 셀렉터|설명|
|:---|:---|
|`::first-letter`|첫 번째 글자|
|`::first-line`|첫 번째 줄|
|`::before`|element 내용의 앞|
|`::after`|element 내용의 뒤|
|`::selection`|선택된 글자|

## CSS 우선 순위

- 클래스 셀렉터 > 태그 셀렉터
- 우선순위가 동등할 때는 나중에 선언된 스타일 적용

## 박스 모델

- 웹 문서의 내용을 박스 형태로 정의하는 방법
- CSS 레이아웃의 기본이 되는 개념
- 브라우저가 Element를 렌더링 할 때 참고하는 값

![image](https://user-images.githubusercontent.com/68840566/194836665-51ff62e2-b720-43e2-925d-eaa8e53155bf.png)

## CSS 기본 속성

1. box-sizing : element크기를 잡는 기준

    |속성값|설명|
    |:---|:---|
    | "border-box" | 테두리영역과 그 안쪽 영역|
    | "padding-box" | 안쪽 여백 영역과 그 안쪽 영역|
    | "content-box" | 내용 영역과 그 안쪽 영역 |
    | "initial" | 기본값으로 설정|
    | "inherit" | 부모 요소의 속성값을 상속 받음|

2. width, hieght

3. margin, padding - top/bottom/left/right

4. border-top/bottom/left/right

    |속성값|설명|
    |:---|:---|
    |"none"|테두리가 없음, 기본값|
    |"hidden"|테두리를 감춤|
    |"solid"|실선|
    |"dotted"|점선|
    |"dashed"|짧은 직선|
    |"groove"|창에 조각한것처럼|

    ![image](https://user-images.githubusercontent.com/68840566/194836713-c811467b-e425-43f6-a693-dbb20560ebff.png)


5. display

    |속성값|설명|
    |:---|:---|
    |"inline-block"| block레벨 요소도 inline레벨로 사용 가능|
    |"none"| 화면에서 보이지 않게 함<br>(visibility: hidden은 화면에 보이지는 않으나 공간을 유지함)|
    |"grid"|레이아웃을 더 정교하게 나누거나 계층을 잘 컨트롤 할 수 있게 함|

6. overflow
: 자식 element가 부모 element를 넘어갈 때 렌더링 방식
    |속성값|설명|
    |:---|:---|
    |"visible"|내용을 자르지 않고 그대로 보여줌, 기본값|
    |"hidden"|부모 element를 넘어가는 값은 잘라냄|
    |"scroll"|넘어가는 내용을 가로, 세로 스크롤바를 이용해 보여줌|
    |"auto"|내용이 넘치는 경우에만 스크롤바를 보여줌|
    |"text-overflow"|텍스트가 부모 요소를 벗어난 경우 말 줄임을 위해 사용|
    
7. z-index : 요소가 겹칠 경우의 요소의 순서 설정(높을수록 상위)

## Flexible 박스
- `display: flex;`
- `flex: 숫자` : 숫자 비율만큼의 공간 차지
- `flex wrap: wrap` : 한줄을 넘어서도 flex-box가 유지될 수 있도록 함
- `justify-content: default/flex-start/center/flex-end` : 요소 정렬(flex-direction과 같은 방향/흐름 방향의 시작에서 정렬/흐름 방향의 가운데에서 정렬/ 흐름 방향의 끝에서 정렬)

## Font
1. 글자에 적용할 수 있는 속성

    |속성|속성값|설명|
    |:---|:---|:---|
    |`font-style`|"normal/italic/oblique"|글자 스타일|
    |`font-weight`|"lighter/normal/bold/bolder/1~100"|글자 굵기|
    |`font-size`|"숫자"|글자 크기|
    |`font-family`|"글꼴이름"|글꼴|
    |`line-height`|"normal/숫자"|기본 글꼴의 상대적인 크기|


## Web Font
 
## Material Icon 
