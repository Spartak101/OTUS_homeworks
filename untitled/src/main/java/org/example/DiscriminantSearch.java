package org.example;

public class DiscriminantSearch implements Discriminant {
    double a;
    double b;
    double c;

    public DiscriminantSearch(double a, double b, double c) {
        try {
            if(a < Double.MIN_VALUE){
                throw new Exception("а не может быть равен нулю");
            } else
                this.a = a;
            this.b = b;
            this.c = c;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public void discriminant() {
        System.out.println("discriminant");
    }

    public double[] discriminantSearch(double a, double b, double c) {
        double[] doubles;
        double d = (b * b - 4 * a * c);
        if (d > 0) {
            doubles = new double[]{(-b+Math.sqrt(d))/(2*a),(-b-Math.sqrt(d))/(2*a)};
        } else if (d < 0){
            doubles = new double[]{};
        } else {
            doubles = new double[]{(-b)/(2*a),(-b)/(2*a)};
        }
        return doubles;
    }
}
