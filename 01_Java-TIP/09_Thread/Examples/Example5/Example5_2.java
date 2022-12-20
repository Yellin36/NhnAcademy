package Example5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//문제 5-2. synchronized 키워드와 정적 메소드를 이용해 동기화 시켜라
public class Example5_2 {
    //자바에서 지원하는 synchronized를 이용하세요.
    //스레드 동작 상태를 확인합니다.
    static class Task extends Thread {
        private long interval;
        private boolean stop;

        public Task(long interval) {
            this.interval = interval;
        }

        @Override
        public void run() {
            stop = false;
            long startTime = System.currentTimeMillis();
            long previousPrintTime = 0;

            while (!stop) {
                try {
                    long totalElapsedTime = System.currentTimeMillis() - startTime;
                    long elapsedTime = totalElapsedTime - previousPrintTime;
                    print(this.interval, startTime);
                    System.out.printf("[ %02d:%02d.%03d ][ %02d.%03d ] %s\n",
                            totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60,
                            totalElapsedTime % 1000,
                            (elapsedTime / 1000), elapsedTime % 1000,
                            this.getName());
                    previousPrintTime = totalElapsedTime;
                } catch (InterruptedException e) {
                }
            }
        }
        static synchronized void print(long interval, long startTime) throws InterruptedException {
            //static을 설정하지않으면 synchronized가 먹히지 않는다.
            //메모리 특정 지점을 알려주기 위해서???//
            Thread.sleep(interval - (System.currentTimeMillis() - startTime) % interval);
        }
        public void stop2() {
            stop = true;
        }
    }

    public static void main(String [] args) throws InterruptedException {
        Task task1 = new Task(3000);
        Task task2 = new Task(5000);
        task1.start();
        task2.start();
        long startTime = System.currentTimeMillis();
        long previousPrintTime = 0;
        for(int i = 0 ; i < 100 ; i++) {
            Thread.sleep(1000);
            if (i % 2 == 0) {
                task1.interrupt();
                task2.interrupt();
            }
            long totalElapsedTime = System.currentTimeMillis() - startTime;
            long elapsedTime = totalElapsedTime - previousPrintTime;
            System.out.printf("[ %02d:%02d.%03d ][ %02d.%03d ] %s - %s\n",
                    totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60,
                    totalElapsedTime % 1000,
                    (elapsedTime / 1000), elapsedTime % 1000,
                    task1.getState(), task2.getState());
            previousPrintTime = totalElapsedTime;
        }
        task1.stop2();
        task2.stop2();
    }

}
