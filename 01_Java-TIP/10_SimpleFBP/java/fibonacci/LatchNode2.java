package SimpleFBP2.fibonacci;

import SimpleFBP2.message.Message;
import SimpleFBP2.node.InputOutputNode2;

import java.io.IOException;

//Latch : 입력되는 값을 클럭이 들어올때 마다 출력한다.
//새롭게 업데이트든 값이 없는 경우, default를 돌려 준다.

/**
 * 2 Input
 *      0 : signal
 *      1 : 값 업데이트
 * 1 Output
 *      0 : 현재 값 출력
 *  */
public class LatchNode2 extends InputOutputNode2 {
    private final Message defaultValue;
    private boolean prepared;

    public LatchNode2(double value) {
        super(2, 1);
        this.defaultValue = new Message(value);
        getInputPort(1).put(this.defaultValue);
        prepared = false;
    }
    @Override
    protected synchronized void main() throws IOException {
        //System.out.print(getId() + " wake:");
        Message message1, message2;

        if (getInputPort(0).hasMessage() && getInputPort(1).hasMessage()) {
            message1 = getInputPort(0).get();
            message2 = getInputPort(1).get();

            if((Double)message1.getPayload() < (Double)message2.getPayload()) message1 = message2;

            if ((Double) message1.getPayload() <= (Double) this.defaultValue.getPayload()) {
                output(this.defaultValue);
            } else {
                output(message1);
            }
        }
    }
}
