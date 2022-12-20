import SimpleFBP2.calculator.AdditionNode2;
import SimpleFBP2.node.RNGNode2;
import SimpleFBP2.node.StandardOutNode2;

public class TestAdditionNode2 {
    public static void main(String[] args) {
        RNGNode2 inNode1 = new RNGNode2(1000);
        RNGNode2 inNode2 = new RNGNode2(1000);

        AdditionNode2 additionNode = new AdditionNode2();
        StandardOutNode2 outNode = new StandardOutNode2();

        inNode1.connect(0, additionNode.getInputPort(0));
        inNode2.connect(0, additionNode.getInputPort(1));
        additionNode.connect(0, outNode.getInputPort(0));

        outNode.start();
        additionNode.start();
        inNode2.start();
        inNode1.start();
    }
}
