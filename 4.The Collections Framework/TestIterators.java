import java.util.*;
public class TestIterators {
    public static void main(String[] args) {
        Set<String> port = new HashSet<String>();
        Collections.addAll(port, "AO","BR","CV","GW","MO","MZ","PT");
        System.out.println(port);
        Iterator itl = port.iterator();
        System.out.printf("itl.next(): %s%n",itl.next());
        System.out.printf("itl.next(): %s%n",itl.next());
        System.out.printf("itl.next(): %s%n",itl.next());
        System.out.printf("itl.next(): %s%n",itl.next());
        itl.remove();
        System.out.println(port);
        System.out.printf("itl.next():%s%n",itl.next());
        itl.remove();
        System.out.println(port);
        Iterator it2 = port.iterator();
        while(it2.hasNext()){
            System.out.printf("%s ",it2.hasNext());
        }
        System.out.println("");
        System.out.printf("itl.next(): %s%n",itl.next());
    }
}
