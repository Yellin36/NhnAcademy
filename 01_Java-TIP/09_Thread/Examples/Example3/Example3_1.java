package Example3;

//문제 3-1. 스레드 안에서 스레드를 생성해 봅니다.
public class Example3_1 {
    //Task에서 두개의 주기를 받아 스레드 내에서 스레드를 추가로 실행합니다.
    //결과를 확인합니다. 동작에 대해 설명하세요.
    static class Task implements Runnable {
        boolean stopFlag;
        long interval;
        long childInterval;
        Thread thread;
        Task childTask;
        public Task(long interval) {
            this.stopFlag = true;
            this.interval = interval;
            this.thread = new Thread(this);
        }
        public Task(long interval, long childInterval) {
            this.stopFlag = true;
            this.interval = interval;
            this.thread = new Thread(this);
            this.childInterval = childInterval;
        }
        public boolean isStop() { return this.stopFlag == true; }
        public long getInterval() { return this.interval; }
        public void join() throws InterruptedException {
            this.thread.join();
        }
        public void stop() {
            this.stopFlag = true;
        }
        public void start() {
            this.thread.start();
        }
        @Override
        public void run() {
            if(this.childInterval != 0) {
                this.childTask = new Task(childInterval);
                this.childTask.start();
            }
            this.stopFlag = false;
            System.out.printf("스레드[ %s ]을 시작합니다\n", Thread.currentThread().getName());
            try {
                while(!this.isStop()) {
                    Thread.sleep(this.getInterval());
                    System.out.printf("스레드[ %s ] 동작중\n", Thread.currentThread().getName());
                }
            } catch(InterruptedException e) {
                System.out.printf("스레드[ %s ]에서 인터럽트가 발생하였습니다!\n", Thread.currentThread().getName());
            } finally {
                this.stopFlag = false;
            }
            System.out.printf("스레드[ %s ]을 종료합니다\n", Thread.currentThread().getName());
        }
    }

    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(2000, 1000);
        task.start();
        Thread.sleep(10000);
        task.stop();
        task.join();
    }
}
