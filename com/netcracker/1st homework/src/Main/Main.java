package Main;

/*import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;*/

/*Задачи на тему: Основные принципы объектно-ориентированного программирования. Java классы и объекты.
 * Реализовать  Java классы в соответствии с UML диаграммами */

import CoordinateSystems.Pentagon.MyPentagon;
import CoordinateSystems.Points.MyPoint;
import CoordinateSystems.Triangles.MyTriangle;

public class Main {
    public static void main(String[] args) {
        /*Circles circle = new Circles(3,"green");
        System.out.println(circle);
        System.out.println("The area of circle = " + circle.getArea());
        System.out.println("The perimeter of circle = " + circle.getPerimeter());
        System.out.println();
        Rectangles rectangle = new Rectangles(5,7);
        System.out.println(rectangle);
        System.out.println("The area of rectangle = " + rectangle.getArea());
        System.out.println("The perimeter of rectangle = " + rectangle.getPerimeter());*/

        /*Employee employee = new Employee(1488,"Pussy","Destroyer",100000);
        System.out.println(employee);
        System.out.println("Annual salary is " + employee.getAnnualSalary() + "$");
        System.out.println("The full name is " + employee.getName());
        try {
            System.out.println("Let's increase salary bygaga! The salary now is " + employee.raiseSalary(150) + "$ per month!");
        }catch (PercentTooLargeException e){
            System.out.println(e.getMessage());
        }*/

        /*Author[] authors = {new Author("Quentin Tarantino",'m'), new Author("Quentina Taranti", 'f'), new Author("Samuel L. Jackson",'m')};
        Book book = new Book("Pulp fiction",authors,100, 2);
        System.out.println(book.getAuthorNames());
        System.out.println(book);*/

        /*MyPoint myPoint = new MyPoint(4,3);
        System.out.println(myPoint);
        System.out.println("Distance from (0, 0) = " + myPoint.distance());
        System.out.println("Distance from (10, 10) = " + myPoint.distance(10,10));
        MyPoint anotherPoint = new MyPoint(6, 8);
        System.out.println("Distance from " + anotherPoint + " to " + myPoint + " = " + myPoint.distance(anotherPoint));
        anotherPoint.setXY(100, 64);
        double[] xyOfAnotherPoint = anotherPoint.getXY();
        System.out.println("Now distance from " + anotherPoint + " to " + myPoint + " = " + myPoint.distance(xyOfAnotherPoint[0],xyOfAnotherPoint[1]));*/

        /*MyTriangle myTriangle = new MyTriangle(new MyPoint(0,0), new MyPoint(4,0), new MyPoint(2,3.4641016151377545)); //Equilateral, the same as 2*sqrt(3).
        System.out.println(myTriangle);
        System.out.println("The perimeter of triangle is " + myTriangle.getPerimeter());
        System.out.println("The triangle is " + myTriangle.getType());
        System.out.println();
        MyTriangle myTriangle1 = new MyTriangle(new MyPoint(0,0), new MyPoint(4,0), new MyPoint(2,3.464101615137754)); //Isosceles.
        System.out.println(myTriangle1);
        System.out.println("The perimeter of triangle is " + myTriangle1.getPerimeter());
        System.out.println("The triangle is " + myTriangle1.getType());*/

        Main main = new Main();
        main.doTestForPentagon();

    }

    /*public void doTestForListIterator(){
        LinkedList<Double> listOfEdges = new LinkedList<>();
        for (double i = 0.0; i < 100.0; i+=5) listOfEdges.add(i);

        ListIterator<Double> listIterator = listOfEdges.listIterator(0);
        while (listIterator.hasNext()){
            int countOfEqualEdges = 0;
            Double edge = listIterator.next();
            int index = listIterator.nextIndex();
            ListIterator<Double> theRestOfList = listOfEdges.listIterator(index);
            while (theRestOfList.hasNext()){
                Double leftEdge = theRestOfList.next();
                int previousIndex = theRestOfList.previousIndex();
                int nextIndex = theRestOfList.nextIndex();
                System.out.println(leftEdge.toString() + " : " + previousIndex + ", _, " + nextIndex);
            }
        }
    }*/

