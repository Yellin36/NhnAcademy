package Example1;

//문제 1-2. 클래스에 필드를 추가하고, 이를 이용해서 스레드를 중지시키도록 메소드를 추가합니다
public class Example1_2 {
    static class Task extends Thread {
        int intervalMS;
        boolean stop;   //stopFlag
        public Task(int intervalMS) {
            this.intervalMS = intervalMS;
            this.stop = false;
        }
        public void run()  {
            System.out.printf("스레드[ %s ]을 시작합니다\n", Thread.currentThread().getName());
            this.stop = false;
            try {
                while(!stop) {
                    /** busy waiting? sleep()[잠재우는것]대신에 while문을 계속 돌리는것**/
                    Thread.sleep(intervalMS);
                    /** sleep을 하면서 바로 stop이 되지 않는 경우가 발생할 수 있다.
                        --> sleep시간에 따라 쓸데없이 오래 기다리게됨.**/
                    System.out.printf("스레드[ %s ] 동작중\n", Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {

            } /**추가**/finally {
                stop = false;
            }
            System.out.printf("스레드[ %s ]을 종료합니다\n", Thread.currentThread().getName());
        }
        //메인 스레드에서 안전하게 중지 시킬 수 있도록 기능을 추가합니다.
        public void stop2() {
            stop = true;
        }
    }
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(1000);

        task.start();
        Thread.sleep(5000);
        task.stop2();
        task.join();
    }
}
