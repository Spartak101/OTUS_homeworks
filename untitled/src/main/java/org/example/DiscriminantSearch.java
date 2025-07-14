package org.example;

public class DiscriminantSearch {
    double a;
    double b;
    double c;
    double epsilon;


    public DiscriminantSearch(double a, double b, double c, double epsilon) throws Exception {
//        try {
        aIsNotZero(a);
        checkingForNumber(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
        this.epsilon = epsilon;
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
    }

    private void aIsNotZero(double a) {
        Double doubleValue = Double.valueOf(a);
        Double doubleEpsilon = Double.valueOf(0.0);
        if (doubleValue.compareTo(doubleEpsilon) == 0) {
            throw new IllegalArgumentException("а не может быть равен нулю");
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

    public double getEpsilon() {
        return epsilon;
    }

    public double[] discriminantSearch(double a, double b, double c, double epsilon) throws Exception {
        if (checkingForNumber(a, b, c)) {
            double[] doubles;
            double d = (b * b - 4 * a * c);
            if (d > 0 && d >= epsilon) {
                doubles = new double[]{(-b + Math.sqrt(d)) / (2 * a), (-b - Math.sqrt(d)) / (2 * a)};
                return doubles;
            } else if (d < 0 && Math.abs(d) >= epsilon) {
                doubles = new double[]{};
                return doubles;
            } else if (Math.abs(d) < epsilon) {
                doubles = new double[]{(-b) / (2 * a), (-b) / (2 * a)};
                return doubles;
            }
        }
        return null;
    }

    private boolean checkingForNumber(double a, double b, double c) throws Exception {
        checkingForNaN(a, "a");
        checkingForNaN(b, "b");
        checkingForNaN(c, "c");
        return true;
    }


    private boolean checkingForNaN(double a, String string) {
        if (!Double.isFinite(a)) {
            throw new IllegalArgumentException(string + " не является числом");
        }

        return true;
    }
}
