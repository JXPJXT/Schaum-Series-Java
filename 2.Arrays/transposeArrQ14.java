import java.util.Arrays;

public class transposeArrQ14 {
    public static void main(String[] args) {
        double[][] arr = {{1.1, 2.2, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[][] transposedArr = transpose(arr);

        System.out.println("Original Array:");
        System.out.println(Arrays.deepToString(arr));
        
        System.out.println("\nTransposed Array:");
        System.out.println(Arrays.deepToString(transposedArr));
    }

    static double[][] transpose(double[][] arr) {
        if (arr == null || arr.length == 0) {
            return new double[0][0];
        }

        int rows = arr.length;
        int cols = arr[0].length;
        double[][] transposed = new double[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposed[i][j] = arr[j][i];
            }
        }
        
        return transposed;
    }
}