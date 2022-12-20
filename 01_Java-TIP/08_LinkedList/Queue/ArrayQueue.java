package Queue;

public class ArrayQueue<E> implements Queue<E> {
    final int DEFAULT_SIZE = 100;
    private E[] elements;
    private int head, tail;
    private int defaultSize;

    public ArrayQueue() {
        this.elements = (E[]) new Object[DEFAULT_SIZE];
        this.defaultSize = DEFAULT_SIZE;
        this.head = this.tail = 0;
    }
    public ArrayQueue(int size) {
        this.elements = (E[]) new Object[size];
        this.defaultSize = size;
        this.head = this.tail = 0;
    }
    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override
    public void add(E element) {
        this.elements[tail++] = element;
    }

    @Override
    public E element() {
        if(isEmpty()) throw new java.util.NoSuchElementException("No value");
        return elements[head];
    }

    @Override
    public E remove() {
        if(isEmpty()) throw new java.util.NoSuchElementException("No value");

        return elements[head++];
    }

    @Override
    public int size() {
        return (this.defaultSize + this.tail - this.head) % this.defaultSize;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < tail; i++) {
            if(i < head) line.append("  ");
            else line.append(elements[i] + " ");
        }
        return line.toString();
    }
}
