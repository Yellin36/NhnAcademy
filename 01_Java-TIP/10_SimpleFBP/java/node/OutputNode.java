package SimpleFBP.node;

import SimpleFBP.wire.InputSocket;

public abstract class OutputNode extends ActiveNode {
    protected InputSocket[] inputSockets;

    public OutputNode() {
        super();
    }
    public OutputNode(int count) {
        this();
        inputSockets = new InputSocket[count];
    }
    public int getInputSocketCount() {
        return inputSockets.length;
    }
    public InputSocket getInputSocket(int index) {
        return inputSockets[index];
    }
}
