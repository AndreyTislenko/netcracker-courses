package ComplexNumbers;

import java.util.Objects;

public class MyComplex {
    private double real;
    private double imaginary;

    public MyComplex() {}
    public MyComplex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }
    public void setReal(double real) {
        this.real = real;
    }
    public double getImaginary() {
        return imaginary;
    }
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }
    public void setValue(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(real);
        if (imaginary < 0) {
            str.append(" - ").append(-imaginary);
        }
        else {
            str.append(" + ").append(imaginary);
        }
        str.append("i");
        return str.toString();
    }

    public boolean isReal() {
        return real != 0.0;
    }
    public boolean isImaginary() {
        return imaginary != 0.0;
    }

    @Override
    public boolean equals(Object o) {
        /*I was very surprised that I can use dot syntax to get to the
        * private fields of other instance of MyComplex class.
        * Before that I used getters, but now I think I will use dot instead.*/
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return (myComplex.real == real) &&
                (myComplex.imaginary == imaginary);
    }
    public boolean equals(double real, double imaginary) {
        return (this.real == real) && (this.imaginary == imaginary);
    }
    @Override
    public int hashCode() {
        return Objects.hash(real, imaginary);
    }

    public double magnitude() {
        return Math.sqrt(real*real + imaginary*imaginary);
    }
    public double argument() {
        /*Math.atan2(y,x) is much more pertinent then Math.atan(y/x)
        * sins Math.atan returns an angle in the range -pi/2 through pi/2.
        * Computing argument of complex number we really need another range,
        * the range of -pi to pi.*/
        return Math.atan2(imaginary, real);
    }

    public MyComplex add(MyComplex right) {
        return addition(right, 1);
    }
    public MyComplex addNew(MyComplex right) {
        MyComplex sum = new MyComplex();
        sum.add(this).add(right);
        return  sum;
    }
    public MyComplex subtract(MyComplex right) {
        return addition(right, -1);
    }
    public MyComplex subtractNew(MyComplex right) {
        MyComplex result = new MyComplex();
        result.add(this).subtract(right);
        return  result;
    }
    private MyComplex addition(MyComplex right, int operation) {
        this.real = this.real + (operation)*right.real;
        this.imaginary = this.imaginary + (operation)*right.imaginary;
        return this;
    }

    public MyComplex multiply(MyComplex right) {
        double real = this.real;
        this.real = this.real*right.real - this.imaginary*right.imaginary;
        this.imaginary = real*right.imaginary + this.imaginary*right.real;
        return this;
    }
    public MyComplex conjugate() {
        return new MyComplex(this.real, -this.imaginary);
    }
    public MyComplex divide(MyComplex right) {
        double precision = 10000000000000.0; //14 significant digits after decimal point.
        this.multiply(right.conjugate());
        double divider = right.magnitude();
        divider *= divider;
        divider = Math.round(divider*precision)/precision;
        this.real /= divider;
        this.imaginary /= divider;
        return this;
    }
}
