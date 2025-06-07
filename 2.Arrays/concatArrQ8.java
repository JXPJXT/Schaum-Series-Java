public class concatArrQ8 {
    public static void main(String[] args) {
        int[] a={1,2,3};
        int[] b={4,5,6};
        System.out.print("Orignal A: ");
        DuplicatingArrays.print(a);
        System.out.println();
        System.out.print("Orignal B: ");
        DuplicatingArrays.print(b);
        System.out.println();
        System.out.println("Concatenated Array: "+concatenate(a, b));
    }
    static Object[] concatenate(Object[] a, Object[] b){
        Object[] c = new Object[a.length+b.length];
        for(int i=0;i<a.length;i++){
            c[i]=a[i];
        }
        for(int i=0;i<b.length;i++){
            c[i+a.length]=b[i];
        }
        return c;
    }
}
