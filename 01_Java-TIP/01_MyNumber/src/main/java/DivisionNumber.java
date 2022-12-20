package practice1;

public class DivisionNumber extends Operation{
    public DivisionNumber(MyRationalNumber num1, MyRationalNumber num2) {
        super(num1, num2);
        int numerator = num1.getNumerator() * num2.getDenominator();
        int denominator =  num2.getNumerator() * num1.getDenominator();

        this.result = new MyRationalNumber(numerator, denominator);
    }
}