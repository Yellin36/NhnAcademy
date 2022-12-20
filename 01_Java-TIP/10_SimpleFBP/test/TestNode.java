import SimpleFBP.node.Node;

public class TestNode extends Node {
    public static void main(String[] args) {
        Node[] nodes = new Node[10];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TestNode();
        }
        for (Node node : nodes) {
            System.out.println(node.getId() + ", " + node.getName());
            node.getLogger().info(node.getId() + ", " + node.getName());
        }
    }
}
