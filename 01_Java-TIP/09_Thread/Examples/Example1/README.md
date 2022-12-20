## 문제 1. Thread 클래스를 이용해 독립적으로 수행되는 객체를 만들자.
Tread 클래스를 확장해 독집적으로 수행할 수 있는 객체 생성을 위한 클래스를 정의합니다.


### 문제 1-1. Thread 클래스를 확장해 정의하라
- 정해진 시간 간격으로 메시지를 출력하도록 스레드로 동작하는 클래스를 정의 합니다.
- 동작 시간 각기 다른 두개의 객체를 생성합니다.
- 두개의 객체를 동작시켜 메시지 출력 시간 간격을 확인합니다.
- 스레드의 동작 상태에 대해 확인합니다

```java
public class Exmaple1_1 {
    static class Task extends Thread {
        ...
    }
    public static void main(String [] args) throws InterruptedException {
        Task task1 = new Task(2000);
        Task task2 = new Task(3000);
        task1.start();
        task2.start();
        for(int i = 0 ; i < 100 ; i++) {
            System.out.printf("%s - %s\n", task1.getState(), task2.getState());
            Thread.sleep(1000);
        }
    }
}
```

실행 결과는 아래와 같습니다.
```
RUNNABLE - TIMED_WAITING
TIMED_WAITING - TIMED_WAITING
Thread-0
TIMED_WAITING - TIMED_WAITING
Thread-1
TIMED_WAITING - TIMED_WAITING
Thread-0
TIMED_WAITING - TIMED_WAITING
TIMED_WAITING - TIMED_WAITING
Thread-1
Thread-0
TIMED_WAITING - TIMED_WAITING
```

### 문제 1-2. 클래스에 필드를 추가하고, 이를 이용해서 스레드를 중지시키도록 메소드를 추가합니다
- 메인 스레드에서 안전하게 중지 시킬 수 있도록 기능을 추가합니다.
- Thread에서 제공하는 stop은 문제를 발생시킬 가능성이 있어 더이상 사용을 권장하지 않으므로 사용하지 않습니다.
- 무한 반복을 위해 wait상태로 만들 수 있다. 이 경우, 즉시 중지하지 않고, 상태 변경 후 중지 됩니다. 
- 어떠한 해결 방법이 있을까요? 

```java
public class Example1_2 {
    static class Task extends Thread {
        ...
    }
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(1000);
        task.start();
        Thread.sleep(5000);
        task.stop2();
        task.join();
    }
}
```
- 위 코드에서 stop()메소드를 재정의하지 않고, stop2()로 정의하였다. 이유는 무엇일까요? 
    > 해당 stop()메소드를 final로 선언하였기때문에 Override되지 않는다.

실행 결과는 아래와 같습니다.
```
스레드[ Thread-0 ]을 시작 합니다
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ]을 종료 합니다
```

### 문제 1-3. 클래스에 별도의 필드 추가 없이 스레드를 중지시키도록 메소드를 추가합니다
- Thread 클래스에서 지원하는 interrupt() 메소드를 이용합니다.

```java
public class Example1_3 {
    static class Task extends Thread {
        ...
    }
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(1000);
        task.start();
        Thread.sleep(5000);;
        task.interrupt();
        task.join();
    }
}
```
실행 결과는 아래와 같습니다.
```
스레드[ Thread-0 ]을 시작 합니다
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ]에서 인터럽트가 발생하였습니다!
스레드[ Thread-0 ]을 종료 합니다
```