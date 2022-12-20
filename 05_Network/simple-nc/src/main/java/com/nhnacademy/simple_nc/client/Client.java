package com.nhnacademy.simple_nc.client;

import com.nhnacademy.simple_nc.Receiver;
import com.nhnacademy.simple_nc.Sender;

import java.io.*;
import java.net.Socket;

public class Client {
    private final Socket socket;

    private Sender clientSender;
    private Receiver clientReceiver;

    public Client(String serverIp, int portNum) throws IOException{
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

