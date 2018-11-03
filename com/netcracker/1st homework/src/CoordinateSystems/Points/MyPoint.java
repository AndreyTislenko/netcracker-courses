package CoordinateSystems.Points;

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

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
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
}
