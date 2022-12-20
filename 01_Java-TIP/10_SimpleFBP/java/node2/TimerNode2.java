package SimpleFBP2.node;

import SimpleFBP2.message.Message;

//Clock : 일정 주기로 신호를 생성한다. 신호가 생성될때 마다 피보나치 수열의 다음 수가 계산되어 출력된다.
public class TimerNode2 extends InputNode2 {
    public TimerNode2(long interval) {
        super(1);
        setInterval(interval);
    }
    public synchronized void main() {
        //System.out.println("\t" + getName() + ": Signal.");
        output(new Message(new Double(0.0)));
    }
}
