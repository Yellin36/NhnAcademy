package com.nhnacademy.simple_nc;


import com.nhnacademy.simple_nc.server.*;
import com.nhnacademy.simple_nc.client.*;

import java.io.IOException;
import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("$ ");
            if(checkLine(scanner.nextLine())) break;
        }
    }
    public static boolean checkLine(String line) throws IOException {
        String words[] = line.split(" ");
        String hostname = "";
        int portNum = 0;

        if(words[0].equals("snc")) {
            if(words.length != 3) {
                printInfo("wrong option counts");
                return false;
            }
            if(words[1].equals("-l")) {
                hostname = words[1];
            }
            else {
                String[] nums = words[1].split("[.]");

                if(nums.length == 4) hostname = words[1];
                else {
                    printInfo("no such ip.");
                    return false;
                }
            }
            try {
                portNum = Integer.valueOf(words[2]);
            } catch(NumberFormatException e) {
                printInfo("no such portNum");
                return false;
            }
        }
        else {
            printInfo("command not found");
            return false;
        }

        if(hostname.equals("-l"))
            new Server(portNum).run();
        else new Client(hostname, portNum).run();

        return true;
    }
    public static void printInfo(String info) {
        System.out.println(info);
        System.out.println("----------------------------------------------------");
        System.out.println("Usage: snc [option]/[hostname] [port]");
        System.out.println("Options:");
        System.out.println("-l   <port>     server mode");
        System.out.println("----------------------------------------------------");
    }
}
