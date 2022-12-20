package com.nhnacademy.simple_nc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
    private Scanner scanner;
    private PrintWriter out;
    private Socket socket;

    public Sender(Socket socket) throws IOException {
        this.socket = socket;
        this.scanner = new Scanner(System.in);
        this.out = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (out != null) {
                String line = scanner.nextLine();

                out.println(line);
                out.flush();
            }
        } catch (Exception e) {
        }
    }
}

