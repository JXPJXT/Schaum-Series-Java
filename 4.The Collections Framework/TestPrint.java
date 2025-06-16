public class TestPrint {
    public static void main(String[] args) {
        args = new String[]{"CA","US","MX","HN","GT"};
        print(args);
    }
    static <E> void print(E[] a){
        for(E ae: a){
            System.out.printf("%s ",ae);
        }
        System.out.println();
    }
    static void print(Collection<?> c){
        for(Object o:C){
            System.out.printf("%s ",o);
        }
        System.out.println();
    }
}
