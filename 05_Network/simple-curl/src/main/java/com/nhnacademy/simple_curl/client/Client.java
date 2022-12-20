package com.nhnacademy.simple_curl.client;

import com.nhnacademy.simple_curl.Curl;

import java.io.*;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Client(Socket socket) throws IOException {
        this.socket = socket;

        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream());
    }
    public void run(URI host, List<String> options, List<String> optionValues) throws IOException {
        boolean print = makeMethodCurl(host, options, optionValues);

        printResult(print);
    }
    public List<String> printResult(boolean canPrint) {
        System.out.println("=================================");
        String line;
        List<String> lines = new ArrayList<>();

        try {
            while ((line = in.readLine()) != null) {
                lines.add(line);

                if (line.equals("")) canPrint = true;

                if (canPrint) System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Hey, error to get result");
        }
        return lines;
    }
    public boolean makeMethodCurl(URI host, List<String> options, List<String> optionValues) {
        boolean printAll = false;
        boolean hasHeader = false;
        boolean redirect = false;

        String method = "GET";
        String requestURL = host.getPath();
        String httpVersion = "HTTP/1.1";
        String headerValue = null;
        String contentValue = null;
        String filePath = null;

        for (int i = 0; i < options.size(); i++) {
            switch (options.get(i)) {
                case "-X":
                    method = optionValues.get(i);
                    break;
                case "-v":
                    printAll = true;
                    break;
                case "-H":
                    hasHeader = true;
                    headerValue = optionValues.get(i).replace("\"", "");
                    break;
                case "-d":
                    if(!hasHeader) headerValue = "Content-Type: application/json";
                    contentValue = optionValues.get(i).substring(2, optionValues.get(i).length() -2);
                    break;
                case "-L":
                    redirect = true;
                    break;

                case "-F":
                    String value = optionValues.get(i);
                    filePath = value.split("=")[1].replaceAll("[@\"]", "");
                    break;
            }
        }
        Curl curl = new Curl(method, requestURL, httpVersion, host.getHost(), headerValue, contentValue, filePath, printAll);

        curl.sendOptionInfo(); //추가된 옵션 확인
        if(redirect) redirectPage(curl, 1);
        else curl.sendOptionPrint(out);

        return printAll;
    }
    boolean redirectPage(Curl curl, int count) {
        System.out.println("=================================");
        System.out.println("> Redirect count : " + count);
        try {
            socket = new Socket(curl.getHost(), 80);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            curl.sendOptionPrint(out);

            if (count == 5) return false;

            List<String> lines = printResult(curl.getPrintAll());

            //redirection 결과가 300번대인 경우
            if (lines.get(0).split(" ")[1].charAt(0) == '3') {
                for (int i = 1; i < lines.size(); i++) {
                    String[] line = lines.get(i).split(":");
                    String word = line[0].toLowerCase();
                    if (word.equals("location")) {
                        curl.setRequestURL(line[1].strip());
                        break;
                    }
                }

                in.close();
                out.close();
                socket.close();

                return redirectPage(curl, count + 1);
            }

        }catch (IOException e) {}
        return true;
    }
}
