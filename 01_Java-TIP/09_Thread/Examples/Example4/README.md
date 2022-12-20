## 문제 4. 인터럽트로 인한 동작 변화를 수정합니다.
### 문제 4-1. Busy waiting으로 대기합니다.
- 메시지 출력 대기를 busy waiting으로 구현합니다.
- 메인 스레드 내에서 두개의 객체가 동작하는 시간 간격보다 짧게하여 인터럽트를 생성합니다.
- 인터럽트로 인해 어떠한 문제가 발생하였는가? 이유를 설명하세요.
```java
import java.time.LocalDateTime;
public class Example4 {
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
totalElapsedTime % 1000,
(elapsedTime / 1000), elapsedTime % 1000,
task1.getState(), task2.getState());
previousPrintTime = totalElapsedTime;
}
}
}
```
실행 결과는 아래와 같습니다
```
[ 00:01.005 ][ 01.005 ] RUNNABLE - RUNNABLE
[ 00:02.033 ][ 01.028 ] RUNNABLE - RUNNABLE
[ 00:03.000 ][ 03.000 ] Thread-0
[ 00:03.039 ][ 01.006 ] RUNNABLE - RUNNABLE
[ 00:04.044 ][ 01.005 ] RUNNABLE - RUNNABLE
[ 00:05.000 ][ 05.000 ] Thread-1
[ 00:05.049 ][ 01.005 ] RUNNABLE - RUNNABLE
[ 00:06.000 ][ 03.000 ] Thread-0
[ 00:06.053 ][ 01.004 ] RUNNABLE - RUNNABLE
[ 00:07.057 ][ 01.004 ] RUNNABLE - RUNNABLE
```

### 문제 4-2. Thread.sleep() 메소드를 이용해 대기합니다.
- 메인 스레드 내에서 두개의 객체가 동작하는 시간 간격보다 짧게하여 인터럽트를 생성합니다.
- 인터럽트로 인해 어떠한 문제가 발생하였는가? 이유를 설명하세요. 
- (코드의 기본틀은 4-1과 동일합니다.)

실행 결과는 아래와 같습니다.
```
[ 00:01.005 ][ 01.005 ] TIMED_WAITING - TIMED_WAITING
[ 00:02.054 ][ 01.049 ] TIMED_WAITING - TIMED_WAITING
[ 00:03.057 ][ 01.003 ] TIMED_WAITING - TIMED_WAITING
[ 00:04.063 ][ 01.006 ] TIMED_WAITING - TIMED_WAITING
[ 00:05.067 ][ 01.004 ] TIMED_WAITING - TIMED_WAITING
[ 00:06.072 ][ 01.005 ] TIMED_WAITING - TIMED_WAITING
[ 00:07.076 ][ 01.004 ] TIMED_WAITING - TIMED_WAITING
[ 00:08.081 ][ 01.005 ] TIMED_WAITING - TIMED_WAITING
```

### 문제 4-3. 인터럽트로 인해 발생한 문제를 해결합니다.
- 수정하여 정해진 시간 간격에 맞도록 메시지가 출력되도록 수정합니다.
- 메시지 출력 시간 간격의 오차는 일부 발생할 수 있으나, 밀림 현상은 발생하지 않아야 합니다.
- 스레드 동작 상태를 확인합니다.
- (코드의 기본틀은 4-1과 동일합니다.)

실행 결과는 아래와 같습니다.
```
[ 00:01.002 ][ 01.002 ] TIMED_WAITING - TIMED_WAITING
[ 00:02.048 ][ 01.046 ] TIMED_WAITING - TIMED_WAITING
[ 00:03.004 ][ 03.004 ] Thread-0
[ 00:03.054 ][ 01.006 ] TIMED_WAITING - TIMED_WAITING
[ 00:04.059 ][ 01.005 ] TIMED_WAITING - TIMED_WAITING
[ 00:05.005 ][ 05.005 ] Thread-1
[ 00:05.065 ][ 01.006 ] TIMED_WAITING - TIMED_WAITING
[ 00:06.005 ][ 03.001 ] Thread-0
[ 00:06.069 ][ 01.004 ] TIMED_WAITING - TIMED_WAITING
[ 00:07.075 ][ 01.006 ] TIMED_WAITING - TIMED_WAITING
[ 00:08.079 ][ 01.004 ] TIMED_WAITING - TIMED_WAITING
[ 00:09.005 ][ 03.000 ] Thread-0
[ 00:09.085 ][ 01.006 ] TIMED_WAITING - TIMED_WAITING
[ 00:10.003 ][ 04.998 ] Thread-1
[ 00:10.091 ][ 01.006 ] TIMED_WAITING - TIMED_WAITING
```


> 인터럽트 발생 조건