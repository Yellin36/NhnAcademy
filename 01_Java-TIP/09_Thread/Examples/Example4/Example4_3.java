package Example4;

//문제 4-3. 인터럽트로 인해 발생한 문제를 해결합니다.
public class Example4_3 {
    //수정하여 정해진 시간 간격에 맞도록 메시지가 출력되도록 수정합니다. 메시지 출력 시간 간격의 오차는 일부 발생할 수 있으나, 밀림 현상은 발생하지 않아야 합니다.
    //스레드 동작 상태를 확인합니다.
    static class Task extends Thread {
        int interval;

        public Task(int interval) {
            this.interval = interval;
        }

        @Override
        public void run() {
            long startTime = System.currentTimeMillis();
            long previousPrintTime = 0;
            
            while(true) {
                try {
                    Thread.sleep(interval - (System.currentTimeMillis() - startTime) % interval);
                    //못자면 못잔만큼 다시 자게 만들어 버리기

                    long totalElapsedTime = System.currentTimeMillis() - startTime;
                    long elapsedTime = totalElapsedTime - previousPrintTime;
                    System.out.printf("[ %02d:%02d.%03d ][ %02d.%03d ] %s\n",
                            totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60,
                            totalElapsedTime % 1000,
                            (elapsedTime / 1000), elapsedTime % 1000,
                            this.getName());
                    previousPrintTime = totalElapsedTime;
                } catch(InterruptedException ignore) {

                }
            }
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
    }
}
