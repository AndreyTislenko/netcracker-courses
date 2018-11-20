package CoordinateSystems.Triangles;

import CoordinateSystems.Points.MyPoint;
import CoordinateSystems.Polygons.MyPolygon;

import java.util.*;

public class MyTriangle extends MyPolygon {
    //All required methods (getType, getPerimeter) and instance variables are in superclass.
    //Also equals and hashCode are overridden in MyPolygon.

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        super(v1, v2, v3);
        createQualificationForTriangle();
    }
    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3){
        this(new MyPoint(x1, y1), new MyPoint(x2, y2), new MyPoint(x3, y3));
    }

    @Override
    public String toString() {
        StringBuilder myTriangle = new StringBuilder("MyTriangle{");
        //I wanted to use just v.length, but... whatever.
        for (int i = 0; i < super.v.length; i++){
            myTriangle.append("v").append(i+1).append("=").append(super.v[i]);
            if (i < super.v.length - 1) myTriangle.append(", ");
            else myTriangle.append("}");
        }
        return myTriangle.toString();
    }

    private void createQualificationForTriangle(){
        /*In this case we have sets of one number and sometimes of two numbers.
        * So {1} means all edges are only equal to itself, so it's scalene
        * (in other cases it will be just random polygon).
        * {2, 1} means there are at least two edges that are equal and at least one that is equal to itself.
        * It's isosceles. And so on.*/
        HashSet<Integer> equalEdgesForEquilateralQualification = new HashSet<>();
        equalEdgesForEquilateralQualification.add(3);
        HashSet<Integer> equalEdgesForIsoscelesQualification = new HashSet<>();
        equalEdgesForIsoscelesQualification.add(2);
        equalEdgesForIsoscelesQualification.add(1);
        HashSet<Integer> equalEdgesForScaleneQualification = new HashSet<>();
        equalEdgesForScaleneQualification.add(1);

        HashMap<HashSet<Integer>, String> qualifications = new HashMap<>();
        qualifications.put(equalEdgesForEquilateralQualification , "Equilateral");
        qualifications.put(equalEdgesForIsoscelesQualification, "Isosceles");
        qualifications.put(equalEdgesForScaleneQualification, "Scalene");

        MyTriangle.setQualifications(qualifications);
    }
}
