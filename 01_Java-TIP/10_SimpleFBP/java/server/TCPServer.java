package SimpleFBP2.server;

import SimpleFBP2.message.Message;
import SimpleFBP2.node.ActiveNode2;

import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends ActiveNode2 {
    private ServerSocket server;
    private Socket socket;
    private final String serverIp = "127.0.0.1";

    private DataInputStream in;
    private DataOutputStream out;
    public TCPServer() { }

    @Override
    public void preprocess() throws IOException {
        server = new ServerSocket(7777);
        this.socket = server.accept();

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public synchronized void main() throws IOException {
        //System.out.println("TCPServer 실행");

        String payload;
        //TCPClient 로부터 데이터 수신
        if(socket.getInputStream() != null) {
            payload = in.readUTF();
            //System.out.println("TCP Client 로부터 데이터를 받았습니다." + payload);

            out.writeUTF(payload);
            //System.out.println("TCP Client 로 데이터를 전송했습니다." + payload);
        }
    }

}
