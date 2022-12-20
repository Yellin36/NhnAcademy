package SimpleFBP.node;

import SimpleFBP.util.MyLogger;

import java.util.HashMap;
import java.util.NoSuchElementException;

public abstract class Node2 {
    private static HashMap<String, Node2> nodes = new HashMap<>();
    private static Integer count = 0;
    private final String id;
    private String name;
    private MyLogger logger;

    public Node2() {
        Node2.count++;
        //this.id = randomUUID().toString();
        this.id = String.format("%s@%08d", this.getClass().getSimpleName(), Node2.count);
        //this.name = "Node-" + count;
        this.name = this.getClass().getSimpleName();
        logger = new MyLogger(this.name);
        Node2.nodes.put(this.id, this);
    } // 기본 생성자
    public Node2(String name) {
        Node2.count++;
        this.id = String.format("%s@%08d", this.getClass().getSimpleName(), Node2.count);
        this.name = this.getClass().getSimpleName();
        logger = new MyLogger(this.name);
        Node2.nodes.put(this.id, this);
    } // 이름 지정 생성자
    // getter & setter

    public String getName() { return name; }
    public MyLogger getLogger() { return logger; }
    public static Integer getCount() { return count; }
    public String getId() { return id; }
    public void setName(String name) { this.name = name; }
    public void setLogger(MyLogger logger) { this.logger = logger; }
    public static Node2 getNode(String id) {
        if(!Node2.nodes.containsKey(id)) {
            throw new NoSuchElementException();
        }
        return Node2.nodes.get(id);
    }
}
