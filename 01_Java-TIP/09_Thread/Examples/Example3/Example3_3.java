package Example3;

//문제 3-2. 스레드 내부에서 생성된 스레드가 종료되도록 수정합니다.
public class Example3_3 {

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
                this.childTask.thread.setDaemon(true);
                this.childTask.start();
            }
            this.stopFlag = false;
            System.out.printf("스레드[ %s ]을 시작합니다\n", Thread.currentThread().getName());
            try {
                while(!this.isStop()) {
                    Thread.sleep(this.getInterval());
                    if(this.thread.isDaemon()) System.out.printf("스레드[ %s: Daemon ] 동작중\n", Thread.currentThread().getName());
                    else System.out.printf("스레드[ %s ] 동작중\n", Thread.currentThread().getName());
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

        //동작 출력시 데몬 쓰레드의 종료는 찍히지 않는다 -> JVM은 데몬의 종료를 기다려주지않고 일반 쓰레드가 끝나는 그 즉시 종료시킴
    }
}
