package practice1;

public class MyRationalNumber extends MyNumber implements Comparable<MyRationalNumber> {
    protected int numerator;
    protected int denominator;

    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    //1. 디폴트 값 0/1
    //2. 정수를 받는 경우
    //3. MyRationNumber을 받는 경우 : @Notnull사용
    //  this.numerator = number.getNumerator();
    //  this.denominator = number.getDenominator();
    public MyRationalNumber(int numerator, int denominator) {
        try {
            if (denominator == 0) {
                throw new Exception("분모는 0이 될 수 없습니다.");
                //throw new IllegalArgumentException(""); 을 사용하여 try-catch문 생략
            }
            int gcd = getGcd(Math.abs(numerator), Math.abs(denominator));

            if(denominator < 0) {
                numerator *= -1;
                denominator *= -1;
            }
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public MyRationalNumber(double rationalNumber) {
        int numerator;
        int denominator = 1;

        while(rationalNumber * denominator % 1 != 0) {
            denominator *= 10;
        }
        numerator = (int)(rationalNumber * denominator);

        int gcd = getGcd(Math.abs(numerator), Math.abs(denominator));

        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }
    public int getGcd(int num1, int num2) {
        return (num2 == 0) ? num1 : getGcd(num2, num1 % num2);
    }
    //사칙연산
    //1. 덧셈, 뺄셈, 곱셈, 나눗셈 : 타입이 맞는가

    /* public MyRationalNumber plus(@NotNull MyNumber number){ //연산은 MyNumber로 받지만 결과는 해당 타입으로 출력
    *   if(!(number instanceof MyRationalNumber)) {
    *       throw new ILLegalArgumentException("유리수가 아님);
    *   }
    *   return new MyRationNumber( 덧셈연산들);
    * } */

    //2. 나눗셈(0으로 나눈 경우의 Exception)

    public String toString() {  //내부적으로 필요할때 자동으로 호출됨.
        return (numerator == 0 || denominator == 1) ? numerator + "" : "(" + numerator +"/"+denominator + ")";
    }
    // create 는 무엇인가?!?!나중에 배우는걸루
    /* public static mrn create(String value) {
     *  if(value.contain("/"0 {
     *      String [] fields = value.split("/");
     */
    @Override
    public int compareTo(MyRationalNumber o) {
        return 0;
    }
}
