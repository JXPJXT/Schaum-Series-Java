import java.util.*;
public class TestFillQ1{
    public static void main(String[] args) {
        Object[] a = new Object[4];
        Arrays.fill(a, new Date());
        DuplicatingArrays.print(a);
        Arrays.fill(a,22);
        DuplicatingArrays.print(a);
        Arrays.fill(a,"Yo");
        DuplicatingArrays.print(a);
    }
}