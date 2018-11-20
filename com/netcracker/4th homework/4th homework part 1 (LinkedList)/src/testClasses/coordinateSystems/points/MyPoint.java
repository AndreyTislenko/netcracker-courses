package testClasses.coordinateSystems.points;

public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {}
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double[] getXY(){
        return new double[]{x, y};
    }
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distance(double x, double y){
        return Math.sqrt((this.x - x)*(this.x - x) + (this.y - y)*(this.y - y));
    }
    public double distance(MyPoint anotherPoint){
        return distance(anotherPoint.getX(), anotherPoint.getY());
    }
    public double distance(){
        return distance(0.0,0.0);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    @Override
    public boolean equals(Object otherObj) {
        //haha funny we are comparing dots
        if (this == otherObj) return true;
        if (otherObj == null) return false;
        if (otherObj.getClass() != getClass()) return false;

        MyPoint otherPoint = (MyPoint)otherObj;
        return (x == otherPoint.getX())&&
                (y == otherPoint.getY());
    }

    @Override
    public int hashCode(){
        int result = 17;
        long x = Double.doubleToLongBits(this.x);
        result = 31*result + (int)(x^(x>>>32));
        long y = Double.doubleToLongBits(this.y);
        result = 31*result + (int)(y^(y>>>32));
        return result;
    }
}
