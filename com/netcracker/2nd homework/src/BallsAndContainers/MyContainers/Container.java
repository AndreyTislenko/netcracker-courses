package BallsAndContainers.MyContainers;

import BallsAndContainers.MyBalls.Ball;

import java.util.Objects;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        x1 = x;
        y1 = y;
        x2 = x + width;
        y2 = y + height;
    }

    public int getX() {
        return x1;
    }
    public int getY() {
        return y1;
    }
    public int getWidth() {
        return x2 - x1;
    }
    public int getHeight() {
        return y2 - y1;
    }

    public boolean contains(Ball ball) {
        float x = ball.getX();
        float y = ball.getY();
        int radius = ball.getRadius();
        return (x1 + radius <= x)&&(x <= x2 - radius)&&
                (y1 + radius <= y)&&(y <= y2 - radius);
    }

    @Override
    public String toString() {
        return "Container{" +
                "(" + x1 +
                ", " + y1 +
                "), (" + x2 +
                ", " + y2 +
                ")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container container = (Container) o;
        return x1 == container.x1 &&
                y1 == container.y1 &&
                x2 == container.x2 &&
                y2 == container.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2);
    }
}
