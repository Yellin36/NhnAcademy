package Queue;

public class LinkedQueue<E> implements Queue<E> {
    static class LinkedNode<E> {
        private E value;
        private LinkedNode<E> next;

        public LinkedNode(E value, LinkedNode<E> next) {
            this.value = value;
            this.next = next;
        }

        public E getValue() { return value; }
        public LinkedNode<E> getNext() { return next; }
        public void setNext(LinkedNode<E> node) {
            this.next = node;
        }
    }
    private LinkedNode<E> head, tail;
    private int count;

    public LinkedQueue() {
        this.head = this.tail = null;
        count = 0;
    }
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void add(E element) {
        if(isEmpty()) {
            this.head = new LinkedNode<E>(element, null);
            this.tail = head;
        }
        else {
            this.tail.setNext(new LinkedNode<E>(element, null));
            this.tail = this.tail.getNext();
        }
        count ++;
    }

    @Override
    public E element() {
        if(isEmpty()) throw new java.util.NoSuchElementException("No value");
        return this.head.getValue();
    }

    @Override
    public E remove() {
        if(isEmpty()) throw new java.util.NoSuchElementException("No value");

        E element = this.head.getValue();
        if(count-- == 1) {
            head = tail = null;
        }
        else {
            LinkedNode tmp = this.head.getNext();
            this.head.setNext(null);  //연결고리를 끊어서 가비지의 밥으로 만든다
            this.head = tmp;
        }

        return element;
    }

    @Override
    public int size() {
        return count;
    }
    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        for (LinkedNode i = this.head; i != null; i = i.getNext()) {
            line.append(i.getValue() + " ");
        }
        return line.toString();
    }

}
