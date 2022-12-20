package lambda;

import java.util.function.Function;

public class TestFunction {
    public static class Square implements Function<Integer, Integer> {
        public Integer apply(Integer t) {
            return t * t;
        }
    }
    public static void main(String[] args) {
        Square square = new Square();
        Function<Integer, Integer> square2 = (x) -> x * x;

        System.out.println("Class : 2 * 2 = " + square.apply(2));
        System.out.println("Lambda : 2 * 2 = " + square2.apply(2));
    }
}
