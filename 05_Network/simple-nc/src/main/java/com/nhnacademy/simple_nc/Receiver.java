package com.nhnacademy.simple_nc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver extends Thread {
    private BufferedReader in;

    public Receiver(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while(in != null) {
                System.out.println(in.readLine());
            }
        } catch (IOException e) {
            System.exit(0);
        }
    }
}