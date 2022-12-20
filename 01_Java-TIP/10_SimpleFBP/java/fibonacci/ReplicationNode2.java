package SimpleFBP2.fibonacci;

import SimpleFBP2.message.Message;
import SimpleFBP2.node.InputOutputNode2;

import java.io.IOException;

//Replication : 입력 받은 값은 2개의 출력으로 만든다
public class ReplicationNode2 extends InputOutputNode2 {
    public ReplicationNode2() {
        super(1, 2);
    }

    @Override
    protected synchronized void main() throws IOException {
        //System.out.println(getId() + "wake");
        if(getInputPort(0).hasMessage()) {

            Message m = getInputPort(0).get();
            //System.out.println(getId() + ": 시그널 전송(" + message.getPayload() + ")");
            output(m);
        }
    }
}
