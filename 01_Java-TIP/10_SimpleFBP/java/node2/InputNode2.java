package SimpleFBP2.node;

import SimpleFBP2.message.Message;

public abstract class InputNode2 extends ActiveNode2 {
    private final InputPort[] peerInputPorts;   //상대방과의 연결

    protected InputNode2(int count) {
        super();
        this.peerInputPorts = new InputPort[count];
    }
    public void connect(int index, InputPort port) {
        if(index < this.peerInputPorts.length) {
            this.peerInputPorts[index] = port;
            System.out.println("connection complete.");
        }
        else throw new IndexOutOfBoundsException();
    }
    public void output(Message message) {
        for (InputPort port : this.peerInputPorts) {
            if(port != null) {
                port.put(message);
            }
        }
    }
}
