package practice1;

public class MyInteger extends MyRationalNumber {
    //1. 정수를 받는 경우와 MyInteger을 받는 경우 :MyRationNumber의 생성자2번 사용하기
    public MyInteger(int integer) {
        super(integer, 1);
    }
    public MyInteger(int numerator, int denominator) {
        super(numerator,1);
        try {
            if(denominator != 1) {
                throw new Exception("분수는 정수가 될 수 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //int getValue() { return this.getNumerator(); } : 보는 사람의 이해를 위함/그냥 정수를 가져오기위한것
    //사칙연산의 예외처리(타입비교와 0으로 나누는 경우) 조심

}