    /*public void otherTests(){
        HashSet<Integer> list1 = new HashSet<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        HashSet<Integer> list2 = new HashSet<>();
        list2.add(2);
        list2.add(3);
        list2.add(1);

        System.out.println(list1.equals(list2));
    }*/

    public void doTestForPentagon(){
        //JRisk jRisk;
        MyPentagon pentagon;

        /*pentagon = new MyPentagon(new MyPoint(100.0 + Math.random()*200.0, 100.0 + Math.random()*200.0), new MyPoint(150.0 + Math.random()*200.0, 100.0 + Math.random()*200.0), new MyPoint(300.0 + Math.random()*200.0, 150.0 + Math.random()*200.0), new MyPoint(400.0 + Math.random()*200.0, 400.0 + Math.random()*200.0), new MyPoint(100.0 + Math.random()*200.0, 180.0 + Math.random()*200.0));
        System.out.println(pentagon);
        System.out.println(pentagon.getType());
        System.out.println();

        pentagon = new MyPentagon(new MyPoint(0.0, 0.0), new MyPoint(5.0, 0.0), new MyPoint(7.0, 2.0), new MyPoint(5.0, 5.0), new MyPoint(0.0, 5.0));
        System.out.println(pentagon);
        System.out.println(pentagon.getType()); //Three-equal
        System.out.println();

        pentagon = new MyPentagon(new MyPoint(0.0, 0.0), new MyPoint(200.0, 0.0), new MyPoint(280.0, 100.0), new MyPoint(200.0, 200.0), new MyPoint(0.0, 200.0));
        System.out.println(pentagon);
        System.out.println(pentagon.getType()); //Tree-equal and two-equal
        System.out.println();*/

        double someAngle = 2.0*Math.PI/5.0; //PI - 3PI/5
        //Equilateral pentagon with the length of edge of 100
        pentagon = new MyPentagon(new MyPoint(200.0, 200.0), new MyPoint(300.0, 200.0), new MyPoint(300.0 + 100.0*Math.cos(someAngle), 200.0 + 100.0*Math.sin(someAngle)), new MyPoint(250.0, 200.0 + 100.0*(Math.cos(3.0*Math.PI/10.0) + Math.sin(someAngle))), new MyPoint(200.0 - 100.0*Math.cos(someAngle), 200.0 + 100.0*Math.sin(someAngle)));
        System.out.println(pentagon);
        System.out.println(pentagon.getType()); //Tree-equal and two-equal but should be equilateral. I assume it's because cos and sin methods are not quiet accurate.
                                                //It can be seen at debug mode. The edges array will contain something like this {100.0, 100.00000000000001, 100.0, 100.0, 100.00000000000001}
    }
}

//Optional to read
/*P.S.
* How smart and versatile should our code be? We could write anything,
* from a terribly simple function that can only pad a number to be three
* characters wide to a complicated generalized number-formatting system
* that handles fractional numbers, negative numbers, alignment of decimal dots,
* padding with different characters, and so on.
*
* A useful principle is to not add cleverness unless you are absolutely sure
* you’re going to need it. It can be tempting to write general “frameworks”
* for every bit of functionality you come across. Resist that urge.
* You won’t get any real work done—you’ll just be writing code that you never use.*/

//some swing stuff to visualize what is going on
/*
class JRisk {

    private JFrame mainMap;
    private Polygon poly;

    public JRisk(MyPolygon myPolygon) {
        initComponents(myPolygon);
    }

    private void initComponents(MyPolygon myPolygon) {

        mainMap = new JFrame();
        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ArrayList<Integer> xCoordinates = new ArrayList<>();
        ArrayList<Integer> yCoordinates = new ArrayList<>();
        for (MyPoint point: myPolygon.getV()){
            xCoordinates.add((int)Math.round(point.getX()));
            yCoordinates.add((int)Math.round(point.getY()));
        }

        int xPoly[] = convertIntegers(xCoordinates);
        int yPoly[] = convertIntegers(yCoordinates);

        poly = new Polygon(xPoly, yPoly, xPoly.length);
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.drawPolygon(poly);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
    }

    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }
}*/
