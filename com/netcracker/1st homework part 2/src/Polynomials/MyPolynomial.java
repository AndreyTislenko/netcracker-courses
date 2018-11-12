package Polynomials;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coefficients;

    public MyPolynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    public int getDegree() {
        return coefficients.length - 1;
    }

    @Override
    public String toString(){
        StringBuilder listPolynomial = new StringBuilder();
        for (int i =  getDegree(); i >= 0; i--) {
            double coefficient = coefficients[i];
            if (coefficient != 0) {
                if (coefficient < 0) {
                    listPolynomial.append(" - ");
                    if (coefficient != -1.0) listPolynomial.append(-coefficient);
                } else {
                    if (i != getDegree()) listPolynomial.append(" + ");
                    if (coefficient != 1.0) listPolynomial.append(coefficient);
                }

                if (i > 1) {
                    listPolynomial.append("x^").append(i);
                } else if (i == 1) {
                    listPolynomial.append("x");
                } else {
                    listPolynomial.append(Math.abs(coefficient));
                }
            }
        }
        return listPolynomial.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPolynomial that = (MyPolynomial) o;
        return Arrays.equals(coefficients, that.coefficients);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coefficients);
    }

    public double evaluate(double x) {
        double result = coefficients[0];
        for (int i = 1; i < coefficients.length; i++) {
            result += coefficients[i]*Math.pow(x,i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] coefficientsOfResult = new double[Math.max(this.coefficients.length, right.coefficients.length)];
        for (int i = 0; i < coefficientsOfResult.length; i++){
            double thisCoefficient = i < this.coefficients.length ? this.coefficients[i] : 0.0;
            double rightCoefficient = i < right.coefficients.length ? right.coefficients[i] : 0.0;
            coefficientsOfResult[i] = thisCoefficient + rightCoefficient;
        }
        return new MyPolynomial(coefficientsOfResult);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        int capacityOfResult = this.coefficients.length + right.coefficients.length - 1;
        double[] coefficientsOfResult = new double[capacityOfResult];
        for (int i = 0; i < capacityOfResult; i++) {
            coefficientsOfResult[i] = 0.0;
            for (int j = 0; j <= i; j++){
                double thisCoefficient = j < this.coefficients.length ? this.coefficients[j] : 0.0;
                double rightCoefficient = i - j < right.coefficients.length ? right.coefficients[i - j] : 0.0;
                coefficientsOfResult[i] += thisCoefficient*rightCoefficient;
            }
        }
        return new MyPolynomial(coefficientsOfResult);
    }
}
