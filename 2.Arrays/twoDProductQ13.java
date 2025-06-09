public class twoDProductQ13 {
    public static void main(String[] args) {
        double[][] matrixA = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0}
        };
        double[][] matrixB = {
            {7.0, 8.0},
            {9.0, 10.0},
            {11.0, 12.0}
        };
        double[][] result = product(matrixA, matrixB);
        System.out.println("Product is:");
        printMatrix(result);
    }

    static double[][] product(double[][] x, double[][] y) {
        double[][] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                double sum = 0.0;
                for (int k = 0; k < x[0].length; k++) {
                    sum += x[i][k] * y[k][j];
                }
                z[i][j] = sum;
            }
        }
        return z;
    }

    static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
