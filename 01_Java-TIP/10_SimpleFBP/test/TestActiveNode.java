import SimpleFBP.node.ActiveNode;

public class TestActiveNode extends ActiveNode {
    public void preprocess() {
        this.getLogger().info("preprocess!");
    }
    public void main() {
        this.getLogger().info("Hello!");
    }
    public static void main(String[] args) {
        TestActiveNode node = new TestActiveNode();

        System.out.println(node.getClass().hashCode());
        node.setInterval(1000);
        node.start();

        while(true) {

        }
    }
}
