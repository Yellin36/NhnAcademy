package SimpleFBP2.chatting;

import SimpleFBP2.chatting.ChatMessage;
import SimpleFBP2.node.ActiveNode2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class ChatServer extends ActiveNode2 {
    private HashMap clients;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ChatServer() {
        clients = new HashMap<>();
        Collections.synchronizedMap(clients);
    }

    @Override
    public void preprocess() throws IOException {
        serverSocket = new ServerSocket(1234);
        System.out.println("서버가 시작하였습니다.");

    }

    @Override
    protected synchronized void main() throws IOException {
        socket = serverSocket.accept();
        System.out.printf("[%s:%s]에서 접속하였습니다.\n", socket.getInetAddress(), socket.getPort());

        new Server(socket).start();
    }
    public void sendTo(String words[]) {
        if(words[2].equals("all")) {
            sendToAll(words[0], words[1]);
        }
        else {
            try {
                DataOutputStream out;
                if (clients.containsKey(words[2])) {
                    out = (DataOutputStream) clients.get(words[2]);
                    out.writeUTF(new ChatMessage(words[0] + "(귓속말)", words[1], words[2]).toString());
                }
                else {
                    out = (DataOutputStream) clients.get(words[0]);
                    out.writeUTF(new ChatMessage("도움말", "존재하지 않는 사용자입니다.", words[0]).toString());
                }
            } catch (IOException e) {}
        }
    }
    public void sendToAll(String sender, String msg){
        Set<String> keys = clients.keySet();
        for(String key: keys) {
            try {
                if(key.equals(sender)) continue;
                DataOutputStream out = (DataOutputStream) clients.get(key);

                out.writeUTF(new ChatMessage(sender, msg, "all").toString());
            } catch (IOException e) {}
        }
    }
    class Server extends Thread {
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public Server(Socket socket) throws IOException {
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run()  {
            String name = "";
            try {
                name = in.readUTF();
                clients.put(name, out);
                sendToAll("공지", name + "님이 입장하셨습니다.");

                while(in != null) {
                    try {
                        String line = in.readUTF();
                        String[] words = line.split("/");

                        sendTo(words);
                    } catch (EOFException e) {}
                }
            } catch (IOException e) {

            }finally {
                sendToAll("공지", name + "님이 나가셨습니다.");
                clients.remove(name);
                System.out.printf("[%s:%s]에서 접속을 종료하였습니다.\n", socket.getInetAddress(), socket.getPort());
                System.out.println("현재 접속자 수는 " + clients.size() + "입니다.(" + clients + ")");
            }

        }
    }
}
