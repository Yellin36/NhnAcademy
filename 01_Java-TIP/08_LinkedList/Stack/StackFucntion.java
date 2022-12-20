package Stack;

public class StackFucntion {
    //3번
    public static <E> Stack<E> reversed(Stack<E> stack) {
        Stack<E> newStack = new ArrayStack<E>();

        while(!stack.isEmpty()) {
            newStack.push(stack.pop());
        }
        return newStack;
    }
    //4번
    public static <E> Stack<E> reversed2(Stack<E> stack) {
        Stack<E> newStack = new ArrayStack<E>();
        Stack<E> tmpStack = new ArrayStack<E>();
        E value;
        while(!stack.isEmpty()) {
            value = stack.pop();
            newStack.push(value);
            tmpStack.push(value);
        }
        while(!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
        return newStack;
    }
    //5번
    public static <E> void reverse(Stack<E> stack) {
        Stack<E> tmpStack = new ArrayStack<E>();
        while(!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        while(!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }
    }
    //6번
    public static <E> E penultimate(Stack<E> stack) {
        E tmp1 = stack.pop();
        E tmp2 = stack.peek();

        stack.push(tmp1);

        return tmp2;
    }
    //7번
    public static <E> E popPenultimate(Stack<E> stack) {
        E tmp1 = stack.pop();
        E tmp2 = stack.pop();

        stack.push(tmp1);

        return tmp2;
    }
    //8번
    public static <E> E bottom(Stack<E> stack) {
        return reversed2(stack).peek();
    }
    //9번
    public static <E> E popBottom(Stack<E> stack) {
        reverse(stack);
        E result = stack.pop();
        reverse(stack);

        return result;
    }
}
