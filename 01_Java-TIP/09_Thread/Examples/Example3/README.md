## 문제 3. 데몬을 만들어 봅니다.
### 문제 3-1. 스레드 안에서 스레드를 생성해 봅니다.
- Task에서 두개의 주기를 받아 스레드 내에서 스레드를 추가로 실행합니다.
- 결과를 확인합니다. 동작에 대해 설명하세요

```java
public class Example3_1 { 
    static class Task implements Thread {
        ...
    }
    public static void main(String [] args) throws InterruptedException {
        Task task = new Task(2000, 1000);
        task.start();
        Thread.sleep(10000);
        task.stop();
        task.join();
    }
}
```

### 문제 3-2. 스레드 내부에서 생성된 스레드가 종료되도록 수정합니다.
- 3-1에서 발생한 문제를 해결합니다.
- 결과를 확인합니다. 동작에 대해 설명하세요.
  (기본 코드는 3-1과 동일합니다)

### 문제 3-3. 스레드 내부에서 생성된 스레드를 데몬으로 생성해 봅니다.
- Task에서 두개의 주기를 받아 스레드 내에서 스레드를 추가로 실행합니다.
- 결과를 확인합니다. 동작에 대해 설명하세요.
  (기본 코드는 3-1과 동일합니다.)