package practice1;

public class MyNaturalNumber extends MyInteger {
    public MyNaturalNumber(int naturalNumber) {
        super(naturalNumber);
        try {
            if(naturalNumber <= 0) {
                throw new Exception("0, 음의 정수는 자연수가 될 수 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
