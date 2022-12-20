package SimpleFBP.wire;

import SimpleFBP.node.Node;
import SimpleFBP.util.Logger;

public class Socket {
    private static int count = 0;
    private String id;
    protected Node node;
    private Logger logger;
    public Socket(Node node) {
        this.id = String.format("%s@%08d", this.getClass().getSimpleName(), ++Socket.count);
        this.node = node;
    }
    public String getId() {
        return this.id;
    }
    public Logger getLogger() {
        return this.logger;
    }
}
