package Figures.Rectangles;

import Figures.Figures.Integrable;

public class Rectangle implements Integrable {
    private float length = 1.0f;
    private float width = 1.0f;

    public Rectangle() {}
    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }
    public void setLength(float length) {
        this.length = length;
    }
    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return getLength()*getWidth();
    }

    @Override
    public double getPerimeter() {
        return 2.0*(getLength() + getWidth());
    }

    @Override
    public String toString() {
        return "Figures.Figures.Figures.Rectangles{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
