package SimpleFBP.node;

import SimpleFBP.message.Message;
import SimpleFBP.wire.Wire;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ActiveNode extends Node implements Runnable {
    private final Thread thread;
    private boolean stopped;
    private long startTime;
    private long interval;
    private final Queue<Message> messageQueue;
    private final Lock locker;

    public ActiveNode() {
        super();
        thread = new Thread(this);
        interval = 1000;
        this.messageQueue = new LinkedList<>();
        this.locker = new ReentrantLock();
    }
    public ActiveNode(String name) {
        super(name);
        thread = new Thread(this);
        interval = 1000;
        this.messageQueue = new LinkedList<>();
        this.locker = new ReentrantLock();
    }

    public Thread getThread() { return thread; }
    public boolean isStopped() { return stopped; }
    public long getStartTime() { return startTime; }
    public long getInterval() { return interval; }
    public void setStopped(boolean stopped) { this.stopped = stopped; }
    public void setStartTime(long startTime) { this.startTime = startTime; }
    public void setInterval(long interval) { this.interval = interval; }

    public void start() {
        thread.start();
    }
    public void stop() {
        thread.interrupt();
    }
    public void preprocess() throws IOException { }
    protected synchronized void main() throws IOException {
        //main
        getLogger().info(getId() + ", " + getName());
    }
    protected synchronized void idle() throws InterruptedException {
        //idle
        Thread.sleep(this.interval - (System.currentTimeMillis() - this.startTime) % this.interval);
    }
    protected void postprocess() { }
    @Override
    public void run() {
        this.startTime = System.currentTimeMillis();
        try {
            this.preprocess();
        } catch(IOException e) {
            return;
        }
        while(!this.stopped) {
            try {
                this.main();
                this.idle();
            } catch (InterruptedException e) {
                this.getLogger().info(e + "");
                this.stopped = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //terminated
        this.postprocess();
    }
    public Message getMessage() {
        return new Message();
    }
    protected void messageProcessing() {
        if(this.messageQueue.isEmpty()) this.messageProcessing(this.getMessage());
    }
    protected void messageProcessing(Message message) {
        //this.getLogger().info("Message received from: " + ((PostMessage)message).getSenderId());
    }
    public static void wiring(InputNode inNode, int outPort, OutputNode outNode, int inPort) {
        Wire wire = new Wire();
        inNode.getOutputSocket(outPort).plug(wire);
        outNode.getInputSocket(inPort).plug(wire);
    }
}
