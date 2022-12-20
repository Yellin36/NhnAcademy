## 📌 구현 조건
1. 이진 트리를 위한 노드 만들기
    > #### 노드 Node
    >    - Field
    >        - value: Integer
    >        - LeftChild: Node
    >        - RightChild: Node
    >    - Method
    >        - Constructor
    >        - search
    >        - getList
    - 단, 트리의 순회 방법은 결정되지 않아 정의하지 않음

2. 노드를 확장하여 트리 구성이 가능한 노드 만들기
    - 전위 순회 PreorderTreeTraverse
    - 중위 순회 InorderTreeTraverse
    - 후위 순회 PostorderTreeTraverse
  
3. 각 노드에 add/remove 메소드 추가
    - 트리 순회는 중위 순회로 설정
    - 왼쪽 자식 노드는 루트 노드보다 값이 작음
    - 오른쪽 자식 노드는 루트 노드보다 값이 큼
  
4. 제네릭을 이용한 범용 트리 만들기

## 📝 구현 내용

<img src="https://user-images.githubusercontent.com/68840566/187456994-31272df3-c847-4273-95ba-cafd025b302a.png"  width="500"/>

- 이진트리의 remove함수 구현 보충

## 🛠 보충해야할점
* 이진트리 탐색(깊이 우선 탐색:DFS/너비 우선 탐색:BFS)
* 이진트리는 데이터에 따라 대각선으로 길게 느려뜨려지는 쏠림 현상이 발생 → AVL 트리, B-트리, 레드블랙 트리<br>
* 
<a href="https://velog.io/@yerin6860"><img src="https://img.shields.io/badge/Velog-3DDC84?style=flat-square&logo=Blogger&logoColor=white"/></a> --> 추가예정
