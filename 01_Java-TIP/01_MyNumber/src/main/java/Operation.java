package practice1;

public class Operation {
    protected MyRationalNumber num1, num2, result;

    public Operation(MyNaturalNumber rNum1, MyNaturalNumber rNum2) {
        num1 = rNum1;
        num2 = rNum2;
    }
    public Operation(MyInteger rNum1, MyInteger rNum2) {
        num1 = rNum1;
        num2 = rNum2;
    }
    public Operation(MyRationalNumber rNum1, MyRationalNumber rNum2) {
        num1 = rNum1;
        num2 = rNum2;
    }
    public String toString() {
        return result.toString();
    }
}


