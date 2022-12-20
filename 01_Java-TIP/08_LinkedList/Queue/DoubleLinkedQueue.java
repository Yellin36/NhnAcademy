package Queue;

public class DoubleLinkedQueue<E> implements Queue<E> {
    static class DoubleLinkedNode<E> {
        private E value;
        private DoubleLinkedNode<E> next, previous;

        public DoubleLinkedNode() {
            this.value = null;
            this.next = this.previous = null;
        }
        public DoubleLinkedNode(E value, DoubleLinkedNode<E> previous, DoubleLinkedNode<E> next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public E getValue() { return value; }
        public DoubleLinkedNode<E> getNext() { return next; }
        public DoubleLinkedNode<E> getPrevious() { return previous; }
        public void setNext(DoubleLinkedNode<E> node) { this.next = node; }
        public void setPrevious(DoubleLinkedNode<E> node) { this.previous = previous; }
    }
    private DoubleLinkedNode<E> head;
    private int count;

    public DoubleLinkedQueue() {
        this.head = new DoubleLinkedNode<>();
        count = 0;
    }
    @Override
    public boolean isEmpty() {
        return count == 0;
        //return this.head.getNext() == this.head;
    }

    @Override
    public void add(E element) {
        DoubleLinkedNode newNode = new DoubleLinkedNode<>(element,this.head, this.head.getNext());
        this.head.setNext(newNode);
        newNode.getNext().setPrevious(newNode);

        count++;
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

        this.head.getPrevious().setNext(this.head.getNext());
        this.head.getNext().setPrevious(this.head.getPrevious());
        this.head.setPrevious(null);
        this.head.setNext(null);
        count--;

        return element;
    }

    @Override
    public int size() {
        return count;
    }
}
