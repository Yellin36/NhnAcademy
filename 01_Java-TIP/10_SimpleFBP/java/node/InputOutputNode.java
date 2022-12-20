package SimpleFBP.node;

import SimpleFBP.message.Message;
import SimpleFBP.wire.InputSocket;
import SimpleFBP.wire.OutputSocket;

public abstract class InputOutputNode extends ActiveNode {
    private InputSocket[] inputSockets;
    private OutputSocket[] outputSockets;

    public InputOutputNode(int inputCount, int outputCount) {
        this.inputSockets = new InputSocket[inputCount];
        this.outputSockets = new OutputSocket[outputCount];
    }
    public int getOutputSocketCount() {
        return this.outputSockets.length;
    }
    public OutputSocket getOutputSocket(int index) {
        return this.outputSockets[index];
    }
    public int getInputSocketCount() {
        return this.inputSockets.length;
    }
    public InputSocket getInputSocket(int index) {
        return this.inputSockets[index];
    }
    public void output(Message message) {
    }
}
