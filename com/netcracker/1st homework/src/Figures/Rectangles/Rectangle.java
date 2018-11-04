package Figures.Rectangles;

import Figures.Figures.Integrable;

import java.util.Objects;

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
        return "Rectangles{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) return true;
        if (otherObj == null) return false;
        if (otherObj.getClass() != getClass()) return false;

        Rectangle otherRectangle = (Rectangle)otherObj;
        return (length == otherRectangle.getLength())&&
                (width == otherRectangle.getWidth());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + Float.floatToIntBits(length);
        result = 31*result + Float.floatToIntBits(width);
        return result;
    }
}
