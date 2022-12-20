package Example2;

//문제 2-2. Runnable 인터페이스를 이용해 Thread 클래스 상속과 같이 구현하라.
public class Example2_2 {
    //구현된 클래스에서 생성한 객체에서 직접 실행할 수 있도록 클래스를 구성합니다.
    //이와 같이 구성할 경우, Thread클래스를 확장해 구현한 것과 비슷해 보인다. 어떠한 이점과 단점이 있는지 설명합니다.
    static class MyThread extends Thread {
        int intervalMS;
        boolean stopFlag;

        public MyThread(int intervalMS) {
            this.intervalMS = intervalMS;
            this.stopFlag = false;
        }
        @Override
        public void run() {
            this.stopFlag = false;
            System.out.printf("스레드[ %s ]을 시작합니다\n", Thread.currentThread().getName());
            try {
                while(!this.stopFlag) {
                    Thread.sleep(intervalMS);
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
    static class Task implements Runnable {
        private MyThread thread;

        public Task(int intervalMS) {
            this.thread = new MyThread(intervalMS); //메인 쓰레드가 돌리는 중
        }
        //run():single thread과 start():multi thread의 차이점
        //run() : 쓰레드의 상태를 고려하지않고 돌리기만 함
        @Override
        public void run() {
            this.thread.start();
        }

        public void start() {
            this.run();
        }
        public void stop() {
            this.thread.stopFlag = true;
        }
        public void join() throws InterruptedException {
            thread.join();
        }
    }
    //Runnable 인터페이스를 구현하여 Thread의 메인을 구성합니다.
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(1000); //일반적으로 Runnable 인터페이스를 이용할 경우, 별도의 Thread 객체를 생성하고 이를 통해 실행 시킵니다

        task.start();

        Thread.sleep(5000);

        task.stop();

        task.join();
    }
}
