package lambda;

import java.util.ArrayList;

public class TestStreamAPI {

//ㄱㅊㄷ
    public static void main(String[] args) {
        ArrayList<String> places = new ArrayList<>();
        places = addData(places);

        places.stream().filter(p->p.endsWith("DO"))
                .forEach(p-> System.out.println(p.toUpperCase()));

        places.stream().filter(p->p.endsWith("do"))
                .forEach(p-> System.out.println(p.toUpperCase()));
    }

    public static ArrayList<String> addData(ArrayList<String> list) {
        list.add("GYEONGGI-DO");
        list.add("GANGWON-DO");
        list.add("CHUNGCHEONGNAM-DO");
        list.add("CHUNGCHEONGBUK-DO");
        list.add("JEOLLANAM-DO");
        list.add("JEOLLABUK-DO");
        list.add("GYEONGSANGNAM-DO");
        list.add("GYEONGSANGBUK-DO");
        list.add("JEJU-DO");
        for (int i = 0; i < 10; i++) {
            list.add("special city" + i + "-si");
        }
        for (int i = 0; i < 10; i++) {
            list.add("SOME city" + i + "-do");
        }
        return list;
    }
}
