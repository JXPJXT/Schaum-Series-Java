import java.util.*;

public class tallyStringQ10 {
    public static void main(String[] args) {
        String s = "Hi this is j";
        System.out.println(Arrays.toString(tally(s)));
    }

    static int[] tally(String s){
        int[] frequency = new int[26];

        for(int i = 0; i < s.length(); i++){
            char ch = Character.toUpperCase(s.charAt(i));

            if(Character.isLetter(ch)){
                frequency[ch - 'A']++;
            }
        }
        return frequency;
    }
}