package Example1;
//문제 1-1. Thread 클래스를 확장해 정의하라
public class Example1_1 {
    //정해진 시간 간격으로 메시지를 출력하도록 스레드로 동작하는 클래스를 정의 합니다.
    static class Task extends Thread {
        int intervalMS;
        public Task(int intervalMS) {
            this.intervalMS = intervalMS;
        }
        public void run()  {
            while(true) {
                try {
                    Thread.sleep(intervalMS);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);  //추가
                }
            }
        }
    }
    public static void main(String [] args) throws InterruptedException {
        //동작 시간 각기 다른 두개의 객체를 생성합니다.
        Task task1 = new Task(2000);
        Task task2 = new Task(3000);

        task1.start();
        task2.start();
        //두개의 객체를 동작시켜 메시지 출력 시간 간격을 확인합니다.
        for(int i = 0 ; i < 100 ; i++) {
            System.out.printf("%s - %s\n", task1.getState(), task2.getState());
            Thread.sleep(1000);
        }
    }
}
