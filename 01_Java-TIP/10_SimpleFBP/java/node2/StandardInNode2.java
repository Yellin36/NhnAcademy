package SimpleFBP2.node;

import SimpleFBP2.message.Message;

import java.util.Scanner;

public class StandardInNode2 extends InputNode2 {
    Scanner scanner;
    public StandardInNode2(int count) {
        super(count);
        this.scanner = new Scanner(System.in);
    }
    @Override
    public synchronized void main() {
        System.out.print("In: ");

        Message m;
        m = new Message(scanner.nextLine());

        this.output(m);
    }
}
