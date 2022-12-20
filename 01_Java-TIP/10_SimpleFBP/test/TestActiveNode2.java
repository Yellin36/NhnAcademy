import SimpleFBP.node.ActiveNode2;

public class TestActiveNode2 extends ActiveNode2 {
    public void preprocess() {
        this.getLogger().info("preprocess!");
    }
    public void main() {
        this.getLogger().info("Hello!");
    }
    public void postprocess() { this.getLogger().info("postprocess!"); }

    public static void main(String[] args) throws InterruptedException {
        TestActiveNode2 node = new TestActiveNode2();

        System.out.println(node.getClass().hashCode());
        node.setInterval(1000);
        node.start();

        Thread.sleep(10000);
        node.stop();
    }
}
