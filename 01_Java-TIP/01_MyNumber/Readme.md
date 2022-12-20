## 📌 조건
1. 클래스 타입
    1. 숫자: MyNumber
    2. 유리수: MyRationalNumber
        - 숫자에 포함
        - 자연수, 정수, 유리수, 분자/분모를 받아 생성 가능
    3. 정수: MyInteger
        - 유리수에 포함
        - 자연수, 정수를 받아 생성 가능
    4. 자연수: MyNaturalNumber
        - 정수에 포함
        - 정수를 받아 생성 가능

2. 4칙 연산 규칙
    - 각 숫자 간의 연산은 가능 ( 자연수-연산자-자연수 : O)
    - 다른 타입의 숫자 간의 연산은 불가능 ( 유리수-연산자-자연수: X)
  
3. 오류 종류
    - 분수는 정수가 될 수 없습니다.
    - 0, 음의 정수는 자연수가 될 수 없습니다.
  
4. 각 결과값은 가장 단순한 형태로 출력 : 정수 또는 기약분수

## 📝 구현 내용

<img src="https://user-images.githubusercontent.com/68840566/187435993-05a1865a-dc26-4c86-9a8f-a88b01b8a5a7.png"  width="500" height="300"/>

- 추상메소드를 사용하여 MyNumber 클래스 내에 사칙연산을 구현
- instanceof을 사용하여 클래스 타입 확인

## 🛠 보충해야할점
* 클래스 분석 <br>
* 상속관계 + 생성자<br>
* 예외 발견 및 처리방법<br>
* 추상메소드 구현 + 클래스타입 비교를 통한 다른 타입간의 연산 제어<br>
* 최상위 클래스<br>
###### 클래스에 꼭 필드와 메소드가 필요한 것은 아니니 해당 클래스의 목적을 파악하고 작성할 것
<a href="https://velog.io/@yerin6860"><img src="https://img.shields.io/badge/Velog-3DDC84?style=flat-square&logo=Blogger&logoColor=white"/></a> --> 추가예정
