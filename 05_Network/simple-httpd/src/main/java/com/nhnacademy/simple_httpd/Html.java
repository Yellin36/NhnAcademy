package com.nhnacademy.simple_httpd;

public class Html {
    public String getHtmlDirListForm(String dirPath, String[] lists) {
        return "<!DOCTYPE>\r\n" +
                "<html>\r\n" +
                "<head>\r\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" +
                "<title>Directory listing for /.android/</title>\r\n" +
                "</head>\r\n" +
                "<body>\r\n" +
                "<h1>Directory listing for " + dirPath + "</h1>\r\n" +
                "<hr>\r\n" +
                getHtmlLists(lists) +
                "<hr>\r\n" +
                "</body>\r\n" +
                "</html>";
    }
    public String getHtmlLists(String[] lists) {
        StringBuilder listsForm = new StringBuilder();

        listsForm.append("<ul>\r\n");
        listsForm.append(getHtmlList(getHtmlLink(".")));
        listsForm.append(getHtmlList(getHtmlLink("..")));
        for(String list : lists) {
            listsForm.append(getHtmlList(getHtmlLink(list)));
        }
        listsForm.append("</ul>\r\n");
        return listsForm.toString();
    }
    public String getHtmlList(String line) {
        return "<li>" + line + "</li>";
    }
    public String getHtmlLink(String value) {
        return "<a href = \"\\" + value + "\">\\" + value + "</a>";
    }
}
