## 문제 2. Runnable 인터페이스를 활용하라
Java의 스레드를 이용하는 두가지 방법중 하나인 Runnable 인터페이스를 이용해 스레드 확장 클래스를 구현합니다.

### 문제 2-1. Runnable 인터페이스를 이용해 클래스를 구현하라
- 생성된 클래스는 일정 시간 간격으로 메시지를 출력합니다. 
- 일정 시간은 생성자를 통해 생성시 받습니다. 
- Runnable 인터페이스를 이용하여 구현한 경우, 문제점이 무엇일까요? 
- 메시지 출력 후 call stack을 확인하고, 앞서 Thread 클래스를 확장한 것과 비교해 봅니다.

```java
import java.util.Arrays;
    public class Example2_1 {
    static class Task implements Runnable {
        ...
    }
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(1000);
        Thread taskThread = new Thread(task);
        
        taskThread.start();
        
        Thread.sleep(5000);
        
        task.stop();
        
        taskThread.join();
    }
}
```
실행 결과는 아래와 같습니다.
```
스레드[ Thread-0 ]을 시작 합니다
스레드[ Thread-0 ] 동작중
java.lang.Exception: Stack trace
 at java.base/java.lang.Thread.dumpStack(Thread.java:1383)
 at Example2_1$Task.run(Example2_1.java:24)
 at java.base/java.lang.Thread.run(Thread.java:829)
스레드[ Thread-0 ] 동작중
java.lang.Exception: Stack trace
 at java.base/java.lang.Thread.dumpStack(Thread.java:1383)
 at Example2_1$Task.run(Example2_1.java:24)
 at java.base/java.lang.Thread.run(Thread.java:829)
```

### 문제 2-2. Runnable 인터페이스를 이용해 Thread 클래스 상속과 같이 구현하라.
- Runnable 인터페이스를 구현하여 Thread의 메인을 구성합니다.
- 일반적으로 Runnable 인터페이스를 이용할 경우, 별도의 Thread 객체를 생성하고 이를 통해 실행 시킵니다.
- 구현된 클래스에서 생성한 객체에서 직접 실행할 수 있도록 클래스를 구성합니다.
- 이와 같이 구성할 경우, Thread클래스를 확장해 구현한 것과 비슷해 보인다. 어떠한 이점과 단점이 있는지 설명합니다
```java
public class Example2_2 {
    static class Task implements Runnable {
        ...
    }
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(1000);
        task.start();
        Thread.sleep(5000);
        task.stop();
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
스레드[ Thread-0 ] 동작중
스레드[ Thread-0 ]을 종료 합니다
```

> run()과 start()의 차이점