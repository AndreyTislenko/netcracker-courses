package Main;

import BallsAndContainers.MyBalls.Ball;
import BallsAndContainers.MyContainers.Container;
import BallsAndContainers.SwingAnimation.Animation;
import ComplexNumbers.MyComplex;
import Polynomials.MyPolynomial;

public class Main {
    public static void main(String[] args) {
        /*MyComplex complex = new MyComplex(1.0, -2.0);
        System.out.println("Let z = " + complex);

        MyComplex anotherComplex = new MyComplex(2.0, 7.0);

        System.out.println("(" + complex + ") + (" + anotherComplex + ") = " + complex.addNew(anotherComplex));
        System.out.println("The z is " + complex);
        System.out.println("(" + complex + ") - (" + anotherComplex + ") = " + complex.subtractNew(anotherComplex));
        System.out.println("The z is " + complex);
        System.out.println();

        System.out.print("(" + complex + ") - (");System.out.println(anotherComplex + ") = " + complex.subtract(anotherComplex));
        System.out.println("The z now is " + complex);
        System.out.print("(" + complex + ") + (");System.out.println(anotherComplex + ") = " + complex.add(anotherComplex));
        System.out.println("The z now is " + complex);
        System.out.println();

        System.out.print("(" + complex + ")*(");System.out.println(anotherComplex + ") = " + complex.multiply(anotherComplex));
        System.out.println("The z now is " + complex);
        System.out.print("(" + complex + ")/(");System.out.println(anotherComplex + ") = " + complex.divide(anotherComplex));
        System.out.println("The z now is " + complex);*/
        //--------------------------------------------------------------------------------------------------------------
        /*MyPolynomial myPolynomial = new MyPolynomial(-1.0, 0.0, 1.0);

        System.out.println("1) P(x) = " + myPolynomial);
        System.out.println("   P(x) == some another polynomial => " + myPolynomial.equals(new MyPolynomial(-1.0, 0.0, 1.0)));
        double x = 1.0;
        System.out.println("   P(" + x + ") = " + myPolynomial.evaluate(x));

        MyPolynomial myPolynomial1 = new MyPolynomial(1.0, 0.0, 1.0);

        System.out.println("2) Q(x) = " + myPolynomial1);
        System.out.println("   (" + myPolynomial + ") + (" + myPolynomial1 + ")" + " = " + myPolynomial.add(myPolynomial1));
        System.out.println("   (" + myPolynomial + ")*(" + myPolynomial1 + ")" + " = " + myPolynomial.multiply(myPolynomial1));*/
        //--------------------------------------------------------------------------------------------------------------
        Container container = new Container(100,100,300,200); //Default values for container.
        Ball ball = new Ball(500,120,20,30, 180); //Default values for ball.
        Animation animation = new Animation(container, ball); //The swing stuff.
        //System.out.println(container.contains(new Ball(180,280,20,30,-90)));
    }
}
