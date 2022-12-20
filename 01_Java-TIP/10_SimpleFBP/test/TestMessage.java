import SimpleFBP.message.Message;

public class TestMessage {
    public static void main(String[] args) {
        Message[] messages = new Message[5];

        for (int i = 0; i < messages.length; i++) {
            messages[i] = new Message();
        }
        for (Message message: messages) {
            System.out.println(message.getId());
        }
    }
}
