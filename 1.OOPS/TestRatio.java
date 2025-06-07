public class TestRatio{
    public static void main(String[] args) {
        System.out.println("Ratio.ZERO = "+Ratio.ZERO);
        System.out.println("Ratio.ZERO.value() = "+Ratio.ZERO.value());
        Ratio x = new Ratio(22, 7);
        System.out.println("x = "+x);
        System.out.println("x.value = "+x.value());
        System.out.println("x.equals(Ratio.ZERO): "+x.equals(Ratio.ZERO));
        Ratio xx = new Ratio(44,14);
        System.out.println("xx.value() = "+xx.value());
        System.out.println("x.equals(xx): "+x.equals(xx));

        Ratio r1 = new Ratio(1, 2);
        Ratio r2 = new Ratio(3, 4);
        Ratio r3 = new Ratio(2, 4);
        Ratio r4 = new Ratio(-1, 2);

        System.out.println("\nTesting compareTo:");
        System.out.println("r1.compareTo(r2): " + r1.compareTo(r2));
        System.out.println("r2.compareTo(r1): " + r2.compareTo(r1));
        System.out.println("r1.compareTo(r3): " + r1.compareTo(r3));
        System.out.println("r1.compareTo(Ratio.ZERO): " + r1.compareTo(Ratio.ZERO));
        System.out.println("Ratio.ZERO.compareTo(r1): " + Ratio.ZERO.compareTo(r1));
        System.out.println("r4.compareTo(r1): " + r4.compareTo(r1));

        System.out.println();
        Ratio n = new Ratio(22,7);
        System.out.println("n.hashCode(): "+n.hashCode());
    }
}

class Ratio implements Comparable{
    protected int num;
    protected int den;
    public static final Ratio ZERO = new Ratio();
    private Ratio(){
        this(0,1);
    }
    public Ratio(int num,int den){
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.num=num;
        this.den=den;
        normalize(this);
    }
    @Override
    public boolean equals(Object object){
        if(object==this){
            return true;
        }
        else if(!(object instanceof Ratio)){
            return false;
        }
        Ratio that = (Ratio)object;
        return(this.num*that.den==that.num*this.den);
    }
    @Override
    public int compareTo(Object object){
        if(object==this){
            return 0;
        }
        else if(!(object instanceof Ratio)){
            throw new IllegalArgumentException("Ratio type expected");
        }
        Ratio that = (Ratio)object;
        normalize(this);
        normalize(that);
        return (this.num*that.den - that.num*this.den);
    }
    private static void normalize(Ratio x){
        if(x.num == 0){
            x.den = 1;
        }
        else if(x.den < 0){
            x.num *= -1;
            x.den *= -1;
        }
    }
    public int getNum(){
        return num;
    }
    public int getDen(){
        return den;
    }
    @Override
    public String toString(){
        return String.format("%d/%d",num,den);
    }
    public double value(){
        return (double)num/den;
    }
}