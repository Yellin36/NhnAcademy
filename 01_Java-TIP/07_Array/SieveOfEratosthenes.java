import java.util.BitSet;
import java.util.Vector;

public class SieveOfEratosthenes {
    public static void Eratos(int n, Vector<String> list) {
        BitSet check = new BitSet();

        check.set(0);
        check.set(1);

        for (int i = 2; i * i <= n; i++) {
            if(check.get(i)) continue;

            for (int j = i*i; j <= n; j += i) {
                check.set(j);
            }
        }
        for (int i = 0; i <= n; i++) {
            if(check.get(i)) list.add("[  x  ]");
            else list.add(String.format("[%5d]", i));
        }
    }
    public static Vector<Integer> getPrimes(int n) {
        BitSet check = new BitSet();
        Vector<Integer> list = new Vector<>();

        for (int i = 2; i * i <= n; i++) {
            if(check.get(i)) continue;

            list.add(i);
            for (int j = i*i; j <= n; j += i) {
                check.set(j);
            }
        }
        return list;
    }
    public static String factorization(int num) {
        Vector<Integer> primes = getPrimes(num);
        int[] count = new int[primes.size() + 3];
        StringBuilder line = new StringBuilder();

        int i=0, prime;
        while(num != 1 && (prime = primes.get(i)) <= num) {
            if(num % prime == 0) {
                count[prime]++;
                num /= prime;
            }
            else {
                i++;
            }
        }
        for (int j = 0; j < count.length; j++) {
            if(count[j] > 0) line.append(j + "*" + count[j] + " + ");
        }
        return line.toString();
    }

    public static void EratosTest(int n) {
        Vector<String> list = new Vector<>();
        long beforeTime, afterTime, secDiffTime;

        beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        Eratos(n, list);
        afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("Answer2:  " + secDiffTime + "ms 걸림.");

        //printVector(list);
    }
    public static void printVector(Vector<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if(i % 10 == 0) {
                System.out.println();
            }
            System.out.print(list.get(i) + " ");
        }
    }
}
