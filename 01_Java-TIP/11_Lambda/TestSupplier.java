package lambda;

import java.util.function.Supplier;

public class TestSupplier {
    public static class Fibonacci implements Supplier<Integer> {
        int[] fibs = {0, 1};
        @Override
        public Integer get() {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        }
    }
    public static void main(String[] args) {
        int[] fibs = {0, 1};
        Supplier<Integer> fibonacci2 = () -> {
            int result = fibs[1];
            int fib3 = fibs[0] + fibs[1];
            fibs[0] = fibs[1];
            fibs[1] = fib3;
            return result;
        };
        for(int i = 0 ; i < 10 ; i++) {
            System.out.print(fibonacci2.get() + " ");
        }
        System.out.println("");
    }
}
