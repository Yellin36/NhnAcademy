package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableThread implements Runnable {
    private String message;
    private int loopCount;
    private int intervalMs;
    static private final ReentrantLock lock = new ReentrantLock();
    public RunnableThread(String message, int intervalMs) {
        this.message = message;
        this.loopCount = 0;
        this.intervalMs = intervalMs;
    }
    public void wakeUp() { notify(); }

    synchronized public static void task1(RunnableThread thread) throws InterruptedException {
        //static이 아니었을경우 해당 객체에만 적용
        System.out.println(String.format("%s - entry", thread.message, thread.loopCount));
        Thread.sleep((long) (thread.intervalMs));
        System.out.println(String.format("%s - exit", thread.message, thread.loopCount));
    }
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long previousTime = startTime;
/*
        while(!Thread.interrupted()) {
            try {
                long currentTime = System.currentTimeMillis();
                long totalElapsedTime = currentTime - startTime;
                long elapsedTime = currentTime - previousTime;

                previousTime = currentTime;
                ++this.loopCount;
                System.out.println(String.format("%8d : %8d : %s - %d", totalElapsedTime, elapsedTime, message, this.loopCount));

            } catch (InterruptedException e) {
                System.out.println("Woke up by an interruption.");
            }
        }*/
    }
}
class TestRunnableThread {
    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(new RunnableThread("One", 5000));
        Thread thread2 = new Thread(new RunnableThread("Two", 7000));
        Thread thread3 = new Thread(new RunnableThread("Three", 9000));
        thread1.start();
        thread2.start();
        thread3.start();

        thread2.join();

        while(true) {
            Thread.sleep(3000);
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();
    }
    }
}