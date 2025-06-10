import java.util.*;
public class pascalTriQ15 {

    public static void main(String[] args) {
        int numRows = 6;
        int[][] triangle = pascal(numRows);

        System.out.println("Pascal's Triangle (" + numRows + " rows):");
        for (int i = 0; i < numRows; i++) {
            for (int k = 0; k < numRows - i; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.printf("%4d", triangle[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println(Arrays.deepToString(triangle));

    }

    static int[][] pascal(int n) {
        int[][] p = new int[n][n];
        for (int i = 0; i < n; i++) {
            p[i][0] = 1;
            p[i][i] = 1;
            for (int j = 1; j < i; j++) {
                p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
            }
        }
        return p;
    }
}