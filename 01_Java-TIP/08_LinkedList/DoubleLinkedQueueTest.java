import Queue.*;

public class DoubleLinkedQueueTest {
    public static void main(String[] args) {
        Queue<Integer> q = new DoubleLinkedQueue<Integer>();
        q.add(1);
        System.out.println("Queue : " + q);
        q.add(2);
        System.out.println("Queue : " + q);
        q.add(3);
        System.out.println("Queue : " + q);
        q.remove();
        System.out.println("Queue : " + q);
        q.remove();
        System.out.println("Queue : " + q);
        q.add(4);
        System.out.println("Queue : " + q);
        q.add(5);
        System.out.println("Queue : " + q);
        q.add(6);
        System.out.println("Queue : " + q);
        q.remove();
        System.out.println("Queue : " + q);
        q.add(7);
        System.out.println("Queue : " + q);
        q.remove();
        System.out.println("Queue : " + q);
        q.remove();
        System.out.println("Queue : " + q);
        q.remove();
    }
}
