package Tree;

import java.util.List;

public class PreorderNode extends Node {
    @Override
    public Integer search(Integer key) {
        //전위 순회(preorder traverse) : 뿌리(root)를 먼저 방문
        if(value.equals(key)) return key;
        if(this.leftChild != null) return this.leftChild.search(key);
        if(this.rightChild != null) return this.rightChild.search(key);

        throw new IllegalArgumentException("찾는 값이 존재하지 않습니다.");
    }

    @Override
    public void getList(List<Integer> list) {
        list.add(this.value);
        if(this.leftChild !=null) leftChild.getList(list);
        if(this.rightChild != null) rightChild.getList(list);
    }

    @Override
    public void add(Integer value) {

    }

    @Override
    public void remove(Integer value) {

    }

    public String toString() {
        return value.toString();
    }
}
