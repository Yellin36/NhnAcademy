import Stack.LinkedStack;
import Stack.Stack;

public class LinkedStackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<Integer>(); // Stack을 생성합니다.
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push(1); // Stack에 1을 넣습니다.
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push(2);
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push(3);
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push(4);
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push(5);
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push(6);
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push(7);
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
    }
}
