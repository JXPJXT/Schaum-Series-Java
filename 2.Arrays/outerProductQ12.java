import java.util.Arrays;

public class outerProductQ12 {
    public static void main(String[] args) {
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] y = {10.0, 9.0, 8.0, 7.0, 6.0};
        
        double[][] result = outerProduct(x, y);

        for (double[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    static double[][] outerProduct(double[] x, double[] y) {
        double[][] z = new double[x.length][y.length];
        
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                z[i][j] = x[i] * y[j];
            }
        }
        return z;
    }
}