import Stack.ArrayStack;

import java.lang.reflect.Array;

public class ArrayStackTest
{
    public static void main(String[] args) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        stack.setTrace(true);

        stack.push('A');
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push('B');
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push('C');
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push('D');
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push('E');
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push('F');
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.reverse();
        System.out.println("Reverse Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.push('G');
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.
        stack.pop();
        System.out.println("Stack : " + stack); // Stack을 출력해 봅니다.

    }
}
