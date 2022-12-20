package SyntaxTree;

public class NodeConstant extends NodeOperand{
    private Integer value;

    public NodeConstant(Integer value) {
        this.value = value;
    }
    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public Integer getChildNodeCount() {
        return 0;
    }
    public String toString() {
        return value + "";
    }
}
