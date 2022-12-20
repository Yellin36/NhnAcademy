package com.nhnacademy.simple_httpd;

import com.nhnacademy.simple_httpd.server.Server;

import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        while(true) {
            System.out.print("$ ");
            line = scanner.nextLine();

            int portNum;
            if((portNum = checkCommand(line)) > 0) {
                new Server(portNum).start();
                break;
            }
        }
    }
    public static int checkCommand(String line) {
        String tokens[] = line.split(" ");

        if(tokens[0].equals("shttpd")) {
            try {
                int portNum = Integer.valueOf(tokens[1]);

                if(0 <= portNum && portNum <= 65535) return portNum;
            } catch(NumberFormatException e) {
                System.out.println(">> wrong portNum");
            }
        }
        return -1;
    }
}
