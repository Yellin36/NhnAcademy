package lambda;

import java.util.function.Predicate;

public class TestPredicate {
    public static class IsNegative implements Predicate<Integer> {

        @Override
        public boolean test(Integer integer) {
            return integer < 0;
        }

    }
    public static void main(String[] args) {
        IsNegative isNegative = new IsNegative();
        Predicate<Integer> isNegative2 = (x)->x<0;
        System.out.println("Class : 1 = " + isNegative.test(1) + ", -1 = " + isNegative.test(-1));
        System.out.println("Lambda : 1 = " + isNegative2.test(1) + ", -1 = " + isNegative2.test(-1));
    }
}
