package Stack;

public interface Stack<E> {
    public boolean isEmpty();
    public void push(E element);
    public E pop();
    public E peek();
    public int size();
    public void reverse();

    /** 위에서 두번재 삭제 및 값 리턴 **/
    public E penultimate();
    public E popPenultimate();
    public E bottom();
    public E popBottom();
}
