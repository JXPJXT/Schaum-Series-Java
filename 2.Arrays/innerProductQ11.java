public class innerProductQ11 {
    public static void main(String[] args) {
        double[] x = {1.0,2.0,3.0,4.0,5.0};
        double[] y = {10.0,9.0,8.0,7.0,6.0};
        System.out.println(innerProduct(x,y));
    }
    static double innerProduct(double[] x, double[] y){
        double sum=0.0;
        for(int i=0;i<x.length && i<y.length;i++){
            sum+=x[i]*y[i];
        }
        return sum;
    }
    
}
