public class meanCheckQ5 {
    public static void main(String args[]){
        int[] a = {9,7,8,4,6,4,2,3,5,4,6,4,5,1,4,6,8,7,9,6,3,5,4};
        System.out.println("Mean of array A is: "+mean(a));
    }
    static int mean(int[] a){
        double sum=0.0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        return (int)(sum/a.length);
    }
}
