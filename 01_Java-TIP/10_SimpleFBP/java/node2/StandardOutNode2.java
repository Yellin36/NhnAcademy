package SimpleFBP2.node;

import SimpleFBP2.message.Message;

public class StandardOutNode2 extends OutputNode2 {
    public StandardOutNode2() {
        super(1);
    }
    public StandardOutNode2(int count) {
        super(count);
    }
    @Override
    public synchronized void main() {
        Message message = null;

        for (InputPort inputPort: inputPorts) {
            if(inputPort.hasMessage()) {
                //System.out.println("메세지 발견");
                message = inputPort.get();
                System.out.println(message.getPayload() + " ");
            }
        }
    }
}
