import practice1.*;

public class NumberTest {
        public static void main(String [] args) {
        String num1, num2;

        MyRationalNumber n1 = new MyRationalNumber(0.56);
        MyRationalNumber n2 = new MyRationalNumber(4, 5);
        MyInteger n3 = new MyInteger(-34);
        MyInteger n4 = new MyInteger(0);
        MyNaturalNumber n5 = new MyNaturalNumber(15);
        MyNaturalNumber n6 = new MyNaturalNumber(92);

        System.out.println("덧셈");
        System.out.println(n1 + "+" + n2 + " = " + new AdditionNumber(n1,n2).toString());
        System.out.println(n3 + "+" + n4 + " = " + new AdditionNumber(n3,n4).toString());
        System.out.println(n5 + "+" + n6 + " = " + new AdditionNumber(n5,n6).toString());
        System.out.println("뺄셈");
        System.out.println(n1 + "-" + n2 + " = " + new SubtractionNumber(n1,n2).toString());
        System.out.println(n3 + "-" + n4 + " = " + new SubtractionNumber(n3,n4).toString());
        System.out.println(n5 + "-" + n6 + " = " + new SubtractionNumber(n5,n6).toString());
        System.out.println("곱셈");
        System.out.println(n1 + "*" + n2 + " = " + new MultiplicationNumber(n1,n2).toString());
        System.out.println(n3 + "*" + n4 + " = " + new MultiplicationNumber(n3,n4).toString());
        System.out.println(n5 + "*" + n6 + " = " + new MultiplicationNumber(n5,n6).toString());
        System.out.println("나눗셈");
        System.out.println(n1 + "/" + n2 + " = " + new DivisionNumber(n1,n2).toString());
        System.out.println(n3 + "/" + n4 + " = " + new DivisionNumber(n3,n4).toString());
        System.out.println(n5 + "/" + n6 + " = " + new DivisionNumber(n5,n6).toString());


        }
}
