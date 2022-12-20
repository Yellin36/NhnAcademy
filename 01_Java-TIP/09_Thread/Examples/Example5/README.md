## 문제 5. 두개의 객체를 동기화 시켜라
두개의 객체는 다른 객체에 영향을 받지 않고 동작해야 합니다.<br>
두개의 객체가 메시지 출력에 상호 영향 받도록 수정합니다.

## 문제 5-1. Lock을 이용해 동기화 시켜보자.
- java.util.concurrent.locks를 이용하세요.
- 예를 들어, 첫번째 객체가 출력하고, 두번째 객체가 출력됩니다면 두출력간 시간 간격은 첫번째 객체에 설정된 시간 간격이 되어야 합니다.
- 단, 첫번째 객체가 출력된 후 다음 객체는 첫번째나 두번째 객체가 될 수 있습니다.
- 스레드 동작 상태를 확인합니다.

```java
import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example5_1 {
    static class Task extends Thread {
        ...
    }
    public static void main(String [] args) throws InterruptedException {
        Task task1 = new Task(3000);
        Task task2 = new Task(5000);
        task1.start();
        task2.start();
        task1.join();
    }
}
```

실행 결과는 아래와 같습니다.
```
[ 00:00.000 ][ 00.000 ] Thread-1
[ 00:05.028 ][ 05.028 ] Thread-1
[ 00:10.032 ][ 10.032 ] Thread-0
[ 00:13.038 ][ 08.010 ] Thread-1
[ 00:18.041 ][ 08.009 ] Thread-0
[ 00:21.044 ][ 03.003 ] Thread-0
[ 00:24.049 ][ 03.005 ] Thread-0
```

### 문제 5-2. synchronized 키워드와 정적 메소드를 이용해 동기화 시켜라
- 자바에서 지원하는 synchronized를 이용하세요.
- 스레드 동작 상태를 확인합니다.

```java
import java.time.LocalDateTime;
public class Example5_2 {
    static class Task extends Thread {
        ...
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
                totalElapsedTime % 1000, (elapsedTime / 1000), elapsedTime % 1000,
                task1.getState(), task2.getState());
            previousPrintTime = totalElapsedTime;
        }
        task1.stop2();
        task2.stop2();
    }
}
```

실행 결과는 아래와 같습니다

```
[ 00:00.000 ][ 00.000 ] Thread-0
[ 00:00.000 ][ 00.000 ] Thread-1
[ 00:01.006 ][ 01.006 ] Thread-0
[ 00:01.006 ][ 01.006 ] Thread-1
[ 00:01.005 ][ 01.005 ] TIMED_WAITING - BLOCKED
[ 00:02.010 ][ 01.005 ] TIMED_WAITING - BLOCKED
[ 00:03.013 ][ 01.003 ] TIMED_WAITING - BLOCKED
[ 00:03.013 ][ 03.013 ] Thread-0
[ 00:03.013 ][ 03.013 ] Thread-1
[ 00:04.014 ][ 01.001 ] TIMED_WAITING - BLOCKED
[ 00:05.019 ][ 01.005 ] TIMED_WAITING - BLOCKED
[ 00:05.019 ][ 05.019 ] Thread-1
[ 00:05.019 ][ 05.019 ] Thread-0
[ 00:06.025 ][ 01.006 ] BLOCKED - TIMED_WAITING
[ 00:07.029 ][ 01.004 ] BLOCKED - TIMED_WAITING
[ 00:07.029 ][ 07.029 ] Thread-0
[ 00:07.029 ][ 07.029 ] Thread-1
[ 00:08.034 ][ 01.005 ] TIMED_WAITING - BLOCKED
[ 00:09.037 ][ 01.003 ] TIMED_WAITING - BLOCKED
```

### 문제 5-3. synchronized 키워드와 객체를 이용해 동기화 시켜라
- 자바에서 지원하는 synchronized를 이용하세요.
- 정적 메소드를 사용하지 않습니다.

```java
public class Example5_3 {
    static class Printer {
        ...
    }
    
    static class Task extends Thread {
        ...
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
            totalElapsedTime % 1000, (elapsedTime / 1000), elapsedTime % 1000,
            task1.getState(), task2.getState());
        previousPrintTime = totalElapsedTime;
    }
    task1.stop2();
    task2.stop2();
    }
}
```
실행 결과는 아래와 같습니다.
```
[ 00:00.000 ][ 00.000 ] Thread-1
[ 00:01.005 ][ 01.005 ] BLOCKED - TIMED_WAITING
[ 00:01.006 ][ 01.006 ] Thread-1
[ 00:02.012 ][ 01.007 ] BLOCKED - TIMED_WAITING
[ 00:03.018 ][ 01.006 ] BLOCKED - TIMED_WAITING
[ 00:03.019 ][ 03.019 ] Thread-1
[ 00:04.025 ][ 01.007 ] BLOCKED - TIMED_WAITING
[ 00:05.031 ][ 01.006 ] BLOCKED - TIMED_WAITING
[ 00:05.031 ][ 05.031 ] Thread-1
[ 00:06.035 ][ 01.004 ] BLOCKED - TIMED_WAITING
[ 00:07.041 ][ 01.006 ] BLOCKED - TIMED_WAITING
[ 00:07.041 ][ 07.041 ] Thread-1
[ 00:08.045 ][ 01.004 ] BLOCKED - TIMED_WAITING
[ 00:09.051 ][ 01.006 ] BLOCKED - TIMED_WAITING
[ 00:00.000 ][ 00.000 ] Thread-0
[ 00:09.052 ][ 09.052 ] Thread-0
[ 00:10.053 ][ 01.002 ] TIMED_WAITING - BLOCKED
[ 00:11.056 ][ 01.003 ] TIMED_WAITING - BLOCKED
[ 00:09.051 ][ 09.051 ] Thread-1
[ 00:11.056 ][ 11.056 ] Thread-0
[ 00:12.061 ][ 01.005 ] TIMED_WAITING - BLOCKED
```

### 문제 5-4. synchronized 키워드와 객체를 이용해 동기화 시켜라
- 자바에서 지원하는 synchronized를 이용하세요.
- 정적 메소드를 사용하지 않습니다.
- 메소드 synchronized를 이용하지 않습니다.

```java
public class Example5_4 {
    static class Printer {
        ...
    }
    static class Task extends Thread {
        ...
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
                totalElapsedTime % 1000, (elapsedTime / 1000), elapsedTime % 1000,
                task1.getState(), task2.getState());
            previousPrintTime = totalElapsedTime;
        }
        task1.stop2();
        task2.stop2();
    }
}
```

실행 결과는 아래와 같습니다.
```
[ 00:00.000 ][ 00.000 ] Thread-1
[ 00:00.000 ][ 00.000 ] Thread-0
[ 00:01.005 ][ 01.005 ] BLOCKED - RUNNABLE
[ 00:01.005 ][ 01.005 ] Thread-0
[ 00:02.011 ][ 01.006 ] TIMED_WAITING - BLOCKED
```