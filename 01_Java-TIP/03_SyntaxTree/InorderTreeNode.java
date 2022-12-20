package Tree;

import java.util.List;

public class InorderTreeNode extends Node {
    public InorderTreeNode() {}
    public InorderTreeNode(Integer key) {
        super(key);
    }
    public InorderTreeNode(Integer value, InorderTreeNode leftChildeNode, InorderTreeNode rightChildNode) {
        super(value, leftChildeNode, rightChildNode);
    }
    public InorderTreeNode(Node node) {
        this.value = node.value;
        this.leftChild = node.leftChild;
        this.rightChild = node.rightChild;
    }
    @Override
    public Integer search(Integer key) {
        //중위 순회(inorder traverse) : 왼쪽 하위 트리를 방문 후 뿌리(root)를 방문
        if(this.leftChild != null) {
            try{    //탐색을 마치지 않았는데 리프노드이기때문에 생기는 오류 해결
                return this.leftChild.search(key);
            } catch(Exception ignore) {}
        }
        if(value.equals(key)) return key;
        if(this.rightChild != null) {
            try {
                return this.rightChild.search(key);
            } catch(Exception ignore) {}
        }
        throw new RuntimeException("찾는 값이 존재하지 않습니다.");
    }

    @Override
    public void getList(List<Integer> list) { // 모든 노드의 값을 순회순서로 가져온다
        if(this.leftChild !=null) leftChild.getList(list);
        list.add(this.value);
        if(this.rightChild != null) rightChild.getList(list);
    }

    public void add(Integer value) {
        //데이터에따라 사선으로 쭉 출력될 수 있기에 나중에 이를 해결하기 위한 레드블랙 트리같은 방법을 사용하면 될 것 같다.
        if(this.value >= value) {   // -> this.value.compareTo(value) -1(작은경우), 0, +1(큰경우)
            if(leftChild != null) leftChild.add(value);
            else {
                leftChild = new InorderTreeNode(value);
            }
        }
        else {
            if(rightChild != null) rightChild.add(value);
            else {
                rightChild = new InorderTreeNode(value);
            }
        }
    }
    @Override
    public void remove(Integer value) {
        /* * 경우의 수
         * 왼쪽이 없는 경우 : 오른쪽 자식 노드 그대로 가져오기
         * 오른쪽이 없는 경우 : 왼쪽 자식 노드를 그대로 가져오기
         * 둘다 없는 경우 : null
         * 둘다 있는 경우 : 왼쪽자식노드의 가장 오른쪽최하단 노드 또는 오른쪽 자식노드의 가장 왼쪽 하단 노드를 삭제한 노드의 위치로 이동
         */
        try {
            if(search(value) == value) {
                if(this.value.compareTo(value) == 0) {//삭제할 노드가 등장하면
                    //마지막 친구를 불러와
                    if(this.leftChild == null) {
                        //this = new InorderTreeNode(rightChild);
                    }
                    else if(this.rightChild == null) {
                        //this = new InorderTreeNode(leftChild);
                    }
                    else if(this.leftChild == null && this.rightChild == null){
                        //this = null;
                    }
                    else {
                        while(this.leftChild != null && this.leftChild.rightChild != null) {

                        }
                    }

                    //부모노드의
                }
                else if(this.value.compareTo(value) > 0) {
                    if(this.leftChild != null) leftChild.remove(value);
                }
                else {
                    if(this.rightChild != null) rightChild.remove(value);
                }
            }
        } catch(Exception e) { }//지울데이터가 없는 경우
    }
    public String toString() {
        return value.toString();
    }
}
