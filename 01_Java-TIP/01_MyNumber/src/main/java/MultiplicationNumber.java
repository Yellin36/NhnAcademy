package practice1;

public class MultiplicationNumber extends Operation{
    public MultiplicationNumber(MyRationalNumber num1, MyRationalNumber num2) {
        super(num1, num2);
        int numerator = num1.getNumerator() * num2.getNumerator();
        int denominator = num1.getDenominator() * num2.getDenominator();

        this.result = new MyRationalNumber(numerator, denominator);
    }
}
