package Thread;

public class TestInterrupt {
    static class Task extends Thread {
        public void run() {
            System.out.println("started");
            try {
                while(true) {
                    System.out.println("running");
                    Thread.sleep(1000);
                }
            } catch(InterruptedException e) {
                System.out.println("Interrupt occurred!");
            }
            System.out.println("finished");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Task();
        thread.start();

        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {

        }
        thread.interrupt();
    }
}
