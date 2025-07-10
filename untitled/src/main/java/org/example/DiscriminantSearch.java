package org.example;

public class DiscriminantSearch implements Discriminant {
    double a;
    double b;
    double c;

    public DiscriminantSearch(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void discriminant() {
        System.out.println("discriminant");
    }

    private double[] discriminantSearch(double a, double b, double c) {
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
