//Has an Error
public class reverseArrayQ7{
    public static void main(String args[]){
       int[] arr = {1,2,3,4,5,6,7,8,9};
       System.out.print("Orignal Array: ");
       DuplicatingArrays.print(arr);
       reverse(arr);
       System.out.print("Reverse Array: "); 
       DuplicatingArrays.print(arr);
    }
    static void reverse(int[] a){
        int n = a.length;
        if(n<2){
            return ;
        }
        for(int i=0;i<n/2;i++){
            swap(a,i,n-i-1);
        }
    }
    static void swap(int[] a,int i,int j){
        int ai = a[i];
        int aj = a[j];
        a[i] = aj;
        a[j] = ai;
    }
}