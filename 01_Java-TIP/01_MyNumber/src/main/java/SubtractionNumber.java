package practice1;

public class SubtractionNumber extends Operation{
    public SubtractionNumber(MyRationalNumber num1, MyRationalNumber num2) {
        super(num1, num2);
        int numerator = num1.getNumerator() * num2.getDenominator() - num2.getNumerator() * num1.getDenominator();
        int denominator = num1.getDenominator() * num2.getDenominator();

        this.result = new MyRationalNumber(numerator, denominator);
    }
}