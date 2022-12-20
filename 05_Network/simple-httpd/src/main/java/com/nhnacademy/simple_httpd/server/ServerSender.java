package com.nhnacademy.simple_httpd.server;

import com.nhnacademy.simple_httpd.Html;
import com.nhnacademy.simple_httpd.Path;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSender extends Thread {
    private Socket socket;
    private int portNum;
    private PrintWriter writer;

    private Path path;
    public ServerSender(Socket socket, int portNum) {
        this.portNum = portNum;
        this.socket = socket;

        String rootPath = System.getProperty("user.dir");
        System.out.println("curPath: " + rootPath);
        this.path = new Path(rootPath);

        try {
            writer = new PrintWriter(socket.getOutputStream());
//            send("/");
        } catch (IOException e) {

        }
    }
    public String getNextUrl() { return path.getPath();}
    public void send(String requestPath) {
        path.addPath(requestPath);

        File curDir = new File(path.getFullPath());
        String[] curDirLists = curDir.list();
        String body = new Html().getHtmlDirListForm(path.getPath(), curDirLists);

        writer.println("GET HTTP/1.1 200 OK");
        writer.println("Host: localhost:" + portNum);
        writer.println("Content-Type: text/html; charset=utf-8\r\n"
                + "Content-Length: " + body.length());
        writer.println();
        writer.println(body);
        writer.flush();

    }


}
