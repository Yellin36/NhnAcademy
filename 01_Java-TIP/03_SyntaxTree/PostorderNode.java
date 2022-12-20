package Tree;


import java.util.List;

public class PostorderNode extends Node {
    @Override
    public Integer search(Integer key) {
        //후위 순회(postorder traverse) : 하위 트리 모두 방문 후 뿌리(root)를 방문
        if(this.leftChild != null) return this.leftChild.search(key);
        if(this.rightChild != null) return this.rightChild.search(key);
        if(value.equals(key)) return key;

        throw new IllegalArgumentException("찾는 값이 존재하지 않습니다.");
    }

    @Override
    public void getList(List<Integer> list) {
        if(this.leftChild !=null) leftChild.getList(list);
        if(this.rightChild != null) rightChild.getList(list);
        list.add(this.value);
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
