package SimpleFBP.message;

import SimpleFBP.node.Node;

import java.util.Random;

public class Message {
    private static Integer count = 0;
    private final String id;
    private final long creationTime;
    private Object payload;

    public Message() {
        this.id = String.format("%s@%08d", this.getClass().getSimpleName(), ++Message.count);
        this.creationTime = System.currentTimeMillis();
    }
    public Message(Object payload) {
        this();
        this.payload = payload;
    }
    public String getId() { return this.id; }
    public long getCreationTime() { return this.creationTime; }
    public Object getPayload() { return this.payload; }
    public void setPayload(Object payload) { this.payload = payload; }
}
