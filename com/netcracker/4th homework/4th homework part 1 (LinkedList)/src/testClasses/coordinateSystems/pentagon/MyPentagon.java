package testClasses.coordinateSystems.pentagon;

import testClasses.coordinateSystems.points.MyPoint;
import testClasses.coordinateSystems.polygons.MyPolygon;

import java.util.HashMap;
import java.util.HashSet;

public class MyPentagon extends MyPolygon {

    public MyPentagon(MyPoint p1, MyPoint p2, MyPoint p3, MyPoint p4, MyPoint p5){
        super(p1, p2, p3, p4, p5);
        createQualificationForPentagon();
    }
    private void createQualificationForPentagon(){
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(1);
        HashSet<Integer> hashSet21 = new HashSet<>();
        hashSet21.add(2);
        hashSet21.add(1);
        HashSet<Integer> hashSet31 = new HashSet<>();
        hashSet31.add(3);
        hashSet31.add(1);
        HashSet<Integer> hashSet32 = new HashSet<>();
        hashSet32.add(3);
        hashSet32.add(2);
        HashSet<Integer> hashSet41 = new HashSet<>();
        hashSet41.add(4);
        hashSet41.add(1);
        HashSet<Integer> hashSet5 = new HashSet<>();
        hashSet5.add(5);

        HashMap<HashSet<Integer>, String> qualifications = new HashMap<>();
        qualifications.put(hashSet1, "Scalene");
        qualifications.put(hashSet21, "Two-equal");
        qualifications.put(hashSet31, "Three-equal");
        qualifications.put(hashSet32, "Tree-equal and two-equal");
        qualifications.put(hashSet41, "Four-equal");
        qualifications.put(hashSet5, "Equilateral");

        MyPolygon.setQualifications(qualifications);
    }
}
