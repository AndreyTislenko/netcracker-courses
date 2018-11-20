package CoordinateSystems.Polygons;

import CoordinateSystems.Points.MyPoint;

import java.util.*;

public class MyPolygon {
    protected MyPoint[] v;
    protected double[] edges;
    // Old representation.
    /* The Integer ArrayList represents an amount of edges that are equal.
     * Two edges can be equal, and equality is a kind of relation. The
     * relation that bounds these edges together and separate them from others.
     * The others can also have relations. If an edge exists and if there is no
     * other edges that have relation(s) with this one, the one still has relation
     * with itself.
     *
     * So to represent this idea we use ArrayList. The multitude of these relations
     * will look like this {m1, m2, m3, ..., mi, ..., mn}, where mi is number of edges
     * that are bound by equality relationship (mi >= 1). The order of the elements is
     * not important. For instance {1,1,1} is scalene, {2,1} is isosceles and {3} is
     * equilateral triangle respectively. As we can see the sum of elements of our
     * ArrayList equals the number of edges in polygon.
     *
     * There can be many different equal edges in polygon (e.g. {2,2} - parallelogram or
     * kite, {4} - square or {3, 2, 1, 4, 1} - blablablagram(*) or something).
     *
     * (*)Anyone can contrive as many qualification words based on numbers
     *  of array list as possible.*/

    // New representation.
    /*Unfortunately the array list takes into account the order of its elements.
    * And creating a new equal method for two lists of arrays containing equal
    * elements, but in a different order, which returns true, is cumbersome.
    * So I started using a set instead. And a set is not quite well representation,
    * since it cannot contain equal elements... E.g. the set {2, 1} will only say
    * "there are at least 2 equal edges and there is at least 1 edge equal only to
    * itself" but there could be other distinct edges not equal to previous
    * that have the "own" 2 (or edge that has its "own" 1). In this new representation
    * sum of elements of set is NOT equal to the number of edges in polygon. Moreover
    * {2, 1} can be triangle or quadrilateral or anything else...*/
    protected static HashMap<HashSet<Integer>, String> qualifications;

    public MyPolygon(MyPoint... v) {
        this.v = v;
        computeEdges();
    }

    protected void computeEdges(){
        edges = new double[v.length];
        double doublePrecision = 1000000000000000.0; // double: 64 bits (8 bytes) where 52 bits are used for the mantissa (about 16 decimal digits).
        for (int i = 0; i < v.length; i++){
            //We can't put irrational numbers in ANSI, so we have to calculate with finite precision. That's why Math.round.
            edges[i] = Math.round(v[i].distance(v[(i+1)%v.length])*doublePrecision)/doublePrecision; // or we could use i < v.length - 1 ? i + 1 : 0
        }
    }

    public double[] getEdges(){
        return edges;
    }

    public static HashMap<HashSet<Integer>, String> getQualifications() {
        return qualifications;
    }

    public static void setQualifications(HashMap<HashSet<Integer>, String> qualifications) {
        MyPolygon.qualifications = qualifications;
    }

    public double getPerimeter(){
        double perimeter = 0.0;
        for (double edge: edges){
            perimeter+=edge;
        }
        return  perimeter;
    }

    public String getType(){
        /*The method is made of these steps:
         * 1) Declaring needed variables and initialising Polygon qualification via string variable.
         * 2) Algorithm(*) of counting equal edges and adding these counts to the set.
         * 3) The final part is just finding according String in the map's value that represents
         *    qualification.
         *
         * (*) Pseudo code for the algorithm:
         *        CREATING int count.
         *        LOOP:Iterating over edges while there is no edge left
         *             GET current edge and next index of the edge. Count by default is 1
         *             LOOP:Iterating over other edges that are left starting with the next edge
         *                  GET this next edge,
         *                  IF current edge equal this next edge
         *                       add 1 to count
         *                       remove this next edge
         *                  END IF
         *             END LOOP
         *             ADD count to the set
         *             START next iterating with next edge (?)(**)
         *        END LOOP
         *
         *  (**) This is a problem that is described below.
         */
        //--------------------------------------------------------------------------------------------------------------
        //1)
        //Declaration and setting.
        String qualification = null;

        //"Wrapping" an array of edges into a linked list.
        LinkedList<Double> listOfEdges = new LinkedList<>();
        for (Double edge: edges){
            listOfEdges.add(edge);
        }

        /*We will contain different countOfEqualEdges in this set.
         * So after it is obtained, it will be used to find the equivalent
         * key in qualifications map.*/
        HashSet<Integer> setOfNumbersOfEqualEdges = new HashSet<>();
        //--------------------------------------------------------------------------------------------------------------
        //2)
        //The main process.
        ListIterator<Double> iteratorOfEdges = listOfEdges.listIterator(0);
        int countOfEqualEdges;
        while (iteratorOfEdges.hasNext()){
            countOfEqualEdges = 1; //by default one edge is equal to itself.
            double currentEdge = iteratorOfEdges.next(); //(*)here we have exception when the last line of code is omitted.
            int nextIndexOfCurrentEdge = iteratorOfEdges.nextIndex();

            ListIterator<Double> iteratorOfEdgesThatAreLeft = listOfEdges.listIterator(nextIndexOfCurrentEdge);
            while (iteratorOfEdgesThatAreLeft.hasNext()){
                double otherEdge = iteratorOfEdgesThatAreLeft.next();
                if (currentEdge == otherEdge){
                    countOfEqualEdges++;
                    iteratorOfEdgesThatAreLeft.remove(); //deleting equal edge so it won't be encountered again.
                }
            }
            setOfNumbersOfEqualEdges.add(countOfEqualEdges);
            iteratorOfEdges = listOfEdges.listIterator(nextIndexOfCurrentEdge); //this line bewilders me(*)

            //(*)
            /*I don't understand why, but without this line the method sometimes trows a
             * java.util.ConcurrentModificationException with pentagon. This line has to be unnecessary, because iterator
             * is already going to start with the next index. It looks like the purpose of this line is to somewhat
             * "refresh" the iteratorOfEdges. The difference between algorithm with the line and without it is that with
             * the line it's removing the "history" of iteration of our iteratorOfEdges. The lastReturned value becomes null.
             * And I really don't get it why this is so important for iterator to forget what he was iterating.
             * It doesn't have to influence on getting next nodes, does it?*/
        }
        //--------------------------------------------------------------------------------------------------------------
        //3)
        //finding the match in the Polygon.qualifications
        for (Map.Entry<HashSet<Integer>, String> pair: getQualifications().entrySet()){
            if (setOfNumbersOfEqualEdges.equals(pair.getKey())){
                qualification = pair.getValue();
                break;
            }
        }
        return qualification;
        //--------------------------------------------------------------------------------------------------------------
        //The end.
    }

    public MyPoint[] getV() {
        return v;
    }

    public void setV(MyPoint[] v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "v=" + Arrays.toString(v) +
                '}';
    }

    @Override
    public boolean equals(Object otherObj){
        //I took into account only edges, because I think points don't really matter.
        if (this == otherObj) return true;
        if (otherObj == null) return false;
        if (otherObj.getClass() != getClass()) return false;

        MyPolygon otherPolygon = (MyPolygon)otherObj;
        return Arrays.equals(edges, otherPolygon.getEdges());
    }

    @Override
    public int hashCode(){
        /*because I used only edges for equals, I have to use only them to calculate hashCode.
        * If I use points also it will cause the breach of agreement that if equals return true,
        * hashCodes have to be the same.*/
        int result = 17;
        result = 31*result + Arrays.hashCode(edges);
        return result;
    }
}
