package Stack;

import java.util.ArrayList;

public class ArrayStack <E> implements Stack<E> {
    final int DEFAULT_SIZE = 100;
    private E[] elements;
    private int top;

    boolean trace;
    public void setTrace(boolean trace) { this.trace = trace; }
    // warning : 문제가 있을지도...?(언제 터질지 모르는 폭탄)
    // error : 문제 발생
    // fatal : 심각한 문제

    public ArrayStack() {
        this.elements = (E[])new Object[this.DEFAULT_SIZE];
        this.top = -1;
    }
    public ArrayStack(int size) {
        this.elements = (E[])new Object[size]; //모든 레퍼런스 타입이 Object이기 때문, 모두 레퍼런스만을 가지기때문에 어떤타입이든 사이즈가 같기 때문
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return (top < 0);
    }

    @Override
    public void push(E element) {
    elements[++top] = element;
    }

    @Override
    public E pop() {
        if(isEmpty()) throw new java.util.NoSuchElementException("No value");
        return elements[top--];
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new java.util.NoSuchElementException("No value");
        return elements[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public void reverse() {
        ArrayStack<E> newArray = new ArrayStack<E>(this.elements.length + 1);

        while (!this.isEmpty()) {
            newArray.push(this.pop());
        }
        this.elements = newArray.elements;
        this.top = newArray.top;

        newArray = null;
    }

    @Override
    public E penultimate() {
        E element1 = pop();
        E element2 = peek();

        push(element1);

        return element2;
    }

    @Override
    public E popPenultimate() {
        E element1 = pop();
        E element2 = pop();

        push(element1);

        return element2;
    }

    @Override
    public E bottom() {
        reverse();
        E element = peek();
        reverse();

        return element;
    }

    @Override
    public E popBottom() {
        reverse();
        E element = pop();
        reverse();

        return element;
    }

    //자바의 garbage collector는 변수에 레퍼런스가 없을 때 리소스를 해제한다.
    //시스템 부하를 막기위해 pop한 기존의 자리에 null을 입력하는 것이 좋다.
    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();

        for (int i = 0; i <= top; i++) {
            line.append(elements[i] + " ");
        }

        return line.toString();
    }

}
