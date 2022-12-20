package Example4;

//문제 4-2. Thread.sleep() 메소드를 이용해 대기합니다.
public class Example4_2 {
    //메인 스레드 내에서 두개의 객체가 동작하는 시간 간격보다 짧게하여 인터럽트를 생성합니다.
    //인터럽트로 인해 어떠한 문제가 발생하였는가? 이유를 설명하세요.
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
                    Thread.sleep(interval);
                    long totalElapsedTime = System.currentTimeMillis() - startTime;
                    long elapsedTime = totalElapsedTime - previousPrintTime;
                    System.out.printf("[ %02d:%02d.%03d ][ %02d.%03d ] %s\n",
                            totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60,
                            totalElapsedTime % 1000,
                            (elapsedTime / 1000), elapsedTime % 1000,
                            this.getName());
                    previousPrintTime = totalElapsedTime;
                } catch(InterruptedException e) {
                    System.out.printf("%s - %s: interrupt\n", getName(), getState());
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
