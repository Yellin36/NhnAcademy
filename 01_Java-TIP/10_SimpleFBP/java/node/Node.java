package SimpleFBP.node;



import SimpleFBP.util.Logger;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static java.util.UUID.randomUUID;

public abstract class Node {
    private static HashMap<String, Node> nodes = new HashMap<>();
    private static Integer count = 0;
    private final String id;
    private String name;
    private Logger logger;

    public Node() {
        Node.count++;
        //this.id = randomUUID().toString();
        this.id = String.format("%s@%08d", this.getClass().getSimpleName(), Node.count);
        //this.name = "Node-" + count;
        this.name = this.getClass().getSimpleName();
        logger = new Logger(this.name);
        Node.nodes.put(this.id, this);
    } // 기본 생성자
    public Node(String name) {
        Node.count++;
        this.id = String.format("%s@%08d", this.getClass().getSimpleName(), Node.count);
        this.name = this.getClass().getSimpleName();
        logger = new Logger(this.name);
        Node.nodes.put(this.id, this);
    } // 이름 지정 생성자
    // getter & setter

    public String getName() { return name; }
    public Logger getLogger() { return logger; }
    public static Integer getCount() { return count; }
    public String getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setLogger(Logger logger) { this.logger = logger; }
    public static Node getNode(String id) {
        if(!Node.nodes.containsKey(id)) {
            throw new NoSuchElementException();
        }
        return Node.nodes.get(id);
    }
}
