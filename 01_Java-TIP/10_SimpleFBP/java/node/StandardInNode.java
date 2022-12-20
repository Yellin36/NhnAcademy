package SimpleFBP.node;

import SimpleFBP.message.Message;

import java.util.Scanner;

public class StandardInNode extends InputNode {
    Scanner scanner;

    public StandardInNode() {
        super();
        this.scanner = new Scanner(System.in);
    }
    public StandardInNode(int count) {
        super(count);
    }
    @Override
    public void main() {
        Message message = new Message(scanner.nextLine());
        output(message);
        getLogger().info(getId() + ", " + getName());
    }
    @Override
    public void postprocess() {
        scanner.close();
    }
}
