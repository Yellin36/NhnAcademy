package com.nhnacademy.simple_httpd;

import java.util.Stack;

public class Path {
    private final String rootPath;
    private Stack<String> paths;
    private String urlPath;

    public Path(String rootPath) {
        this.rootPath = rootPath;
        this.paths = new Stack<>();
    }
    public String getUrlPath() {
        String path = "//";
        for (int i = 0; i < paths.size(); i++) {
            path += paths.get(i) + "/";
        }
        path = path.s
        return path;
    }
    public String getDirPath() {
        String path = rootPath;
        for(String p : paths) {
            path += "\\" + p;
        }
        return path;
    }
    public String getPath() {
        String path = "";
        for (int i = 0; i < paths.size(); i++) {
            path += paths.get(i);
        }
        return path;
    }
    public String getFullPath() {
        String fullPath = rootPath;
        for (int i = 0; i < paths.size(); i++) {
            fullPath += paths.get(i);
        }
        return fullPath;
    }
    public boolean addPath(String path) {
        if(path == null) return true;
        switch (path) {
            case "\\":
                if(paths.isEmpty()) {
                    System.out.println("경로 추가: " + path);
                    paths.push(path);
                }
                break;
            case "\\..":
                if(paths.isEmpty()) {
                    return false;
                }
                else paths.pop();
                System.out.println("뒤로가기");
                break;
            default:
                paths.push(path);
                System.out.println("경로 추가: " + path);
                break;
        }
        return true;
    }
    public String toString() {
        return getFullPath();
    }
}
