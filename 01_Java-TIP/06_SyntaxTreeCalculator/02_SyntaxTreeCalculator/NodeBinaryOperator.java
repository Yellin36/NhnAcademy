package SyntaxTree;

public abstract class NodeBinaryOperator extends Node {
    private String operator;
    private Node leftChild, rightChild;

    public NodeBinaryOperator() { }
    public NodeBinaryOperator(String operator, Node n1, Node n2) {
        this.operator = operator;
        this.leftChild = n1;
        this.rightChild = n2;
    }
    public String getOperator() { return operator; }
    public Node getLeftChild() { return leftChild; }
    public Node getRightChild() { return rightChild; }
    @Override
    public abstract Integer getValue();

    @Override
    public Integer getChildNodeCount() {
        Integer count = 0;

        if(leftChild != null) count ++;
        if(rightChild != null) count++;

        return count;
    }
    public String toString() {
        return "(" + operator + " " + leftChild + " " + rightChild + ")";
    }
}
