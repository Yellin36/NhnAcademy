package SimpleFBP.wire;

import SimpleFBP.message.Message;
import SimpleFBP.node.Node;

import java.util.NoSuchElementException;

public class OutputSocket extends Socket {
    private InputConnector inputConnector;
    public OutputSocket(Node node) {
        super(node);
    }
    public void plug(InputConnector inputConnector) {
        //if(this.inputConnector == null)
            this.inputConnector = inputConnector;
    }
    public void unplug() {
        this.inputConnector = null;
    }
    public void put(Message message) {
        if(inputConnector != null) inputConnector.put(message);
        else {
            throw new NoSuchElementException();
        }
    }
}
