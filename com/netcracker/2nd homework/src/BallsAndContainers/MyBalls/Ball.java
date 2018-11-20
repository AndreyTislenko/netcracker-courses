package BallsAndContainers.MyBalls;

import java.util.Objects;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;
    private int direction;
    private int velocity;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        setVelocityAndDirection(speed, direction);
    }

    public float getX() { return x; }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public float getXDelta() {
        return xDelta;
    }
    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }
    public float getYDelta() {
        return yDelta;
    }
    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }
    public void setVelocityAndDirection(int velocity, int direction) {
        double precision = 100000000000000.0;
        this.direction = direction;
        this.velocity = velocity;
        xDelta = velocity*(float)(Math.round(Math.cos(2*Math.PI*direction/360.0)*precision)/precision);
        yDelta = velocity*(float)(Math.round(Math.sin(2*Math.PI*direction/360.0)*precision)/precision);
    }
    public int getDirection() {
        return direction;
    }
    public int getVelocity() {
        return velocity;
    }

    public void move() {
        x+=xDelta;
        y+=yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }
    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "(" + x +
                ", " + y +
                "), radius=" + radius +
                ", speed=(" + xDelta +
                ", " + yDelta +
                ")}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Float.compare(ball.x, x) == 0 &&
                Float.compare(ball.y, y) == 0 &&
                radius == ball.radius &&
                Float.compare(ball.xDelta, xDelta) == 0 &&
                Float.compare(ball.yDelta, yDelta) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, radius, xDelta, yDelta);
    }

}
