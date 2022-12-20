## 📌 구현 조건

1. 동물 클래스를 정의
    > 표유류 : 박쥐(수영잘함), 호랑이, 고래
    
    > 조류 : 매, 타조, 펭귄
    
    > 날수 있는 동물을 분류 / 수영할 수 있는 동물을 분류
    
2. 동물들에게 직접적으로 날 수 있는지, 헤엄칠 수 있는지 물어볼 수 없습니다.
3. 동물들을 특성(날기, 헤엄치기)별로 분류하고, 종류를 출력합니다. 단, 동물은 클래스 이름으로 대체합니다. -> getClass().getName();
4. 날기와 헤엄치기를 다른 방법으로 분류해봅니다. : abstract(객체가 안될때) class, interface(기능), Annotation, ...중에 하나

## 📝 구현 내용

<img src="https://user-images.githubusercontent.com/68840566/187437766-bf3d3034-80cb-4bba-a95c-88252dab7fff.png"  width="500"/>

- 인터페이스 이외의 방법 → 어노테이션을 이용하여 특징을 구별하기

## 🛠 보충해야할점
* 추상클래스, 이터페이스, 어노테이션(커스텀 어노테이션 선언 방법) 각각의 활용 및 차이점 <br>
* List의 stream 활용법<br>
<a href="https://velog.io/@yerin6860"><img src="https://img.shields.io/badge/Velog-3DDC84?style=flat-square&logo=Blogger&logoColor=white"/></a> --> 추가예정
