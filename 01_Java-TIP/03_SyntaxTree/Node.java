package Tree;

import java.util.List;

public abstract class Node {
    //Field
    protected Integer value;
    protected Node leftChild;
    protected Node rightChild;

    //Method
    //1. Constructor
    public Node() { }
    public Node(Integer value) {
        this.value = value;
        leftChild = rightChild = null;
    }
    public Node(Integer value, Node leftNode, Node rightNode) {
        this.value = value;
        this.leftChild = leftNode;
        this.rightChild = rightNode;
    }
    //2. search
    //MyAnswer : public abstract Node search();
    public abstract Integer search(Integer key);
    //3. getList
    //MyAnswer : public abstract List<Node> getList();
    public abstract void getList(List<Integer> list);
    public abstract void add(Integer value);
    public abstract void remove(Integer value);
}
