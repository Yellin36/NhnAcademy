package com.nhnacademy.simple_nc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientOrServer {
    private ServerSocket serverSocket;
    private Socket socket;

    private Sender clientSender;
    private Receiver clientReceiver;

    //Server
    public ClientOrServer(int portNum) throws IOException {
        this.serverSocket = new ServerSocket(portNum);
        System.out.println("server is waiting");

        this.socket = this.serverSocket.accept();
        System.out.println("server connected");
    }
    //Client
    public ClientOrServer(String serverIp, int portNum) throws IOException {
        this.socket = new Socket(serverIp, portNum);
        System.out.println("connected");
    }

    public void run() throws IOException {
        this.clientSender = new Sender(this.socket);
        this.clientReceiver = new Receiver(this.socket);

        clientSender.start();
        clientReceiver.start();
    }
}
