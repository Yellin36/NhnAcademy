package com.nhnacademy.simple_nc.server;

import com.nhnacademy.simple_nc.Receiver;
import com.nhnacademy.simple_nc.Sender;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;
    private final Socket socket;

    private Receiver serverReceiver;
    private Sender serverSender;

    public Server(int portNum) throws IOException {
        this.serverSocket = new ServerSocket(portNum);
        System.out.println("server is waiting");

        this.socket = this.serverSocket.accept();
        System.out.println("server connected");
    }

    public void run() throws IOException {
        serverReceiver = new Receiver(this.socket);
        serverSender = new Sender(this.socket);

        serverReceiver.start();
        serverSender.start();
    }
}
