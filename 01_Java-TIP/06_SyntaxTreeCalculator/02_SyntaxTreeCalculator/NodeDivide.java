package SyntaxTree;

public class NodeDivide extends NodeBinaryOperator {
    public NodeDivide(Node n1, Node n2) {
        super("/", n1, n2);
    }

    @Override
    public Integer getValue() {
        if(getRightChild().getValue() == 0) {
            throw new RuntimeException("0으로 나눌수는 없습니다.");
        }
        return getLeftChild().getValue() / getRightChild().getValue();
    }
}
