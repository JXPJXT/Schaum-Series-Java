public class TestLinearSearch{
    public static void main(String args[]){
        int[] a = {22,33,44,55,66,77,88,99};
        //ch02.ex02.DuplicatingArrays.print(a);
        System.out.println("search(a,44): "+search(a,44));
        System.out.println("search(a,55): "+search(a,77));
        System.out.println("search(a,77): "+search(a,77));
        System.out.println("search(a,100): "+search(a,100));
    }
    //O(n)--Time Complexity
    static int search(int[] a,int x){
        for(int i=0;i<a.length;i++){
            if(a[i]==x){
                return i;
            }
        }
        return -1;
    }
}