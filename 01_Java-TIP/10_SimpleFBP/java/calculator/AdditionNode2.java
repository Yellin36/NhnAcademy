package SimpleFBP2.calculator;

import SimpleFBP2.message.Message;
import SimpleFBP2.node.InputOutputNode2;

public class AdditionNode2 extends InputOutputNode2 {
    public AdditionNode2() {
        super(2, 1);
    }
    public synchronized void main() {
        Message m1;
        Message m2;

        if(getInputPort(0).hasMessage() && getInputPort(1).hasMessage()) {
            m1 = getInputPort(0).get();
            m2 = getInputPort(1).get();
            Double sum = (Double)m1.getPayload() + (Double)m2.getPayload();

            System.out.printf("(%s)연산 결과: %f + %f = %f\n", getId(), (Double)m1.getPayload(), (Double)m2.getPayload(), sum);

            output(new Message(sum));
        }

    }
    public void setTrace() {

    }
}
