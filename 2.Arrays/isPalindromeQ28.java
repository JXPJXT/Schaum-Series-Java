public class isPalindromeQ28 {
    boolean isPalindrome(int n){
        if(n<0){
            return false;
        }
        int p10=1;
        while(p10<n){
            if(n/p10!=n%10){
                return false;
            }
            n/=10;
            p10/=10;
            n%=p10;
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
