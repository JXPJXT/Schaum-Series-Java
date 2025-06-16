import java.util.*;
public class TestLinkedHashset {
    public static void main(String args[]){
        Set<String> ital = new LinkedHashSet<String>();
        Collections.addAll(ital,"IT","VA","SM","CH");
        System.out.println(ital);
        ital.remove("VA");
        System.out.println(ital);
        ital.add("VA");
        System.out.println(ital);
    }
}
