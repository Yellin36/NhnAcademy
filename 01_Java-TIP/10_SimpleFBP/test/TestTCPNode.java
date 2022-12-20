import SimpleFBP2.client.TCPClient;
import SimpleFBP2.node.StandardInNode2;
import SimpleFBP2.node.StandardOutNode2;
import SimpleFBP2.node.TCPInNode;
import SimpleFBP2.node.TCPOutNode;
import SimpleFBP2.server.TCPServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCPNode {
    public static void main(String[] args) throws IOException {

        StandardInNode2 sin = new StandardInNode2(1);
        StandardOutNode2 sout = new StandardOutNode2(1);
        TCPInNode tin = new TCPInNode();
        TCPOutNode tout = new TCPOutNode();

        TCPClient tClient = new TCPClient();
        TCPServer tServer = new TCPServer();

        sin.connect(0, tout.getInputPort(0));
        tout.connect(0, tClient.getInputPort(0));
        tClient.connect(0, tin.getInputPort(0));
        tin.connect(0, sout.getInputPort(0));

        sout.start();
        sin.start();
        tin.start();
        tout.start();
        tServer.start();
        tClient.start();
    }
}
