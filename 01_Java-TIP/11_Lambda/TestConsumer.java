package lambda;

import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestConsumer {
    public static void main(String[] args) {
        Random random = new Random();
        Consumer<Integer> positivePrint = (x)->{if (x >= 0) System.out.print(x + " ");};
        for(int i = 0 ; i < 10 ; i++) {
            positivePrint.accept(random.nextInt());
        }
        System.out.println();
        Stream<Integer> positiveRandomStream = Stream.generate(random::nextInt).filter(x-> x>=0).limit(10);
        positiveRandomStream.forEach(x-> System.out.print(x+" "));
    }
}
