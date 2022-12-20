package SimpleFBP2.client;

import SimpleFBP2.message.Message;
import SimpleFBP2.node.InputOutputNode2;

import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient extends InputOutputNode2 {
    private Socket socket;
    private final String serverIp = "127.0.0.1";
    private DataInputStream in;
    private DataOutputStream out;

    public TCPClient() {
        super(1, 1);
    }

    @Override
    public void preprocess() throws IOException {
        this.socket = new Socket(serverIp, 7777);

        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
    }

    @Override
    public synchronized void main() throws IOException {
        //System.out.println("TCPClient 실행");

        //TCPServer로 데이터 전송
        if (getInputPort(0).hasMessage()) {
            //System.out.println("TCPOutNode 로부터 데이터를 받았습니다.");
            Message message = getInputPort(0).get();

            out.writeUTF(String.valueOf(message.getPayload()));
            //System.out.println("TCP 서버로 데이터를 전송했습니다." + message.getPayload());

            output(new Message(in.readUTF()));
            //System.out.println("서버로부터 데이터를 받았습니다." + message.getPayload());

        }
    }
}
