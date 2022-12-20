package Thread;

public class ExtendedThread extends Thread {
    private String message;
    private int loopCount;
    public ExtendedThread(String message) {
        this.message = message;
        this.loopCount = 0;
    }

    public void run() {
        while(!Thread.interrupted()) {
            try {
                ++this.loopCount;
                System.out.println(this.message + " : " + this.loopCount);
                Thread.sleep((long)(Math.random() * 1000));
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class TestExtendedJava {
    public static void main(String[] args) {
        ExtendedThread thread1 = new ExtendedThread("1");
        ExtendedThread thread2 = new ExtendedThread("2");
        ExtendedThread thread3 = new ExtendedThread("3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
