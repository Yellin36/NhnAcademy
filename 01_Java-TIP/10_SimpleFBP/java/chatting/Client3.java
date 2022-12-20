package chatting;

import SimpleFBP2.chatting.ChatClient;
import SimpleFBP2.chatting.ChatInNode;
import SimpleFBP2.chatting.ChatOutNode;
import SimpleFBP2.node.TCPInNode;
import SimpleFBP2.node.TCPOutNode;

import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("사용자 이름을 입력해주세요: ");
        String name = s.nextLine();
        //s.close();

        ChatInNode sin = new ChatInNode(1);
        ChatOutNode sout = new ChatOutNode(1);
        TCPInNode tin = new TCPInNode();
        TCPOutNode tout = new TCPOutNode();

        ChatClient tClient = new ChatClient(name);

        sin.connect(0, tout.getInputPort(0));
        tout.connect(0, tClient.getInputPort(0));
        tClient.connect(0, tin.getInputPort(0));
        tin.connect(0, sout.getInputPort(0));

        sout.start();
        sin.start();
        tin.start();
        tout.start();
        tClient.start();

    }
}
