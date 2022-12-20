import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static int BinarySearch(int[] list, int target) {
        if(!isSorted(list)) throw new RuntimeException("탐색이 불가능합니다.");

        int small = 0, big = list.length, middle;

        while(small <= big) {
            middle = (small + big) / 2;
            if(list[middle] == target) {
                return middle;
            } else if(list[middle] > target ) {
                big = middle;
            } else {
                small = middle;
            }
        }
        return -1;
    }

    public static int SIZE = 1000000;
    public static boolean isSorted(int[] list) {
        for (int i = 1; i < list.length; i++) {
            if(list[i-1] > list[i]) return false;
        }
        return true;
    }

    public static void BinarySearchTest() {
        int[] list = new int[SIZE];
        for (int i = 0; i < list.length; i++) {
            list[i] = (new Random().nextInt(SIZE));
        }
        System.out.println(list);
        Arrays.sort(list);
        System.out.println(list);

        int result, target = new Random().nextInt(SIZE);
        double beforeTime, afterTime, secDiffTime;


        beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        result = BinarySearch(list, target);
        afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        secDiffTime = (afterTime - beforeTime)*10000; //두 시간에 차 계산
        System.out.println("Mine" + secDiffTime + "초 걸림. --> " + result);

        beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        result = Arrays.binarySearch(list, target);
        afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        secDiffTime = (afterTime - beforeTime)*10000; //두 시간에 차 계산
        System.out.println(secDiffTime + "초 걸림. --> " + result);
    }
}
