package SimpleFBP2.node;

public class TCPInNode extends InputOutputNode2 {
    public TCPInNode() {
        super(1, 1);
    }

    @Override
    public synchronized void main() {
        if(getInputPort(0).hasMessage()) {
            output(getInputPort(0).get());
        }
    }
}
