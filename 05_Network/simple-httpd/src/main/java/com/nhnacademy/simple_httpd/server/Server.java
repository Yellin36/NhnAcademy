package com.nhnacademy.simple_httpd.server;

import com.nhnacademy.simple_httpd.Html;
import com.nhnacademy.simple_httpd.Path;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

public class Server extends Thread {
    private final int portNum;
    private Socket socket;
    private ServerSocket serverSocket;

    private BufferedReader reader;
    private PrintWriter writer;

    private Path path;
    private Receiver serverReceiver;

    public Server(int portNum) {
        this.portNum = portNum;
        try {
            this.serverSocket = new ServerSocket(portNum);
        } catch (IOException e) {
            System.out.println("failed to make server");
        }
        String rootPath = System.getProperty("user.dir");
        System.out.println("curPath: " + rootPath);
        this.path = new Path(rootPath);
    }


    @Override
    public void run() {
        Socket socket;
        try {
            socket = serverSocket.accept();
            System.out.println("success to connect(" + socket.getLocalSocketAddress() + ")");

            while(true) {
                writer = new PrintWriter(socket.getOutputStream());
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                serverReceiver = new Receiver(reader);
                serverReceiver.start();

                send();

                String newDir;
                while((newDir = serverReceiver.getNewString()) == null) { }


                if(path.addPath(newDir)) {
                    try {
                        System.out.println("새로운 소켓의 주소: " +"http://localhost:" + portNum + path.getUrlPath());
                        URI uri = new URI("http://localhost:" + portNum + path.getUrlPath());

                        socket = new Socket(uri.getHost(), portNum);
                    } catch (URISyntaxException e) {
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("failed to connect");
        }
    }
    public String send() {
        File curDir = new File(path.getDirPath());
        System.out.println("찾아올 파일 경로: " + path.getDirPath());
        String[] curDirLists = curDir.list();
        String body = new Html().getHtmlDirListForm(path.getPath(), curDirLists);

        writer.println("GET HTTP/1.1 200 OK");
        writer.println("Host: localhost:" + portNum);
        writer.println("Content-Type: text/html; charset=utf-8\r\n"
                + "Content-Length: " + body.length());
        writer.println();
        writer.println(body);
        writer.flush();

        return "success";
    }

}
class Receiver extends Thread{
    private BufferedReader reader;
    private String newString = null;

    public Receiver(BufferedReader reader) {
        this.reader = reader;
    }
    @Override
    public void run() {
        String path;
        while(newString == null) {
            if((path = read(reader)) != "error") {
                System.out.println("새로운 경로를 찾았습니다; " + path);
                newString = path;
                break;
            }
        }
    }
    public String getNewString() { return newString; }
    public void setNewStringNull() {
        this.newString = null;
    }
    public String read(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String words[] = line.split(":");

                System.out.println(line);

                if(words[0].equals("Referer")) {
                    System.out.println("Referer: " + words[3]);
                    String paths[] = words[3].split("/");

                    return paths[paths.length - 1].trim();
                }
            }
        } catch (IOException e) {

        }
        return "error";
    }

}
