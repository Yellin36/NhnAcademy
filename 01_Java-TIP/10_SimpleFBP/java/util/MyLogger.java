package SimpleFBP.util;

public class MyLogger {
    private String name;

    public MyLogger(String name) {
        this.name = name;
    }
    public void error(String m) {
        System.out.printf("[ error ] [ %s ] - %s\n", this.name, m);
    }
    public void info(String m) {
        System.out.printf("[ info ] [ %s ] - %s\n", this.name, m);
    }
    public void warning(String m) {
        System.out.printf("[ warning ] [ %s ] - %s\n", this.name, m);
    }
    public void debug(String m) {
        System.out.printf("[ debug ] [ %s ] - %s\n", this.name, m);
    }
}
