package Example1;

//문제 1-3. 클래스에 별도의 필드 추가 없이 스레드를 중지시키도록 메소드를 추가합니다
public class Example1_3 {
    static class Task extends Thread {
        int intervalMS;
        public Task(int intervalMS) {
            this.intervalMS = intervalMS;
        }

        public void stop2() {
            interrupt();
        }
        public void run() {
            System.out.printf("스레드[ %s ]을 시작합니다\n", Thread.currentThread().getName());
            /** busy waiting, sleep(), wait() : CPU 성능과 관련하여 고려해야함. **/
            try {
                while (!interrupted()) {

                    Thread.sleep(intervalMS);
                    System.out.printf("스레드[ %s ] 동작중\n", Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                System.out.printf("스레드[ %s ]에서 인터럽트가 발생하였습니다!\n", Thread.currentThread().getName());
                interrupt();
            }
            System.out.printf("스레드[ %s ]을 종료합니다\n", Thread.currentThread().getName());
        }
    }
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(1000);

        task.start();

        Thread.sleep(5000);;
        //Thread 클래스에서 지원하는 interrupt() 메소드를 이용합니다
        task.stop2();

        task.join();
        /**메인이 이 시점에 기다리고 있다가 , 해당 스레드가 terminated되었다면 메인으로 제어권이 다시 돌아오고 종료됨.
         * 종료시점을 몰라 기다리는 경우가 있어 join을 해주는게 좋을 것 같다.
         * join이 필요없는 경우는 daemon thread인 경우이다. **/
    }
}
