package Figures.Circles;

import Figures.Figures.Integrable;

public class Circle implements Integrable {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {}
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color){
        /* We could use Circles(double radius) to set radius here, but
         * just in case if somebody tries to delete this constructor
         * we will use this.radius syntax instead.*/
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getArea(){
        double radius = getRadius();
        return Math.PI*radius*radius;
    }

    /*I know it may sound stupid but it's my code anyway
    * so just get used to it.*/
    @Override
    public double getPerimeter() {
        return 2.0*Math.PI*getRadius();
    }

    @Override
    public String toString() {
        return "Circles{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
