import SimpleFBP2.calculator.AdditionNode2;
import SimpleFBP2.fibonacci.LatchNode2;
import SimpleFBP2.fibonacci.ReplicationNode2;
import SimpleFBP2.node.*;

public class TestFibonacciNode2 {
    public static void main(String[] args) {
        TimerNode2 clockNode = new TimerNode2(1000) ;

        LatchNode2 latchNode1 = new LatchNode2(0.0) ;
        LatchNode2 latchNode2 = new LatchNode2(1.0) ;

        ReplicationNode2 replicationNode1 = new ReplicationNode2();
        ReplicationNode2 replicationNode2 = new ReplicationNode2();
        ReplicationNode2 replicationNode3 = new ReplicationNode2();

        AdditionNode2 additionNode = new AdditionNode2();
        StandardOutNode2 standardOutNode1 = new StandardOutNode2();

        clockNode.connect(0, replicationNode1.getInputPort(0));
        replicationNode1.connect(0, latchNode1.getInputPort(0));
        replicationNode1.connect(1, latchNode2.getInputPort(0));
        latchNode1.connect(0, replicationNode2.getInputPort(0));
        latchNode2.connect(0, additionNode.getInputPort(1));
        replicationNode2.connect(0, additionNode.getInputPort(0));
        replicationNode2.connect(1, latchNode2.getInputPort(1));
        additionNode.connect(0, replicationNode3.getInputPort(0));
        replicationNode3.connect(0, latchNode1.getInputPort(1));
        replicationNode3.connect(1, standardOutNode1.getInputPort(0));
        standardOutNode1.start();
        replicationNode1.start();
        replicationNode2.start();
        replicationNode3.start();
        additionNode.start();
        latchNode2.start();
        latchNode1.start();
        clockNode.start();


    }
}