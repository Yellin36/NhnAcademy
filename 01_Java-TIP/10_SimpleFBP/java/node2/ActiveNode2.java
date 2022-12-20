package SimpleFBP2.node;

import SimpleFBP2.message.Message;
import SimpleFBP2.message.PostMessage;

import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.LinkedList;
import java.util.Queue;

public abstract class ActiveNode2 extends Node2 implements Runnable {
    private final Thread thread;
    private boolean stopped;
    private long startTime;
    private long interval;
    
    //MessageServer-----
    private Lock messageQueueLocker;
    private Queue<Message> messageQueue;
    //------------------
    
    public ActiveNode2() {
        super();
        //MessageServer-----
        messageQueueLocker = new ReentrantLock();
        messageQueue = new LinkedList<>();
        //------------------
        thread = new Thread(this);
        interval = 1000;
    }
    public ActiveNode2(String name) {
        super(name);
        //MessageServer-----
        messageQueueLocker = new ReentrantLock();
        messageQueue = new LinkedList<>();
        //------------------
        thread = new Thread(this);
        interval = 1000;
    }

    public Thread getThread() { return thread; }
    public boolean isStopped() { return stopped; }
    public long getStartTime() { return startTime; }
    public long getInterval() { return interval; }
    public void setStopped(boolean stopped) { this.stopped = stopped; }
    public void setStartTime(long startTime) { this.startTime = startTime; }
    public void setInterval(long interval) { this.interval = interval; }

    public void start() {
        this.thread.start();
    }
    public void stop() {
        this.thread.interrupt();
    }
    public void preprocess() throws IOException {
        System.out.printf("%s(%s): 시작합니다.\n",getId(), getName());
    }
    protected synchronized void main() throws IOException { /*main : 상속해서 추가*/ }
    protected synchronized void idle() throws InterruptedException {
        Thread.sleep(this.interval);
    }
    protected void postprocess() { /*main : 상속해서 추가*/ }
    
    //MessageServer-----
    public synchronized void postMessage(PostMessage message) {
        this.messageQueueLocker.lock();
        this.messageQueue.add(message);
        this.messageQueueLocker.unlock();
    }

    protected void messageProcessing(Message message) {
        this.getLogger().info("Message received from : " + ((PostMessage)message).getSenderId());
    }
    //------------------
    
    @Override
    public void run() {
        this.stopped = false;

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
        this.postprocess();
    }
}
