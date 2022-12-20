package SimpleFBP2.chatting;

import SimpleFBP2.chatting.ChatMessage;
import SimpleFBP2.node.InputPort;
import SimpleFBP2.node.OutputNode2;

public class ChatOutNode extends OutputNode2 {
    public ChatOutNode() {
        super(1);
    }
    public ChatOutNode(int count) {
        super(count);
    }
    @Override
    public synchronized void main() {
        ChatMessage message = null;

        for (InputPort inputPort: inputPorts) {
            if(inputPort.hasMessage()) {
                //System.out.println("메세지 발견");
                message = (ChatMessage)inputPort.get();

                System.out.printf("%s: %s\n", message.getSenderId(), message.getPayload());
            }
        }
    }
}
