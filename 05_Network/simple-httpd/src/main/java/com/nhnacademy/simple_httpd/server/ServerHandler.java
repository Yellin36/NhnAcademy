package com.nhnacademy.simple_httpd.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerHandler extends Thread {
    private Socket socket;
    private String curPath = System.getProperty("user.dir");
    private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Date date;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while((line = reader.readLine()) != null) {
                date = new Date(System.currentTimeMillis());
                System.out.println(" [ " + formatter.format(date) + " ] "+ socket.getLocalSocketAddress() + " : " + line);
            }
        } catch (IOException e) {

        }

    }
}
