public class Test {
    public static void main(String[] args) {
        String content = "--------------------------75c430a9ff9f270b\r\n" +
                "Content-Disposition: form-data; name=\"upload\"; filename=\"hello.py\"\r\n" +
                "Content-Type: application/octet-stream\r\n" +
                "\r\n" +
                "#i think it's unfair.\r\n" +
                "print(\"hello world\")\r\n" +
                "--------------------------75c430a9ff9f270b--\r";
        System.out.println(content.length());
    }
}
