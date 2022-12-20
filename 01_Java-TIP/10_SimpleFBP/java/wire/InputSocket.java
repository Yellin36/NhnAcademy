package SimpleFBP.wire;

import SimpleFBP.message.Message;
import SimpleFBP.node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class InputSocket extends Socket {
    private Queue<Message> messageQueue;
    private OutputConnector outputConnector;

    public InputSocket(Node node) {
        super(node);
        messageQueue = new LinkedList<Message>();
    }
    public void plug(OutputConnector outputConnector) {
        //if(this.outputConnector == null)
            this.outputConnector = outputConnector;
            this.outputConnector.connect(this);
    }
    public void unplug() {
        this.outputConnector = null;
    }
    public void put(Message message) {
        messageQueue.add(message);
    }
    public int getMessageCount() { return messageQueue.size(); }
    public Message getMessage() { return messageQueue.element(); }
}
