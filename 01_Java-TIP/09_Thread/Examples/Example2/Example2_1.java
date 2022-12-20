package Example2;

//문제 2-1. Runnable 인터페이스를 이용해 클래스를 구현하라
public class Example2_1 {
    static class Task implements Runnable {
        int intervalMS;
        boolean stopFlag;
        public Task(int intervalMS) {
            this.intervalMS = intervalMS;
        }

        @Override
        public void run() {
            stopFlag = false;
            System.out.printf("스레드[ %s ]을 시작합니다\n", Thread.currentThread().getName());
            try {
                while(!stopFlag) {
                    Thread.sleep(intervalMS);
                    System.out.printf("스레드[ %s ] 동작중\n", Thread.currentThread().getName());
                    Thread.dumpStack();
                }
            } catch(InterruptedException e) {
                System.out.printf("스레드[ %s ]에서 인터럽트가 발생하였습니다!\n", Thread.currentThread().getName());
            } finally {
                stopFlag = false;
            }
            System.out.printf("스레드[ %s ]을 종료합니다\n", Thread.currentThread().getName());
        }
        public void stop() {
            stopFlag = true;
        }
    }
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(1000);
        Thread taskThread = new Thread(task);

        taskThread.start();

        Thread.sleep(5000);

        task.stop();

        taskThread.join();
    }
}
