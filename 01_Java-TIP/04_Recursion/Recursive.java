package Recursive;

public class Recursive {
    public static int Sigma(int n) {
        return (n > 1) ?  n + Sigma(n - 1) : 1;
    }
    public static int Factorial(int n) {
        return (n > 1) ? n * Factorial(n - 1) : 1;
    }
    /* BigInteger 을 사용해보자 : recursion과 iteration은 차이가 크지않지만 recursion이 느린건 확실하다
     *
     * public static BigInteger Factorial(BigInteger n) {
     *  if(n.compareTo(new BigInteger("1") <= 0) {
     *      return new BigInteger("1");
     *  }
     *  return n.multiply(Factorial.recursion(n.subtract(new BigInteger("1"))));
     * }
     */
    public static int Fibonacci(int n) {
        return (n > 1) ? Fibonacci(n - 1) + Fibonacci(n - 2) : n;
    }

    public static void main(String[] args) {
        System.out.println("Sigma 5 = " + Sigma(5));

        System.out.println("Factorial 5 = " + Factorial(5));

        for (int i = 0; i < 10; i++) {
            System.out.println("Fibonacci " + i + " = " + Fibonacci(i));
        }
    }


}
