public class minElementQ4{
    public static void main(String args[]){
        int[] a = {9,7,8,4,6,4,2,3,5,4,6,4,5,1,4,6,8,7,9,6,3,5,4};
        System.out.println("Min Element in Array A: " + minimum(a));
    }
    static int minimum(int[] a){
        int min = a[0];
        for(int i = 1; i < a.length ; i++){
            if(a[i]<min){
                min=a[i];
            }
        }
        return min;
    }
}