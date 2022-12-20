package Example5;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//문제 5-1. Lock을 이용해 동기화 시켜보자.
public class Example5_1 {
    //java.util.concurrent.locks를 이용하세요.
    //예를 들어, 첫번째 객체가 출력하고, 두번째 객체가 출력됩니다면 두출력간 시간 간격은 첫번째 객체에 설정된 시간 간격이 되
    //어야 합니다.
    //단, 첫번째 객체가 출력된 후 다음 객체는 첫번째나 두번째 객체가 될 수 있습니다.
    //스레드 동작 상태를 확인합니다.
    static class Task extends Thread {
        private long interval;
        static Lock Lock = new ReentrantLock();
        //lock을 집어넣은 이유? lock은 하나만 있어야함. (공유를 해야함 --> static), 공유 시키는 방법: 외부에서 넣어주거나 static같은 것

        public Task(long interval) {
            this.interval = interval;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            long previousPrintTime = 0;

            while (true) {
                Lock.lock();
                try {
                    Thread.sleep(interval - (System.currentTimeMillis() - startTime) % interval);

                    long totalElapsedTime = System.currentTimeMillis() - startTime;
                    long elapsedTime = totalElapsedTime - previousPrintTime;
                    System.out.printf("[ %02d:%02d.%03d ][ %02d.%03d ] %s\n",
                            totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60,
                            totalElapsedTime % 1000,
                            (elapsedTime / 1000), elapsedTime % 1000,
                            this.getName());
                    previousPrintTime = totalElapsedTime;
                    Lock.unlock();
                    Thread.yield();
                } catch (InterruptedException ignore) {

                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task(3000);
        Task task2 = new Task(5000);
        task1.start();
        task2.start();
        task1.join();
        //한놈이 계속 나올 수도있으나 이건 선점의 문제일뿐
    }

}
