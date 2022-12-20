package SimpleFBP2.chatting;

import SimpleFBP2.chatting.ChatMessage;
import SimpleFBP2.node.InputNode2;

import java.io.IOException;
import java.util.Scanner;

public class ChatInNode extends InputNode2 {
    Scanner scanner;
    public ChatInNode(int count) {
        super(count);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void preprocess() throws IOException {
        printInfo();
    }

    @Override
    public synchronized void main() {
        //System.out.print("입력 : ");

        ChatMessage message;
        String line = scanner.nextLine();

        if((message = getMessage(line)) != null) {
            this.output(message);
        }
    }
    public void printInfo() {
        System.out.println("메세지를 보내는 방법!");
        System.out.println("1.전체에게 : 메세지내용");
        System.out.println("2.특정사용자에게 : 메세지내용/받을사람");
    }
    public ChatMessage getMessage(String line) {
        String receiver, msg;
        String[] words = line.split("/");

        if(words.length > 2 || words.length < 1) {
            System.out.println("메세지 전송 방법을 확인해주세요.");
            printInfo();
            return null;
        }
        msg = words[0];
        receiver = (words.length == 2) ? words[1] : "all";
        ChatMessage message = new ChatMessage(this.getName(), msg, receiver);
        return message;
    }
}
