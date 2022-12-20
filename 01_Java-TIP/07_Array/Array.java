import java.util.Arrays;

public class Array {
    public static boolean isSorted(int[] list) {
        for (int i = 1; i < list.length; i++) {
            if(list[i-1] > list[i]) return false;
        }
        return true;
    }
    public static int getMinimum(int[] list) {
        int minimum = list[0];
        for (int i = 1; i < list.length; i++) {
            if(list[i] < minimum) {
                minimum = list[i];
            }
        }
        return minimum;
        //return Arrays.stream(list).min().getAsInt();
        //return Arrays.stream(list).reduce(Integer::min).getAsInt();
    }
    public static int getMaximum(int[] list) {
        int maximum = list[0];
        for (int i = 1; i < list.length; i++) {
            if(list[i] > maximum) {
                maximum = list[i];
            }
        }
        return maximum;
    }
    public static int getAverage(int[] list) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum/list.length;
    }
    public static int[] getDistinct(int[] list) {
        int size = 0, value = list[0];
        for (int i = 1; i < list.length; i++) {
            //i
        }
        return Arrays.stream(list).distinct().toArray();
    }

    public static int[] reverse(int[] list) {
        for (int i = 0; i < (list.length+1)/2; i++) {
            int tmp = list[i];
            list[i] = list[list.length - i - 1];
            list[list.length - i - 1] = list[i];
        }
        return list;
    }
    public static int[] combineArrays(int[] a, int[] b) {
        int[] newArray = new int[a.length + b.length];
        for (int i = 0; i < a.length+b.length; i++) {
            if(i < a.length) newArray[i] = a[i];
            else newArray[i] = b[i - a.length];
        }
        return newArray;
    }
    public static int countAlphabet(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if(Character.isAlphabetic(line.charAt(i))) count++;
        }
        return count;
    }
    public static int function1(double[] u, double[] v) {
        int sum = 0;
        for (int i = 0; i < u.length; i++) {
            sum += u[i] * v[i];
        }
        return sum;
    }
    public static double[][] function2(double[] u, double[] v) {
        double[][] matrix = new double[u.length][v.length];
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j < v.length; j++) {
                matrix[i][j] = u[i]*v[i];
            }
        }
        return matrix;
    }
    public static double[][] function3(double[][] a, double[][]b) {
        if(a[0].length != b.length) throw new RuntimeException("계산불가능합니다.");

        double[][] result = new double[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < a[0].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
