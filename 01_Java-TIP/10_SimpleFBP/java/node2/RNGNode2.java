package SimpleFBP2.node;

import SimpleFBP2.message.Message;

import java.util.InputMismatchException;

public class RNGNode2 extends StandardInNode2 {
    public RNGNode2(long interval) {
        super(1);
        setInterval(interval);
    }
    @Override
    public synchronized void main() {
        //System.out.print(getId() + " In : ");

        Message m;
        try {
            m = new Message(scanner.nextInt());

            this.output(m);
        } catch(InputMismatchException e) {
            System.out.println("숫자로 입력해주십시오.");
            throw e;
        }
    }
}
