public class Example1 {
    public static void main(String[] args) {
        String [] words = {"Hello", "world"};
        StringBuilder line = new StringBuilder();

        for(String word : words) {
            line.append(word + " ");
        }

        System.out.println(line.toString());

        System.out.println("END");
    }
    //1. 클래스
    // - 분자/분모 만들기, 분모가 0일때의 예외처리, notnull과 같은 어노테이션
    //2. 추상 클래스와 인터페이스
    // - 상속관계가 존재할때
    // - 기능적인 확장
    //
}

