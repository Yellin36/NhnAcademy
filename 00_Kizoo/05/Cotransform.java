public class Cotransform {
    public static void main(String[] args) {
        new G().test();
    }
}

class F {
    X m() { System.out.println("F"); return new X(); }
}

class G extends F {
    Y m() { System.out.println("G"); return new Y(); }

    public static void test() {
        F f = new G();
        f.m();
    }
}
class X {

}
class Y extends X{

}