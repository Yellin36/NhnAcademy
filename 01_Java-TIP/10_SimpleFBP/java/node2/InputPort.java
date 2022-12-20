package SimpleFBP2.node;

import SimpleFBP2.message.Message;
import SimpleFBP2.node.Node2;
import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InputPort {
    Node2 node;
    Queue<Message> messageQueue;
   Lock locker= new ReentrantLock();
    public InputPort(Node2 node) {
        this.node = node;
        this.messageQueue = new LinkedList<>();
    }
    public void put(Message message) {
        locker.lock();
        this.messageQueue.add(message);
        locker.unlock();
    }

    public boolean hasMessage() {
        return !this.messageQueue.isEmpty();
    }
    public  Message get() {
        Message message;
        this.locker.lock();
        message = this.messageQueue.poll();
        this.locker.unlock();

        return message;
    }
    public void remove() {
        locker.lock();
        this.messageQueue.poll();
        locker.unlock();
    }
}
