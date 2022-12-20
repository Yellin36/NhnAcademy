## 📌 구현 조건
1. 형태소 분석
    - 문자열을 의미 있는 형태소 단위로 분리 → 숫자(정수)와 연산자로 구분
    - 단, 분리 관련 함수는 사용 불가
    
2. 연산자의 부호 구분
    - 숫자 '-'와 부호 '-'의 구분

3. 연산식의 문법적 오류 찾기


## 📝 구현 내용
<img src="https://user-images.githubusercontent.com/68840566/187466593-725f41e4-5da6-4e68-9f60-f7d5ce113cc0.png"  width="500" />
- 괄호를 recursion을 사용하여 반복적인 패턴을 생각하기
    - '(' : recursion 시작
    - ')' : recursion 종료
 - 각각의 형태소를 Token(클래스)화하여 각각에 operator(연산자), operand(피연산자) 타입 추가하기

## 🛠 보충해야할점
- 다양한 형태소 분석 방법
- Tokenizer 업그레이드

<a href="https://velog.io/@yerin6860"><img src="https://img.shields.io/badge/Velog-3DDC84?style=flat-square&logo=Blogger&logoColor=white"/></a> --> 추가예정
