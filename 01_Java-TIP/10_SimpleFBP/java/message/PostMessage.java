package SimpleFBP2.message;

import SimpleFBP2.node.ActiveNode2;

public class PostMessage extends Message {
    private static Integer count = 0;
    private final String id;
    private final long creationTime;
    private Object payload;
    private String senderId, receiverId;

    public PostMessage() {
        this.id = String.format("%s@%08d", this.getClass().getSimpleName(), ++PostMessage.count);
        this.creationTime = System.currentTimeMillis();
    }
   /* public PostMessage(String sender, String receiver, Object payload) {
        this();
        this.senderId = sender;
        this.receiverId = receiver;
        this.payload = payload;
    }*/

    public PostMessage(Object x, String id, Object y) {
        this();
        this.senderId = String.valueOf(x);
        this.receiverId = String.valueOf(y);
        this.payload = payload;
    }



    public String getId() { return this.id; }
    public String getSenderId() { return senderId; }
    public String getReceiverId() { return receiverId; }
    public long getCreationTime() { return this.creationTime; }
    public Object getPayload() { return this.payload; }
    public void setPayload(Object payload) { this.payload = payload; }
}
