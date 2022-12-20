import java.util.*;

public class RationalNumberTest {
    static class RationalNumber {
        private int numerator, denominator;
        public RationalNumber(int numerator, int denominator)  {
            if(0==denominator) throw new ArithmeticException("분모는 0이 될 수 없음");
            this.numerator = numerator;
            this.denominator = denominator;
            if(denominator < 0) {
                this.numerator = -numerator;
                this.denominator = -denominator;
            }
            //yak();
        }
        public int getDenominator() { yak(); return denominator; }
        public int getNumerator() { yak(); return numerator; }
        public String toString() { return String.valueOf(getNumerator()) + '/' + String.valueOf( denominator ); }

        private void yak() {
            int g = gdc( Math.abs(numerator), Math.abs(denominator) );
            { numerator = numerator / g; denominator = denominator / g; }
        }
        //Hash
        @Override
        public int hashCode() {
            return Objects.hash(numerator, denominator);
        }
        @Override
        public boolean equals(Object obj) {
            if(obj instanceof RationalNumber) {
                RationalNumber tmp = (RationalNumber)obj;
                if(this.numerator == tmp.numerator && this.denominator == tmp.denominator) {
                    return true;
                }
            }
            return false;
        }

        private int gdc(int x, int y) { return 0 == y ? x : gdc(y, x % y); }
    }


    public static void main(String[] args) {
        Set s = new HashSet();
        Set s2 = new TreeSet();

        int a = 1;
        Integer b = new Integer(1);
        RationalNumber twos[] = { new RationalNumber( 2, 1 ), new RationalNumber( 4, 2 ), new RationalNumber( -2, -1 ) };
        Collections.addAll(s, twos);
        System.out.println(s);
        System.out.println(new RationalNumber(4, 8));
//        Collections.addAll(s2, twos);
//        System.out.println(s2);
    }
}
