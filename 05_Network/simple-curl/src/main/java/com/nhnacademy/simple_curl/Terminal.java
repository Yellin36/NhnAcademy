package com.nhnacademy.simple_curl;

import com.nhnacademy.simple_curl.client.Client;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Terminal {
    public static void main(String[] args) throws URISyntaxException {
        Scanner scanner = new Scanner(System.in);

        printInfo("");
        while(true) {
            System.out.print("$ ");
            String line = scanner.nextLine();

            if(line.equals("^C")) break;

            String commands[] = line.split(" ");

            if(commands[0].equals("scurl")) {
                try {
                    String hostURL = commands[commands.length - 1];

                    String words[] = hostURL.split(":");
                    int port = (words.length == 2) ? 80 : Integer.valueOf(words[2]);

                    URI uri = new URI(hostURL);

                    Socket socket = new Socket(uri.getHost(), port);

                    List<String> options = new ArrayList<>();
                    List<String> optionValues = new ArrayList<>();

                    String values= "";
                    for (int i = 1; i < commands.length - 1; i++) {
                        if(commands[i].length() == 0) continue;

                        if(commands[i].charAt(0) == '-') {
                            options.add(commands[i]);
                            if(i != 1)optionValues.add(values);
                            values = "";
                        }
                        else {
                            values += commands[i];
                        }
                    }
                    optionValues.add(values);

//                    System.out.println("=================================");
//                    System.out.println("[ Command 명령어 분석 ]");
//                    System.out.println("=================================");
//                    System.out.println("Options: " + options);
//                    System.out.println("OptionValues: " + optionValues);

                    Client client = new Client(socket);
                    client.run(uri, options, optionValues);

                } catch (UnknownHostException e) {
                    System.out.println("Hey, Wrong URL");
                } catch (IOException e) {
                    System.out.println("Hey, Failed");
                    e.printStackTrace();
                }
            }
        }
    }
    public static void printInfo(String info) {
        System.out.println(info);
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Usage: scurl [options] url\n" +
                "Options:\n" +
                "-v                 verbose, 요청, 응답 헤더를 출력합니다.\n" +
                "-H <line>          임의의 헤더를 서버로 전송합니다.\n" +
                "-d <data>          POST, PUT 등에 데이타를 전송합니다.\n" +
                "-X <command>       사용할 method 를 지정합니다. 지정되지 않은 경우 기본값은 GET 입니다.\n" +
                "-L                 서버의 응딥이 30x 계열이면 다음 응답을 따라 갑니다.\n" +
                "-F <name=content>  multipart/form-data 를 구성하여 전송합니다. content 부분에 @filename 을 사용할 수 있습니다.");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("예제1 $ scurl http://httpbin.org/get");
        System.out.println("예제2 $ scurl -X GET http://httpbin.org/get");
        System.out.println("예제3 $ scurl -v http://httpbin.org/get");
        System.out.println("예제4 $ scurl -v -H \"X-Custom-Header: NA\" -v http://httpbin.org/get");
        System.out.println("예제5 $ scurl -v -X POST -d \\\"{ \"hello\": \"world\" }\\\" -H \"Content-Type: application/json\"  http://httpbin.org/post");
        System.out.println("예제6 $ scurl -L http://httpbin.org/status/302");
        System.out.println("예제6-1 $ scurl -v -L http://httpbin.org/status/302");
        System.out.println("**예제 7은 영어 텍스트 파일로 부탁드립니다....나중에 옵션 추가를 해볼게요..");
        System.out.println("예제7 $ scurl -v -X POST -F \"upload=@c:\\Users\\yerin\\Downloads\\hello.py\" http://httpbin.org/post" );
        //scurl -F "upload=@c:\\Users\\yerin\\Downloads\\img.png" http://httpbin.org/post
        //curl -F "upload=@c:\Users\yerin\Downloads\dream.jpeg" http://httpbin.org/post
        //scurl -v -X POST -F "upload=@c:\Users\yerin\Downloads\hello.py" http://httpbin.org/post
        //scurl -v -X POST -F "upload=@/Users/yerin/Downloads/hello.py" http://httpbin.org/post
        System.out.println("----------------------------------------------------------------------------");
    }
}
