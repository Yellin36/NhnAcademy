import practice2.*;

import java.util.ArrayList;

public class AnimalTest {
    public static void main(String[] args) {
        ArrayList<String> fly = new ArrayList<>(), swim = new ArrayList<>();
        Animal animals[] = {new Bat(), new Hawk(), new Ostrich(), new Penguin(), new Tiger(), new Whale()};

        for (Animal animal : animals) {
            if (animal instanceof Flyable) fly.add(animal.getClass().getSimpleName());
            if (animal instanceof Swimable) swim.add(animal.getClass().getSimpleName());
        }
        System.out.println("Flyable Animal : " + fly);
        System.out.println("Swimable Animal : " + swim);

    }
    /* stream
     * : Arrays는 stream(연속적인 데이터를 접근할때, 무한 어레이..?)을 사용가능하다: ~할때까지  -> 필터, 맵 기능을 사용할 수 있다.
     * -filter + 람다식을 사용하여 필터링하여 값을 가져오는 방법 : 연속적으로 들어오는 값을 필터링함
     * -map
     * reduce
     */

    // isAnnotationPresent("__") : __한 어노테이션을 가지고 있는지

    /* Answer
     * List<Animal> animals = Arrays.asList(new Bat(), new ...);
     * System.out.println("Flyable : " + Arrays.toString(animals.stream().filter(x->x instanceof Flyable).toArray()));
     * System.out.println("Swimable : " + Arrays.toString(animals.stream().filter(x->x.getClass().isAnnotationPresent(Swimable.class)).toArray()));
     */
}
