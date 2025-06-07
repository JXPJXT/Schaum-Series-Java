public class checkSortedQ3{
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {1,2,3,4,5,9,8,7,6};
        System.out.println("Is A Sorted? : "+isSorted(a));
        System.out.println("Is B Sorted? : "+isSorted(b));
    }
    static boolean isSorted(int[] a){
        if(a.length<2){
            return true;
        }
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1]){
                return false;
            }
        }
        return true;
    }
}