package SimpleFBP2.chatting;

import SimpleFBP2.message.Message;

public class ChatMessage extends Message {
    private String senderId, receiverId;

    public ChatMessage() {
        super();
    }
    public ChatMessage(String senderId, Object payload, String receiverId) {
        super(payload);
        this.senderId = senderId;
        this.receiverId = receiverId;
    }
    public String getSenderId() { return this.senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId;}
    public String getReceiverId() { return this.receiverId; }

    @Override
    public String toString() {
       return this.getSenderId() + "/" + this.getPayload() + "/" + getReceiverId();
    }
}
