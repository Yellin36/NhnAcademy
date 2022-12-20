package com.nhnacademy.simple_httpd.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

public class ServerReceiver extends Thread {
    private Socket socket;
    private int portNum;
    private ServerSender serverSender;

    public ServerReceiver(Socket socket, int portNum) {
        this.socket = socket;
        this.portNum = portNum;
        serverSender = new ServerSender(socket, portNum);
        serverSender.send("/");
    }
    private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

    @Override
    public void run() {
        try {
            String url = "";
            try {
                url = new URI(socket.getInetAddress().getHostAddress()).getHost();
            } catch(URISyntaxException e) {

            }
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while((line = reader.readLine()) != null) {
                String words[] = line.split(" ");
                System.out.println(line);
//                for(String word: words) {
//                    if(!word.equals("") && word.charAt(0) == '/') {
//                        serverSender.send(word);
//                        String nextUrl = url + serverSender.getNextUrl();
//                        socket = new Socket(nextUrl, portNum);
//                        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                        serverSender = new ServerSender(socket, portNum);
//                        break;
//                    }
//                }
            }
        } catch (IOException e) {

        }

    }
}
