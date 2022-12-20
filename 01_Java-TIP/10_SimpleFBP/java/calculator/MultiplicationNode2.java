package SimpleFBP2.calculator;

import SimpleFBP2.message.Message;
import SimpleFBP2.node.InputOutputNode2;

public class MultiplicationNode2 extends InputOutputNode2 {
    public MultiplicationNode2() {
        super(2, 1);
    }
    public synchronized void main() {
        Message m1;
        Message m2;

        if(getInputPort(0).hasMessage() && getInputPort(1).hasMessage()) {
            m1 = getInputPort(0).get();
            m2 = getInputPort(1).get();
            Integer result = (Integer)m1.getPayload() * (Integer) m2.getPayload();
            System.out.print(m1.getPayload() + " * " +  m2.getPayload() + " = ");

            output(new Message(result));
        }

    }
}
