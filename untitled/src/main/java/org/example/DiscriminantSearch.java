package org.example;

public class DiscriminantSearch implements Discriminant {
    double a;
    double b;
    double c;
    double epsilon;


    public DiscriminantSearch(double a, double b, double c, double epsilon) {
//        try {
            Double doubleValue = Double.valueOf(a);
            Double doubleEpsilon = Double.valueOf(0.0);
            if (doubleValue.compareTo(doubleEpsilon) == 0) {
                throw new IllegalArgumentException("а не может быть равен нулю");
            } else {
                this.a = a;
                this.b = b;
                this.c = c;
                this.epsilon = epsilon;
            }
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
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

    @Override
    public void discriminant() {
        System.out.println("discriminant");
    }

    public double[] discriminantSearch(double a, double b, double c, double epsilon) {
        double[] doubles;
        double d = (b * b - 4 * a * c);
        if (d > 0 && d >= epsilon) {
            doubles = new double[]{(-b + Math.sqrt(d)) / (2 * a), (-b - Math.sqrt(d)) / (2 * a)};
            return doubles;
        } else if (d < 0 && Math.abs(d) >= epsilon) {
            doubles = new double[]{};
            return doubles;
        } else if(Math.abs(d) < epsilon){
            doubles = new double[]{(-b) / (2 * a), (-b) / (2 * a)};
            return doubles;
        }
        return null;
    }

    private boolean checkingTheBoundaryValues(double a, double b, double c) throws Exception{
        Double aa = Double.valueOf(Math.abs(a));
        Double bb = Double.valueOf(Math.abs(b));
        Double cc = Double.valueOf(Math.abs(c));
        Double doubleValueZero = Double.valueOf(0.0);
        Double doubleMinValue = Double.MIN_VALUE;
        if(aa.compareTo(doubleValueZero) == 0){
            throw new IllegalArgumentException("а не может быть равен нулю");
        } else if (aa.compareTo(doubleMinValue) == -1) {
            throw new IllegalArgumentException("а не может быть меньше минимального значения для double");
        } else if (bb.compareTo(doubleMinValue) == -1) {
            throw new IllegalArgumentException("b не может быть меньше минимального значения для double");
        } else if (cc.compareTo(doubleMinValue) == -1) {
            throw new IllegalArgumentException("c не может быть меньше минимального значения для double");
        }
        return true;
    }

    private boolean TheAValueIsTooHigh(double a, String string) throws IllegalArgumentException {
        Double aa = Double.valueOf(Math.abs(a));
        Double doubleMaxValue = Double.MAX_VALUE;
        if(aa.compareTo(doubleMaxValue) == 1){
            throw new IllegalArgumentException(string + " не может быть больше максимального значения для double");
        }
        return true;
    }



    private boolean TheAValueIsTooSmall(double a, String string){
        Double aa= Double.valueOf(Math.abs(a));
        Double doubleMinValue = Double.MIN_VALUE;
        if(aa.compareTo(doubleMinValue) == -1){
            throw new IllegalArgumentException(string + " не может быть меньше минимального значения для double");
        }
        return true;
    }

    private boolean checkingForNaN(double a, String string){
         if(!Double.isNaN(a)){
            throw new IllegalArgumentException(string + " не является числом");
        }
        return true;
    }
}
