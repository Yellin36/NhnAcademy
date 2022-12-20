package SimpleFBP2.server;

import SimpleFBP2.message.PostMessage;
import SimpleFBP2.node.ActiveNode2;
import SimpleFBP2.node.InputOutputNode2;
import SimpleFBP2.node.InputPort;
import SimpleFBP2.node.Node2;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageServer extends ActiveNode2 {
    private static final MessageServer globalServer = new MessageServer();
    private final Map<String, ActiveNode2> nodes;
    private final Queue<PostMessage> postMessageQueue;
    private final Lock lock;

    public MessageServer() {
        super();
        this.nodes = new HashMap<>();
        this.postMessageQueue = new LinkedList<>();
        this.lock = new ReentrantLock();
    }
    public void connect(ActiveNode2 node) {
        if(this.nodes.containsKey(node.getId())) {
            throw new NoSuchElementException();
        }
        this.nodes.put(node.getId(), node);
    }
    public void disconnect(ActiveNode2 node) {
        if(this.nodes.containsKey(node.getId())) {
            throw new NoSuchElementException();
        }
        this.nodes.remove(node.getId());
    }
    public void postMessage(PostMessage message) {
        this.lock.lock();
        this.postMessageQueue.add(message);
        this.lock.unlock();
    }
    public void main() throws IOException {
        super.main();
        if(!this.postMessageQueue.isEmpty()) {
            this.lock.lock();
            PostMessage message = this.postMessageQueue.poll();
            this.lock.unlock();
            try {
                Node2 node = Node2.getNode(message.getReceiverId());
                if(node instanceof ActiveNode2) {
                    ((ActiveNode2)node).postMessage(message);
                }
                if(this.nodes.containsKey(message.getReceiverId())) {

                }
            } catch (NullPointerException e) {
                this.getLogger().error(""+e);
            }
        }
    }
    public static MessageServer getGlobalServer() {
        return MessageServer.globalServer;
    }
}
