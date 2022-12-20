package SimpleFBP.node;

import SimpleFBP.message.Message;
import SimpleFBP.wire.OutputSocket;

public abstract class InputNode extends ActiveNode {
    private OutputSocket [] outputSockets;

    public InputNode() {
        this(1);
    }
    public InputNode(int count) {
        super();
        outputSockets = new OutputSocket[count];
    }
    public int getOutputSocketCount() {
        return outputSockets.length;
    }
    public OutputSocket getOutputSocket(int index) {
        return outputSockets[index];
    }
    public void output(Message message) {
        //추후 추가예정
    }
}
