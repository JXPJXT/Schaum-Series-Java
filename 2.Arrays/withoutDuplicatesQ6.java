public class withoutDuplicatesQ6 {
    public static void main(String args[]){
        int[] a = {9,7,8,4,6,4,2,3,5,4,6,4,5,1,4,6,8,7,9,6,3,5,4};
        System.out.println("A originally: "+a);
        System.out.println("A without duplicates: "+withoutDuplicates(a));
    }
    static int[] withoutDuplicates(int[] a){
        int n = a.length;
        if(n<2){
            return a;
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(a[j]==a[i]);
                --n;
                System.arraycopy(a, j, j, j, n);
            }
        }
    }
}
