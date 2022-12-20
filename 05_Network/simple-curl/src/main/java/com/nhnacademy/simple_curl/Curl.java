package com.nhnacademy.simple_curl;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class Curl {
    private String method;
    private String requestURL;
    private String httpVersion;
    private String host;
    private String header;
    private String content;
    private boolean printAll;
    private String filePath;

    public Curl() {}
    public Curl(String method, String requestURL, String httpVersion, String host, boolean printAll) {
        this.method = method;
        this.requestURL = requestURL;
        this.httpVersion = httpVersion;
        this.host = host;
        this.printAll = printAll;
    }

    public Curl(String method, String requestURL, String httpVersion, String host, String header, String content, String filePath, boolean printAll) {
        this(method, requestURL, httpVersion, host, printAll);
        this.filePath = filePath;
        this.header = header;
        this.content = content;
    }
    public String getMethod() {
        return method;
    }

    public String getHost() {
        return host;
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }
    public String getHttpVersion() { return httpVersion; }
    public String getRequestURL() { return requestURL; }
    public boolean getPrintAll() {
        return printAll;
    }
    public String getFirstLine() { return method + " " + requestURL + " " + httpVersion; }

    public void setMethod(String method) {
        this.method = method;
    }
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void sendOptionInfo() {
        System.out.println("=================================");
        System.out.println("[ Output List ]");
        System.out.println("=================================");
        System.out.println("Method: " + method);
        System.out.println("Host: " + host);
        if(header != null) System.out.println("Header: " + header);
        if(content != null) System.out.println("Content: " + content + "(" + content.length() + ")");
        if(filePath != null) System.out.println("FileName: " + filePath);
    }
    public void sendOptionPrint(PrintWriter out) {
        String requestBody = "";
        String uuid = "-----------" + UUID.randomUUID().toString();
        if(filePath != null) {
            try {
                BufferedReader rd = new BufferedReader(new FileReader(filePath));

                String words[] = filePath.replace("\\", " ").split(" ");
                String fileName = words[words.length-1];

                requestBody += "--" + uuid + "\r\n";
                requestBody += "Content-Disposition: form-data; name=\"upload\"; filename=\"" + fileName + "\"\r\n";
                requestBody += "Content-Type: application/octet-stream\r\n";
                requestBody += "\r\n";

                String l;
                while ((l = rd.readLine()) != null) {
                    requestBody += l + "\r\n";
                }
                requestBody += "--" + uuid + "--\r\n";
            } catch (FileNotFoundException e) {
                System.out.println("___1");
            } catch (IOException e) {
                System.out.println("_____3");
            }
        }

        //메서드 출력
        out.println(method + " " + requestURL + " " + httpVersion);

        //헤더 출력
        out.println("Host: " + host);

        if(header != null) {
            out.println(header);
        }
        out.println("User-Agent: curl/7.79.1");
        out.println("Accept: */*");

        //헤더 및 엔터티 본문 출력
        if(content != null) {
            out.println("Content-Length: " + content.length());
            out.println();
            out.println(content);
        }
        if(filePath != null) {
            System.out.println("-------Content-Length: " + requestBody.length());
            out.println("Content-Length: " + requestBody.length() );
            out.println("Content-Type: multipart/form-data; boundary=" + uuid);
            out.println();
            out.println(requestBody);
        }
        out.println();
        out.flush();
    }


}
