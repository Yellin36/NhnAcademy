package SimpleFBP2.node;

import SimpleFBP2.message.Message;

import java.util.NoSuchElementException;

public abstract class InputOutputNode2 extends ActiveNode2 {
    private final InputPort[] inputPorts;
    private final InputPort [] peerInputPorts;

    protected InputOutputNode2(int inputCount, int outputCount) {
        inputPorts = new InputPort[inputCount];
        peerInputPorts = new InputPort[outputCount];

        for (int i = 0; i < inputCount; i++) {
            inputPorts[i] = new InputPort(this);
        }
    }
    public void connect(int index, InputPort port) {
        if(peerInputPorts[index] == null)
            peerInputPorts[index] = port;
    }
    public int getInputPortCount() {
        return inputPorts.length;
    }

    public InputPort getInputPort(int index) {
        if(inputPorts[index] != null)
            return inputPorts[index];
        else throw new NoSuchElementException();
    }

    public void output(Message message) {
        for (InputPort port : this.peerInputPorts) {
            if(port != null) {
                port.put(message);
            }
        }
    }
}
