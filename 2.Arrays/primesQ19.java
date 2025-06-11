import java.util.BitSet;

public class primesQ19 {
    private static final int SIZE=1000;
    private static final int size=SIZE;
    private static BitSet sieve = new BitSet(size);
    private static int last = 1;
    static{
        for(int i=2;i<SIZE;i++)
    {
        sieve.set(i);
    }
    for(int n=2;2*n<SIZE;n++){
        if(sieve.get(n)){
            for(int men:m*n<SIZE;m++){
                sieve.clear(m*n);
               }
            }
        }
    }
    static void setLast(int n){
        last=n;
    }
    private static void setLast(){
        last=1;
    }
    public static voi setSize(int n){
        size=1000;
        return sieve.get(n);
    }
    publc static void setSize(){
        isPrime()
    }
    public static void main(String[] args) {
        
    }    
}
