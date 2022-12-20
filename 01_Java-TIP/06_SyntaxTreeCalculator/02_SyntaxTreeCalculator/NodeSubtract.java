package SyntaxTree;

public class NodeSubtract extends NodeBinaryOperator {
    public NodeSubtract(Node n1, Node n2) {
        super("-", n1, n2);
    }

    @Override
    public Integer getValue() {
        return getLeftChild().getValue() - getRightChild().getValue();
    }
}
