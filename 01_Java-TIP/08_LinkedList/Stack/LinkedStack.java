package Stack;

public class LinkedStack<E> implements Stack<E> {
    static class LinkedNode<E> {
        private E value;
        private LinkedNode<E> next;

        public LinkedNode(E value, LinkedNode<E> next) {
            this.value = value;
            this.next = next;
        }

        public E getValue() { return value; }
        public LinkedNode<E> getNext() { return next; }
    }
    LinkedNode<E> head;
    int count;

    public LinkedStack() {
        this.head = null;
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0 );
    }

    @Override
    public void push(E element) {
        this.head = new LinkedNode<E>(element, head);
        count++;
    }

    @Override
    public E pop() {
        if(isEmpty()) throw new java.util.NoSuchElementException("No value");

        E value = this.head.getValue();
        if(count == 1) {
            this.head = null;
        }
        else this.head = this.head.getNext();
        count--;

        return value;
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new java.util.NoSuchElementException("No value");
        return head.getValue();
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void reverse() {

    }

    @Override
    public E penultimate() {
        return null;
    }

    @Override
    public E popPenultimate() {
        return null;
    }

    @Override
    public E bottom() {
        return null;
    }

    @Override
    public E popBottom() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        LinkedNode<E> element = this.head;

        while(element != null) {
            line.append(element.getValue() + " ");
            element = element.getNext();
        }
        return line.toString();
    }
}
