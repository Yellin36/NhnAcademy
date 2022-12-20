package Queue;

public interface Queue <E> {
    public boolean isEmpty();
    public void add(E element);
    public E element();
    public E remove();
    public int size();
}
