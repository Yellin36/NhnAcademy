import SimpleFBP2.calculator.AdditionNode2;
import SimpleFBP2.calculator.MultiplicationNode2;
import SimpleFBP2.calculator.SubtractionNode2;
import SimpleFBP2.message.PostMessage;
import SimpleFBP2.node.RNGNode2;
import SimpleFBP2.node.StandardOutNode2;
import SimpleFBP2.server.MessageServer;

public class TestMessageServerNode2 {
    public static void main(String[] args) {
        int interval = 1000;
        RNGNode2 v1 = new RNGNode2(interval);
        RNGNode2 v2 = new RNGNode2(interval);
        RNGNode2 v3 = new RNGNode2(interval);
        RNGNode2 v4 = new RNGNode2(interval);

        AdditionNode2 additionNode = new AdditionNode2();
        SubtractionNode2 subtractionNode = new SubtractionNode2();
        MultiplicationNode2 multiplicationNode = new MultiplicationNode2();

        StandardOutNode2 outNode = new StandardOutNode2();

        v1.connect(0, additionNode.getInputPort(0));
        v2.connect(0, additionNode.getInputPort(1));
        v3.connect(0, subtractionNode.getInputPort(0));
        v4.connect(0, subtractionNode.getInputPort(1));
        additionNode.connect(0, multiplicationNode.getInputPort(0));
        subtractionNode.connect(0, multiplicationNode.getInputPort(1));
        multiplicationNode.connect(0, outNode.getInputPort(0));

        outNode.start();

        MessageServer.getGlobalServer().connect(additionNode);
        MessageServer.getGlobalServer().connect(subtractionNode);
        MessageServer.getGlobalServer().connect(multiplicationNode);

        additionNode.setTrace(
                (x, y)->MessageServer.getGlobalServer().postMessage(
                        new PostMessage(x, outNode.getId(), y)));
        subtractionNode.setTrace(
                (x, y)->MessageServer.getGlobalServer().postMessage(
                        new PostMessage(x, outNode.getId(), y)));
        multiplicationNode.setTrace(
                //바이
                (x, y)->MessageServer.getGlobalServer().postMessage(
                        new PostMessage(x, outNode.getId(), y))
                //컨슈머 공간
        );

        additionNode.start();
        subtractionNode.start();
        multiplicationNode.start();
        v4.start();
        v3.start();
        v2.start();
        v1.start();
    }
}
