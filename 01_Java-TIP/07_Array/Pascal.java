public class Pascal {
    public static int findPascal(int col, int row) {
        if(row == 0 || col == row) return 1;
        else  return findPascal(col - 1, row-1) + findPascal(col - 1, row);
    }
    public static int[][] Pascal(int line) {
        int[][] result = new int[line][];
        for (int i = 0; i < line; i++) {
            result[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                result[i][j] = (j == 0 || j == i) ? 1 : result[i-1][j-1] + result[i-1][j];
            }
        }
        return result;
    }
    public static void PascalTest() {
        int col = 5, row = 3;
        printArray(Pascal(8));
        System.out.println("( " + col + ", " + row + " ) -> " + findPascal(col, row));
    }
    public static void printArray(int[][] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < list[i].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }
}
