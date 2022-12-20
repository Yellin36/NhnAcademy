package Example5;

//문제 5-3. synchronized 키워드와 객체를 이용해 동기화 시켜라
public class Example5_3 {
    //자바에서 지원하는 synchronized를 이용하세요.
    //정적 메소드를 사용하지 않습니다.

    static class Printer {
        synchronized void printAndSleep(String message, long interval) throws InterruptedException {
            Thread.sleep(interval);
            System.out.print(message);
        }
    }
    static class Task extends Thread {
        private long interval;
        private boolean stop;
        private Printer printer;

        public Task(long interval, Printer printer) {
            this.printer = printer;
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
                    String message = String.format("[ %02d:%02d.%03d ][ %02d.%03d ] %s\n",
                            totalElapsedTime / (60 * 1000), (totalElapsedTime / 1000) % 60,
                            totalElapsedTime % 1000,
                            (elapsedTime / 1000), elapsedTime % 1000,
                            this.getName());
                    printer.printAndSleep(message, this.interval - (System.currentTimeMillis() - startTime) % interval);
                    previousPrintTime = totalElapsedTime;
                } catch (InterruptedException e) {
                }
            }
        }
        public void stop2() {
            stop = true;
        }
    }

    public static void main(String [] args) throws InterruptedException {
        Printer printer = new Printer();
        Task task1 = new Task(3000, printer);
        Task task2 = new Task(5000, printer);

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
