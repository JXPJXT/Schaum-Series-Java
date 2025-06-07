import java.util.*;

public class MyShape {
    public static void main(String[] args) {
        // Demonstration code
        Point p1 = new MyPoint(3, 4);
        Circle circle = new MyCircle(p1, 5);
        System.out.println("Circle area: " + circle.area());
    }
}

interface Point {
    double amplitude();
    double distanceTo(Point point);
    @Override boolean equals(Object object);
    double magnitude();
    @Override String toString();
    double xCoordinate();
    double yCoordinate();
}

interface Line {
    boolean contains(Point point);
    @Override boolean equals(Object object);
    boolean isHorizontal();
    boolean isVertical();
    double slope();
    @Override String toString();
    double xIntercept();
    double yIntercept();
}

interface Circle {
    double area();
    Polynomial derivative();
    @Override boolean equals(Object object);
    Polynomial sum(Polynomial polynomial);
    @Override String toString();
    double valueAt(double x);
}

interface Polynomial {
    int degree();
    Polynomial derivative();
    @Override boolean equals(Object object);
    Polynomial sum(Polynomial polynomial);
    @Override String toString();
    double valueAt(double x);
}

class MyPoint implements Point {
    private double x, y;
    public static final Point ORIGIN = new MyPoint(0, 0);

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double amplitude() {
        return Math.atan2(y, x);
    }

    public double distanceTo(Point point) {
        MyPoint that = (MyPoint) point;
        double dx = that.x - x;
        double dy = that.y - y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyPoint)) return false;
        MyPoint that = (MyPoint) obj;
        return Double.compare(that.x, x) == 0 
            && Double.compare(that.y, y) == 0;
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }

    @Override public String toString() {
        return String.format("(%.2f,%.2f)", x, y);
    }

    public double xCoordinate() { return x; }
    public double yCoordinate() { return y; }
}

class MyLine implements Line {
    private final double m, b;

    public MyLine(double m, double b) {
        this.m = m;
        this.b = b;
    }

    public boolean contains(Point point) {
        if (isVertical()) {
            return point.xCoordinate() == xIntercept();
        }
        return Double.compare(point.yCoordinate(), 
                             m * point.xCoordinate() + b) == 0;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyLine)) return false;
        MyLine that = (MyLine) obj;
        return Double.compare(that.m, m) == 0 
            && Double.compare(that.b, b) == 0;
    }

    public boolean isHorizontal() { return m == 0; }
    public boolean isVertical() { return Double.isInfinite(m); }
    public double slope() { return m; }

    @Override public String toString() {
        return isVertical() ? "x=" + xIntercept() 
             : "y=" + String.format("%.2fx+%.2f", m, b);
    }

    public double xIntercept() {
        return isHorizontal() ? Double.NaN : -b/m;
    }

    public double yIntercept() {
        return isVertical() ? Double.NaN : b;
    }
}

class MyCircle implements Circle {
    private final Point center;
    private final double radius;

    public MyCircle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    @Override public Polynomial derivative() {
        throw new UnsupportedOperationException();
    }

    @Override public Polynomial sum(Polynomial polynomial) {
        throw new UnsupportedOperationException();
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyCircle)) return false;
        MyCircle that = (MyCircle) obj;
        return center.equals(that.center) 
            && Double.compare(radius, that.radius) == 0;
    }

    @Override public String toString() {
        return String.format("Circle[%s, r=%.2f]", center, radius);
    }

    public double valueAt(double x) {
        throw new UnsupportedOperationException();
    }
}

class MyPolynomial implements Polynomial {
    private final double[] coefficients;

    public MyPolynomial(double[] coefficients) {
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
    }

    public int degree() {
        return coefficients.length - 1;
    }

    public Polynomial derivative() {
        double[] d = new double[coefficients.length-1];
        for (int i=0; i<d.length; i++)
            d[i] = coefficients[i+1] * (i+1);
        return new MyPolynomial(d);
    }

    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyPolynomial)) return false;
        return Arrays.equals(coefficients, ((MyPolynomial)obj).coefficients);
    }

    public Polynomial sum(Polynomial other) {
        MyPolynomial p = (MyPolynomial) other;
        double[] sum = new double[Math.max(coefficients.length, p.coefficients.length)];
        for (int i=0; i<sum.length; i++) {
            double a = i < coefficients.length ? coefficients[i] : 0;
            double b = i < p.coefficients.length ? p.coefficients[i] : 0;
            sum[i] = a + b;
        }
        return new MyPolynomial(sum);
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<coefficients.length; i++) {
            if (i > 0) sb.append(" + ");
            sb.append(String.format("%.2fx^%d", coefficients[i], i));
        }
        return sb.toString();
    }

    public double valueAt(double x) {
        double result = 0;
        for (int i=0; i<coefficients.length; i++)
            result += coefficients[i] * Math.pow(x, i);
        return result;
    }
}
