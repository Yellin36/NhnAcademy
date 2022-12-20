package SimpleFBP2.chatting;

import SimpleFBP2.node.InputOutputNode2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatClient extends InputOutputNode2 {
    private Socket socket;
    private final String serverIp = "127.0.0.1";
    private DataInputStream in;
    private DataOutputStream out;
    private Boolean hasMsg;

    public ChatClient(String name) {
        super(1, 1);
        hasMsg= false;
        setName(name);
    }

    @Override
    public void preprocess() throws IOException {
        this.socket = new Socket(serverIp, 1234);

        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        out.writeUTF(getName());

        new Receiver(in).start();
        new Sender(out, getName()).start();
    }

    @Override
    public synchronized void main() throws IOException {
        //stop();
    }
    public ChatMessage intoMessage(String line) {
        String[] words = line.split("/");
        return new ChatMessage(words[0], words[1], words[2]);
    }
    class Sender extends Thread {
        DataOutputStream out;
        String name;

        public Sender(DataOutputStream out, String name) {
            this.out = out;
            this.name = name;
        }

        @Override
        public void run() {
            while(out!=null) {
                if (getInputPort(0).hasMessage()) {
                    try {
                        ChatMessage message = (ChatMessage) getInputPort(0).get();
                        message.setSenderId(name);

                        out.writeUTF(message.toString());
                    } catch (IOException e) {
                    }
                }
                try {
                    sleep(1000);
                } catch(InterruptedException e) {}
            }
        }
    }
    class Receiver extends Thread {
        DataInputStream in;
        public Receiver(DataInputStream in) {
            this.in = in;
        }

        @Override
        public void run() {
            while(in != null) {
                try {
                    String line = in.readUTF();
                    output(intoMessage(line));

                    sleep(1000);
                } catch (IOException e) {
                } catch (InterruptedException e) {
                }

            }
        }
    }
}
